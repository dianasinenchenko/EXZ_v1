package com.devitis.exz_v1.data.network.api;

import com.devitis.exz_v1.data.models.responce.KIPResponce;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Diana on 15.04.2019.
 */

public interface APIService {

    @GET("kip/")
    Call<KIPResponce> getKip();

    @GET("skz/")
    Call<KIPResponce> getSkz();

}
