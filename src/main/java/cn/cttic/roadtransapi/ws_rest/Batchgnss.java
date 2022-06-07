package cn.cttic.roadtransapi.ws_rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("batchgnss")
public class Batchgnss {
	
	@JsonProperty(value="batchgnss")
	 private String context;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
