package pl.ogiba.hfrecyclerviewdemo;

import android.view.View;
import android.widget.TextView;

import pl.ogiba.hfrecyclerview.HFRecyclerView;

/**
 * Created by robertogiba on 21.01.2018.
 */

public class DemoHFViewHolder extends HFRecyclerView.ViewHolder {

    private TextView textView;

    public DemoHFViewHolder(View itemView) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.tv_simple_value);
    }

    public DemoHFViewHolder setText(String value) {
        this.textView.setText(value);
        return this;
    }
}
