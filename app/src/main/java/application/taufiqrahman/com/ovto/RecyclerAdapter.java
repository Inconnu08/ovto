package application.taufiqrahman.com.ovto;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Taufiq on 5/9/2018.
 *
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Data> dataList;
    private Context context;

    public RecyclerAdapter(List<Data> dataList, Context context){

        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Data data = dataList.get(position);
        holder.fullname.setText(data.getFirst_name() + ", " + data.getLast_name());
        Glide.with(context).load(data.getAvatar()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView  fullname;

        public MyViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView) itemView.findViewById(R.id.cardView_image);
            fullname = (TextView) itemView.findViewById(R.id.cardView_location);
        }
    }

    public void addData(List<Data> data){

        for(Data d: data){
            dataList.add(d);
        }
    }
}
