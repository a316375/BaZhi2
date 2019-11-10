package xyxgame.bazhi2.jiemen;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import xyxgame.bazhi2.R;

public class JieMengActivity extends AppCompatActivity implements ExpandableListView.OnChildClickListener{
    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_meng);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();


    }


    public void init() {
        expandableListView = (ExpandableListView) findViewById(R.id.exlv);

        List<String> groupData = JieMengWords.Title();
        List<String> words=JieMengWords.Say();


        HashMap<String, List<String>> childData = new HashMap<>();
        for (int i = 0; i <groupData.size(); i++) {
            childData.put(groupData.get(i), Arrays.asList(words.get(i)));
        }


        // Setting up the Adapter
        adapter = new ExpandableListAdapter(this, groupData, childData);

        expandableListView.setAdapter(adapter);
        // Implementing callback to get notified when a Child item is clicked
        expandableListView.setOnChildClickListener(this);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        TextView childItem = v.findViewById(R.id.tv_child_text);
        String item = childItem.getText().toString();
        Toast.makeText(this, item + " clicked!", Toast.LENGTH_SHORT).show();
        return true;
    }

}


