package com.example.langeweileade;

public class RowItem {
    private int imageId;
    private String title;
    private String desc;
    private String price;
  
    
    public RowItem(int imageId, String title, String desc, String price) {
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
        this.setPrice(price);
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return title + "\n" + desc;
    }
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}