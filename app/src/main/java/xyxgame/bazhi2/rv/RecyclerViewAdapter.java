package xyxgame.bazhi2.rv;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import xyxgame.bazhi2.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerViewClickListener mListener;
    private List<String> mDataset = new ArrayList<>();

    public RecyclerViewAdapter(RecyclerViewClickListener listener) {
        mListener = listener;
        mDataset.add("八字算命");
        mDataset.add("代烧元宝");
        mDataset.add("风水罗盘");
        mDataset.add("清除快取");

    }

    public void updateData(List<String> dataset) {
        mDataset.clear();
        mDataset.addAll(dataset);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.rv_layout, parent, false);
        return new RowViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RowViewHolder) {
            RowViewHolder rowHolder = (RowViewHolder) holder;
            //set values of data here
            ((RowViewHolder) holder).textView.setText(mDataset.get(position));

        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}