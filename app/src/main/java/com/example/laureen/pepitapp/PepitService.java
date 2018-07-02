package com.example.laureen.pepitapp;

import com.example.laureen.pepitapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PepitService {
    @GET("3")
    Call<List<User>> getUser();

    @POST("auth/signup/")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("auth/signin")
    Call<String> loginUser(@Field("username") String username, @Field("password") String password);

}
