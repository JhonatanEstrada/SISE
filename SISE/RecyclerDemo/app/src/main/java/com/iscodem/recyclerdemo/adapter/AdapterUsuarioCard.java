package com.iscodem.recyclerdemo.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iscodem.recyclerdemo.R;
import com.iscodem.recyclerdemo.model.UsuarioCard;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by iscodem on 07/04/2017.
 */

public class AdapterUsuarioCard extends RecyclerView.Adapter<AdapterUsuarioCard.UsuarioCardViewHolder>{

    private ArrayList<UsuarioCard> usuarioCards;
    private int resource;
    private Activity activity;

    public AdapterUsuarioCard(ArrayList<UsuarioCard> usuarioCards, int resource, Activity activity) {
        this.usuarioCards = usuarioCards;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public UsuarioCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new UsuarioCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsuarioCardViewHolder holder, int position) {
        UsuarioCard usuarioCard = usuarioCards.get(position);
        holder.tvNombreUsuarioCard.setText(usuarioCard.getNombre());
        holder.tvNumberLikeCard.setText(usuarioCard.getNumLike());
        holder.tvTimeLikeCard.setText(usuarioCard.getTimeLike());
        Picasso.with(activity).load(usuarioCard.getFotoCard()).into(holder.imgFotoUsuarioCard);
    }

    @Override
    public int getItemCount() {
        return usuarioCards.size();
    }


    /**
     * Esta clase trabaja con cada uno de los view que componen el card
     */
    public class UsuarioCardViewHolder extends RecyclerView.ViewHolder{
        //Aqui definimos todo los views que componen al card
        private ImageView imgFotoUsuarioCard;
        private TextView tvNombreUsuarioCard;
        private TextView tvTimeLikeCard;
        private TextView tvNumberLikeCard;

        public UsuarioCardViewHolder(View itemView) {
            super(itemView);

            imgFotoUsuarioCard = (ImageView) itemView.findViewById(R.id.imgFotoUsuarioCard);
            tvNombreUsuarioCard = (TextView) itemView.findViewById(R.id.tvNombreUsuarioCard);
            tvTimeLikeCard = (TextView) itemView.findViewById(R.id.tvTimeLikeCard);
            tvNumberLikeCard = (TextView) itemView.findViewById(R.id.tvNumberLikeCard);
        }
    }
}
