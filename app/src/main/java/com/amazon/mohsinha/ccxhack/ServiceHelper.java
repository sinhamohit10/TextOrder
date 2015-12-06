package com.amazon.mohsinha.ccxhack;

/**
 * Created by mohsinha on 12/5/15.
 */

import android.app.Activity;
import android.util.Log;

import com.amazon.mohsinha.ccxhack.apicalls.ServiceAPI;
import com.amazon.mohsinha.ccxhack.beans.ASIN;
import com.amazon.mohsinha.ccxhack.beans.ASINData;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ServiceHelper {

    Retrofit retrofit = null;
    Activity activity = null;
    ViewHolderAdapter mAdapter = null;
    ServiceAPI search = null;
    public ServiceHelper(ViewHolderAdapter mAdapter, Activity activity){
         retrofit = new Retrofit.Builder()
                .baseUrl("http://159.203.94.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.mAdapter = mAdapter;
        this.activity = activity;
        this.search = retrofit.create(ServiceAPI.class);
    }

    void callSearch(String query){

        try {
            Call<List<ASIN>> call = search.find(query);
            Log.d("MYTAG", "Making async call");
            //synchronous call
            Response<List<ASIN>> response = call.execute();
            if(response.body().size()>0){
                Log.d("MYTAG", "Callback returned");
                List<MyObj> objList = getItems(response);

                mAdapter.addAll(objList);
                mAdapter.notifyDataSetChanged();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    void callSNS(String cart){
        Call<List<ASINData>> call = null;
        if(cart==null) {
            call = search.sns();
        }else{
            call = search.snscart(cart);
        }
        try {
            Response<List<ASINData>> response = call.execute();
            if (response.body().size() > 0) {
                Log.d("MYTAG", "Callback returned");
                List<MyObj> objList = getItemsSNS(response);

                mAdapter.addAll(objList);
                mAdapter.notifyDataSetChanged();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    private List<MyObj> getItemsSNS(Response<List<ASINData>> response) {
        List<ASINData> resp = response.body();
        List<MyObj> data = new ArrayList<MyObj>();
        MyObj obj2 = new MyObj();
        obj2.setName("Amazon");
        obj2.setTitle("You might want to reoder the following products");
        data.add(obj2);
        int max = 0;
        for(ASINData asin:resp){
            if(max==3){
                break;
            }
            MyObj obj = new MyObj();
            obj.setName("Amazon");
            obj.setTitle(asin.getTitle());
            obj.setDesc(asin.getPrice().toString());
            obj.setImage(asin.getImageURL());
            obj.setRating(asin.getACR());
            obj.setReorder(getReoderString(asin));
            data.add(obj);
            max++;
        }
        return data;
    }

    private List<MyObj> getItems(Response<List<ASIN>> response) {
        List<ASIN> resp = response.body();
        List<MyObj> data = new ArrayList<MyObj>();
        for(ASIN asin:resp){
            MyObj obj = new MyObj();
            obj.setName("Amazon");
            obj.setTitle(asin.getTitle());
            obj.setDesc(asin.getPrice().toString());
            obj.setImage(asin.getImageUrl());
            obj.setRating(asin.getAcr());
            data.add(obj);
        }
        return data;
    }

    private String getReoderString(ASINData asin){
        String reorderString = "You tend to order this every "+asin.getMEAN()+" days\nYour last order was "+asin.getLastOrder()+" days back";
        return reorderString;
    }

}
