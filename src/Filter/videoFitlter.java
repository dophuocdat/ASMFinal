package Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import Controller.FavoriteDAO;
import Controller.UserDAO;
import Model.User;

@WebFilter({ "/OEServlet/*", "/OEServlet/showVideo/*", "/OEServlet/register" })
public class videoFitlter extends HttpFilter implements Filter {
	FavoriteDAO dao = new FavoriteDAO();

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		User user = (User) request.getSession().getAttribute("user");
		String uri = request.getRequestURI();
		// System.out.println(uri);
		if (uri.contains("/showVideo")) {
			// System.out.println("Filter show video");
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			switch (action) {
			case "watch": {
				System.out.println("Action Watch");
				if (user == null) {
					request.getSession().setAttribute("active", false);
					request.getSession().setAttribute("UserNotLogin", true);
				} else {
					request.getSession().setAttribute("UserNotLogin", false);
					Boolean active = dao.checkActive(id, user.getIdUser());
					if (active) {
						System.out.println("đã like");
						request.getSession().setAttribute("active", true);
					} else {
						System.out.println("Chưa like");
						request.getSession().setAttribute("active", false);
					}
				}
				break;
			}
			case "liked": {
				// System.out.println("filter liked");
				if (user == null) {
					request.getSession().setAttribute("active", false);

				} else {
					Boolean activeLike = (Boolean) request.getSession().getAttribute("active");

					// System.out.println("Trước khi active: " + activeLike);
					if (activeLike) {
						request.getSession().setAttribute("active", false);
						System.out.println("sau khi active: " + request.getSession().getAttribute("active"));
					} else {
						request.getSession().setAttribute("active", true);
						System.out.println("sau khi active: " + request.getSession().getAttribute("active"));
					}

				}

				break;
			}
			case "share": {
				// System.out.println(uri);
				// System.out.println("Status share");
				String to = request.getParameter("to");
				String from = request.getParameter("from");
				String message = request.getParameter("message");
				String linkYTB = request.getParameter("link");
				// System.out.println(to + "/ " + from + "/ " + message + "/ " + linkYTB);
				break;
			}
			}
		} else if (uri.contains("/register")) {
			String fullName = request.getParameter("fullName");
			String idUser = request.getParameter("idUser");
			String Email = request.getParameter("email");
			String pass = request.getParameter("password");
			String cfPass = request.getParameter("confirmPassword");

			String error = "";
			int checkError = 0;
			if (fullName.isBlank() || fullName.isEmpty()) {
				error += "Fullname không được để trống \n";
				checkError++;
			}
			if (idUser.isBlank() || idUser.isEmpty()) {
				error += "idUser không được để trống \n";
				checkError++;
			}
			if (Email.isBlank() || Email.isEmpty()) {
				error += "Email không được để trống \n";
				checkError++;
			}
			if (pass == null) {
				error += "pass không được để trống \n";
				checkError++;
			}
			UserDAO dao = new UserDAO();
			Boolean checkId = dao.findById(idUser);
			if (checkId) {
				error += "Id Người dùng đã được sử dụng";
				checkError++;
			}
			if (checkError > 0) {
				request.getSession().setAttribute("ErrorRegister", error);
				request.getRequestDispatcher("/views/account/signUp.jsp").forward(request, response);
				return;
			}

		}
		// default Language
		String lang = request.getParameter("lang");
		System.out.println(lang);
		if (lang != null) {
			request.getSession().setAttribute("lang", lang);
		}

		chain.doFilter(request, response);
	}

}
