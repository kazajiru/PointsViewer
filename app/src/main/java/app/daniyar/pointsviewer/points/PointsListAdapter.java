package app.daniyar.pointsviewer.points;

import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import app.daniyar.pointsviewer.models.Point;

public class PointsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final IPointsManager mPointsManager;

    public PointsListAdapter(IPointsManager manager) {
        this.mPointsManager = manager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Point point = mPointsManager.getItem(position);
        List<Point> points = mPointsManager.getAllPointsSortedByXASC();
    }

    @Override
    public int getItemCount() {
        return mPointsManager.getCount();
    }
}
