package app.daniyar.pointsviewer.points;

import java.util.List;

import app.daniyar.pointsviewer.models.Point;

public interface IPointsManager {
    List<Point> getAllPointsSortedByXASC();

    Point getItem(int position);

    int getCount();

    void addItem(Point item);

    void addAll(List<Point> items);
}
