package com.mapbox.mapboxandroiddemo.account;

import com.mapbox.mapboxandroiddemo.model.usermodel.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Service for making call to Mapbox API for account information
 */

interface MapboxAccountRetrofitService {

  @GET("User/{username}")
  Call<UserResponse> getUserAccount(@Path("username") String userName, @Query("access_token") String accessToken);

  @FormUrlEncoded
  @POST("grant_type=authorization_code&client_id={clientId}&client_secret={clientSecret}"
    + "&redirect_uri={redirectUri}&code={code}")
  Call<Object> getAccessToken(@Header("User-Agent") String userAgentHeader,
                              @Field("clientId") String clientId,
                              @Field("clientSecret") String clientSecret,
                              @Field("redirectUri") String redirectUri,
                              @Field("code") String code);
}