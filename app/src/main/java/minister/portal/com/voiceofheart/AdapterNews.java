package minister.portal.com.voiceofheart;

/**
 * Created by Pawan on 9/27/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<NewsBeans> data= Collections.emptyList();
    NewsBeans current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterNews(Context context, List<NewsBeans> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_list, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        NewsBeans current=data.get(position);
        myHolder.newsid.setText(current.getNewsid());
        myHolder.newstitle.setText(current.getNewstitle());
        myHolder.statename.setText(current.getStatename());



        Glide.with(context).load(current.getCountryname())
                .placeholder(R.drawable.ic_launcher)
                .error(R.drawable.ic_launcher)
                .into(myHolder.ivFish);



    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView newsid;
        TextView newstitle;
        TextView statename;
        ImageView ivFish;


        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            newsid= (TextView) itemView.findViewById(R.id.txtid);
            newstitle= (TextView) itemView.findViewById(R.id.txttitle);
            statename = (TextView) itemView.findViewById(R.id.txtstate);
            ivFish= (ImageView) itemView.findViewById(R.id.ivFish);

        }

    }

}