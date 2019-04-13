package app.daniyar.pointsviewer.points;

import app.daniyar.pointsviewer.PointsManager;

public class PointPresenterImpl implements IPointsContract.IPointsPresenter {
    private final IPointsContract.IPointsView mView;

    public PointPresenterImpl(IPointsContract.IPointsView view) {
        this.mView = view;
    }

    @Override
    public void init() {
        mView.init();
    }

    @Override
    public void loadPoints() {
        mView.onPointsLoaded(PointsManager.getInstance());
    }
}
