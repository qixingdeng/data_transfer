package cn.cttic.roadtransapi.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Transaction_Header_list complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction_Header_list">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transaction_serialnum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_targetservice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_sourceservice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_system_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_service_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_isreq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_signature" type="{http://roadwayservice.cttic.cn/}Transaction_signature"/>
 *         &lt;element name="transaction_response" type="{http://roadwayservice.cttic.cn/}Transaction_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction_Header_list", propOrder = {
		"transactionSerialnum", "transactionTargetservice",
		"transactionSourceservice", "transactionSystemId",
		"transactionServiceId", "transactionDate", "transactionTime",
		"transactionIsreq", "transactionSignature", "transactionResponse" })
public class TransactionHeaderList {

	@XmlElement(name = "transaction_serialnum", required = true)
	protected String transactionSerialnum;
	@XmlElement(name = "transaction_targetservice", required = true)
	protected String transactionTargetservice;
	@XmlElement(name = "transaction_sourceservice", required = true)
	protected String transactionSourceservice;
	@XmlElement(name = "transaction_system_id", required = true)
	protected String transactionSystemId;
	@XmlElement(name = "transaction_service_id", required = true)
	protected String transactionServiceId;
	@XmlElement(name = "transaction_date", required = true)
	protected String transactionDate;
	@XmlElement(name = "transaction_time", required = true)
	protected String transactionTime;
	@XmlElement(name = "transaction_isreq", required = true)
	protected String transactionIsreq;
	@XmlElement(name = "transaction_signature", required = true)
	protected TransactionSignature transactionSignature;
	@XmlElement(name = "transaction_response", required = true)
	protected TransactionResponse transactionResponse;

	/**
	 * Gets the value of the transactionSerialnum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionSerialnum() {
		return transactionSerialnum;
	}

	/**
	 * Sets the value of the transactionSerialnum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionSerialnum(String value) {
		this.transactionSerialnum = value;
	}

	/**
	 * Gets the value of the transactionTargetservice property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionTargetservice() {
		return transactionTargetservice;
	}

	/**
	 * Sets the value of the transactionTargetservice property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionTargetservice(String value) {
		this.transactionTargetservice = value;
	}

	/**
	 * Gets the value of the transactionSourceservice property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionSourceservice() {
		return transactionSourceservice;
	}

	/**
	 * Sets the value of the transactionSourceservice property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionSourceservice(String value) {
		this.transactionSourceservice = value;
	}

	/**
	 * Gets the value of the transactionSystemId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionSystemId() {
		return transactionSystemId;
	}

	/**
	 * Sets the value of the transactionSystemId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionSystemId(String value) {
		this.transactionSystemId = value;
	}

	/**
	 * Gets the value of the transactionServiceId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionServiceId() {
		return transactionServiceId;
	}

	/**
	 * Sets the value of the transactionServiceId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionServiceId(String value) {
		this.transactionServiceId = value;
	}

	/**
	 * Gets the value of the transactionDate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * Sets the value of the transactionDate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionDate(String value) {
		this.transactionDate = value;
	}

	/**
	 * Gets the value of the transactionTime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionTime() {
		return transactionTime;
	}

	/**
	 * Sets the value of the transactionTime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionTime(String value) {
		this.transactionTime = value;
	}

	/**
	 * Gets the value of the transactionIsreq property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionIsreq() {
		return transactionIsreq;
	}

	/**
	 * Sets the value of the transactionIsreq property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionIsreq(String value) {
		this.transactionIsreq = value;
	}

	/**
	 * Gets the value of the transactionSignature property.
	 * 
	 * @return possible object is {@link TransactionSignature }
	 * 
	 */
	public TransactionSignature getTransactionSignature() {
		return transactionSignature;
	}

	/**
	 * Sets the value of the transactionSignature property.
	 * 
	 * @param value
	 *            allowed object is {@link TransactionSignature }
	 * 
	 */
	public void setTransactionSignature(TransactionSignature value) {
		this.transactionSignature = value;
	}

	/**
	 * Gets the value of the transactionResponse property.
	 * 
	 * @return possible object is {@link TransactionResponse }
	 * 
	 */
	public TransactionResponse getTransactionResponse() {
		return transactionResponse;
	}

	/**
	 * Sets the value of the transactionResponse property.
	 * 
	 * @param value
	 *            allowed object is {@link TransactionResponse }
	 * 
	 */
	public void setTransactionResponse(TransactionResponse value) {
		this.transactionResponse = value;
	}

}
