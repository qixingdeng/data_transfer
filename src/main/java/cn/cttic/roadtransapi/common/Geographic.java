package cn.cttic.roadtransapi.common;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

public class Geographic {
	/**
	 * @param raidus 单位米
	 * return minLat,minLng,maxLat,maxLng
	*/
	 public static double[] getAround(double lat, double lon, int raidus) {

		 
	 Double latitude = lat;
	 Double longitude = lon;

	 Double degree = (24901 * 1609) / 360.0;
	 double raidusMile = raidus;

	 Double dpmLat = 1 / degree;
	 Double radiusLat = dpmLat * raidusMile;
	 Double minLat = latitude - radiusLat;
	 Double maxLat = latitude + radiusLat;

	 Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
	 Double dpmLng = 1 / mpdLng;
	 Double radiusLng = dpmLng * raidusMile;
	 Double minLng = longitude - radiusLng;
	 Double maxLng = longitude + radiusLng;
	 return new double[]{minLat, minLng, maxLat, maxLng};
	}
	 
	 
	 /**
	     * 根据经纬度和距离返回一个矩形范围
	     * 
	     * @param lng
	     *            经度
	     * @param lat
	     *            纬度
	     * @param distance
	     *            距离(单位为米)
	     * @return [lng1,lat1, lng2,lat2] 矩形的左下角(lng1,lat1)和右上角(lng2,lat2)
	     */
	  public static double[] getRectangle(double lng, double lat, long distance) {
	        float delta = 111000;
	        if (lng != 0 && lat != 0) {
	            double lng1 = lng - distance
	                    / Math.abs(Math.cos(Math.toRadians(lat)) * delta);
	            double lng2 = lng + distance
	                    / Math.abs(Math.cos(Math.toRadians(lat)) * delta);
	            double lat1 = lat - (distance / delta);
	            double lat2 = lat + (distance / delta);
	            return new double[] { lng1, lat1, lng2, lat2 };
	        } else {
	            // TODO ZHCH 等于0时的计算公式
	            double lng1 = lng - distance / delta;
	            double lng2 = lng + distance / delta;
	            double lat1 = lat - (distance / delta);
	            double lat2 = lat + (distance / delta);
	            return new double[] { lng1, lat1, lng2, lat2 };
	        }
	    }
	  
	  /**
	     * 得到两点间的距离 米
	     * 
	     * @param lat1
	     * @param lng1
	     * @param lat2
	     * @param lng2
	     * @return
	     */
	    public static double getDistanceOfMeter(double lng1,double lat1, 
	    		 double lng2 , double lat2) {
	        double radLat1 = rad(lat1);
	        double radLat2 = rad(lat2);
	        double a =  Arith.sub(radLat1,  radLat2);
	        double b = rad(lng1) - rad(lng2);
	        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
	                + Math.cos(radLat1) * Math.cos(radLat2)
	                * Math.pow(Math.sin(b / 2), 2)));
	        s = s * EARTH_RADIUS;
	        s = Math.round(s * 10000) / 10;
	        return s;
	    }
	     
	    private static double rad(double d) {
	    	double num = Arith.mul(d, Math.PI);
	    			
	        return  Arith.div(num, 180.0);
	    }
	 
	    /**
	     * 地球半径：6378.137KM
	     */
	    public static double EARTH_RADIUS = 6378.137;
	    
	
	     
	    /**
	     * 计算经纬度点对应正方形4个点的坐标
	     *
	     * @param longitude
	     * @param latitude
	     * @param distance
	     * @return
	     */
	    public static Map<String, double[]> returnLLSquarePoint(double longitude,
	            double latitude, double distance) {
	    	
	        Map<String, double[]> squareMap = new HashMap<String, double[]>();
	        // 计算经度弧度,从弧度转换为角度
	        double dLongitude = 2 * (Math.asin(Math.sin(distance
	                / (2 * EARTH_RADIUS))
	                / Math.cos(Math.toRadians(latitude))));
	        dLongitude = Math.toDegrees(dLongitude);
	        // 计算纬度角度
	        double dLatitude = distance / EARTH_RADIUS;
	        dLatitude = Math.toDegrees(dLatitude);
	        // 正方形
	        
	        double[] leftTopPoint = { latitude + dLatitude, longitude - dLongitude };
	        double[] rightTopPoint = { latitude + dLatitude, longitude + dLongitude };
	        double[] leftBottomPoint = { latitude - dLatitude,longitude - dLongitude };
	        double[] rightBottomPoint = { latitude - dLatitude,longitude + dLongitude };
	        
	        
	        double[] topPoint = { latitude + dLatitude, longitude  };
	        double[] bottomPoint = { latitude - dLatitude,longitude  };
	        double[] leftPoint = { latitude ,longitude - dLongitude };
	        double[] rightPoint = { latitude , longitude + dLongitude };
	       
	        squareMap.put("leftTopPoint", leftTopPoint);
	        squareMap.put("rightTopPoint", rightTopPoint);
	        squareMap.put("leftBottomPoint", leftBottomPoint);
	        squareMap.put("rightBottomPoint", rightBottomPoint);
	        
	        squareMap.put("topPoint", topPoint);
	        squareMap.put("bottomPoint", bottomPoint);
	        squareMap.put("leftPoint", leftPoint);
	        squareMap.put("rightPoint", rightPoint);
	         
	        return squareMap;
	    }
	    
	    
	    
	    /**
	     * 根据经纬度2个经纬度算出来矩形四个角的点（居中）
	     *
	     * @param first(longitude,latitude) -- 经度，纬度
	     * @param end
	     * @return
	     */
	    
	    public static double[] getDistancePoint(double longitude,double latitude,double distance){
    		double dLongitude = 2 * (Math.asin(Math.sin(distance
	                / (2 * EARTH_RADIUS))
	                / Math.cos(Math.toRadians(latitude))));
	        dLongitude = Math.toDegrees(dLongitude);
	        // 计算纬度角度
	        double dLatitude = distance / EARTH_RADIUS;
	        dLatitude = Math.toDegrees(dLatitude);
	        
	        double[] point = { dLatitude, dLongitude };
	        
	        return point ;
	    }
	    
	    public static double  floor(double num){
	    	BigDecimal numbig = new BigDecimal(num);
	    	numbig =  numbig.setScale(6, BigDecimal.ROUND_HALF_EVEN);
	    	return numbig.doubleValue();
	    }
	    
	    public static Map<String, double[]> rectanguPointOfMidde(double[] first,
	    		double[] end , double wide) {
	    	
	    	BigDecimal fristlongitude = new BigDecimal(first[0]);
    		BigDecimal fristlatitude = new BigDecimal(first[1]);
    		BigDecimal endlongitude = new BigDecimal(end[0]); 
    		BigDecimal endlatitude = new BigDecimal(end[1]);
    		
    		
	    	double distance  = getDistanceOfMeter(fristlongitude.doubleValue(),fristlatitude.doubleValue(),endlongitude.doubleValue(),endlatitude.doubleValue());
	    	Map<String, double[]> squareMap= Maps.newHashMap();
	    	if(distance>0){
	    		
	    	    double length = 0 ;
	    	    
	    		if(fristlongitude.compareTo(endlongitude) == 0 && fristlatitude.compareTo(endlatitude)!=0){
	    			length =Arith.div(wide, 1000);
	    		}
	    		else if (fristlongitude.compareTo(endlongitude) != 0 && fristlatitude.compareTo(endlatitude)==0) {
	    			length =Arith.div(wide, 1000);
				}
	    		else {
	    			length = wide / Math.sqrt(2)/1000; // 的边长长度，单位 米
				}
	    	
	    		
	    		Map<String, double[]> fristsquareMap = returnLLSquarePoint(fristlongitude.doubleValue(),fristlatitude.doubleValue(),length);
	    		Map<String, double[]> endsquareMap = returnLLSquarePoint(endlongitude.doubleValue(),endlatitude.doubleValue(),length);
	    		
	    		
	    		if(fristlongitude.compareTo(endlongitude) == 0 && fristlatitude.compareTo(endlatitude)!=0){
	    			// 精度相同（x轴相等)
	    			squareMap.put("1", fristsquareMap.get("leftPoint"));
    				squareMap.put("2", fristsquareMap.get("rightPoint"));
    				squareMap.put("3", endsquareMap.get("rightPoint"));
    		        squareMap.put("4", endsquareMap.get("leftPoint"));
    		        
	    			
	    		}
	    		else if (fristlongitude.compareTo(endlongitude) != 0 && fristlatitude.compareTo(endlatitude)==0) {
	    			squareMap.put("1", fristsquareMap.get("topPoint"));
    				squareMap.put("2", fristsquareMap.get("bottomPoint"));
    				squareMap.put("3", endsquareMap.get("bottomPoint"));
    		        squareMap.put("4", endsquareMap.get("topPoint"));
	    			
				}
	    		else {
	    			/*if(endlatitude.compareTo(fristlatitude)>0){
	    				squareMap.put("1", fristsquareMap.get("leftBottomPoint"));
	    				squareMap.put("2", fristsquareMap.get("rightTopPoint"));
	    				squareMap.put("3", endsquareMap.get("rightTopPoint"));
	    		        squareMap.put("4", endsquareMap.get("leftBottomPoint"));
	    			}else {
	    				squareMap.put("1", fristsquareMap.get("leftTopPoint"));
	    		        squareMap.put("2", fristsquareMap.get("rightBottomPoint"));
	    		        squareMap.put("3", endsquareMap.get("rightBottomPoint"));
	    		        squareMap.put("4", endsquareMap.get("leftTopPoint"));
					}*/
	    			if (fristlongitude.compareTo(endlongitude) > 0 && fristlatitude.compareTo(endlatitude) > 0){
	    				squareMap.put("1", fristsquareMap.get("leftTopPoint"));
	    		        squareMap.put("2", fristsquareMap.get("rightBottomPoint"));
	    		        squareMap.put("3", endsquareMap.get("rightBottomPoint"));
	    		        squareMap.put("4", endsquareMap.get("leftTopPoint"));
	    			}
	    			else if (fristlongitude.compareTo(endlongitude) > 0 && fristlatitude.compareTo(endlatitude) < 0){
	    				squareMap.put("1", fristsquareMap.get("rightTopPoint"));
	    		        squareMap.put("2", fristsquareMap.get("leftBottomPoint"));
	    		        squareMap.put("3", endsquareMap.get("leftBottomPoint"));
	    		        squareMap.put("4", endsquareMap.get("rightTopPoint"));
	    			}
	    			else if (fristlongitude.compareTo(endlongitude) < 0 && fristlatitude.compareTo(endlatitude) > 0){
	    				squareMap.put("1", fristsquareMap.get("leftBottomPoint"));
	    				squareMap.put("2", fristsquareMap.get("rightTopPoint"));
	    				squareMap.put("3", endsquareMap.get("rightTopPoint"));
	    		        squareMap.put("4", endsquareMap.get("leftBottomPoint"));
	    			}
	    			else if (fristlongitude.compareTo(endlongitude) < 0 && fristlatitude.compareTo(endlatitude) < 0){
	    				squareMap.put("1", fristsquareMap.get("rightBottomPoint"));
	    				squareMap.put("2", fristsquareMap.get("leftTopPoint"));
	    				squareMap.put("3", endsquareMap.get("leftTopPoint"));
	    		        squareMap.put("4", endsquareMap.get("rightBottomPoint"));
	    			}
				}
	    	}else {
	    		squareMap.put("1", first);
		        squareMap.put("2", first);
		        squareMap.put("3", first);
		        squareMap.put("4", first);
			}
	    	
	        return squareMap;
	    }
	    
	   
	    /**
	     * 基于googleMap中的算法得到两经纬度之间的距离,计算精度与谷歌地图的距离精度差不多，相差范围在0.2米以下
	     * @param lon1 第一点的精度
	     * @param lat1 第一点的纬度
	     * @param lon2 第二点的精度
	     * @param lat3 第二点的纬度
	     * @return 返回的距离，单位m
	     * */
	    public static double GetDistance(double lon1,double lat1,double lon2, double lat2)
	    {     
	       double radLat1 = rad(lat1);
	       double radLat2 = rad(lat2);
	       double a = radLat1 - radLat2;
	       double b = rad(lon1) - rad(lon2);
	       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
	       s = s * EARTH_RADIUS;
	       s = Math.round(s * 10000) / 10000;
	       return s;
	    }
	   	 
}
