package com.aca.photobrowser;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NkarFragment extends Fragment {

    private RecyclerView recyclerView;

    private int images[]={R.drawable.nk1, R.drawable.nk2, R.drawable.nk3, R.drawable.nk4,
            R.drawable.nk5, R.drawable.nk6, R.drawable.nk7, R.drawable.nk8, R.drawable.nk9, };




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_nkar,container,false);



        Adapter adapter=new Adapter(new Adapter.ItemsClickLisener() {
            @Override
            public void onItemClicked(int position) {


                int image_id = images[position];

                Intent intent=new Intent(getContext(),Preview.class);
                intent.putExtra("images",image_id);
                startActivity(intent);


                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.addToBackStack( "tag" ).commit();






            }
        });


        recyclerView=view.findViewById(R.id.RV);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);




        return view;
    }


}
