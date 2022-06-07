package cn.cttic.roadtransapi.ws_roadway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Transaction_Response complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transaction_retcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_retmsg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = { "transactionRetcode",
		"transactionRetmsg" })
public class TransactionResponse {

	@XmlElement(name = "retcode", required = true)
	protected String transactionRetcode;
	@XmlElement(name = "retmsg", required = true)
	protected String transactionRetmsg;

	/**
	 * Gets the value of the transactionRetcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionRetcode() {
		return transactionRetcode;
	}

	/**
	 * Sets the value of the transactionRetcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionRetcode(String value) {
		this.transactionRetcode = value;
	}

	/**
	 * Gets the value of the transactionRetmsg property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionRetmsg() {
		return transactionRetmsg;
	}

	/**
	 * Sets the value of the transactionRetmsg property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionRetmsg(String value) {
		this.transactionRetmsg = value;
	}

}
