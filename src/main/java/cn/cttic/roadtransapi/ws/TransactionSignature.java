package cn.cttic.roadtransapi.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Transaction_signature complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction_signature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transaction_md5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transaction_detail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction_signature", propOrder = { "transactionMd5",
		"transactionDetail" })
public class TransactionSignature {

	@XmlElement(name = "transaction_md5", required = true)
	protected String transactionMd5;
	@XmlElement(name = "transaction_detail", required = true)
	protected String transactionDetail;

	/**
	 * Gets the value of the transactionMd5 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionMd5() {
		return transactionMd5;
	}

	/**
	 * Sets the value of the transactionMd5 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionMd5(String value) {
		this.transactionMd5 = value;
	}

	/**
	 * Gets the value of the transactionDetail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionDetail() {
		return transactionDetail;
	}

	/**
	 * Sets the value of the transactionDetail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionDetail(String value) {
		this.transactionDetail = value;
	}

}
