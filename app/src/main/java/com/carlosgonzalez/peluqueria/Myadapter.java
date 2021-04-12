package com.carlosgonzalez.peluqueria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class Myadapter extends FirebaseRecyclerAdapter<model,Myadapter.myviewholder>
        {
public Myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
        }

@Override
protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model)
        {
        holder.name.setText(model.getNombre());
        holder.descrip.setText(model.getDescripcion());
        holder.costo.setText(model.getPrecio());
        Glide.with(holder.img.getContext()).load(model.getUrl()).into(holder.img);
        }

@NonNull
@Override
public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
        }

class myviewholder extends RecyclerView.ViewHolder
{
    CircleImageView img;
    TextView name,descrip,costo;
    public myviewholder(@NonNull View itemView)
    {
        super(itemView);
        img=(CircleImageView)itemView.findViewById(R.id.img1);
        name=(TextView)itemView.findViewById(R.id.nametext);
        descrip=(TextView)itemView.findViewById(R.id.coursetext);
        costo=(TextView)itemView.findViewById(R.id.emailtext);
    }
}
}
