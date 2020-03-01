package com.aca.photobrowser;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ItemsClickLisener itemsClickLisener;

    private int images[]={R.drawable.nk1, R.drawable.nk2, R.drawable.nk3, R.drawable.nk4,
            R.drawable.nk5, R.drawable.nk6, R.drawable.nk7, R.drawable.nk8, R.drawable.nk9, };


    public Adapter(ItemsClickLisener itemsClickLisener) {
        this.itemsClickLisener = itemsClickLisener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementi_orinak, parent, false);
        return new ViewHolder(view,itemsClickLisener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


      int image_id = images[position];
        holder.nkar.setImageResource(image_id);



    }


    @Override
    public int getItemCount() {
        return images.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder  {

        private ImageView nkar;



        public ViewHolder(@NonNull View itemView, final ItemsClickLisener itemsClickLisener) {
            super(itemView);

            nkar = itemView.findViewById(R.id.nkar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemsClickLisener.onItemClicked(getAdapterPosition());

                }
            });



        }


    }
    public interface ItemsClickLisener{
        void onItemClicked(int position);

    }








}
