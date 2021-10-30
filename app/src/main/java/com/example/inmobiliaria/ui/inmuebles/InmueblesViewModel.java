package com.example.inmobiliaria.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import com.example.inmobiliaria.modelo.Inmuebles;
import com.example.inmobiliaria.request.ApiClient;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class InmueblesViewModel extends AndroidViewModel {
    private MutableLiveData<List<Inmuebles>> inmueblesMutable;
    private Context context;

    public InmueblesViewModel(@NonNull Application application) {
        super(application);

        context = application.getApplicationContext();

    }

    public LiveData<List<Inmuebles>> getInmuebles() {
        if (inmueblesMutable == null) {
            inmueblesMutable = new MutableLiveData<>();
        }
        return inmueblesMutable;

    }

    public void mostrarInmuebles() {

        Call<List<Inmuebles>> listaInmuebles = ApiClient.getMyApiClient().listaInmuebles(ApiClient.obtenerToken(context));
        listaInmuebles.enqueue(new Callback<List<Inmuebles>>() {
            @Override
            public void onResponse(Call<List<Inmuebles>> call, Response<List<Inmuebles>> response) {
                if(response.isSuccessful()){
                    inmueblesMutable.postValue(response.body());
                }else{
                    Log.d("else","ERROR en el else");
                    Toast.makeText(context, "No se encuentran inmuebles.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Inmuebles>> call, Throwable t) {
                Log.d("failure","ERROR en el failure");
                Toast.makeText(context, "Se ha producido un error ", Toast.LENGTH_SHORT).show();

            }
        });


        //ApiClient apiClient= ApiClient.getApi();
        //ArrayList<Inmueble> inmuebles = apiClient.obtnerPropiedades();
        //this.inmueblesMutable.setValue(inmuebles);

    }
}
