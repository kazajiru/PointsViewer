package app.daniyar.pointsviewer.points;

import app.daniyar.pointsviewer.IPointsManager;

public interface IPointsContract {
    interface IPointsView {
        void init();

        void onPointsLoaded(IPointsManager manager);
    }

    interface IPointsPresenter {

        void init();

        void loadPoints();

    }
}
