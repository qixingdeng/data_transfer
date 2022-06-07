package cn.cttic.roadtransapi.orm.waterway.domain;


public class VoluIrreShipExtModel extends VoluIrreShip{
	
	private String period; //运量周期
	
	private String shipType; //船舶类型

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

}
