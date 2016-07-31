package util;

public class TimeUtil {
	/**
	 * 将秒转换为 时分秒的字符串形式
	 * @param sencond
	 * @return
	 */
	public static String secondToString(int sencond) {
		/**
		 * 获取总的时长 时/分/秒
		 */
		int h = sencond/3600;
		int m = (sencond%3600)/60;
		int s = (sencond%3600)%60;
		String timeLong    = h + "时" + m + "分" + s +"秒";
		return timeLong;
	}
}
