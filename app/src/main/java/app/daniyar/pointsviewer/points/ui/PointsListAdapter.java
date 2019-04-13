package app.daniyar.pointsviewer.points.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import app.daniyar.pointsviewer.IPointsManager;
import app.daniyar.pointsviewer.R;
import app.daniyar.pointsviewer.models.Point;
import app.daniyar.pointsviewer.points.ui.BaseItemViewHolder;
import app.daniyar.pointsviewer.points.ui.GraphItemViewHolder;
import app.daniyar.pointsviewer.points.ui.SimpleItemViewHolder;

public class PointsListAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {
    private static final int TYPE_SIMPLE_ITEM = 0;
    private static final int TYPE_GRAPH_ITEM = 1;
    private final IPointsManager mPointsManager;

    public PointsListAdapter(IPointsManager manager) {
        this.mPointsManager = manager;
    }

    @NonNull
    @Override
    public BaseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_GRAPH_ITEM) {
            return new GraphItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_plot_list_item, parent, false));
        }
        return new SimpleItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_text_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseItemViewHolder holder, int position) {
        if (holder instanceof GraphItemViewHolder) {
            List<Point> points = mPointsManager.getAllPointsSortedByXASC();
            holder.setData(points);
        } else {
            Point point = mPointsManager.getItem(position);
            holder.setData(point);
        }
        holder.updateUI();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_GRAPH_ITEM;
        }
        return TYPE_SIMPLE_ITEM;
    }

    @Override
    public int getItemCount() {
        return mPointsManager.getCount();
    }
}
