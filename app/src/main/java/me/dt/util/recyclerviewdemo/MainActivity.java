package me.dt.util.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import me.dt.util.recyclerviewdemo.SlipReAdapter.ISlipClickAction;

public class MainActivity extends Activity {

  RecyclerView mRecyclerView;
  List<String> data;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mRecyclerView = findViewById(R.id.recycler);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    mRecyclerView.setHasFixedSize(true);

    data = new ArrayList<>();
    data.add("1");
    data.add("2");
    data.add("3");
    data.add("4");
    data.add("5");
    data.add("6");
    data.add("7");
    data.add("8");
    data.add("9");
    data.add("5");
    data.add("6");
    data.add("7");
    data.add("8");
    data.add("9");

    SlipReAdapter.Builder builder = new SlipReAdapter.Builder()
        .setAdapter(new Adapter(this, data))
        .setISlipClickAction(new ISlipClickAction() {
          @Override
          public void onAction(int position) {
            data.remove(position);
          }
        })
        .setMode(SlipReAdapter.MODE_DELETE)
        .setSlipViewId(R.layout.item_remove);
    mRecyclerView.setAdapter(builder.build());
  }


}
