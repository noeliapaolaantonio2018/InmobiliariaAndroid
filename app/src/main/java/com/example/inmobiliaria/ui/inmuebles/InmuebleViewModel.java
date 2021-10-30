package com.example.inmobiliaria.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.net.DnsResolver;
import android.telecom.Call;
import android.widget.Toast;

import com.example.inmobiliaria.modelo.Inmuebles;
import com.example.inmobiliaria.request.ApiClient;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class InmuebleViewModel extends AndroidViewModel {

    private MutableLiveData<Inmuebles> inmuebleMutable;
    private Context context;

    public InmuebleViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Inmuebles> getInmueble() {
        if (inmuebleMutable == null) {
            inmuebleMutable = new MutableLiveData<>();
        }
        return inmuebleMutable;
    }

    public void cargarInmueble(int id){
        Call<Inmuebles> inmueble = ApiClient.getMyApiClient().obtenerPorId(id,ApiClient.obtenerToken(context));
        inmueble.enqueue(new DnsResolver.Callback<Inmuebles>() {
            @Override
            public void onResponse(Call<Inmuebles> call, Response<Inmuebles> response) {
                if(response.isSuccessful()){
                    inmuebleMutable.postValue(response.body());
                }
                else{

                    Toast.makeText(context, "El Inmueble no se ha encontrado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Inmuebles> call, Throwable t) {
                Toast.makeText(context, "A ocurrido un error!!! :( ", Toast.LENGTH_SHORT).show();
            }
        });

        //Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        //inmuebleMutable.setValue(inmueble);
    }


    public void modificarrDisponible(int id){
        Call<Inmuebles> estadoInmueble= ApiClient.getMyApiClient().modificarDisponible(ApiClient.obtenerToken(context),id);

        estadoInmueble.enqueue(new DnsResolver.Callback<Inmuebles>() {
            @Override
            public void onResponse(Call<Inmuebles> call, Response<Inmuebles> response) {
                if(response.isSuccessful()){
                    inmuebleMutable.setValue(response.body());
                }
                else{
                    Toast.makeText(context, "inmueble no encontrado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmuebles> call, Throwable t) {
                Toast.makeText(context, "Ha ocurrio un error :( ", Toast.LENGTH_LONG).show();
            }
        });




//ApiClient apiClient = ApiClient.getApi();
        //apiClient.actualizarInmueble(inmueble);
        //this.inmuebleMutable.setValue(inmueble);
    }
}
