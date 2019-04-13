package app.daniyar.pointsviewer.points.ui;

import android.view.View;
import android.widget.TextView;

import java.util.Locale;

import androidx.annotation.NonNull;
import app.daniyar.pointsviewer.R;
import app.daniyar.pointsviewer.models.Point;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleItemViewHolder extends BaseItemViewHolder<Point> {
    @BindView(R.id.view_x_value)
    protected TextView xValue;

    @BindView(R.id.view_y_value)
    protected TextView yValue;

    public SimpleItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void updateUI() {
        xValue.setText(String.format(Locale.getDefault(),"%s", data.getX()));
        yValue.setText(String.format(Locale.getDefault(),"%s", data.getY()));
    }
}
