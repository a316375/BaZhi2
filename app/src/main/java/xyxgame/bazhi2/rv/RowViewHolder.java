package xyxgame.bazhi2.rv;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import xyxgame.bazhi2.R;

public class RowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private RecyclerViewClickListener mListener;
    public TextView textView;

    RowViewHolder(View v, RecyclerViewClickListener listener) {
        super(v);
        mListener = listener;
        textView=v.findViewById(R.id.textshow);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mListener.onClick(view, getAdapterPosition());
    }
}
