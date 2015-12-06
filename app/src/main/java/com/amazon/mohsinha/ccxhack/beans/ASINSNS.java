package com.amazon.mohsinha.ccxhack.beans;

public class ASINSNS {

	private String Title;
	private String ASIN;
	private String ImageUrl;
	private Float Price;
	private Float ShippingPrice;
	private Integer Count;
	private Float MEAN;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getASIN() {
		return ASIN;
	}
	public void setASIN(String aSIN) {
		ASIN = aSIN;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public Float getShippingPrice() {
		return ShippingPrice;
	}
	public void setShippingPrice(Float shippingPrice) {
		ShippingPrice = shippingPrice;
	}
	public Integer getCount() {
		return Count;
	}
	public void setCount(Integer count) {
		Count = count;
	}
	public Float getMEAN() {
		return MEAN;
	}
	public void setMEAN(Float mEAN) {
		MEAN = mEAN;
	}
}
