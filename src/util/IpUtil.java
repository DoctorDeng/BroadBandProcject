package util;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {
	public static  String getIpAddr() {
		Random random = new Random();
		int a = random.nextInt(244)+1;
		int b = random.nextInt(244)+1;
		int c = random.nextInt(244)+1;
		String ip = a+"."+b+"."+c;
		return ip;
	}
}
