package com.fgcalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.fgcalarm.model.entities.Station;
import com.fgcalarm.model.persistence.RepositoryManager;

import java.util.ArrayList;
import java.util.Arrays;

import static com.fgcalarm.R.drawable.s1;


public class CustomAdapterSelector extends RecyclerView.Adapter<CustomAdapterSelector.AdapterViewHolder>{

    Context ctx;
    Intent intent;
    ArrayList<Station> stations;

    CustomAdapterSelector(Context context, int linia_id){
        ctx = context;
        intent = new Intent(ctx, ActivadorActivity.class);

        stations = new ArrayList<>();
        stations.add(RepositoryManager.getStationRepository().findAll().get(linia_id));
    }


    @Override
    public CustomAdapterSelector.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row_layout_selector, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapterSelector.AdapterViewHolder adapterViewholder, int position) {
       adapterViewholder.name.setText(stations.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return stations.size();
    }



    public class AdapterViewHolder extends RecyclerView.ViewHolder {


        public ImageView icon;
        public TextView name;
        public View v;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            final int x = itemView.getVerticalScrollbarPosition();
            this.v = itemView;
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    intent.putExtra("estacio", stations.get(x).getName());
                    intent.putExtra("station_id",stations.get(x).getId());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(intent);
                }
            });
        }

    }
}