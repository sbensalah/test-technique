package test.technique.soumaya.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
		
	 public static  Double round(Double value, int scale) {
		    return BigDecimal.valueOf(value).setScale(scale, RoundingMode.HALF_UP).doubleValue();
		}
}
