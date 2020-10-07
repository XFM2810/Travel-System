import javax.xml.ws.Endpoint;

public class WeatherServer {
public static void main(String[] args) {
  System.out.print("start\n");
  Endpoint.publish("http://localhost:8080/weather", new WeatherInterfaceImpl());
  System.out.print("success");
  }
 }