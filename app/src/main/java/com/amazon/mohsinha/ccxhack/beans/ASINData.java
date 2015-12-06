package com.amazon.mohsinha.ccxhack.beans;

public class ASINData {
	private String Title;
	private String ASIN;
	private String ImageURL;
	private String Price;
	private String ShippingCost;
	private String ACR;
	private String MEAN;
	private String VAR;
	private String LastOrder;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getASIN() {
		return ASIN;
	}

	public void setASIN(String ASIN) {
		this.ASIN = ASIN;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getShippingCost() {
		return ShippingCost;
	}

	public void setShippingCost(String shippingCost) {
		ShippingCost = shippingCost;
	}

	public String getACR() {
		return ACR;
	}

	public void setACR(String ACR) {
		this.ACR = ACR;
	}

	public String getMEAN() {
		return MEAN;
	}

	public void setMEAN(String MEAN) {
		this.MEAN = MEAN;
	}

	public String getVAR() {
		return VAR;
	}

	public void setVAR(String VAR) {
		this.VAR = VAR;
	}

	public String getLastOrder() {
		return LastOrder;
	}

	public void setLastOrder(String lastOrder) {
		LastOrder = lastOrder;
	}
}
