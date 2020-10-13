package servicer;

import javax.jws.WebService;

import servicer.service.GetIP4TravelService;

@WebService
public class GetIP4Travel implements GetIP4TravelImpl {

	@Override
	public String getIP4Travel(String ip) {
		// TODO Auto-generated method stub
		return GetIP4TravelService.getIP4Travel(ip);
	}

}
