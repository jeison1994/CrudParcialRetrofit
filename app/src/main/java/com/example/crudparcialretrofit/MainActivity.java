package com.example.crudparcialretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.ListView;

import com.example.crudparcialretrofit.adapter.EmpleadoAdapter;
import com.example.crudparcialretrofit.constant.Constants;
import com.example.crudparcialretrofit.interfaces.CrudInterface;
import com.example.crudparcialretrofit.model.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List <Empleado> empleado;
    CrudInterface crudInterface;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lisView);
        getAll ();
    }
    private  void getAll(){

        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CrudInterface.class);
        Call<List<Empleado>> call = crudInterface.getAll();
        call.enqueue(new Callback<List<Empleado>>() {
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;

            }
                empleado = response.body();
                EmpleadoAdapter empleadoAdapter = new EmpleadoAdapter(empleado, getApplicationContext());
                listView.setAdapter(empleadoAdapter);
                empleado.forEach(p -> Log.i("Empleado ", p.toString()));
            }
            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                Log.e("Throw err: ", t.getMessage());


            }
        });





    }
}
