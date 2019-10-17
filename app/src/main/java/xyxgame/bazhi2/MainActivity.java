package xyxgame.bazhi2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import xyxgame.bazhi2.Activity.Daishao_Activity;
import xyxgame.bazhi2.luopan.Luopan;
import xyxgame.bazhi2.rv.RecyclerViewAdapter;
import xyxgame.bazhi2.rv.RecyclerViewClickListener;
import xyxgame.bazhi2.util.DataCleanManager;
import xyxgame.bazhi2.util.Open;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       initData();



    }

    private void initData() {
        RecyclerView recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        RecyclerViewClickListener listener=new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (position==0){startActivity(new Intent(MainActivity.this,BaZhi.class));};
                if (position==1){startActivity(new Intent(MainActivity.this, Daishao_Activity.class));};
                if (position==2){startActivity(new Intent(MainActivity.this, Luopan.class));};
                if (position==3){ Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.fromParts("package", getPackageName(), null));
                    startActivity(intent);
                };
                if (position==RecyclerViewAdapter.line){};//这是空格行
                //Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_SHORT).show();
                if (position==5){Open.To(getApplicationContext(),Open.a);}
                if (position==6){Open.To(getApplicationContext(),Open.b);}
                if (position==7){Open.To(getApplicationContext(),Open.c);}
                if (position==8){Open.To(getApplicationContext(),Open.d);}
                if (position==9){Open.To(getApplicationContext(),Open.e);}
                if (position==10){Open.To(getApplicationContext(),Open.f);}
            }
        };
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(listener);
        recyclerView.setAdapter(adapter);

        //        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type=adapter.getItemViewType(position);
                if (type==RecyclerViewAdapter.TYPE_Two) return 1;
                if (type==RecyclerViewAdapter.TYPE_One) return 2;
                return 2;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
//        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
//        recyclerView.addItemDecoration(decoration);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      //  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      //  if (id == R.id.action_settings) {
       //     return true;
     //   }

        return super.onOptionsItemSelected(item);
    }
}
