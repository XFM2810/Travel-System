import javax.jws.WebService;
import javax.jws.WebMethod;
@WebService
public interface WeatherInterface { 
    @WebMethod
    public String queryWeather(String cityName);
    
}