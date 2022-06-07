package cn.cttic.roadtransapi.ws;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.cttic.roadtransapi.common.ChangeCharset;
import cn.cttic.roadtransapi.exception.RoadWayService;
import cn.cttic.roadtransapi.signature.Base64;
import cn.cttic.roadtransapi.signature.MD5Util;

public class ReadXmlClient {

	public static void main(String[] args) {

		System.out.println(System.getProperty("file.encoding"));

		ChangeCharset changeCharset = new ChangeCharset();

		//StringBuffer context = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		StringBuffer context = new StringBuffer();
		
		//GetXml getXml=new GetXml("E:\\小三通\\已验证的报文\\许可证同步.xml"); 
		GetXml getXml=new GetXml("E:\\小三通\\已验证更新的报文\\集装箱运量运价情况.xml"); 
		context.append(getXml.removeLineTab(getXml.xmlToString()));

		RoadWayServiceImpService service = new RoadWayServiceImpService();
		RoadWayService portType = service.getRoadWayServiceImpPort();

		cn.cttic.roadtransapi.ws.Command.Transaction transaction = new cn.cttic.roadtransapi.ws.Command.Transaction();

		TransactionHeaderList value = new TransactionHeaderList();
		transaction.setTransactionHeader(value);

		value.setTransactionSerialnum("111111");
		value.setTransactionSourceservice("140000");
		value.setTransactionTargetservice("000000");
		value.setTransactionDate("123456");
		value.setTransactionTime("567890");
		value.setTransactionSystemId("1001");
		//value.setTransactionServiceId("R0101");
		value.setTransactionServiceId("R0104");
		//value.setTransactionServiceId("R0103");
		value.setTransactionIsreq("0");

		TransactionSignature transactionSignature = new TransactionSignature();
		value.setTransactionSignature(transactionSignature);

		// String publikeyString =
		// "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJzWl063g9U+nOcHyUWTQXWrPFS/\n"+
		// "QzRrGIWYy/cAoglNg0YGyX7SUCHHqS0nMHLXR3MOb4PfkW3ln8rWYtfVuVtWRIIwanozlVsqx3BZ\n"+
		// "GwNDjhT9/sDtaG26rtrWzqKgK9RBmbMvW7uePk1/G+L2m50PXAzFlKgBGx9XXiSDl8U/AgMBAAEC\n"+
		// "gYArMsP8L3nFS3il/bQHUNbv1RlJ8mBNWM4pRfuv7eGzlED7EbWAE+d0Vm0XfbrPdtI8M5atiO+i\n"+
		// "iGOp18Dj1/80Y58pBKWqiU8fxJ5872bQIJ9gYszbRz2yGI+IThf0DbQB7oS0mTOw+RrVqQwmwwWt\n"+
		// "Z/rbCzHYtp+fL7S+2E7dAQJBAPOt2Xx/S27QnPfErsMjQwkDKnOBOdXk+S5Qj9NUf1gd3nSOGASV\n"+
		// "CVkLefbfB1MrFYmQApB6duBjFX0lYxQRRb8CQQCkxK9QeovcIZPXVZ0unNYl30yX1QtAvbXWuuOz\n"+
		// "5eQQE8BpjJ5UvJilcMp8V3dXMNFNbxOGOaKBrT+niTsaRGCBAkBlR6G4bBQHJ+/Fz1qvwm0vRsCT\n"+
		// "J2fJbhTfWh6dQGZ5UljOauyyotsyxmFX6VTbDXIzLcbTFANqueQJkst+YLtzAkEAjgpkm/tY8Icd\n"+
		// "vSe4HgPkdLegfs+RKNmilZ99RourZNSyLgukPqZq7UxjsndwkQCrnpZf/XlYB3SECHi8M7O4gQJA\n"+
		// "LWRJ+aF24LjeQztD6PZjxXTfGVTE9a8eUfI5k3LnB8ga/DQ0wSptcAFTNKC3JBvZaYwLNAwgisAA\n"+
		// "Ten/HYFu7g==";

		String base64 = Base64.getBase64(context.toString());
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(base64);
		base64 = m.replaceAll("");

		//String md5 = MD5Util.string2MD5(base64);
		String md5 = MD5Util.strToMD5(base64);

		System.out.println(md5);

		// String signString = new String(
		// Signaturer.sign(publikeyString.getBytes(), md5));
		// transactionSignature.setTransactionDetail(signString);

		transactionSignature.setTransactionMd5(md5);

		transaction.setTransactionBody(context.toString());
		cn.cttic.roadtransapi.ws.CommandResponse.Transaction resptransaction = portType
				.command(transaction);

		String resp = "";
		try {
			resp = changeCharset.toGBK(resptransaction.getTransactionBody());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
