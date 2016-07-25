package util;
/**
 * 字符串处理工具类
 * @author 邓华杰
 *
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空
	 * @param str  需要判断的字符串
	 * @return     为空返回TRUE，不为空返回false
	 */
	public static boolean isNull(String str) {
		if (null != str && !"".equals(str)) {
			return true;
		}
		return false;
	}
}
