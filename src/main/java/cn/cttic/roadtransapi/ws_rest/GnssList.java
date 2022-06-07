package cn.cttic.roadtransapi.ws_rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;


public class GnssList{
	
	public GnssList(){
		
	}
	
	@JsonProperty(value="data")
	private List<Gnss> gatherGnsses = Lists.newArrayList();

	public List<Gnss> getGatherGnsses() {
		return gatherGnsses;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String code;
	
	
}
