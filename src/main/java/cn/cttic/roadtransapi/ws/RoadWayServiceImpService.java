package cn.cttic.roadtransapi.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

import cn.cttic.roadtransapi.exception.RoadWayService;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * RoadWayServiceImpService service = new RoadWayServiceImpService();
 * RoadWayService portType = service.getRoadWayServiceImpPort();
 * portType.command(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "RoadWayServiceImpService", targetNamespace = "http://imp.service.ws.roadtransapi.cttic.cn/", wsdlLocation = "http://localhost:8080/data-transfer/ws/RoadWayService?wsdl")
public class RoadWayServiceImpService extends Service {

	private final static URL ROADWAYSERVICEIMPSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(cn.cttic.roadtransapi.ws.RoadWayServiceImpService.class
					.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = cn.cttic.roadtransapi.ws.RoadWayServiceImpService.class
					.getResource(".");
			url = new URL(baseUrl,
					"http://localhost:8080/data-transfer/ws/RoadWayService?wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/data-transfer/ws/RoadWayService?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		ROADWAYSERVICEIMPSERVICE_WSDL_LOCATION = url;
	}

	public RoadWayServiceImpService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public RoadWayServiceImpService() {
		super(ROADWAYSERVICEIMPSERVICE_WSDL_LOCATION, new QName(
				"http://imp.service.ws.roadtransapi.cttic.cn/",
				"RoadWayServiceImpService"));
	}

	/**
	 * 
	 * @return returns RoadWayService
	 */
	@WebEndpoint(name = "RoadWayServiceImpPort")
	public RoadWayService getRoadWayServiceImpPort() {
		return super.getPort(new QName(
				"http://imp.service.ws.roadtransapi.cttic.cn/",
				"RoadWayServiceImpPort"), RoadWayService.class);
	}

}
