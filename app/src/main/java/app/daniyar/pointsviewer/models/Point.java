package app.daniyar.pointsviewer.models;

public class Point {
    private float mXValue;
    private float mYValue;

    public Point() {
    }

    public Point(float x, float y) {
        this.mXValue = x;
        this.mYValue = y;
    }

    public float getX() {
        return mXValue;
    }

    public void setX(float mXValue) {
        this.mXValue = mXValue;
    }

    public float getY() {
        return mYValue;
    }

    public void setY(float mYValue) {
        this.mYValue = mYValue;
    }
}
