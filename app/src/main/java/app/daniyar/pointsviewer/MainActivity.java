package app.daniyar.pointsviewer;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import app.daniyar.pointsviewer.main.IMainContract;
import app.daniyar.pointsviewer.main.MainPresenterImpl;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainContract.IMainViewer {
    @BindView(R.id.count_edit_box)
    protected EditText countValue;

    private IMainContract.IMainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter = new MainPresenterImpl(this);
        mMainPresenter.init();
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        countValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    onSubmitClick();
                    return true;
                }
                return false;
            }
        });
    }

    @OnClick(R.id.submit_button)
    protected void onSubmitClick() {
        Editable inputValue = countValue.getText();
        if (inputValue.length() > 0) {
            String inputStr = inputValue.toString();
            if (inputStr.contains(".") || inputStr.contains(",")) {
                countValue.setError(getString(R.string.error_wrong_input_value));
            } else {
                Integer count = Integer.valueOf(inputValue.toString());
                mMainPresenter.submit(count);
            }
        } else {
            countValue.setError(getString(R.string.error_empty_field));
        }
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void dismissLoader() {

    }

    @Override
    public void onPointsLoaded() {

    }

    @Override
    public void onPointsLoadFailed(String errorMessage) {

    }
}
