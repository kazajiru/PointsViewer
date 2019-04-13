package app.daniyar.pointsviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import app.daniyar.pointsviewer.main.IMainContract;
import app.daniyar.pointsviewer.main.MainPresenterImpl;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainContract.IMainViewer {
    @BindView(R.id.count_edit_box)
    protected EditText countValue;
    @BindView(R.id.progress_ui)
    protected ProgressBar progressView;

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
                hideKeyboard();

                Integer count = Integer.valueOf(inputValue.toString());
                mMainPresenter.submit(count);
            }
        } else {
            countValue.setError(getString(R.string.error_empty_field));
        }
    }

    private void hideKeyboard() {
        InputMethodManager iMM = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        iMM.hideSoftInputFromWindow(countValue.getWindowToken(), 0);
    }

    @Override
    public void showLoader() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoader() {
        progressView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPointsLoaded() {
        Intent viewerIntent = new Intent(this, PointViewerActivity.class);
        finish();
        startActivity(viewerIntent);
    }

    @Override
    public void onPointsLoadFailed(String errorMessage) {
        Snackbar.make(progressView, errorMessage, Snackbar.LENGTH_SHORT).show();
    }
}
