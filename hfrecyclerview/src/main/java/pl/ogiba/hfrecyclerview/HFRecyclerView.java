package pl.ogiba.hfrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
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
            int additionalItems = 0;

            additionalItems += headerAvailable() ? 1 : 0;
            additionalItems += footerAvailable() ? 1 : 0;

            return getNumberOfItems() + additionalItems;
        }

        @Override
        public int getItemViewType(int position) {
            if (headerAvailable() && position == 0) {
                return HEADER;
            } else if (footerAvailable() && position == getNumberOfItems() + 1) {
                return FOOTER;
            } else {
                if (headerAvailable()) {
                    position--;
                }

                return getViewTypeForItem(position);
            }
        }

        @Override
        public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
            if (headerAvailable() && position == 0) {
                onBindHeaderView();
                return;
            } else if (footerAvailable() && position == getNumberOfItems() + 1) {
                onBindFooterView();
                return;
            }

            if (headerAvailable()) {
                position--;
            }

            super.onBindViewHolder(holder, position, payloads);
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case HEADER:
                    return onCreateHeaderViewHolder(parent);
                case FOOTER:
                    return onCreateFooterViewHolder(parent);
            }

            return onCreateContentViewHolder(parent, viewType);
        }

        public int getViewTypeForItem(int position) {
            return 0;
        }

        public boolean headerAvailable() {
            return false;
        }

        public boolean footerAvailable() {
            return false;
        }

        protected abstract int getNumberOfItems();

        protected abstract VH onCreateHeaderViewHolder(ViewGroup parent);

        protected abstract VH onCreateContentViewHolder(ViewGroup parent, int viewType);

        protected abstract VH onCreateFooterViewHolder(ViewGroup parent);

        protected abstract void onBindHeaderView();

        protected abstract void onBindFooterView();
    }

    public static class Header extends RecyclerView.ViewHolder {
        public Header(View itemView) {
            super(itemView);
        }
    }

    public static class Footer extends RecyclerView.ViewHolder {
        public Footer(View itemView) {
            super(itemView);
        }
    }
}
