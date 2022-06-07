package cn.cttic.roadtransapi.ws_rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

public class BatchgnssList {
	@JsonProperty(value="data")
	private List<Batchgnss> batchgnssList = Lists.newArrayList();

	public List<Batchgnss> getBatchgnssList() {
		return batchgnssList;
	}

	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String code;
}
