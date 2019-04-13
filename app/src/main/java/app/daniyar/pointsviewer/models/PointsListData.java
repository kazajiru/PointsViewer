package app.daniyar.pointsviewer.models;

import java.util.ArrayList;
import java.util.List;

public class PointsListData {
    private List<Point> mPointsList;

    public PointsListData() {
        mPointsList = new ArrayList<>();
    }

    public List<Point> getPointsList() {
        return mPointsList;
    }

    public void setPointsList(List<Point> items) {
        this.mPointsList = items;
    }
}
