package com.first.demo;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.first.demo.models.Patient;

import java.util.ArrayList;

public class PatientRecycleViewAdaptor extends RecyclerView.Adapter <PatientRecycleViewAdaptor.ViewHolder>{
    private OnItemClickListener listener;
    Context context;
    ArrayList<Patient> patients;
    public PatientRecycleViewAdaptor(Context context, ArrayList<Patient> patients, OnItemClickListener listener){
        this.context = context;
        this.patients = patients;
        this.listener = listener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup patient, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.patient_list, patient, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(patients.get(position).getName());
        String idString = "Id:"+String.valueOf(patients.get(position).getId());
        holder.textView2.setText(idString);
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView textView1, textView2;


         public ViewHolder(View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.name);
            textView2 = itemView.findViewById(R.id.id);
             itemView.setOnClickListener(v -> {
                 if (listener != null) {
                     listener.onItemClick(getAdapterPosition());
                 }
             });
        }

    }


}
