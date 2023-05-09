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
import jakarta.servlet.jsp.PageContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.client.http.HttpRequest;

import APIYTB.APIYTB;
import Controller.UserDAO;
import Model.User;

@WebFilter({ "/OEServlet/*" })
public class LoginFilter extends HttpFilter implements Filter {
	List<Model.Videos> listTopMusic = new ArrayList<>();
	List<Model.Videos> ListSport = new ArrayList<>();
	List<Model.Videos> ListFimlAndAnim = new ArrayList<>();
	List<Model.Videos> listNewPolitics = new ArrayList<>();
	List<Model.Videos> listEntertainment = new ArrayList<>();
	


	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
	//	System.out.println(uri);
		if (uri.contains("/Login")) {
			System.out.println("Login");
			String idUser = request.getParameter("idUser");
			String password = request.getParameter("password");
			request.getSession().setAttribute("logger", false);
			User ent = UserDAO.login(idUser, password);
			//System.out.println(idUser + " "+ password);
			if (ent != null) {
				AllListVideo(request);
				request.getSession().setAttribute("user", ent);
				request.getSession().setAttribute("logger", true);
				request.getRequestDispatcher("/views/homepage.jsp").forward(request, response);
			} else {

				request.setAttribute("message", "Đăng nhập thất bại");
				request.getRequestDispatcher("/views/account/login.jsp").forward(request, response);
			}
		}else if(uri.contains("/OEServlet")) {
			AllListVideo(request);
		}

		chain.doFilter(request, response);
	}

	private void AllListVideo(HttpServletRequest request) throws IOException {
		listTopMusic = APIYTB.TopMusic();
		ListSport = APIYTB.SPORTS();
		ListFimlAndAnim = APIYTB.FILMANDANIMATION();
		listNewPolitics = APIYTB.NEWS_POLITICS();
		listEntertainment = APIYTB.ENTERTAINMENT();
		request.setAttribute("listTopMusic", listTopMusic);
		request.setAttribute("listSport", ListSport);
		request.setAttribute("ListFimlAndAnim", ListFimlAndAnim);
		request.setAttribute("listNewPolitics", listNewPolitics);
		request.setAttribute("listEntertainment", listEntertainment);
	}
}
