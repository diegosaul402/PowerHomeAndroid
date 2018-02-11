package com.diegosaul402.powerhome.api;

/**
 * Created by diego on 11/02/2018.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://aqueous-woodland-61813.herokuapp.com/";

    public static ApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
