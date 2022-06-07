package cn.cttic.roadtransapi.common;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.google.common.collect.Lists;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelectWhereParam")
public  class SelectWhereParam{

  private String funcName;
  List<String> paramList = Lists.newArrayList();
public List<String> getParamList() {
	return paramList;
}
public void setParamList(List<String> paramList) {
	this.paramList = paramList;
}
public String getFuncName() {
	return funcName;
}
public void setFuncName(String funcName) {
	this.funcName = funcName;
}
}