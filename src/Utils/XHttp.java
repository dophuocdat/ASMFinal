package Utils;

import jakarta.servlet.http.HttpServletRequest;

public class XHttp {
	public static String getRealPath(String path) {
		HttpServletRequest request = RRSharer.request();
		if (request != null) {
			return request.getServletContext().getRealPath(path);
		} else {
			throw new RuntimeException("No HttpServletRequest found in current thread");
		}
	}
}
