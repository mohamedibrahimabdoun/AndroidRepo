package com.CustomClasses;

public class Restaurants {
	
	private int REST_ID;
	private String REST_NAME;
	private String REST_EMAIL;
	private String REST_WEBSITE;
	private String REST_PATH;
	private String REST_IMAGE_NAME;
	private boolean selected;
	
	public int getREST_ID() {
		return REST_ID;
	}
	public void setREST_ID(int rEST_ID) {
		REST_ID = rEST_ID;
	}
	public String getREST_NAME() {
		return REST_NAME;
	}
	public void setREST_NAME(String rEST_NAME) {
		REST_NAME = rEST_NAME;
	}
	public String getREST_EMAIL() {
		return REST_EMAIL;
	}
	public void setREST_EMAIL(String rEST_EMAIL) {
		REST_EMAIL = rEST_EMAIL;
	}
	public String getREST_WEBSITE() {
		return REST_WEBSITE;
	}
	public void setREST_WEBSITE(String rEST_WEBSITE) {
		REST_WEBSITE = rEST_WEBSITE;
	}
	public String getREST_PATH() {
		return REST_PATH;
	}
	public void setREST_PATH(String rEST_PATH) {
		REST_PATH = rEST_PATH;
	}
	public String getREST_IMAGE_NAME() {
		return REST_IMAGE_NAME;
	}
	public void setREST_IMAGE_NAME(String rEST_IMAGE_NAME) {
		REST_IMAGE_NAME = rEST_IMAGE_NAME;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
