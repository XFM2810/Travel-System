import weatherinterface.WeatherInterfaceImpl;
import weatherinterface.WeatherInterfaceImplService;

public class WeatherClient {
  public static void main(String[] args) {
  WeatherInterfaceImplService weatherInterfaceImplService=new WeatherInterfaceImplService();

  WeatherInterfaceImpl weatherInterfaceImpl=weatherInterfaceImplService.getPort(WeatherInterfaceImpl.class); 
 
  String weather=weatherInterfaceImpl.queryWeather("bj");
  System.out.println(weather);
    }
  }