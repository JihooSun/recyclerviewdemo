package me.dt.util.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public  class Adapter extends RecyclerView.Adapter{

  private Context mContext;
  private List<String> mData;
  public Adapter(Context context,List data){
    mContext = context;
    mData = data;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_content,parent,false));
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {

    MyViewHolder myViewHolder = (MyViewHolder)holder;

    Log.i("Adapter",holder.toString());
    final String value = mData.get(position);
    myViewHolder.mContent.setText(value);
    myViewHolder.btn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(mContext,"内容点击",Toast.LENGTH_SHORT).show();
      }
    });


  }

  @Override
  public int getItemCount() {
    return mData.size();
  }


  public static  class MyViewHolder extends ViewHolder {

    public TextView mContent;
    public Button btn;

    public MyViewHolder(View itemView) {
      super(itemView);
      mContent = itemView.findViewById(R.id.tv_content);
      btn = itemView.findViewById(R.id.btn);
    }
  }
}