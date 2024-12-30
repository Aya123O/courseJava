package lab4;
import java.util.function.Function;

public class TemperatureConverter implements  Function<Double, Double>  {
   
            
            public Double apply(Double centigrade) {
                return (centigrade * 9 / 5) + 32;
            }
  
}
