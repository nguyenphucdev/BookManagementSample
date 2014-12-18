package com.app.model;

/**
 * @author happy
 */
public class Books {

	private int id;
	private String name;
	private String category;
	private String publisher;
	private String price;
	private String summary;
	private String action;


	public Books() {
	}

	public Books(int id, String name, String category, String publisher, String price, String summary) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.publisher = publisher;
		this.price=price;
		this.summary = summary;
		this.action = "submit";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	 public String getAction() {
	        return action;
	    }
	    public void setAction(String action) {
	        this.action = action;
	    }

	
}
