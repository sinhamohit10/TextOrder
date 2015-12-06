package com.amazon.mohsinha.ccxhack.apicalls;

/**
 * Created by mohsinha on 12/5/15.
 */

import com.amazon.mohsinha.ccxhack.beans.ASIN;
import com.amazon.mohsinha.ccxhack.beans.ASINData;
import com.amazon.mohsinha.ccxhack.beans.ASINResp;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.Call;
public interface ServiceAPI {

    @GET("/find")
    Call<List<ASIN>> find(@Query("query") String query);

    @GET("/sns")
    Call<List<ASINData>> sns();

    @GET("/snscart")
    Call<List<ASINData>> snscart(@Query("cart") String cart);

}
