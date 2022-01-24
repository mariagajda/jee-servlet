import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/newsletter")
public class Newsletter extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        boolean cookieValue = false;
        for (Cookie c : cookies) {
            if ("newsletterCookie".equals(c.getName())) {
                cookieValue = true;
            }
        }
        request.setAttribute("onNewsletterList", cookieValue);
        getServletContext().getRequestDispatcher("/newsletter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        Cookie cookie = new Cookie("newsletterCookie", "true");
        cookie.setMaxAge(24 * 3600);
        response.addCookie(cookie);
        request.setAttribute("sendNewsletter", true);

        User[] userTab = userDao.findAll();
        boolean userExist = false;
        for (int i = 0; i < userTab.length; i++) {
            if (userTab[i].getName().equals(name) && userTab[i].getEmail().equals(email)) {
                userExist = true;
            }
        }
        if (!userExist) {
            User newUser = new User(name, email);
            userDao.create(newUser);
        }


    }
}
