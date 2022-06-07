package cn.cttic.roadtransapi.mgr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geotools.geometry.jts.JTSFactoryFinder;

import cn.cttic.roadtransapi.common.Arith;
import cn.cttic.roadtransapi.common.Geographic;
import cn.cttic.roadtransapi.common.Geohash;
import cn.cttic.roadtransapi.common.TableValueOper;
import cn.cttic.roadtransapi.orm.map.dao.GsGeohashMapper;
import cn.cttic.roadtransapi.orm.map.dao.InterMapBaseInfoMapper;
import cn.cttic.roadtransapi.orm.map.dao.InterMapRectDetailInfoMapper;
import cn.cttic.roadtransapi.orm.map.dao.InterMapRectInfoMapper;
import cn.cttic.roadtransapi.orm.map.domain.GsGeohash;
import cn.cttic.roadtransapi.orm.map.domain.InterMapBaseInfo;
import cn.cttic.roadtransapi.orm.map.domain.InterMapRectDetailInfo;
import cn.cttic.roadtransapi.orm.map.domain.InterMapRectInfo;
import cn.cttic.sysframe.common.util.DateUtil;
import cn.cttic.sysframe.common.util.SpringContextUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.WKTReader;


public class MapInfoMgr  {
	
	private MapInfoMgr(){
		
		//init();
		
		StartProcess();

//		double angle = getAzimuth(114.6362127064203,24.70480326867117,114.63522389357969,24.704804011328832);
//		System.out.println("angle="+angle);
//		Coordinate pointA = getPointByAzimuth(114.63522389357969,24.704804011328832, angle+90, RoadWayWide/2/1000 );
//		Coordinate pointB = getPointByAzimuth(114.63522389357969,24.704804011328832, angle-90, RoadWayWide/2/1000 );
//		System.out.println("angle="+angle+"pointA.x="+pointA.x+"pointA.y="+pointA.y+"pointB.x="+pointB.x+"pointB.y="+pointB.y);
	}
	
	 

	private static Logger log = Logger.getLogger(MapInfoMgr.class);
	
	private static MapInfoMgr uniqueInstance = null;
	
	public static MapInfoMgr getInstance() {
	    if (uniqueInstance == null) {
	           uniqueInstance = new MapInfoMgr();
	       }
	    
	       return uniqueInstance;   
	}
	  
	private void deleteRect(){
	   
	   rectInfoMapper.deleteByExample(null);
	   
	   rectInfoDetailMapper.deleteByExample(null);
	
	   //gsGeohashMapper.deleteByExample(null);
	}
	
	private InterMapRectInfoMapper rectInfoMapper = SpringContextUtil.getBean(InterMapRectInfoMapper.class);
	private GsGeohashMapper gsGeohashMapper = SpringContextUtil.getBean(GsGeohashMapper.class);
	private Map<String, GsGeohash> mapGsGeohash = Maps.newHashMap();
	private boolean isInitSign = false ;
	
	
	private void init() {
		if (DBMgr.getInstance().getMap_init().equals("1") && !isInitSign) {
			log.debug("地图基本信息需要更新");
			try {
				deleteRect();
				InterMapBaseInfoMapper mapper = SpringContextUtil
						.getBean(InterMapBaseInfoMapper.class);

				List<InterMapBaseInfo> list = mapper.selectByExample(null);

				if (list != null && list.size() > 0) {
					log.debug(String.format(
							"地图基本信息表[InterMapBaseInfo],记录为[%d]", list.size()));
					Map<String, List<InterMapBaseInfo>> infoMap = Maps
							.newHashMap();

					for (InterMapBaseInfo interMapBaseInfo : list) {
						if (interMapBaseInfo == null) {
							continue;
						}
						String countrycode = interMapBaseInfo.getCountrycode();
						List<InterMapBaseInfo> infoList = null;
						if (infoMap.containsKey(countrycode)) {
							infoList = infoMap.get(countrycode);
						} else {
							infoList = Lists.newArrayList();
							infoMap.put(countrycode, infoList);
						}

						infoList.add(interMapBaseInfo);
					}

					for (Map.Entry<String, List<InterMapBaseInfo>> entry : infoMap
							.entrySet()) {
						List<InterMapBaseInfo> infos = entry.getValue();

						Collections.sort(infos,
								new Comparator<InterMapBaseInfo>() {
									public int compare(InterMapBaseInfo arg0,
											InterMapBaseInfo arg1) {
										return (int) (Double.parseDouble(arg0
												.getPileno()) - Double
												.parseDouble(arg1.getPileno()));
									}
								});

						log.debug(String.format("Process : [%s] , 记录条数:[%d]",
								entry.getKey(), infos.size()));
						for (int i = 0; i < infos.size(); i++) {
							if (i == 0) {
								continue;
							}

							String countrycode = infos.get(i).getCountrycode();

							InterMapBaseInfo endBaseInfo = infos.get(i);
							InterMapBaseInfo beginBaseInfo = infos.get(i - 1);

							// 纠正两个桩点经度相同或者纬度相同的情况
							if (beginBaseInfo.getLongitude().compareTo(
									endBaseInfo.getLongitude()) == 0) {
								endBaseInfo
										.setLongitude(String.valueOf(Double
												.parseDouble(endBaseInfo
														.getLongitude()) + 0.0000001));
							}
							if (beginBaseInfo.getLatitude().compareTo(
									endBaseInfo.getLatitude()) == 0) {
								endBaseInfo
										.setLatitude(String.valueOf(Double
												.parseDouble(endBaseInfo
														.getLatitude()) + 0.0000001));
							}
							double pilenolen = Geographic.getDistanceOfMeter(
									Double.parseDouble(beginBaseInfo
											.getLongitude()), Double
											.parseDouble(beginBaseInfo
													.getLatitude()), Double
											.parseDouble(endBaseInfo
													.getLongitude()), Double
											.parseDouble(endBaseInfo
													.getLatitude()));
							log.debug(String.format(
									"Process : 路:[%s] ,桩点:[%s-%s],桩点距离:[%s]米",
									countrycode, beginBaseInfo.getPileno(),
									endBaseInfo.getPileno(),
									String.valueOf(pilenolen)));
							int ret = ProecessPoint(beginBaseInfo, endBaseInfo);
							if (ret != 0) {
								log.debug("地图基本信息表[InterMapBaseInfo]的信息初始化失败，程序退出");
								isInitSign = false;
								break;
							}
						}
						Insert2DB();
					}

				} else {
					log.debug("地图基本信息表[InterMapBaseInfo],记录为0");
				}

			} catch (Exception e) {
				e.printStackTrace();
				isInitSign = false;
			}

			log.debug("地图基本信息表[InterMapBaseInfo],执行完毕");
			isInitSign = true;

		} else {
			log.debug("地图基本信息不需要更新");
			isInitSign = true;
		}
	}

	private enum PilenoMode{
		middle,
		left,
		right
	}
	
	
	private PilenoMode pilenoMode = PilenoMode.middle;
	
	
	// 单位是米
	private double RoadWayWide = 100.0F ; 
	private double PointInterval = 10.0F;
	
	private int ProecessPoint(InterMapBaseInfo beginBaseInfo , InterMapBaseInfo endBaseInfo){
		int ret = -1 ; 
		log.debug(String.format("构造道路矩形方式为[%s],长度为[%d]米",pilenoMode.toString(),RoadWayWide));
		
		double fristlongitude = Double.parseDouble(beginBaseInfo.getLongitude()) ;
		double fristlatitude =  Double.parseDouble(beginBaseInfo.getLatitude()) ;
		
		double endlongitude =  Double.parseDouble(endBaseInfo.getLongitude()) ;
		double endlatitude =  Double.parseDouble(endBaseInfo.getLatitude()) ;
		
		//获取两桩点构成的四边形
		Map<String, double[]> squareMap= Geographic.rectanguPointOfMidde(new double[]{fristlongitude,fristlatitude}, new double[]{endlongitude,endlatitude}, Arith.div(RoadWayWide, 2, 6));
		
		if(squareMap.size()>0){
			log.debug(String.format("将矩形坐标入库，根据矩形坐标构建多边形"));
			InterMapRectInfo record = new InterMapRectInfo();
			record.setPileno(String.format("[%s]-[%s]", beginBaseInfo.getPileno(),endBaseInfo.getPileno()));
			record.setMultipoint(String.format("开始点:[%s,%s],结束点:[%s,%s]", beginBaseInfo.getLongitude(),beginBaseInfo.getLatitude(),endBaseInfo.getLongitude(),endBaseInfo.getLatitude()));
			record.setCountrycode(beginBaseInfo.getCountrycode());
			record.setSectioncode(beginBaseInfo.getSectioncode());
			record.setExtension("[Longitude(经度),Latitude(纬度)]");
			try {
				record.setCreateDate(DateUtil.getCurrentDate(DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			double[] one = squareMap.get("1");
			double[] two = squareMap.get("2");
			double[] three = squareMap.get("3");
			double[] four = squareMap.get("4");
			
			record.setLeftbottompoint(String.format("%s, %s",String.valueOf(one[0]),String.valueOf(one[1])));
			record.setLefttoppoint(String.format("%s, %s",String.valueOf(two[0]),String.valueOf(two[1])));
			record.setRightbottompoint(String.format("%s, %s",String.valueOf(three[0]),String.valueOf(three[1])));
			record.setRighttoppoint(String.format("%s, %s",String.valueOf(four[0]),String.valueOf(four[1])));

			
			rectInfoMapper.insertSelective(record);
			
			ret =  ProcessRect(squareMap,record);
			
		}else{
			log.debug(String.format("将矩形坐标不能入库，坐标不全"));
		}
		
		return ret ;
	}
	
	private int ProcessPointExt(InterMapBaseInfo beginBaseInfo , InterMapBaseInfo endBaseInfo)
	{
		int ret = -1 ; 
		log.debug(String.format("构造道路矩形方式为[%s],长度为[%d]米",pilenoMode.toString(),RoadWayWide));
		
		double fristlongitude = Double.parseDouble(beginBaseInfo.getLongitude()) ;
		double fristlatitude =  Double.parseDouble(beginBaseInfo.getLatitude()) ;
		
		double endlongitude =  Double.parseDouble(endBaseInfo.getLongitude()) ;
		double endlatitude =  Double.parseDouble(endBaseInfo.getLatitude()) ;
		
		//获取两桩点构成的四边形
		Map<String, double[]> squareMap= Geographic.rectanguPointOfMidde(new double[]{fristlongitude,fristlatitude}, new double[]{endlongitude,endlatitude}, Arith.div(RoadWayWide, 2, 6));
		//Map<String, double[]> squareMap= Geographic.getRectangleByPile(new double[]{fristlongitude,fristlatitude}, new double[]{endlongitude,endlatitude}, Arith.div(RoadWayWide, 2, 6));
		
		
		if(squareMap.size()>0){
			log.debug(String.format("将矩形坐标入库，根据矩形坐标构建多边形"));
			InterMapRectInfo record = new InterMapRectInfo();
			record.setPileno(String.format("[%s]-[%s]", beginBaseInfo.getPileno(),endBaseInfo.getPileno()));
			record.setMultipoint(String.format("开始点:[%s,%s],结束点:[%s,%s]", beginBaseInfo.getLongitude(),beginBaseInfo.getLatitude(),endBaseInfo.getLongitude(),endBaseInfo.getLatitude()));
			record.setCountrycode(beginBaseInfo.getCountrycode());
			record.setSectioncode(beginBaseInfo.getSectioncode());
			record.setExtension("[Longitude(经度),Latitude(纬度)]");
			try {
				record.setCreateDate(DateUtil.getCurrentDate(DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			double[] one = squareMap.get("1");
			double[] two = squareMap.get("2");
			double[] three = squareMap.get("3");
			double[] four = squareMap.get("4");
			
			record.setLeftbottompoint(String.format("%s, %s",String.valueOf(one[0]),String.valueOf(one[1])));
			record.setLefttoppoint(String.format("%s, %s",String.valueOf(two[0]),String.valueOf(two[1])));
			record.setRightbottompoint(String.format("%s, %s",String.valueOf(three[0]),String.valueOf(three[1])));
			record.setRighttoppoint(String.format("%s, %s",String.valueOf(four[0]),String.valueOf(four[1])));

			
			rectInfoMapper.insertSelective(record);
			
			ret =  ProcessRect(squareMap,record);
			
		}else{
			log.debug(String.format("将矩形坐标不能入库，坐标不全"));
		}
		
		return ret ;
	}
	private GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory( null );
	 
	private String rect_format = "POLYGON((%s %s, %s %s, %s %s, %s %s, %s %s))";
	private WKTReader reader = new WKTReader( geometryFactory );
	
	private int  ProcessRect( Map<String, double[]> squareMap ,InterMapRectInfo record){
		int ret = -1 ;
		log.debug(String.format("绘制四边形:(纬度,经度)[%s],[%s],[%s],[%s]",record.getLefttoppoint(),record.getLeftbottompoint(),record.getRightbottompoint(),record.getRighttoppoint()));
		
		
		try {
			double[] one = squareMap.get("1");
			double[] two = squareMap.get("2");
			double[] three = squareMap.get("3");
			double[] four = squareMap.get("4");
			
			String point = String.format(rect_format, String.valueOf(one[1]),String.valueOf(one[0]),
					                                  String.valueOf(two[1]),String.valueOf(two[0]),
					                                  String.valueOf(three[1]),String.valueOf(three[0]),
					                                  String.valueOf(four[1]),String.valueOf(four[0]),
					                                  String.valueOf(one[1]),String.valueOf(one[0]));
			log.debug(point);
			
			Polygon polygon = (Polygon) reader.read(point);//获取四边形
			
			if(polygon!=null){
				Geometry envelope = polygon.getEnvelope();//获取四边形的外接矩形
				
				if(envelope!=null){
					log.debug(String.format("外接矩形的坐标:[%s]",envelope.toText()));
					
				    ret = ProcessPoint( envelope, polygon,record);
				    
				  
				    try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				}else{
					log.debug("求四边形中心点失败");
				}
			}else {
				log.debug("绘制四边形失败");
				
			}
			
		} catch (com.vividsolutions.jts.io.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret ;
	}
	
	
	
	
	public boolean containsPoint(Coordinate[]  points,Coordinate point) {  
	       int verticesCount = points.length;  
	       int nCross = 0;  
	       for (int i = 0; i < verticesCount; ++ i) {  
	    	   Coordinate p1 = points[i];  
	    	   Coordinate p2 = points[(i + 1) % verticesCount];  
	         
	           // 求解 y=p.y 与 p1 p2 的交点  
	           if ( p1.y== p2.y ) {   // p1p2 与 y=p0.y平行  
	               continue;  
	           }  
	           if ( point.y < Math.min(p1.y, p2.y) ) { // 交点在p1p2延长线上   
	               continue;  
	           }  
	           if ( point.y >= Math.max(p1.y, p2.y) ) { // 交点在p1p2延长线上   
	               continue;  
	           }  
	           // 求交点的 X 坐标  
	           double x = (double) ((point.y - p1.y) * (p2.x - p1.x)   
	                       / (p2.y - p1.y) + p1.x);  
	           if ( x > point.x ) { // 只统计单边交点  
	               nCross++;  
	           }  
	       }  
	    // 单边交点为偶数，点在多边形之外  
	       return (nCross%2==1);  
	   }  
	
	public class MapPoint {  
	
	    private double lng;  
	    private double lat;  
	      
	    public MapPoint(double lng , double lat){  
	        this.lng = lng;  
	        this.lat = lat;  
	    }  
	      
	    public MapPoint(){  
	          
	    }  
	  
	  
	    public double getLng() {  
	        return lng;  
	    }  
	  
	  
	    public void setLng(double lng) {  
	        this.lng = lng;  
	    }  
	  
	  
	    public double getLat() {  
	        return lat;  
	    }  
	  
	  
	    public void setLat(double lat) {  
	        this.lat = lat;  
	    }  
	}  
	
	public class Line {  
		  
		  
	    private double k;  
	    private double c;  
	    private MapPoint pointa;  
	    private MapPoint pointb;  
	    private int plus; //1是正 -1是负  
	      
	    public Line(){  
	          
	    }  
	      
	    public Line(MapPoint pointa, MapPoint pointb){  
	        this.pointa = pointa;  
	        this.pointb = pointb;  
	        this.k = (pointb.getLng() - pointa.getLng())  
	                / (pointb.getLat() - pointa.getLat());  
	        this.c = k * pointa.getLat() - pointa.getLng();  
	    }  
	  
	  
	    public double getK() {  
	        return k;  
	    }  
	  
	  
	    public void setK(double k) {  
	        this.k = k;  
	    }  
	  
	  
	    public double getC() {  
	        return c;  
	    }  
	  
	  
	    public void setC(double c) {  
	        this.c = c;  
	    }  
	  
	  
	    public MapPoint getPointa() {  
	        return pointa;  
	    }  
	  
	  
	    public void setPointa(MapPoint pointa) {  
	        this.pointa = pointa;  
	    }  
	  
	  
	    public MapPoint getPointb() {  
	        return pointb;  
	    }  
	  
	  
	    public void setPointb(MapPoint pointb) {  
	        this.pointb = pointb;  
	    }  
	  
	  
	    public int getPlus() {  
	        return plus;  
	    }  
	  
	  
	    public void setPlus(int plus) {  
	        this.plus = plus;  
	    }  
	  
	  
	    public double calculatePoint(MapPoint mapPoint) {  
	        return mapPoint.getLng() - getK()* mapPoint.getLat() + getC();  
	    }  
	}  
	
	
	public class MyPolygon {  
	      
	    private List<Line> lines;  
	    private List<MapPoint> points;  
	      
	    public List<Line> getLines() {  
	        return lines;  
	    }  
	    public void setLines(List<Line> lines) {  
	        this.lines = lines;  
	    }  
	    public List<MapPoint> getPoints() {  
	        return points;  
	    }  
	    public void setPoints(List<MapPoint> points) {  
	        this.points = points;  
	    }  
	      
	    /** 
	     * (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1); 
	     * @param index 
	     * @return true 是凸多边形 
	     */  
	    public boolean isConcave(int index) {  
	        Line lineA = lines.get(index);  
	        Line lineB = lines.get(index+1);  
	        MapPoint point1 = lineA.getPointa();  
	        MapPoint point2 = lineA.getPointb();  
	        MapPoint point3 = lineB.getPointb();  
	        double x2x1 = point2.getLng() - point1.getLng();  
	        double y3y1 = point3.getLat() - point1.getLat();  
	        double y2y1 = point2.getLat() - point1.getLat();  
	        double x3x1 = point3.getLng() - point1.getLng();  
	        double temp = (x2x1*y3y1)-(y2y1*x3x1);  
	        if(temp>0){  
	            return true;  
	        }else{  
	            return false;  
	        }  
	    }  
	      
	    /** 
	     * 寻找初始节点- 
	     */  
	    public int initCurvePoint(){  
	        int size = points.size();  
	        boolean flag = true;  
	        boolean plus = true;  
	        MapPoint point0 = points.get(0);  
	        for(Line line :lines){  
	              
	        }  
	        for(int i = 0 ; i < size ; i++){  
	            MapPoint mapPoint = points.get(i);  
	            for(Line line : lines){  
	                if(line.calculatePoint(mapPoint)<0){  
	                    flag = false;  
	                    plus = false;  
	                    break;  
	                }else{  
	                      
	                }  
	            }  
	            if(flag){  
	                return i;  
	            }  
	            flag = true;  
	        }  
	        return -1;  
	    }  
	      
	    public void removePoint(int j) {  
	        Line line = new Line(points.get(j-1),points.get(j+1));  
	        points.remove(j);  
	        lines.remove(j);  
	        lines.remove(j-1);  
	        lines.add(j-1, line);  
	    }  
	}  
	
	
	private Line getLineByPoints(MapPoint pointa, MapPoint pointb) {  
		double k = (pointb.getLng() - pointa.getLng())  
                / (pointb.getLat() - pointa.getLat());  
		double c = k * pointa.getLat() - pointa.getLng();  
        Line line = new Line();  
        line.setC(c);  
        line.setPointa(pointa);  
        line.setPointb(pointb);  
        line.setK(k);  
        return line;  
    }  
	
	// ( P1 - Q1 ) × ( Q2 - Q1 ) * ( Q2 - Q1 ) × ( P2 - Q1 ) ≥ 0  
    // （x1*y2-x2*y1）*(x1*y3-x3*y1)<0  
    // 计算AB(为（x1b-x1a,y1b-y1a）)向量与AC(为（x2a-x1a,y2a-y1a）)向量的差积  
    // (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1)  
    private boolean isInArea(List<Line> lines, MapPoint point3, MapPoint point4) {  
        int num = 0;  
        for (Line line : lines) {  
            MapPoint point1 = line.getPointa();  
            MapPoint point2 = line.getPointb();  
            double x1 = point1.getLng();  
            double x2 = point2.getLng();  
            double x3 = point3.getLng();  
            double x4 = point4.getLng();  
            double y1 = point1.getLat();  
            double y2 = point2.getLat();  
            double y3 = point3.getLat();  
            double y4 = point4.getLat();  
            double t1 = (x1 - x3) * (y4 - y3) - (y1 - y3) * (x4 - x3);  
            double t2 = (x4 - x3) * (y2 - y3) - (y4 - y3) * (x2 - x3);  
            if (t1 * t2 >= 0) {  
                double t3 = (x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2);  
                double t4 = (x1 - x2) * (y1 - y4) - (y1 - y2) * (x1 - x4);  
                if (t3 * t4 >= 0) {  
                    num++;  
                }  
            }  
        }  
        if (num > 0 && num % 2 != 0) {  
            return true;  
        }  
        return false;  
    }  
    
    private List<Line>  getPolyLinesInfos(MapPoint [] mapPoints) {  
        
    	List<Line> lines = Lists.newArrayList();
        int length = mapPoints.length;  
       
        for (int i = 0; i < mapPoints.length - 1; i++) {  
            
            try {  
                Line line = getLineByPoints(mapPoints[i], mapPoints[i + 1]);  
                if (i < length - 2) {  
                    if (mapPoints[i + 2].getLng() - line.getK()  
                            * mapPoints[i + 2].getLat() + line.getC() < 0) {  
                        line.setPlus(-1);  
                    } else {  
                        line.setPlus(1);  
                    }  
                } else {  
                    if (mapPoints[1].getLng() - line.getK()  
                            * mapPoints[1].getLat() + line.getC() < 0) {  
                        line.setPlus(-1);  
                    } else {  
                        line.setPlus(1);  
                    }  
                }  
                lines.add(line);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
         
        
        return lines;
      
    }  
    
    
    
	private int ProcessPoint(Geometry envelope,Polygon polygon,InterMapRectInfo record){
		 int ret = 0 ;
		 
		 Coordinate[] coordinates =  envelope.getBoundary().getCoordinates();
		 
		 if(coordinates.length < 4)
			 return ret;
		 Coordinate leftbottom = coordinates[0];
		 Coordinate lefttop = coordinates[1];
		 
		 Coordinate righttop = coordinates[2];
		 Coordinate rightbottom = coordinates[3];
		 
		 
		 Coordinate[] coords1  = new Coordinate[] {lefttop, righttop}; 
		 LineString line1 = geometryFactory.createLineString(coords1); // 上边
			
		 Coordinate[] coord2  = new Coordinate[] {leftbottom,rightbottom};
		 LineString line2 = geometryFactory.createLineString(coord2); // 下边
		 
		 // 矩形的top,bommon
		 ProcessLine(polygon,record,line1,line2);
				
		 return ret;
	}
	
	
	private void ProcessLine(Polygon polygon,InterMapRectInfo record,LineString lineTop ,LineString lineBottom)
	{
		double lenth1 = Geographic.getDistanceOfMeter(lineTop.getStartPoint().getX(), lineTop.getStartPoint().getY(), lineTop.getEndPoint().getX(), lineTop.getEndPoint().getY());
		double lenth2 = Geographic.getDistanceOfMeter(lineBottom.getStartPoint().getX(), lineBottom.getStartPoint().getY(), lineBottom.getEndPoint().getX(), lineBottom.getEndPoint().getY());
		
		log.debug(String.format("lineTop:[%s],lineBottom:[%s],差值为:[%s],[%s]", lineTop.toString(),lineBottom.toString(),String.valueOf(lenth1),String.valueOf(lenth2)));
		
		double length  = lenth1>lenth2?lenth1:lenth2;
		
		if(Arith.sub(length,10 * RoadWayWide) >0){
			log.debug(String.format("line的长度是:[%s],超过了最大长度[%s]的10倍",String.valueOf(length),String.valueOf(10 * RoadWayWide)));
			return ;
		}
		
		double[] rightPoint1 = null;
		double[] rightPoint2 = null;
		
		List<Coordinate> pointscCoordinates = Lists.newArrayList();
		
		int loop= Integer.parseInt(new java.text.DecimalFormat("0").format(length)) /10 +1; 
		
		for (int i = 0; i <= loop; i++) {
			
			Coordinate begin = null ;
			Coordinate end = null;
			if(i == 0 ){
				rightPoint1 = new double [] {lineTop.getStartPoint().getCoordinate().x,lineTop.getStartPoint().getCoordinate().y};
				rightPoint2 = new double [] {lineBottom.getStartPoint().getCoordinate().x,lineBottom.getStartPoint().getCoordinate().y}; 
				
				 begin = new Coordinate(rightPoint1[0],rightPoint1[1]);
				 end = new Coordinate(rightPoint2[0],rightPoint2[1]);
				
			}else{
				Map<String, double[]> map = Geographic.returnLLSquarePoint(lineTop.getStartPoint().getX(), lineTop.getStartPoint().getY(), Arith.div(i*10, 1000));
			    rightPoint1 = map.get("rightPoint");
				
				Map<String, double[]> map1 = Geographic.returnLLSquarePoint(lineBottom.getStartPoint().getX(), lineBottom.getStartPoint().getY(), Arith.div(i*10, 1000));
				rightPoint2 = map1.get("rightPoint");
				
				 begin = new Coordinate(rightPoint1[1],rightPoint1[0]);
				 end = new Coordinate(rightPoint2[1],rightPoint2[0]);
			}
			
			
			LineString line = geometryFactory.createLineString(new Coordinate [] {begin,end});
			
			
			GetLineCoordinate(line.getStartPoint().getCoordinate(),line.getEndPoint().getCoordinate(), pointscCoordinates);
			log.debug(String.format("tal:%s/%s,size:[%s]", String.valueOf(i),String.valueOf(loop),String.valueOf(pointscCoordinates.size())));
			
			insertRedioinfo(polygon,record,pointscCoordinates);
			pointscCoordinates.clear();
		}
		
	}
	
	private void GetLineCoordinate(Coordinate leftbegin,Coordinate leftend,List<Coordinate> points){
		
		double lenth = Geographic.getDistanceOfMeter(leftbegin.x, leftbegin.y, leftend.x, leftend.y);
		int loop = Integer.parseInt(new java.text.DecimalFormat("0").format(lenth))/10+1;
		points.add(leftbegin);
		for (int i = 1; i <= loop; i++) {
			Map<String, double[]> map = Geographic.returnLLSquarePoint(leftbegin.x, leftbegin.y, Arith.div(i*10, 1000));
			double[] bottom = map.get("bottomPoint");
			Coordinate bottomPoint = new Coordinate(bottom[1],bottom[0]);
			points.add(bottomPoint);
		}
		
		points.add(leftend);
	}
	
	private Geohash  geohash = new Geohash();
	
	private void setInterMapRectDetailInfo(InterMapRectInfo record,InterMapRectDetailInfo detailinfo,Coordinate mapPoint){
		detailinfo.setCountrycode(record.getCountrycode());
		detailinfo.setPileno(record.getPileno());
		detailinfo.setSectioncode(record.getSectioncode());
		
		//String y = df.format(mapPoint.y);
		//String x = df.format(mapPoint.x);
		
		String y = String.valueOf(mapPoint.y);
		String x = String.valueOf(mapPoint.x);
		
		detailinfo.setLatitude(y);
		detailinfo.setLongitude(x);
		
		String geohashString = geohash.encode(mapPoint.y, mapPoint.x);
		geohashString=geohashString.substring(0,8);
		detailinfo.setExtension(geohashString);
		
		try {
			detailinfo.setCreateDate(DateUtil.getCurrentDate(DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private InterMapRectDetailInfoMapper rectInfoDetailMapper = SpringContextUtil.getBean(InterMapRectDetailInfoMapper.class);
	
	
	private int insertRedioinfo(Polygon polygon,InterMapRectInfo record,List<Coordinate> pointlist){
		int ret = -1 ;
		Coordinate OutPoint = null;
		
		List<InterMapRectDetailInfo>  list = Lists.newArrayList();
		for (Coordinate coordinate : pointlist) {
			Point point = geometryFactory.createPoint(coordinate);
			if(polygon.contains(point)){
				InterMapRectDetailInfo interMapRectDetailInfo = new InterMapRectDetailInfo();
				setInterMapRectDetailInfo(record,interMapRectDetailInfo,coordinate);
				list.add(interMapRectDetailInfo);
				
				if(OutPoint != null)
				{
					InterMapRectDetailInfo OutinterMapRectDetailInfo = new InterMapRectDetailInfo();
					setInterMapRectDetailInfo(record,OutinterMapRectDetailInfo,OutPoint);
					list.add(OutinterMapRectDetailInfo);

					OutPoint = null;
				}
				
			}
			else
			{
				OutPoint = coordinate;
				if(list.size()>0)
				{
					InterMapRectDetailInfo OutinterMapRectDetailInfo = new InterMapRectDetailInfo();
					setInterMapRectDetailInfo(record,OutinterMapRectDetailInfo,OutPoint);
					list.add(OutinterMapRectDetailInfo);
					break;
				}
			}
			
			coordinate = null;
		}
		
		CreateFile(record,list);
		//Write2Redis(record,list);
		Insert2Map(record,list);
		
		pointlist.clear();
		return ret;
	}
	
	private String  DB_FILE_DIR = "E:/temp/";
	private String  DB_FILE_NAME = "%s.dat";
	
	private StringBuffer  filebuffer = new StringBuffer() ;
	
	private DecimalFormat df = new DecimalFormat("###.000000");
	
	private void CreateFile(InterMapRectInfo record,List<InterMapRectDetailInfo> list){
		FileOutputStream out = null;
		File file = null;
		
		log.debug(String.format("[%s],[%s],[%d].....", record.getCountrycode(),record.getPileno(),list.size()));
		try {
			String filepathString = String.format(DB_FILE_DIR+DB_FILE_NAME, record.getCountrycode());
			 file = new File(filepathString); 
				if(!file.exists()){
					file.createNewFile();
				}
				out=new FileOutputStream(file,true);
				int index = 0 ;
				StringBuffer line = new StringBuffer();
				for (InterMapRectDetailInfo interMapRectDetailInfo : list) {
					index++;
					if(index%3000 == 0 ){
						index = 0 ;
						  
						if(filebuffer.length() > 0){
							out.write(filebuffer.toString().getBytes("utf-8"));
							
							filebuffer.delete(0, filebuffer.length());
						}
						
					}else {
						line.delete(0, line.length());
						Map<String, String> map = Maps.newHashMap();
						TableValueOper.GetValue(interMapRectDetailInfo, map);
						
						for (Map.Entry<String, String> entry : map.entrySet()) {
							if(line.length() == 0){
								line.append(entry.getValue());
							}else{
								line.append(",");
								line.append(entry.getValue());
							}
						}
						 
						line.append("\n");
						filebuffer.append(line.toString());
					}
					
					interMapRectDetailInfo = null;
				}
				
				if(filebuffer.length() > 0){
					out.write(filebuffer.toString().getBytes("utf-8"));
					filebuffer.delete(0, filebuffer.length());
				}
				
				
				 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					filebuffer.delete(0, filebuffer.length());
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
    @SuppressWarnings("unused")
	private void Write2Redis(InterMapRectInfo record,List<InterMapRectDetailInfo> list){
    	StringBuffer key = new StringBuffer();;
    	StringBuffer value = new StringBuffer();;
    	log.debug("======Write2Redis=========");
    	for (InterMapRectDetailInfo interMapRectDetailInfo : list) 
    	{
    		
    			key.delete(0, key.length());
    			value.delete(0, value.length());
    			
				Map<String, String> map = Maps.newHashMap();
				TableValueOper.GetValue(interMapRectDetailInfo, map);
				
				for (Map.Entry<String, String> entry : map.entrySet()) {
					if(entry.getKey().equals("extension"))
					{
						key.append(entry.getValue());
					}
					else
					{
						if(value.length() == 0){
							value.append(entry.getValue());
						}else{
							value.append(",");
							value.append(entry.getValue());
						}
						
					}
					
				}
				
				RedisMgr.getInstance().setVelue2Redis(key.toString(), value.toString());
				//line.append("\n");
				//filebuffer.append(line.toString());

			interMapRectDetailInfo = null;
		}
    }
    
    private void Insert2Map(InterMapRectInfo record,List<InterMapRectDetailInfo> list){
    	//GsGeohash geohash = new GsGeohash();
    	
    	//log.debug("======list size is ========="+list.size());
    	if(list.size() == 0)
    		return;
    	
    	String strkey; 
    	
    	
    	for(InterMapRectDetailInfo interMapRectDetailInfo : list){
    		strkey = interMapRectDetailInfo.getCountrycode()+interMapRectDetailInfo.getExtension();
    		
    		if(!mapGsGeohash.containsKey(strkey))
    		{
    			GsGeohash geohash = new GsGeohash();
    			//log.debug("strkey  = "+ strkey);
    			
    			geohash.setGeohash(interMapRectDetailInfo.getExtension());
    	    	geohash.setType(4);
    	    	geohash.setLinecode(interMapRectDetailInfo.getCountrycode());
    	    	geohash.setLinename(interMapRectDetailInfo.getSectioncode());
    	    	geohash.setPilecode1(interMapRectDetailInfo.getPileno());
    	    	
    			mapGsGeohash.put(strkey, geohash);
    			
    		}
    	}

    }
    
    private void Insert2Map(List<PolyGonNew> listPolyGon){

		if(listPolyGon.size() == 0)
    		return;

    	for(PolyGonNew polygon : listPolyGon){
    		
    		String strLinecode = polygon.getFirstLine().getBoundPoint().getLinecode();
    		String strLinename = polygon.getFirstLine().getBoundPoint().getLinename();
    		String strPilecode1 = polygon.getFirstLine().getBoundPoint().getPilecode();
    		String strPilecode2 = polygon.getSecondLine().getBoundPoint().getPilecode();
    		
    		for(Coordinate point : polygon.getAllPoints())
    		{
    			String strGeohash = geohash.encode(point.y, point.x);
    			strGeohash=strGeohash.substring(0,8);
    			
    			String strkey = strLinecode + strGeohash;
    			
	    		if(!mapGsGeohash.containsKey(strkey))
	    		{
	    			GsGeohash geohash = new GsGeohash();

	    			geohash.setGeohash(strGeohash);
	    	    	geohash.setType(4);
	    	    	geohash.setLinecode(strLinecode);
	    	    	geohash.setLinename(strLinename);
	    	    	geohash.setPilecode1(strPilecode1);
	    	    	geohash.setPilecode2(strPilecode2);
	    	    	
	    			mapGsGeohash.put(strkey, geohash);
	    			
	    		}
    		}
    	}
    	
    }
    
    
    private void Insert2DB(){
    	if(mapGsGeohash.size() <= 0)
    		return;
    	//GsGeohashMapper gsGeohashMapper = SpringContextUtil.getBean(GsGeohashMapper.class);
    	List<GsGeohash> geohashs = new ArrayList<GsGeohash>();
    	
    	for(GsGeohash record : mapGsGeohash.values())
    	{
    		geohashs.add(record);
    	}
    	System.out.println("----------------size:"+geohashs.size());
    	

		//如果 list超过10个  分批次处理  begin
		int groupNum = 1000;
		int loopCount = (geohashs.size() % groupNum == 0) ? (geohashs.size() / groupNum)
				: ((geohashs.size() / groupNum) + 1);
		for (int i = 0; i < loopCount; i++) {
			// 子List的起始值
			int startNum = i * groupNum;
			// 子List的终止值
			int endNum = (i + 1) * groupNum;
			// 不能整除的时候最后一个List的终止值为原始List的最后一个
			if (i == loopCount - 1) {
				endNum = geohashs.size();
			}
			// 拆分List
			List<GsGeohash> dtlTemps = geohashs.subList(startNum, endNum);

			gsGeohashMapper.insertList(dtlTemps);
		}
    	/*
    	for(GsGeohash record : mapGsGeohash.values())
    	{
    		log.debug(record.getGeohash()+","+record.getLinecode());
    		gsGeohashMapper.insert(record);
    	}*/
    	mapGsGeohash.clear();
    	//log.debug("mapGsGeohash size = "+ mapGsGeohash.size());
    }

    
    
	private void Write2File(String filename, Coordinate[] points){
		FileOutputStream out = null;
		File file = null;
		System.out.println("===points.length======"+points.length);
		try {
			String  fileDir = "F:/roadPoint/";
			String  fileName = "%s.dat";
			StringBuffer  filebuffer = new StringBuffer() ;
			
			String filepathString = String.format(fileDir+fileName, filename);
			 file = new File(filepathString); 
				if(!file.exists()){
					file.createNewFile();
				}
				out=new FileOutputStream(file,true);
				int index = 0 ;
				StringBuffer line = new StringBuffer();
				for (Coordinate p : points) {
					index++;
					if(index%100 == 0 )
					{
						index = 0 ;
						  
						if(filebuffer.length() > 0){
							out.write(filebuffer.toString().getBytes("utf-8"));
							
							filebuffer.delete(0, filebuffer.length());
						}
						
					}
				
				line.delete(0, line.length());

				line.append(p.x + "," + p.y);

				line.append("\n");
				filebuffer.append(line.toString());
				
					
				}
				
				if(filebuffer.length() > 0){
					out.write(filebuffer.toString().getBytes("utf-8"));
					filebuffer.delete(0, filebuffer.length());
				}

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					filebuffer.delete(0, filebuffer.length());
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	
	private void Write2File(String filename, List<Coordinate> list){
		Write2File(filename, list.toArray(new Coordinate[0]));
	}
	/** 
     * create a Circle  创建一个圆，圆心(x,y) 半径RADIUS 
     * @param x 
     * @param y 
     * @param RADIUS  米
     * @return 
     */  
    private Polygon createCircle(double x, double y, final double RADIUS, int sides){  
        final int SIDES = sides;//圆上面的点个数  
        Coordinate coords[] = new Coordinate[SIDES+1];  
        for( int i = 0; i < SIDES; i++){  
            double angle = ((double) i / (double) SIDES) * Math.PI * 2.0;  
            double dx = Math.cos( angle ) * RADIUS/1000/100;  
            double dy = Math.sin( angle ) * RADIUS/1000/100;  
            coords[i] = new Coordinate( (double) x + dx, (double) y + dy );  
        }  
        coords[SIDES] = coords[0];  
        LinearRing ring = geometryFactory.createLinearRing( coords );  
        Polygon polygon = geometryFactory.createPolygon( ring, null );  
        return polygon;  
    }  
    
    /** 
     *getPolygonByPile  根据2个桩点及路宽，计算出表示这段路的四边形
     * @param x 
     * @param y 
     * @param RADIUS  米
     * @return 
     */  
    @SuppressWarnings("unused")
	private Coordinate[] getPolygonByPile(Coordinate CirclCenterSmall, Coordinate CirclCenterBig, double wide){
    	double length = Geographic.getDistanceOfMeter(CirclCenterSmall.x, CirclCenterSmall.y, CirclCenterBig.x, CirclCenterBig.y);
    	double R  = Math.sqrt(length*length+wide*wide);//斜边长度，即大圆半径
    	double r = wide;//小圆半径
    	int pointSizeOfBig = (int)(2 * Math.PI * R * 10);  //圆周上，每一米一个点
    	int pointSizeOfSmall = (int)(2 * Math.PI * r * 10);
    	
    	Polygon BigCircle = createCircle(CirclCenterBig.x, CirclCenterBig.y, R, pointSizeOfBig);
    	Polygon SmallCirle = createCircle(CirclCenterSmall.x, CirclCenterSmall.y, 200, pointSizeOfSmall);
    	
    	System.out.println("桩点之间距离:"+length);
    	System.out.println("大圆半径:"+R);
    	System.out.println("小圆半径:"+r);
    	
    	Write2File("circle",BigCircle.getCoordinates());
    	Write2File("circle",SmallCirle.getCoordinates());
    	
    	for(Coordinate p : BigCircle.getCoordinates()){
    		double len = Geographic.getDistanceOfMeter(p.x, p.y, CirclCenterBig.x, CirclCenterBig.y);
    		System.out.println("大圆点距大圆圆心距离:"+len);
    	}
    	
    	Geometry interCircle =BigCircle.intersection(SmallCirle);

		Coordinate [] pointsOfInterCircle = interCircle.getCoordinates();
		
		Arrays.sort(pointsOfInterCircle, new CompratorX());
		Coordinate pointX1 = pointsOfInterCircle[0];
		Coordinate pointX2 = pointsOfInterCircle[pointsOfInterCircle.length-1];
		
		Arrays.sort(pointsOfInterCircle, new CompratorY());
		Coordinate pointY1 = pointsOfInterCircle[0];
		Coordinate pointY2 = pointsOfInterCircle[pointsOfInterCircle.length-1];
		
		System.out.println(pointX1.x+","+pointX1.y);
		System.out.println(pointX2.x+","+pointX2.y);
		System.out.println(pointY1.x+","+pointY1.y);
		System.out.println(pointY2.x+","+pointY2.y);

		
		double disX1ToBig = Geographic.getDistanceOfMeter(pointX1.x, pointX1.y, CirclCenterBig.x, CirclCenterBig.y);
		double disX1ToSmall = Geographic.getDistanceOfMeter(pointX1.x, pointX1.y, CirclCenterSmall.x, CirclCenterSmall.y);
		double disX2ToBig = Geographic.getDistanceOfMeter(pointX2.x, pointX2.y, CirclCenterBig.x, CirclCenterBig.y);
		double disX2ToSmall = Geographic.getDistanceOfMeter(pointX2.x, pointX2.y, CirclCenterSmall.x, CirclCenterSmall.y);
		double disY1ToBig = Geographic.getDistanceOfMeter(pointY1.x, pointY1.y, CirclCenterBig.x, CirclCenterBig.y);
		double disY1ToSmall = Geographic.getDistanceOfMeter(pointY1.x, pointY1.y, CirclCenterSmall.x, CirclCenterSmall.y);
		double disY2ToBig = Geographic.getDistanceOfMeter(pointY2.x, pointY2.y, CirclCenterBig.x, CirclCenterBig.y);
		double disY2ToSmall = Geographic.getDistanceOfMeter(pointY2.x, pointY2.y, CirclCenterSmall.x, CirclCenterSmall.y);
		
		log.debug("disX1ToBig="+disX1ToBig+",disX1ToSmall="+disX1ToSmall+",disX2ToBig="+disX2ToBig+",disX2ToSmall="+disX2ToSmall
				+",disY1ToBig="+disY1ToBig+",disY1ToSmall="+disY1ToSmall+",disY2ToBig="+disY2ToBig+",disY2ToSmall="+disY2ToSmall);
		
		Coordinate[] PointsOfPolygon = new Coordinate[2];
		if(disX1ToBig+disX1ToSmall+disX2ToBig+disX2ToSmall > disY1ToBig+disY1ToSmall+disY2ToBig+disY2ToSmall)
		{
			PointsOfPolygon[0] = pointX1;
			PointsOfPolygon[1] = pointX2;
		}
		else
		{
			PointsOfPolygon[0] = pointY1;
			PointsOfPolygon[1] = pointY2;
		}
		
		return PointsOfPolygon;
    }
 
  //比较器，x坐标从小到大排序；x相同时，按照y从小到大排序
    class CompratorX implements Comparator<Coordinate> {
        public int compare(Coordinate t1, Coordinate t2) {
            return t1.x>t2.x? 1:-1;
        }
    }
    //比较器，x坐标从小到大排序；x相同时，按照y从小到大排序
    class CompratorY implements Comparator<Coordinate> {
        public int compare(Coordinate t1, Coordinate t2) {
            return t1.y>t2.y? 1:-1;
        }
    }


    /** 
     * getAzimuth  计算方位角pab，其中lat_a, lng_a是A的纬度和经度； lat_b, lng_b是B的纬度和经度。代码如下：
     * @param lng_a lat_a lng_b lat_b
     * @return  方位角，角度表示
     */  
	private double getAzimuth(double lng_a, double lat_a, double lng_b, double lat_b) {
		double d = 0;
		lat_a = lat_a * Math.PI / 180;
		lng_a = lng_a * Math.PI / 180;
		lat_b = lat_b * Math.PI / 180;
		lng_b = lng_b * Math.PI / 180;

		d = Math.sin(lat_a) * Math.sin(lat_b) + Math.cos(lat_a)
				* Math.cos(lat_b) * Math.cos(lng_b - lng_a);
		d = Math.sqrt(1 - d * d);
		d = d *1000;
		d = Math.cos(lat_b) * Math.sin(lng_b - lng_a) * 1000 / d;
		if(d>1 && d<1.001)
			d = 1;
		if(d<-1 && d>-1.001)
			d = -1;
		d = Math.asin(d) * 180 / Math.PI;
		
		//System.out.println("==方位角before:===="+d);
		if(d<0)
		{
			if(lat_a > lat_b)
				d = 180-d;
			else
				d = 360+d;
		}
		else
		{
			if(lat_a > lat_b)
				d = 180-d;
		}
		//System.out.println("==方位角:===="+d);
		return d;
	}
	

    /** 
     * getAzimuth  将相对于起点的距离转换为经纬度,distance代表到点的距离，angle代表方位角度
     * @param lng 经度, lat 纬度
     * @param angle 方位角，角度表示
     * @param distance
     * @return  Coordinate点坐标
     */  
    private Coordinate getPointByAzimuth(double lng, double lat, double angle, double distance)
    {
    	try
    	{
	    	double EARTH_RADIUS = 6378.173;
	
	    	if(angle > 360)
	    		angle -= 360;
	    	if(angle < 0)
	    		angle += 360;
	    	
	    	angle = angle * Math.PI / 180;//转换为弧度
	
	    	double dy = Math.cos(angle)*distance;
	    	double dx = Math.sin(angle)*distance;
	    	
	    	//System.out.println("dy="+dy+",dx="+dx);
	    	double dLongitude = 2 * (Math.asin(Math.sin(dx
	                / (2 * EARTH_RADIUS))
	                / Math.cos(Math.toRadians(lat))));
	        dLongitude = Math.toDegrees(dLongitude);
	        // 计算纬度角度
	        double dLatitude = dy / EARTH_RADIUS;
	        dLatitude = Math.toDegrees(dLatitude);
	        
	        double lngNew = lng + dLongitude;
	        double latNew = lat + dLatitude;
	        
	        //System.out.println("lngNew,latNew========"+lngNew+","+latNew);
	        
	        return new Coordinate(lngNew, latNew);
    	}
    	catch(Exception e) {
			e.printStackTrace();
    	}
    	return null;
    }
    
    
    private BoundaryPoint getBoundPointByPile(InterMapBaseInfo first, InterMapBaseInfo second)
    {
    	double lng1 = Double.valueOf(first.getLongitude());
		double lat1 = Double.valueOf(first.getLatitude());
		double lng2 = Double.valueOf(second.getLongitude());
		double lat2 = Double.valueOf(second.getLatitude());
		
		double angle = getAzimuth(lng1, lat1, lng2, lat2);
		
		if(Double.isNaN(angle))
			return null;
		Coordinate pointA = getPointByAzimuth(lng1, lat1, angle+90, RoadWayWide/2/1000 );
		Coordinate pointB = getPointByAzimuth(lng1, lat1, angle-90, RoadWayWide/2/1000 );
		
		BoundaryPoint boundPoint = new BoundaryPoint(pointA, pointB, first.getCountrycode(), first.getPileno(), first.getSectioncode());

		
		return boundPoint;
    }
    /** 
     * getTwoPointOfRoad  根据桩点列表，生成桩点两侧各50米的边界点
     * @param piles 桩点数组
     * @return List<Coordinate> 边界点list
     */  
    @SuppressWarnings("unused")
	private List<BoundaryPoint> getTwoPointOfRoad(Map<String, List<InterMapBaseInfo>> infoMap)
    {
    	List<BoundaryPoint> list = new ArrayList<BoundaryPoint>();
    	
    	for(Map.Entry<String, List<InterMapBaseInfo>> entry : infoMap.entrySet())
    	{
    		String linecode = entry.getKey();
    		List<InterMapBaseInfo> interMapBaseInfo = entry.getValue();
    		
    		for(int i = 0; i < interMapBaseInfo.size()-1; i++)
    		{
	    		BoundaryPoint boundPoint = getBoundPointByPile(interMapBaseInfo.get(i), interMapBaseInfo.get(i+1));
	    		if(boundPoint == null)
	    			continue;
	    		list.add(boundPoint);
    		}
    		int lastIndex = interMapBaseInfo.size()-1;
    		BoundaryPoint boundPoint = getBoundPointByPile(interMapBaseInfo.get(lastIndex), interMapBaseInfo.get(lastIndex-1));
    		if(boundPoint == null)
    			continue;
    		Coordinate tmp = boundPoint.getPointLeft();
    		boundPoint.setPointLeft(boundPoint.getPrintRight());
    		boundPoint.setPrintRight(tmp);
    		list.add(boundPoint);
    	}
    	return list;
    }

    @SuppressWarnings("unused")
	private List<BoundaryPoint> getTwoPointOfRoad(List<InterMapBaseInfo> interMapBaseInfo)
    {
		List<BoundaryPoint> list = new ArrayList<BoundaryPoint>();

		for (int i = 0; i < interMapBaseInfo.size() - 1; i++) {
			BoundaryPoint boundPoint = getBoundPointByPile(
					interMapBaseInfo.get(i), interMapBaseInfo.get(i + 1));
			if (boundPoint == null)
				continue;
			list.add(boundPoint);
		}
		int lastIndex = interMapBaseInfo.size() - 1;
		BoundaryPoint boundPoint = getBoundPointByPile(
				interMapBaseInfo.get(lastIndex),
				interMapBaseInfo.get(lastIndex - 1));
		if (boundPoint != null) {
			Coordinate tmp = boundPoint.getPointLeft();
			boundPoint.setPointLeft(boundPoint.getPrintRight());
			boundPoint.setPrintRight(tmp);
			list.add(boundPoint);
		}

		return list;
    }

    
    /** 
     * LoadPileFromDb  从数据库加载桩点信息
     * @param infoMap 桩点信息Map
     * @return 
     */  
    private void LoadPileFromDb(Map<String, List<InterMapBaseInfo>> infoMap)
    {
		try 
		{
			InterMapBaseInfoMapper mapper = SpringContextUtil.getBean(InterMapBaseInfoMapper.class);
	
			List<InterMapBaseInfo> list = mapper.selectByExample(null);
	
			if (list != null && list.size() > 0) 
			{
				log.debug(String.format("地图基本信息表[InterMapBaseInfo],记录为[%d]",
						list.size()));
	
				if (infoMap == null)
					infoMap = Maps.newHashMap();
				else
					infoMap.clear();
	
				// 将桩点信息按路线编号放入map<路线，桩点列表>
				for (InterMapBaseInfo interMapBaseInfo : list) {
					String linecode = interMapBaseInfo.getCountrycode();
					List<InterMapBaseInfo> infoList = null;
	
					if (infoMap.containsKey(linecode)) {
						infoList = infoMap.get(linecode);
					} else {
						infoList = Lists.newArrayList();
						infoMap.put(linecode, infoList);
					}
	
					infoList.add(interMapBaseInfo);
				}
				// 排序
				for (Map.Entry<String, List<InterMapBaseInfo>> entry : infoMap
						.entrySet()) {
					List<InterMapBaseInfo> infos = entry.getValue();
	
					Collections.sort(infos, new Comparator<InterMapBaseInfo>() {
						public int compare(InterMapBaseInfo arg0,
								InterMapBaseInfo arg1) {
							return (int) (Double.parseDouble(arg0.getPileno()) - Double
									.parseDouble(arg1.getPileno()));
						}
					});

					log.debug(String.format("Sort : [%s] , 记录条数:[%d]",
							entry.getKey(), infos.size()));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private class BoundaryPoint
    {
    	
    	public BoundaryPoint(Coordinate pointLeft, Coordinate printRight,
				String linecode, String pilecode, String linename) {
			super();
			this.pointLeft = pointLeft;
			this.printRight = printRight;
			this.linecode = linecode;
			this.pilecode = pilecode;
			this.linename = linename;
		}
    	
    	
    	public Coordinate getPointLeft() {
			return pointLeft;
		}
		public void setPointLeft(Coordinate pointLeft) {
			this.pointLeft = pointLeft;
		}
		public Coordinate getPrintRight() {
			return printRight;
		}
		public void setPrintRight(Coordinate printRight) {
			this.printRight = printRight;
		}
		public String getLinecode() {
			return linecode;
		}
		public void setLinecode(String linecode) {
			this.linecode = linecode;
		}
		public String getPilecode() {
			return pilecode;
		}
		public void setPilecode(String pilecode) {
			this.pilecode = pilecode;
		}
		public String getLinename() {
			return linename;
		}
		public void setLinename(String linename) {
			this.linename = linename;
		}
		
		
		private Coordinate pointLeft;
    	private Coordinate printRight;
    	private String linecode;
    	private String pilecode;
    	private String linename;

    };
    
    private class MyPolyLine
    {
    	
    	public MyPolyLine(BoundaryPoint boundPoint) {
			this.boundPoint = boundPoint;
			this.points = null;
			this.generate();
		}
    	
    	public MyPolyLine(Coordinate leftPoint, Coordinate rightPoint, String linecode, String pilecode, String linename){
    		this(new BoundaryPoint(leftPoint, rightPoint, linecode, pilecode, linename));
    	}
    	

		public void generate(){
			double lng1 = Double.valueOf(boundPoint.pointLeft.x);
			double lat1 = Double.valueOf(boundPoint.pointLeft.y);
			double lng2 = Double.valueOf(boundPoint.printRight.x);
			double lat2 = Double.valueOf(boundPoint.printRight.y);
			
			double angle = getAzimuth(lng1, lat1, lng2, lat2);
			System.out.println("MyPolyLine.generate() angle="+angle);
			System.out.println("linecode="+boundPoint.getLinecode()+ ",pilecode="+boundPoint.getPilecode());
			System.out.println(String.format("lng1=%s,lat1=%s,lng2=%s,lat2=%s\n", lng1, lat1, lng2, lat2  ));
			double linelength = Geographic.getDistanceOfMeter(lng1, lat1, lng2, lat2);
			
			
			int count = (int)Math.round(linelength/PointInterval);
			
			log.debug("linelength:"+linelength+",count="+count);
			
			List<Coordinate> points = new ArrayList<Coordinate>();
			
			points.add(boundPoint.pointLeft);
			for(int i=1; i<count; i++)
			{
				Coordinate pointOne = getPointByAzimuth(lng1, lat1, angle, i*PointInterval/1000 );
				points.add(pointOne);
			}
			points.add(boundPoint.printRight);
			
			this.setPoints(points);
			log.debug("points.size:"+points.size());
    	}
    	public BoundaryPoint getBoundPoint() {
			return boundPoint;
		}
		public void setBoundPoint(BoundaryPoint boundPoint) {
			this.boundPoint = boundPoint;
		}
		public List<Coordinate> getPoints() {
			return points;
		}
		public void setPoints(List<Coordinate> points) {
			this.points = points;
		}
		
		private BoundaryPoint boundPoint;
    	private List<Coordinate> points;
    };
    
    public class PolyGonNew{

    	public PolyGonNew(MyPolyLine firstLine, MyPolyLine secondLine) throws Exception {
			this.firstLine = firstLine;
			this.secondLine = secondLine;
			this.generate();
		}
    	
		public void generate() throws Exception{
    		List<Coordinate> listFirst = firstLine.getPoints();
    		List<Coordinate> listSecond = secondLine.getPoints();
    		

    		List<MyPolyLine> listLine = new ArrayList<MyPolyLine>();
    		
    		int num1 = listFirst.size();
    		int num2 = listSecond.size();

    		for( ; num1>0 || num2>0; )
    		{
    			num1--;
    			num2--;
    			
    			if( num1<0) num1=0;
    			if( num2<0) num2=0;
    			System.out.println("PolyGonNew.generate=============="+num1+","+num2);
    			//System.out.println("PolyGonNew.generate=============="+listFirst.get(num1).x + ","+listFirst.get(num1).y);
    			BoundaryPoint boundaryPoint = new BoundaryPoint(listFirst.get(num1), listSecond.get(num2), 
						firstLine.getBoundPoint().getLinecode(),
						firstLine.getBoundPoint().getPilecode(),
						firstLine.getBoundPoint().getLinename());
				MyPolyLine line = new MyPolyLine(boundaryPoint);
				listLine.add(line);
    		}
    		
    		
    		this.setListLine(listLine);
    	}
		
    	public List<Coordinate> getAllPoints(){
    		List<Coordinate> points = new ArrayList<Coordinate>();

    		points.addAll(firstLine.getPoints());
    		points.addAll(secondLine.getPoints());
    		
    		for(int i=0; i<listLine.size(); i++)
    		{
    			points.addAll(listLine.get(i).getPoints());
    		}
    		return points;
    	}
    	
    	public MyPolyLine getFirstLine() {
			return firstLine;
		}
		public void setFirstLine(MyPolyLine firstLine) {
			this.firstLine = firstLine;
		}
		public MyPolyLine getSecondLine() {
			return secondLine;
		}
		public void setSecondLine(MyPolyLine secondLine) {
			this.secondLine = secondLine;
		}
		public List<MyPolyLine> getListLine() {
			return listLine;
		}
		public void setListLine(List<MyPolyLine> listLine) {
			this.listLine = listLine;
		}
		private MyPolyLine firstLine;
    	private MyPolyLine secondLine;
    	private List<MyPolyLine> listLine;
    	
    };
    
	private void StartProcess() {
		try {
			Map<String, List<InterMapBaseInfo>> infoMap = Maps.newHashMap();

			deleteRect();
			// 加载所有路线桩点数据
			LoadPileFromDb(infoMap);
			// 生成边界点数据
			// List<BoundaryPoint> listBoundPoint = getTwoPointOfRoad(infoMap);

			for (Map.Entry<String, List<InterMapBaseInfo>> entry : infoMap.entrySet()) {
				//String linecode = entry.getKey();
				List<InterMapBaseInfo> interMapBaseInfo = entry.getValue();
				List<BoundaryPoint> listBoundPoint = getTwoPointOfRoad(interMapBaseInfo);

				List<PolyGonNew> listPolyGon = new ArrayList<PolyGonNew>();
				for (int i = 0; i < listBoundPoint.size() - 1; i++) {
					MyPolyLine firstLine = new MyPolyLine(listBoundPoint.get(i));
					MyPolyLine secondLine = new MyPolyLine(listBoundPoint.get(i + 1));
					PolyGonNew polygon = new PolyGonNew(firstLine, secondLine);
					listPolyGon.add(polygon);

					// 所有矩形内点数据放入map排重
					Insert2Map(listPolyGon);
					// 生成的点数据写入文件
					for (PolyGonNew polyGon : listPolyGon) {
						String filenameString = polyGon.getFirstLine().getBoundPoint().getLinecode();
						Write2File(filenameString, polyGon.getAllPoints());
					}

					listPolyGon.clear();
				}
				
				// 向数据库插入结果
				//Insert2DB();
				listBoundPoint.clear();
				listPolyGon.clear();
				// for(BoundaryPoint bp : listBoundPoint)
				// {
				// Coordinate points[] = {bp.pointLeft, bp.printRight};
				// Write2File(points);
				// }

				// 每两个BoundaryPoint组成一个四边形，计算该四边形中的点

				// for(int i=0; i<listBoundPoint.size();i++)
				// {
				// System.out.println("=====================");
				// System.out.println(listBoundPoint.get(i).getPilecode());
				// System.out.println(listBoundPoint.get(i).pointLeft.x);
				// System.out.println(listBoundPoint.get(i).pointLeft.y);
				// System.out.println(listBoundPoint.get(i).printRight.x);
				// System.out.println(listBoundPoint.get(i).printRight.y);
				// System.out.println("=====================");
				//
				// }
				// 根据边界点生成线段及矩形数据
//				 for(PolyGonNew polyGon : listPolyGon)
//				 {
//					 System.out.println("============="+polyGon.getAllPoints().size());
//					 Write2File(polyGon.getAllPoints());
//				 }
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    
    
}
