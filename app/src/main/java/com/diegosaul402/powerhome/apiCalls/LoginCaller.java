package com.diegosaul402.powerhome.apiCalls;

import android.util.Log;
import android.view.View;

import com.diegosaul402.powerhome.api.ApiService;
import com.diegosaul402.powerhome.api.ApiUtils;
import com.diegosaul402.powerhome.models.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by diego on 11/02/2018.
 */

public class LoginCaller {
    private ApiService mAPIService;
    private LoginResponse mResponse;

    public LoginCaller(LoginResponse responseListener){
        this.mResponse = responseListener;
    }

    public void callLogin(String email, String password){
        mResponse.inProgress(true);
        mAPIService = ApiUtils.getAPIService();

        mAPIService.callLogin(email, password).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                mResponse.successLogin(response.body(),
                        response.headers().get("Access-token"),
                        response.headers().get("Client"));
                mResponse.inProgress(false);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                mResponse.errorLogin(call.toString());
                mResponse.inProgress(false);
            }
        });
    }

    public interface LoginResponse{
        void successLogin(Data response, String accessToken, String client);
        void errorLogin(String error);
        void inProgress(boolean isInProgress);
    }
}
