package app.daniyar.pointsviewer.points;

public class PointPresenterImpl implements IPointsContract.IPointsPresenter {
    private final IPointsContract.IPointsView mView;

    public PointPresenterImpl(IPointsContract.IPointsView view) {
        this.mView = view;
    }

    @Override
    public void init() {

    }

    @Override
    public void loadPoints() {

    }
}
