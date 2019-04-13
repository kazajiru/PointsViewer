package app.daniyar.pointsviewer;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.daniyar.pointsviewer.points.IPointsContract;
import app.daniyar.pointsviewer.points.PointPresenterImpl;
import app.daniyar.pointsviewer.points.ui.PointsListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PointViewerActivity extends AppCompatActivity implements IPointsContract.IPointsView {
    @BindView(R.id.points_list)
    protected RecyclerView mPointsList;
    private IPointsContract.IPointsPresenter mPointsPresenter;
    private RecyclerView.Adapter mPointsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPointsPresenter = new PointPresenterImpl(this);
        mPointsPresenter.init();
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_points_viewer);
        ButterKnife.bind(this);
        initPointsListView();
    }

    private void initPointsListView() {
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mPointsList.setLayoutManager(verticalLayoutManager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPointsPresenter.loadPoints();
    }

    @Override
    public void onPointsLoaded(IPointsManager manager) {

        mPointsAdapter = new PointsListAdapter(manager);
        mPointsList.setAdapter(mPointsAdapter);
    }
}
