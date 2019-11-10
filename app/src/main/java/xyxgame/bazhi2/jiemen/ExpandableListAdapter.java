package xyxgame.bazhi2.jiemen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.HashMap;
import java.util.List;

import xyxgame.bazhi2.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private Context mContext;
        // Child Items of the List
        private List<String> mListData;
        // Child Items of the individual items of the List
        private HashMap<String, List<String>> mListChildData;

        public ExpandableListAdapter(Context context, List<String> listData,
                                     HashMap<String, List<String>> listChildData){
            mContext = context;
            mListData = listData;
            mListChildData = listChildData;
        }

        @Override
        public int getGroupCount() {
            return mListData.size();
        }

        @Override
        public int getChildrenCount(int i) {
             return 1;
//             return mListChildData.size();

        }

        @Override
        public Object getGroup(int i) {
            return mListData.get(i);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return mListChildData.get(mListData.get(groupPosition)).get(childPosition);
        }

        @Override
        public long getGroupId(int groupId) {
            return groupId;
        }

        @Override
        public long getChildId(int groupId, int childId) {
            return childId;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View convertView, ViewGroup viewGroup) {

            TextView listItemText;

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.jiemeng_group_layout, null);
            }

            // Fetching the view and binding the appropriate text to it
            listItemText = (TextView) convertView.findViewById(R.id.tv_group_text);
            listItemText.setText(mListData.get(i));
            return convertView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View convertView, ViewGroup viewGroup) {

            TextView listChildItemText;

            if(convertView == null){
                LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.jiement_child_layout, null);
            }

            listChildItemText = (TextView) convertView.findViewById(R.id.tv_child_text);
            listChildItemText.setText(mListChildData.get(mListData.get(i)).get(i1));
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            // Don't forget to set this true so that the child items are selectable
            return true;
        }
    }