package app.daniyar.pointsviewer.points;

import java.util.List;

import app.daniyar.pointsviewer.models.Point;

public interface IPointsContract {
    interface IPointsView {
        void init();

        void onPointsLoaded(List<Point> points);
    }

    interface IPointsPresenter {

        void init();

        void loadPoints();

    }
}
