package cn.cttic.roadtransapi.common;

import java.util.List;

import org.geotools.geometry.jts.JTSFactoryFinder;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

public class GisOperation {
	private GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory( null );  
	/** 
     * create a Point 
     * @param x 
     * @param y 
     * @return 
     */  
    public Coordinate point(double x,double y){  
        return new Coordinate(x,y);  
    }  
      
    
    public Coordinate point(String lonstr,String latstr){  
    	double lon = Geographic.floor(Double.parseDouble(lonstr));
    	double lat = Geographic.floor(Double.parseDouble(latstr));
        return new Coordinate(lon,lat);  
    }  
    
    public Point createPoint(String lon,String lat){  
        Coordinate coord = new Coordinate(Double.parseDouble(lon), Double.parseDouble(lat));  
        Point point = geometryFactory.createPoint( coord );  
        return point;  
    }  
    
    /** 
     * create a line 
     * @return 
     */  
    public LineString createLine(List<Coordinate> points){  
        Coordinate[] coords  = (Coordinate[]) points.toArray(new Coordinate[points.size()]);  
        LineString line = geometryFactory.createLineString(coords);  
        return line;  
    }  
      
    /** 
     * 返回(A)与(B)中距离最近的两个点的距离 
     * @param a 
     * @param b 
     * @return 
     */  
    public double distanceGeo(Geometry a,Geometry b){  
        return a.distance(b);  
    }  
    
    
    /** 
     * 两个几何对象的交集 
     * @param a 
     * @param b 
     * @return 
     */  
    public Geometry intersectionGeo(Geometry a,Geometry b){  
        return a.intersection(b);  
    }  
      
    /** 
     * 几何对象合并 
     * @param a 
     * @param b 
     * @return 
     */  
    public Geometry unionGeo(Geometry a,Geometry b){  
        return a.union(b);  
    }  
      
    /** 
     * 在A几何对象中有的，但是B几何对象中没有 
     * @param a 
     * @param b 
     * @return 
     */  
    public Geometry differenceGeo(Geometry a,Geometry b){  
        return a.difference(b);  
    }  
      
}
