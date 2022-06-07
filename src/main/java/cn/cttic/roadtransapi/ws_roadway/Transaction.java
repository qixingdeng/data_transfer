package cn.cttic.roadtransapi.ws_roadway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transaction_header" type="{http://roadwayservice.cttic.cn/}Transaction_Header_list"/>
 *         &lt;element name="transaction_body" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "transactionHeader", "transactionBody" })
@XmlRootElement(name = "Transaction")
public class Transaction {

	@XmlElement(name = "header", required = true)
	protected TransactionHeaderList transactionHeader;
	@XmlElement(name = "body", required = true)
	protected String transactionBody;

	/**
	 * Gets the value of the transactionHeader property.
	 * 
	 * @return possible object is {@link TransactionHeaderList }
	 * 
	 */
	public TransactionHeaderList getTransactionHeader() {
		return transactionHeader;
	}

	/**
	 * Sets the value of the transactionHeader property.
	 * 
	 * @param value
	 *            allowed object is {@link TransactionHeaderList }
	 * 
	 */
	public void setTransactionHeader(TransactionHeaderList value) {
		this.transactionHeader = value;
	}

	/**
	 * Gets the value of the transactionBody property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionBody() {
		return transactionBody;
	}

	/**
	 * Sets the value of the transactionBody property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionBody(String value) {
		this.transactionBody = value;
	}

}
