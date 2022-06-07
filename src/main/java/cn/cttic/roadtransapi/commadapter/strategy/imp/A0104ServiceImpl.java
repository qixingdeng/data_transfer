package cn.cttic.roadtransapi.commadapter.strategy.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.strategy.ServiceStrategy;
import cn.cttic.roadtransapi.common.RoadWayServiceRoot;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.common.smParamNode;
import cn.cttic.roadtransapi.orm.roadway.dao.DwBaseinfoRoadownerMapper;
import cn.cttic.sysframe.common.util.DateUtil;
import cn.cttic.sysframe.common.util.SpringContextUtil;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class A0104ServiceImpl implements ServiceStrategy {

	@Override
	public InterStatusCode ProcessBusi(String key,String reqcontext, StringBuffer context) {
		
		InterStatusCode code = InterStatusCode.SUCCESS;
		RoadWayServiceRoot root = (RoadWayServiceRoot) XmlOper.xml2Bean(RoadWayServiceRoot.class, reqcontext);
		if(root!=null){
			
			List<smParamNode> list = root.getSmParamNode().getSmParamNode();
			smParamNode req = list.get(0);
			smParamNode page = list.get(1);
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("ownerName", req.getSmParamNode().get(0).getValue());
			map.put("provinceCode",  req.getSmParamNode().get(1).getValue());
			map.put("licenseWord",  req.getSmParamNode().get(2).getValue());
			map.put("licenseCode",  req.getSmParamNode().get(3).getValue());
			
			map.put("queryType",  req.getSmParamNode().get(4).getValue());
			String queryType = req.getSmParamNode().get(4).getValue();
			
			DwBaseinfoRoadownerMapper dw  = (DwBaseinfoRoadownerMapper) SpringContextUtil.getBean(DwBaseinfoRoadownerMapper.class); 
			page.getSmParamNode().get(0).getValue();
			int pageSize = 10;
			int pageNumber = Integer.parseInt(page.getSmParamNode().get(0).getValue());
			
			PageBounds pageBounds = new PageBounds();
			pageBounds.setLimit(pageSize);
			pageBounds.setPage(pageNumber);
			
			PageList<Map<String,Object>> result = dw.selectA0104ByExampleForPage(map, pageBounds);
			
			context.append("<?xml version='1.0' encoding='utf-8'?><respInfo xmlns:xalan='http://xml.apache.org/xalan' xmlns:xs='http://www.w3.org/2001/XMLSchema' xmlns:fn='http://www.w3.org/2005/xpath-functions'><resultCount>").append(result.size()).append("</resultCount>");
			context.append("<pageInfo><limit>").append(result.getPaginator().getLimit()).append("</limit><page>")
				.append(pageNumber).append("</page><totalcount>").append(result.getPaginator().getTotalCount()).append("</totalcount><totalpages>")
				.append(result.getPaginator().getTotalPages()).append("</totalpages></pageInfo>");
			for(int i=0;i<result.size();i++){
				Map<String,Object> entity = result.get(i);
				context.append("<inheritOwnerInfo>");
				context.append("<provinceCode>").append(entity.get("PROVINCE_CODE")).append("</provinceCode>")
				.append("<ownerId>").append(entity.get("OWNER_ID")).append("</ownerId>")
				.append("<ownerName>").append(entity.get("OWNER_NAME")).append("</ownerName>")
				.append("<ownerAddress>").append(entity.get("OWNER_ADDRESS")).append("</ownerAddress>")
				.append("<operatingStatus>").append(entity.get("OPERATING_STATUS")).append("</operatingStatus>")
				.append("<operatingCode>").append(entity.get("OPERATING_CODE")).append("</operatingCode>")
				.append("<certificateInfo>")
					.append("<businessScopeCode>").append(entity.get("BUSINESS_SCOPE_CODE")).append("</businessScopeCode>")
					.append("<businessScopeDesc>").append(entity.get("BUSINESS_SCOPE_DESC")).append("</businessScopeDesc>")
					.append("<licenseWord>").append(entity.get("LICENSE_WORD")).append("</licenseWord>")
					.append("<licenseCode>").append(entity.get("LICENSE_CODE")).append("</licenseCode>")
					.append("<licenseIssueDate>").append( formatDate((Date)entity.get("LICENSE_ISSUE_DATE"))).append("</licenseIssueDate>")
					.append("<certificateState>").append(entity.get("CERTIFICATE_STATE")).append("</certificateState>")
				.append("</certificateInfo>");
				context.append("</inheritOwnerInfo>");
			}
			context.append("</respInfo>");
		}else{
			code = InterStatusCode.NUKONW_ERROR ;
		}
		return code;
	}

	private String formatDate(Date str) {
		String result = DateUtil.format(str, DateUtil.PATTERNYYYYMMDD);
		return result;
	}

	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}

	@Override
	public String GetErrorMsg() {
		// TODO Auto-generated method stub
		return null;
	}

}
