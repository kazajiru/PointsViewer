package app.daniyar.pointsviewer;

import androidx.multidex.MultiDexApplication;
import app.daniyar.pointsviewer.points.IPointsManager;
import app.daniyar.pointsviewer.points.PointsManager;

public class PointApplication extends MultiDexApplication {
    private IPointsManager mPointsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mPointsManager = new PointsManager();
    }
}
