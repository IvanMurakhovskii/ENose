package com.murik.enose.ui.fragment.result.recycler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.murik.enose.R;
import com.murik.enose.presentation.presenter.result.ResultPresenter;


public class ResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_TOTAL_INDICATORS = 2;
    private final ResultPresenter presenter;

    public ResultAdapter(ResultPresenter presenter) {
        this.presenter = presenter;
    }

    private boolean isPositionHeader(int position) {
        return (position == 0);
    }

    @Override
    public int getItemViewType(int position) {
        int totalIndicatorsPositionStart = presenter.getTotalIndicatorsPositionStart();
        if (isPositionHeader(position) || position == totalIndicatorsPositionStart) {
            return TYPE_HEADER;
        } else if (position > totalIndicatorsPositionStart) {
            return TYPE_TOTAL_INDICATORS;
        }
        return TYPE_ITEM;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.header_result_recycler, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_TOTAL_INDICATORS) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.total_indicators_recycler, parent, false);
            return new TotalIndicatorsViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderViewHolder) {
            presenter.onBindHeader(position, (HeaderViewHolder) holder);
        } else if (holder instanceof ResultViewHolder) {
            presenter.onBindPlacesViewPosition(position, (ResultViewHolder) holder);
        } else if (holder instanceof TotalIndicatorsViewHolder) {
            presenter.onBindTotalIndicators(position, (TotalIndicatorsViewHolder) holder);
        }
    }

    @Override
    public int getItemCount() {
        return presenter.getResultRowsCount();
    }
}
