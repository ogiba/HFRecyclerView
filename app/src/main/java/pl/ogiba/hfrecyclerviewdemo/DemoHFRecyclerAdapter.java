package pl.ogiba.hfrecyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pl.ogiba.hfrecyclerview.HFRecyclerView;

/**
 * Created by robertogiba on 21.01.2018.
 */

public class DemoHFRecyclerAdapter extends HFRecyclerView.HFAdapter<DemoHFViewHolder> {

    private ArrayList<Object> items;

    public DemoHFRecyclerAdapter() {
        this.items = new ArrayList<>();
    }

    @Override
    protected int getNumberOfItems() {
        return items.size();
    }

    @Override
    public DemoHFViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_hf_item, parent, false);
        return new DemoHFViewHolder(view);
    }

    @Override
    protected void onCreateHeader(ViewGroup parent) {

    }

    @Override
    protected void onBindHeaderView() {

    }

    @Override
    protected void onBindFooterView() {

    }

    @Override
    public void onBindViewHolder(DemoHFViewHolder holder, int position) {
        holder.setText(String.format("Item %s", position));
    }

    public void setItems(ArrayList<Object> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }
}
