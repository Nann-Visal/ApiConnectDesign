package com.example.apiconnectdesign.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apiconnectdesign.api.model.Province;
import com.example.apiconnectdesign.api.service.ApiService;
import com.example.apiconnectdesign.databinding.FragmentProvincesBinding;
import com.example.apiconnectdesign.ui.adapter.ProvincesAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProvincesFragment extends Fragment {

    private FragmentProvincesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Create obj binding for call layout-view
        com.example.apiconnectdesign.databinding.FragmentProvincesBinding binding = FragmentProvincesBinding.inflate(inflater, container, false);
        this.binding = binding;

        //Call layout-view by biding obj
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Load list provinces from server (api)
        loadProvinceListFromServer();
    }

    //function load data
    private void loadProvinceListFromServer(){

        //create http client
        Retrofit httpClient = new Retrofit.Builder()
                .baseUrl("https://tests3bk.s3.ap-southeast-1.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create service obj
        ApiService apiService = httpClient.create(ApiService.class);

        //load data
        Call<List<Province>> task = apiService.loadProvinceList();
        task.enqueue(new Callback<List<Province>>() {
            @Override
            public void onResponse(Call<List<Province>> call, Response<List<Province>> response) {

                if(response.isSuccessful()){
                    showProvincesList(response.body());
                }else{
                    Toast.makeText(getContext(),"Data Failed!!",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Province>> call, Throwable t) {
                Toast.makeText(getContext(),"Data Failed!!",Toast.LENGTH_LONG).show();
            }
        });
    }

    //function show list
    private void showProvincesList(List<Province> provinceList){

        //create layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.idRecyclerView.setLayoutManager(layoutManager);

        //create adapter
        ProvincesAdapter adapter = new ProvincesAdapter();
        adapter.submitList(provinceList);
        binding.idRecyclerView.setAdapter(adapter);
    }
}
