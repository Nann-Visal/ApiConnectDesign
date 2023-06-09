package com.example.apiconnectdesign.api.service;

import com.example.apiconnectdesign.api.model.Province;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/provinces.json")
    Call<List<Province>> loadProvinceList();
}
