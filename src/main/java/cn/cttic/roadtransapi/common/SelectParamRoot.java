package cn.cttic.roadtransapi.common;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement
public  class SelectParamRoot{

   private String tablename;
   
   private String mappername;
	
   @XmlElementWrapper
   private List<String> column = Lists.newArrayList();
   
   public List<String> getColumn() {
	   return column;
   }


   @XmlElement
   private List<SelectWhereParam> wheres =  Lists.newArrayList();

   public String getTablename() {
	   return tablename;
   }

   public void setTablename(String tablename) {
	   this.tablename = tablename;
   }

  

   public List<SelectWhereParam> getWheres() {
	   return wheres;
   }

   public String getMappername() {
	   return mappername;
   }

   public void setMappername(String mappername) {
	   this.mappername = mappername;
   }
   
   private String key ;
   
   private PageParamInfo pageInfo;


   public String getKey() {
	   return key;
   }

   public void setKey(String key) {
	   this.key = key;
   }

   public PageParamInfo getPageInfo() {
	   return pageInfo;
   }

   public void setPageInfo(PageParamInfo pageInfo) {
	this.pageInfo = pageInfo;
   }
   
   public static void main(String[] args) {
	  
   }
}