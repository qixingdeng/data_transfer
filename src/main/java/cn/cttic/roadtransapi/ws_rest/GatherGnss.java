package cn.cttic.roadtransapi.ws_rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Strings;


@JsonRootName("gnss")
public class GatherGnss{
	
	public GatherGnss(){
		
	}
	private String accesscode ;
	public String getAccesscode() {
		return accesscode;
	}
	public void setAccesscode(String accesscode) {
		this.accesscode = accesscode;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCur_accesscode() {
		return cur_accesscode;
	}
	public void setCur_accesscode(String cur_accesscode) {
		this.cur_accesscode = cur_accesscode;
	}
	public String getWarn_flg() {
		return warn_flg;
	}
	public void setWarn_flg(String warn_flg) {
		this.warn_flg = warn_flg;
	}
	public String getStatus_flg() {
		return status_flg;
	}
	public void setStatus_flg(String status_flg) {
		this.status_flg = status_flg;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getOd_rate() {
		return od_rate;
	}
	public void setOd_rate(String od_rate) {
		this.od_rate = od_rate;
	}
	public String getLocator_rate() {
		return locator_rate;
	}
	public void setLocator_rate(String locator_rate) {
		this.locator_rate = locator_rate;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getPosition_time() {
		return position_time;
	}
	public void setPosition_time(String position_time) {
		this.position_time = position_time;
	}
	public String getRecv_time() {
		return recv_time;
	}
	public void setRecv_time(String recv_time) {
		this.recv_time = recv_time;
	}
	
	@JsonProperty(value="trans_type")
	private String trans ;
	private String vin ;
	private String color ; 
	private String cur_accesscode ;
	
	@JsonProperty(value="warn")
	private String warn_flg ;
	@JsonProperty(value="state")
	private String status_flg ; 
	@JsonProperty(value="lon")
	private String longitude ;
	@JsonProperty(value="lat")
	private String latitude ;
	private String od_rate;
	private String locator_rate;
	
	@JsonIgnore
	private String mileage ; 
	private String direction ;
	
	@JsonProperty(value="elevation")
	private String height ; 
	private String position_time ; 
	private String recv_time ;
	
	public String toString()
    {
		StringBuffer buffer = new StringBuffer();
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":accesscode);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":trans );
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":vin);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":color);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":cur_accesscode);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":longitude);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":latitude);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":warn_flg);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":status_flg);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":height);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":od_rate);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":locator_rate);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":mileage);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":direction);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":position_time);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":recv_time);
		buffer.append(",");
		buffer.append(Strings.isNullOrEmpty(accesscode)?"":locator_rate);
		
        return  buffer.toString();
    }
	
}
