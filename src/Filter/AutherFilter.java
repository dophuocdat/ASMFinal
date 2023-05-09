package Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.List;

import Controller.UserDAO;
import Model.User;

@WebFilter("/OEServlet/Login")
public class AutherFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

//		System.out.println("Filter Login");
		String idUser = request.getParameter("email");
		String password = request.getParameter("idUser");
		chain.doFilter(request, response);
	}

}
