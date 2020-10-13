package client;

public class Main {
	public static void main(String[] args) {
		GetIP4TravelService getIP4TravelService = new GetIP4TravelService();
		GetIP4Travel getIP4Travel = getIP4TravelService.getGetIP4TravelPort();
		String result = getIP4Travel.getIP4Travel("");
		System.out.println(result);
	}
}
