package com.example.inmobiliaria.ui.contratos;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Contratos;
import com.example.inmobiliaria.modelo.Inmuebles;
import com.example.inmobiliaria.modelo.Inquilinos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class ContratoFragment extends Fragment {

    private ContratoViewModel contratoViewModel;
    private TextView tvCodigoContrato;
    private TextView tvFechaInicio;
    private TextView tvFechaCierre;
    private TextView tvMonto;
    private TextView tvInquilinos;
    private TextView tvInmuebles;
    private Context context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contrato_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        tvCodigoContrato = view.findViewById(R.id.tvCodigoContrato);
        tvFechaInicio = view.findViewById(R.id.tvFechaInicio);
        tvFechaCierre = view.findViewById(R.id.tvFechaFin);
        tvMonto = view.findViewById(R.id.tvImporte);
        tvInquilinos = view.findViewById(R.id.tvInquilino);
        tvInmuebles = view.findViewById(R.id.tvInmueble);
        int id =getArguments().getInt("id");
        contratoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);
        contratoViewModel.getContrato().observe(getViewLifecycleOwner(), new Observer<Contratos>() {


            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onChanged(Contratos contratos) {

                tvCodigoContrato.setText(contratos.getIdContr() + "");
                //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                LocalDateTime formatoSalida= LocalDateTime.parse(contratos.getFechaInicio());
                LocalDate formatoEntrada= formatoSalida.toLocalDate();
                tvFechaInicio.setText(formatoEntrada.toString());

                LocalDateTime fc = LocalDateTime.parse(contratos.getFechaCierre());
                LocalDate hhh = fc.toLocalDate();
                tvFechaCierre.setText(hhh.toString());



                tvMonto.setText("$" + contratos.getMonto());
                tvInquilinos.setText(contratos.getInquilinos().getNombre() + " " + contratos.getInquilinos().getApellido());
                tvInmuebles.setText("Domicilio:  " + contratos.getInmuebles().getDireccion());

            }

        });

        contratoViewModel.cargarContrato(id);



    }



}
