package com.diegosaul402.powerhome.api;

import com.diegosaul402.powerhome.models.Data;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by diego on 11/02/2018.
 */

public interface ApiService {
    @POST("/auth/sign_in")
    @FormUrlEncoded
    Call<Data> callLogin(@Field("email") String email, @Field("password") String password);
}
