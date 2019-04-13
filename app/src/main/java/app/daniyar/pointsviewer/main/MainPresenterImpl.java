package app.daniyar.pointsviewer.main;

import android.os.AsyncTask;

import java.io.IOException;

import androidx.annotation.NonNull;
import app.daniyar.pointsviewer.BuildConfig;
import app.daniyar.pointsviewer.models.ErrorMessage;
import app.daniyar.pointsviewer.models.PointsListData;
import app.daniyar.pointsviewer.IPointsManager;
import app.daniyar.pointsviewer.PointsManager;
import app.daniyar.pointsviewer.server.ResponseData;
import app.daniyar.pointsviewer.server.RestAdapter;
import retrofit2.Call;

public class MainPresenterImpl implements IMainContract.IMainPresenter {
    private final IMainContract.IMainViewer mView;
    private IPointsManager mPointManager;

    public MainPresenterImpl(@NonNull IMainContract.IMainViewer view) {
        this.mView = view;
        mPointManager = PointsManager.getInstance();
    }

    @Override
    public void init() {
        mView.init();
    }

    @Override
    public void submit(Integer count) {
        mView.showLoader();

        new AsyncTask<Integer, Void, ResponseData>() {

            @Override
            protected ResponseData doInBackground(Integer... voids) {
                Call<ResponseData> call = RestAdapter.getInstance().getAPI().loadPoints(count, BuildConfig.API_VERSION);

                try {
                    ResponseData result = call.execute().body();

                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(ResponseData result) {
                super.onPostExecute(result);
                mView.dismissLoader();
                if(result != null) {
                    if (result.getResult() == ResponseData.RESULT_OK) {
                        mPointManager.clear();
                        mPointManager.addAll(((PointsListData) result.getPayload()).getPointsList());
                        mView.onPointsLoaded();
                    } else {
                        mView.onPointsLoadFailed(((ResponseData<ErrorMessage>) result).getPayload().getErrorMessage());
                    }
                } else {
                    mView.onPointsLoadFailed("request error");//we can improve it by adding ERROR CODES.
                    // Based on it UI will able to show different notifications and may produce new actions like "retry button"
                }
            }
        }.execute(count);
    }
}
