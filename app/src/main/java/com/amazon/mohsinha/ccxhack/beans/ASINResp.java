package com.amazon.mohsinha.ccxhack.beans;

import java.util.List;
/**
 * Created by mohsinha on 12/5/15.
 */
public class ASINResp {

    List<ASIN> data;

    public List<ASIN> getData() {
        return data;
    }

    public void setData(List<ASIN> data) {
        this.data = data;
    }
}
