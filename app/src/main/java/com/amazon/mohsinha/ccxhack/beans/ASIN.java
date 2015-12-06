package com.amazon.mohsinha.ccxhack.beans;

public class ASIN {

	private String title;
	private String asin;
	private String imageUrl;
	private Float price;
	private Float shippingPrice;
	private Float mean;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(Float shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public Float getMean() {
		return mean;
	}
	public void setMean(Float mean) {
		this.mean = mean;
	}
	public Float getVar() {
		return var;
	}
	public void setVar(Float var) {
		this.var = var;
	}
	public String getAcr() {
		return acr;
	}
	public void setAcr(String acr) {
		this.acr = acr;
	}
	private Float var;
	private String acr;

}
