package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
		public static int generateRandomNumber() {
			double ranNum = Math.random() * 10000;
			int random = (int) ranNum;
			return random;
		}
		
		public static String genCurrenttime() {
//			124134   _11062026
			LocalDateTime now=LocalDateTime.now();
		String time =DateTimeFormatter.ofPattern("hhmmss_ddMMyyyy").format(now);
		
			
			return time;
		}
	}

