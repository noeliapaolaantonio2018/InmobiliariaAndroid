package com.example.inmobiliaria.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.net.DnsResolver;
import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import com.example.inmobiliaria.modelo.Contratos;
import com.example.inmobiliaria.request.ApiClient;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ContratoViewModel extends AndroidViewModel {

    private MutableLiveData<Contratos> contratoMutable;
    private Context context;

    public ContratoViewModel(@NonNull Application application) {

        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<Contratos> getContrato() {
        if (contratoMutable == null) {
            contratoMutable = new MutableLiveData<>();
        }
        return contratoMutable;

    }

    //aca recibimos un inmueble y se busca el contrato vigente
    public void cargarContrato(int id) {
        Log.d("idContrato","id:"+id);
        Call<Contratos> contratoSeleccionado = ApiClient.getMyApiClient().obtenerContratoPorId(id, ApiClient.obtenerToken(context));
        contratoSeleccionado.enqueue(new DnsResolver.Callback<Contratos>() {
            @Override
            public void onResponse(Call<Contratos> call, Response<Contratos> response) {
                if(response.isSuccessful()) {
                    contratoMutable.postValue(response.body());
                }
                else
                    Toast.makeText(context, "El Contrato no se ha encontrado!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Contratos> call, Throwable t) {
                Log.d("contrato","ERROR"+t.getMessage());
                Toast.makeText(context, "Inesperadamente  a ocurrido un ERROR ", Toast.LENGTH_SHORT).show();
            }
        });
        //Inmueble inmueble = (Inmueble) bundle.get("inmueble");
        //ApiClient apiClient= ApiClient.getApi();
        //Contrato contrato= apiClient.obtenerContratoVigente(inmueble);
        //this.contratoMutable.setValue(contrato);

    }
}
