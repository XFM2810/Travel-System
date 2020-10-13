package servicer.model.jsonObject;

public class Result {
	  private String ip;        
	  private Location location;          
	  private Ad_Info ad_info;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Ad_Info getAd_info() {
		return ad_info;
	}
	public void setAd_info(Ad_Info ad_info) {
		this.ad_info = ad_info;
	}           
}
