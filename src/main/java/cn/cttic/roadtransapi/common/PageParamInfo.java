package cn.cttic.roadtransapi.common;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageParamInfo")
public  class PageParamInfo{

    private String limit ;
    private String page ;
    private String totalcount ;
    private String totalpages ;
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}
	public String getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(String totalpages) {
		this.totalpages = totalpages;
	}
    
}