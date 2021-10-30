package com.example.inmobiliaria.ui.contratos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Contratos;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

public class ContratosFragment extends Fragment {
    private ContratosViewModel contratosViewModel;
    private RecyclerView rvInmuebles;
    private InmuebleConContratoAdapter adapter;
    Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contratos_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {

        contratosViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication()).create(ContratosViewModel.class);
        rvInmuebles = view.findViewById(R.id.rvInmuebles);
        contratosViewModel.getInmuebles().observe(getViewLifecycleOwner(), new Observer<List<Contratos>>() {
            @Override
            public void onChanged(List<Contratos> contratos) {
                adapter = new InmuebleConContratoAdapter(context, contratos, getLayoutInflater());
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, RecyclerView.VERTICAL, false);
                rvInmuebles.setLayoutManager(gridLayoutManager);
                rvInmuebles.setAdapter(adapter);
            }
        });
        contratosViewModel.cargarInmueblesConContrato();
    }
}
