package pl.ogiba.hfrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by robertogiba on 21.01.2018.
 */

public class HFRecyclerView extends RecyclerView {
    public HFRecyclerView(Context context) {
        super(context);
    }

    public HFRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HFRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
    }

    public static abstract class HFAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
        private static final int HEADER = -115;
        private static final int FOOTER = -116;

        @Override
        public int getItemCount() {
            return getNumberOfItems() + 2;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return HEADER;
            } else if (position == getNumberOfItems() + 1) {
                return FOOTER;
            } else {
                return getViewTypeForItem(position - 1);
            }
        }

        @Override
        public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
            if (position == 0) {
                onBindHeaderView();
            } else if (position == getNumberOfItems() + 1) {
                onBindHeaderView();
            }
            super.onBindViewHolder(holder, position, payloads);
        }

        public int getViewTypeForItem(int position) {
            return 0;
        }

        protected abstract int getNumberOfItems();

        protected abstract void onCreateHeader(ViewGroup parent);

        protected abstract void onBindHeaderView();

        protected abstract void onBindFooterView();
    }
}
