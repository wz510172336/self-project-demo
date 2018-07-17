package com.taotao.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemCat {
	@JsonProperty("u")
	private String url;
	@JsonProperty("n")
	private String node;
	@JsonProperty("i")
	private List Item;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public List getItem() {
		return Item;
	}

	public void setItem(List item) {
		Item = item;
	}

}
