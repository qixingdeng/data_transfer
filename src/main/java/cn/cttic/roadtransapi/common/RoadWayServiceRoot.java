package cn.cttic.roadtransapi.common;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public  class RoadWayServiceRoot{

	public RoadWayServiceRoot(){
		smParamNode.setId("0000");
	}
	
	private smParamNode smParamNode = new smParamNode() ;

	public smParamNode getSmParamNode() {
		return smParamNode;
	}

	public void setSmParamNode(smParamNode smParamNode) {
		this.smParamNode = smParamNode;
	}
	
	
	public String getBusitable() {
		return busitable;
	}

	public void setBusitable(String busitable) {
		this.busitable = busitable;
	}

	private String busitable ;

}