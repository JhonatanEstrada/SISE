package com.iscodem.recyclerdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iscodem.recyclerdemo.R;
import com.iscodem.recyclerdemo.adapter.AdapterUsuarioCard;
import com.iscodem.recyclerdemo.model.UsuarioCard;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_home, container, false);
        try{
            // Inflate the layout for this fragment

            Toast.makeText(getContext(), "Creando HomeFragment..", Toast.LENGTH_SHORT).show();
            RecyclerView usuarioRecycler = (RecyclerView) view.findViewById(R.id.usuariosRecycler);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            usuarioRecycler.setLayoutManager(linearLayoutManager);

            AdapterUsuarioCard adapterUsuarioCard = new AdapterUsuarioCard(buildUsuarioCard(),R.layout.cardview_usuario,getActivity());

            usuarioRecycler.setAdapter(adapterUsuarioCard);

        }catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }

    public ArrayList<UsuarioCard> buildUsuarioCard(){
        ArrayList<UsuarioCard> usuarioCards = new ArrayList<>();

        try{
            usuarioCards.add(new UsuarioCard("David Porras","10","5","http://www.novalandtours.com/images/guide/guilin.jpg"));
            usuarioCards.add(new UsuarioCard("Alan Garcia","12","8","http://www.educationquizzes.com/library/KS3-Geography/river-1-1.jpg"));
            usuarioCards.add(new UsuarioCard("Alejandro Toledo","30","9","http://www.novalandtours.com/images/guide/guilin.jpg"));
            usuarioCards.add(new UsuarioCard("Ollanta Humala","54","12","http://www.educationquizzes.com/library/KS3-Geography/river-1-1.jpg"));
            usuarioCards.add(new UsuarioCard("David Porras","10","5","http://www.novalandtours.com/images/guide/guilin.jpg"));
            usuarioCards.add(new UsuarioCard("Alan Garcia","12","8","http://www.educationquizzes.com/library/KS3-Geography/river-1-1.jpg"));
            usuarioCards.add(new UsuarioCard("Alejandro Toledo","30","9","http://www.novalandtours.com/images/guide/guilin.jpg"));
            usuarioCards.add(new UsuarioCard("Ollanta Humala","54","12","http://www.educationquizzes.com/library/KS3-Geography/river-1-1.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }

        return usuarioCards;
    }


}
