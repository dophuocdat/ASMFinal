package Servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sound.midi.Soundbank;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.api.services.youtube.model.Video;

import APIYTB.APIYTB;
import Controller.EmailUtility;
import Controller.FavoriteDAO;
import Controller.UserDAO;
import Controller.VideoDAO;
import Model.Favorite;
import Model.User;
import Utils.JpaUitls;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet({ "/OEServlet/Login", "/OEServlet/Logout", "/OEServlet/showVideo/*", "/OEServlet/searchVideo/",
		"/OEServlet/myProfile", "/OEServlet/myFavorite", "/OEServlet/uploadVideo", "/OEServlet/register" })
public class OEServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	FavoriteDAO favDAO = new FavoriteDAO();
	UserDAO userDao = new UserDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/homepage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> infoVideo = new ArrayList<>();
		List<Model.Videos> listVideoSearch = new ArrayList<>();
		String uri = request.getRequestURI();
		User user = (User) request.getSession().getAttribute("user");

		// System.out.println(uri);
		if (uri.contains("/showVideo")) {
			String action = request.getParameter("action");
			String id = request.getParameter("id");
			// System.out.println(action);
			switch (action) {
			case "watch": {

				System.out.println("watch");
				System.out.println("watch active: " + request.getSession().getAttribute("active"));

				showVideo(request, response, id);
				break;
			}
			case "liked": {
				// System.out.println("liked");
				likeAndUnlike(request, user, id);
				break;
			}
			case "share": {
				shareVideoByEmail(request, user);
				break;
			}
			}

		} else if (uri.contains("/Logout")) {
			request.getSession().setAttribute("logger", false);
			request.getSession().setAttribute("user", null);
			request.getRequestDispatcher("/views/homepage.jsp").forward(request, response);
		} else if (uri.contains("/myProfile")) {
			request.getRequestDispatcher("/views/account/myProfile.jsp").forward(request, response);
		} else if (uri.contains("/myFavorite")) {
			List<Favorite> ListMyFavorite = favDAO.findMyFavorite(user.getIdUser());
			request.setAttribute("ListMyFavorite", ListMyFavorite);
			request.getRequestDispatcher("/views/account/myFavorite.jsp").forward(request, response);

		} else if (uri.contains("/uploadVideo")) {

			Part filePart = request.getPart("videoFile");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String category = request.getParameter("category");
			String privacyStatus = request.getParameter("privacyStatus");
			String videoFilePath = filePart.getSubmittedFileName();
			// response.getWriter().print(title+"/ "+ description+"/ "+ category+"/ "
			// +privacyStatus+"/ " +videoFilePath+"/ " +filePart.getInputStream());
			try {
				// APIYTB.insertVideo(title, description, category, privacyStatus,
				// filePart.getInputStream());
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else if (uri.contains("/register")) {
			String fullName = request.getParameter("fullName");
			String idUser = request.getParameter("idUser");
			String Email = request.getParameter("email");
			String pass = request.getParameter("password");
			Boolean admin = false;
			User userRegister = new User(idUser, admin, Email, fullName, pass);

			userDao.insertUser(userRegister);

			request.getRequestDispatcher("/views/homepage.jsp").forward(request, response);
			// response.getWriter().print(request.getSession().getAttribute("ErrorRegister"));
		}

	}

	private void shareVideoByEmail(HttpServletRequest request, User user) {
		String resultMessage = "";
		String to = request.getParameter("to");
		String from = request.getParameter("from");
		String message = request.getParameter("message");
		String linkYTB = request.getParameter("link");
		System.out.println(to + "/ " + from + "/ " + message + "/ " + linkYTB);
		try {
			EmailUtility.sendEmail("smtp.gmail.com", "587", user.getEmail(), "pleesvrijquiicqp", from, "Send Video",
					message + "\n" + linkYTB);
			resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("MessageSendMail", resultMessage);
		}
	}

	private void likeAndUnlike(HttpServletRequest request, User user, String id) {
		Boolean activeLikeAndUnlike = (Boolean) request.getSession().getAttribute("active");
		if (activeLikeAndUnlike) {
			try {
				Video video = APIYTB.getVideoById(id);
				String title = video.getSnippet().getTitle();
				String poster = video.getSnippet().getThumbnails().getMedium().getUrl();
				long views = video.getStatistics().getViewCount().intValue();
				String description = video.getSnippet().getDescription();
				if (description.length() > 100) {
					description = description.substring(0, 100) + "...";
				}
				Date now = new Date();
				// System.out.println(user.getIdUser());

				Favorite model = new Favorite(id, true, description, now, poster, title, views, user); // favDAO.insert(model);
				favDAO.insert(model);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			favDAO.delete(id, user.getIdUser());
		}
	}

	private void showVideo(HttpServletRequest request, HttpServletResponse response, String idVideo)
			throws MalformedURLException, IOException, ServletException {
		List<String> infoVideo;
		List<Model.Videos> listVideoSearch;

		request.setAttribute("idVideo", idVideo);
		String search = request.getParameter("p");
		// System.out.println(search);
		try {
			infoVideo = getInfoVideo(idVideo);

			request.setAttribute("info", infoVideo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listVideoSearch = APIYTB.SearchVideo(search);
		request.setAttribute("listVideoSearch", listVideoSearch);
		request.getRequestDispatcher("/views/showVideo.jsp?action=watch&id=" + idVideo).forward(request, response);
		// String referer = request.getHeader("referer");
		// request.getRequestDispatcher(referer).forward(request, response);
	}

	private List<String> getInfoVideo(String id) throws Exception {
		List<String> infoVideo = new ArrayList<>();
		Video video = APIYTB.getVideoById(id);
		String title = video.getSnippet().getTitle();
		String description = video.getSnippet().getDescription();
		String view = "" + video.getStatistics().getViewCount();
		String likeCount = "" + video.getStatistics().getLikeCount();
		infoVideo.add(title);
		infoVideo.add(description);
		infoVideo.add(view);
		infoVideo.add(likeCount);
		return infoVideo;
	}

}
