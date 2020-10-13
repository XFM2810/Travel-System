package servicer;

import javax.xml.ws.Endpoint;

public class GetIP4TravelService {
	 public static void main(String[] args) {
		 	System.err.println("start\n");
		 	Endpoint.publish("http://localhost:8085/getIP4Travel", new GetIP4Travel());
	        System.out.println("success");
	    }
}
