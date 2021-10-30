package com.example.inmobiliaria.ui.inmuebles;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Inmuebles;

import java.util.List;

import androidx.annotation.NonNull;

public class InmuebleAdapter extends RecyclerView.Adapter<InmuebleAdapter.ViewHolder>{

    private Context context;
    private List<Inmuebles> inmuebles;
    private LayoutInflater inflater;



    public InmuebleAdapter(Context context, List<Inmuebles> inmuebles, LayoutInflater inflater) {
        this.context = context;
        this.inmuebles = inmuebles;
        this.inflater = inflater;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_inmueble_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDireccion.setText(inmuebles.get(position).getDireccion());
        holder.tvPrecio.setText("$" + inmuebles.get(position).getCosto());
        Glide.with(context)
                .load(inmuebles.get(position).getImagen())
                .placeholder(R.drawable.inmu2)
                .into(holder.ivImagenInmueble);


    }

    @Override
    public int getItemCount() {
        return inmuebles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPrecio;
        TextView tvDireccion;
        ImageView ivImagenInmueble;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenInmueble = itemView.findViewById(R.id.ivImagenInmueble);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Inmuebles inmueble = inmuebles.get(getAdapterPosition());
                    //bundle.putSerializable("inmueble", inmueble);
                    bundle.putInt("id", inmueble.getIdInmueble());
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.inmuebleFragment, bundle);
                }
            });
        }
    }
}
