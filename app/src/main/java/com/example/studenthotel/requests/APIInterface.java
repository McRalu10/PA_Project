package com.example.studenthotel.requests;

import com.example.studenthotel.requests.POJO.AccommodationSearch;
import com.example.studenthotel.requests.POJO.ActivitiesSearch;
import com.example.studenthotel.requests.POJO.User;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("/users/register")
    Call<User> register(@Body User user);

    @POST("/users/login")
    Call<User> login(@Body User user);

    @PUT("/users/reset")
    Call<User> reset(@Body User user);

    @GET("/users/out/{userID}")
    Call<Boolean> signOut(@Path("userID") UUID userID);

    @GET("/users/checkin/{userID}")
    Call<Boolean> checkIn(@Path("userID") UUID userID);

    @GET("/users/checkout/{userID}")
    Call<Boolean> checkOut(@Path("userID") UUID userID);

    @GET("accommodation/search")
    Call<AccommodationSearch> searchAccommodation(@Query("first") String first, @Query("second") String second,@Query("roomType") String roomType);

    @GET("activity/search")
    Call<ActivitiesSearch> searchActivity(@Query("first") String first, @Query("second") String second);

    @POST("accommodation/book/{userID}")
    Call<AccommodationSearch> book(@Body AccommodationSearch accommodation, @Path("userID") UUID userID);

    @POST("activity/participate/{activityID}/{userID}")
    Call<ActivitiesSearch> book(@Path("activityID") UUID activityID, @Path("userID") UUID userID);

}
