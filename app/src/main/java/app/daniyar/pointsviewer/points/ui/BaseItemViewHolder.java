package app.daniyar.pointsviewer.points.ui;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseItemViewHolder<T> extends RecyclerView.ViewHolder {
    protected T data;

    public BaseItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setData(@NonNull T data) {
        this.data = data;
    }

    public abstract void updateUI();
}
