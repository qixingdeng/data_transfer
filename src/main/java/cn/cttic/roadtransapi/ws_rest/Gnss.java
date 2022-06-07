package cn.cttic.roadtransapi.ws_rest;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Gnss{
	
	public Gnss(){
		
	}
	
	@JsonProperty(value="gnss")
	private GatherGnss gatherGnsse ;

	public GatherGnss getGatherGnsse() {
		return gatherGnsse;
	}

	public void setGatherGnsse(GatherGnss gatherGnsse) {
		this.gatherGnsse = gatherGnsse;
	}
	
}
