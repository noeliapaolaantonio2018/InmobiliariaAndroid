package com.example.inmobiliaria.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.net.DnsResolver;
import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import com.example.inmobiliaria.modelo.Contratos;
import com.example.inmobiliaria.modelo.Inmuebles;
import com.example.inmobiliaria.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ContratosViewModel extends AndroidViewModel {

    private MutableLiveData<List<Contratos>> inmueblesMutable;
    private Context context;

    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<List<Contratos>> getInmuebles() {
        if (inmueblesMutable == null) {
            inmueblesMutable = new MutableLiveData<>();
        }
        return inmueblesMutable;
    }

    //Acá traemos los inmuebles que tienen contratos vigentes en la ApiClient
    public void cargarInmueblesConContrato() {

        Call<List<Contratos>> inmueblesConContratoV = ApiClient.getMyApiClient().inmueblesConContrato(ApiClient.obtenerToken(context));
        inmueblesConContratoV.enqueue(new DnsResolver.Callback<List<Contratos>>() {
            @Override
            public void onResponse(Call<List<Contratos>> call, Response<List<Contratos>> response) {
                if(response.isSuccessful()){
                    ArrayList<Inmuebles> inmuebles = new ArrayList<>();
                    Log.d("salida",response.body().get(0).getIdContrato()+"");
                    for(Contratos c: response.body()){
                        inmuebles.add(c.getInmuebles());

                    }
                    inmueblesMutable.postValue(response.body());

                }else{
                    Toast.makeText(context, "Sin respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Contratos>> call, Throwable t) {
                Log.d("Error ",t.getMessage());

                Toast.makeText(context, "Inesperadamente a ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        });


        //ApiClient apiClient= ApiClient.getApi();
        //ArrayList<Inmueble> inmuebles= apiClient.obtenerPropiedadesAlquiladas();
        //this.inmueblesMutable.setValue(inmuebles);

    }
}
