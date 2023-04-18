package com.example.crudparcialretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.crudparcialretrofit.R;
import com.example.crudparcialretrofit.model.Empleado;

import java.util.List;

public class EmpleadoAdapter extends BaseAdapter {
    List <Empleado> empleados;
    Context context;
    TextView nameText;
    Button viewButton;

    public EmpleadoAdapter(List<Empleado> empleados, Context context) {
        this.empleados = empleados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return empleados.size();
    }

    @Override
    public Object getItem(int i) {
        return empleados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return empleados.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.empleado_list,viewGroup, false);


        }
        nameText = view.findViewById(R.id.nameText);
        nameText.setText(empleados.get(position).getNombre());
        viewButton = view.findViewById(R.id.viewButton);
        return view;
    }
}
