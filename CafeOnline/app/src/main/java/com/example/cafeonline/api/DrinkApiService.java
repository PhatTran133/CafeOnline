package com.example.cafeonline.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cafeonline.model.request.DrinkRequestModel;
import com.example.cafeonline.model.request.ResetPasswordRequest;
import com.example.cafeonline.model.request.UserProfileRequest;
import com.example.cafeonline.model.request.VerifyCodeRequest;
import com.example.cafeonline.model.response.ApiResponse;
import com.example.cafeonline.model.response.DrinkResponse;
import com.example.cafeonline.model.response.UserResponse;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DrinkApiService {

    //PHAT
    @GET("/api/Drink/{drinkId}/details")
    Call<ApiResponse<DrinkResponse>> getDrinkDetail(@Path("drinkId") int drinkId);
    @GET("/api/Drink/filter")
    Call<ApiResponse<List<DrinkResponse>>> getDrinkFilter(@Query("name") String name );
}
