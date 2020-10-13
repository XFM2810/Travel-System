package servicer;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface GetIP4TravelImpl {
	
	@WebMethod
	String getIP4Travel(String name);

}
