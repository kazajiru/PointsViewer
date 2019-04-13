package app.daniyar.pointsviewer.points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import app.daniyar.pointsviewer.models.Point;

public class PointsManager implements IPointsManager {
    private final List<Point> mPoints = new ArrayList<>();

    public PointsManager() {
    }

    @Override
    public List<Point> getAllPointsSortedByXASC() {
        List<Point> sortingList = new ArrayList<>();
        sortingList.addAll(mPoints);
        Collections.sort(sortingList, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() == o2.getX())
                    return 0;
                else if (o1.getX() > o2.getX())
                    return 1;
                else
                    return -1;
            }
        });
        return sortingList;
    }

    @Override
    public Point getItem(int position) {
        if (position < 0 || position >= mPoints.size()) {
            return null;
        }
        return mPoints.get(position);
    }

    @Override
    public int getCount() {
        return mPoints.size();
    }

    @Override
    public void addItem(Point item) {
        mPoints.add(item);
    }

    @Override
    public void addAll(List<Point> items) {
        mPoints.addAll(items);
    }
}
