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
    public static int TYPE_One = 1;
    public static int TYPE_Two = 2;
    public static  int line=5;//切记分割线line，mDataset对应位置
    int [] icons={R.drawable.sm,R.drawable.yb,R.drawable.compass,R.drawable.erase,R.drawable.sm,
            R.drawable.icon,
            R.drawable.dlwjicon,R.drawable.compass,R.drawable.slfs,R.drawable.yuepu,R.drawable.icon,R.drawable.java};


    public RecyclerViewAdapter(RecyclerViewClickListener listener) {
        mListener = listener;
        mDataset.add("八字算命");
        mDataset.add("代烧元宝");
        mDataset.add("风水罗盘");
        mDataset.add("清除快取");
        mDataset.add("周公解梦");
        mDataset.add("");//这个是line4的分割线，切记
        mDataset.add("地理五诀(秘本)");//com.xyx.dlwj  com.xyx.dlwj.pro
        mDataset.add("简易排盘");//xyxgame.luopan
        mDataset.add("三僚书籍");//com.xyx.slfs
        mDataset.add("乐谱大师");//xyx.newmusic
        mDataset.add("智能面相");//xyxgame.faceAI
        mDataset.add("设计模式");//com.xyx.javadesignmode

    }

    public void updateData(List<String> dataset) {
        mDataset.clear();
        mDataset.addAll(dataset);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        if (viewType == TYPE_One) {
            View view = LayoutInflater.from(context).inflate(R.layout.rv_layout_line, parent, false);
            return new MeduimRowViewHolder(view, mListener);

        }
        if (viewType == TYPE_Two)  {
            View v = LayoutInflater.from(context).inflate(R.layout.rv_layout, parent, false);
            return new RowViewHolder(v, mListener);

        }
      return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RowViewHolder) {
            RowViewHolder rowHolder = (RowViewHolder) holder;
            //set values of data here
            ((RowViewHolder) holder).textView.setText(mDataset.get(position));
            ((RowViewHolder) holder).imageView.setImageResource(icons[position]);

        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==line) return TYPE_One;
        else return TYPE_Two;
    }
}