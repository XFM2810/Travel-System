import javax.jws.WebService;
@WebService(targetNamespace="WeatherInterface") 
public class WeatherInterfaceImpl implements WeatherInterface {
@Override
  public String queryWeather(String cityName) {
  System.out.print("ok2");
  System.out.println("get cityName"+cityName);
  String weather="rain";
  return weather;
   }
  } 