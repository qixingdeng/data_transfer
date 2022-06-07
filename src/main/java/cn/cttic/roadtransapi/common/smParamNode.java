package cn.cttic.roadtransapi.common;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smParamNode")
public class smParamNode {
	
	@XmlTransient
	private smParamNode ParentNode;
	
	private List<smParamNode> smParamNode = Lists.newArrayList();
	
	@XStreamAsAttribute
	@XmlAttribute
	private String id;
	
	@XStreamAsAttribute
	@XmlAttribute
	private String key;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XStreamAsAttribute
	@XmlAttribute
	private String value;

	public smParamNode getParentNode() {
		return ParentNode;
	}

	public void setParentNode(smParamNode parentNode) {
		ParentNode = parentNode;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public List<smParamNode> getSmParamNode() {
		return smParamNode;
	}

	public void setSmParamNode(List<smParamNode> smParamNode) {
		this.smParamNode = smParamNode;
	}
}
