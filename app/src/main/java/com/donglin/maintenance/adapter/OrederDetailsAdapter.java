package com.donglin.maintenance.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.donglin.maintenance.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
public class OrederDetailsAdapter extends RecyclerView.Adapter {
    protected Context mContext;
    protected List<String> mLists;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public OrederDetailsAdapter(Context context, @NonNull List list) {
        this.mContext = context;
        this.mLists = list;
    }

    public void removeData(int position) {
        mLists.remove(position);
        notifyDataSetChanged();
        // notifyItemRemoved(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dl_in_progress_part_item, parent, false);
        return new DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final DebounceViewHolder debounceViewHolder = (DebounceViewHolder) holder;
        debounceViewHolder.itemInprogressTvName.setText(mLists.get(position));
        if (mOnItemClickListener != null) {
            debounceViewHolder.itemPartLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });

            debounceViewHolder.itemPartLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = debounceViewHolder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(debounceViewHolder.itemView, position);
                }
            });
        }

        if (mOnItemLongClickListener != null) {
            debounceViewHolder.itemInprogressTvName.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = debounceViewHolder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(debounceViewHolder.itemView, position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mLists == null) {
            return 0;
        }
        return mLists.size();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    static class DebounceViewHolder extends RecyclerView.ViewHolder {
        /*  @BindView(R.id.item_order_button)
          Button mItemOrderButton;
          @BindView(R.id.item_order_ll)
          LinearLayout mItemOrderLl;
          @BindView(R.id.item_tv_orgNmae)
          TextView mItemTvOrgNmae;
          @BindView(R.id.item_tv_location)
          TextView mItemTvLocation;*/
        @BindView(R.id.item_inprogress_tv_name)
        TextView itemInprogressTvName;
        @BindView(R.id.item_part_ll)
        LinearLayout itemPartLl;


        public DebounceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

