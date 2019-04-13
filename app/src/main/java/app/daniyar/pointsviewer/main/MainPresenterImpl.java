package app.daniyar.pointsviewer.main;

import android.os.AsyncTask;

import java.io.IOException;

import androidx.annotation.NonNull;
import app.daniyar.pointsviewer.BuildConfig;
import app.daniyar.pointsviewer.server.ResponseData;
import app.daniyar.pointsviewer.server.RestAdapter;
import retrofit2.Call;

public class MainPresenterImpl implements IMainContract.IMainPresenter {
    private final IMainContract.IMainViewer mView;

    public MainPresenterImpl(@NonNull IMainContract.IMainViewer view) {
        this.mView = view;
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
        }.execute(count);
    }
}
