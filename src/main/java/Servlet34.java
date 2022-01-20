import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet34")
public class Servlet34 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Cookie[] cookies = request.getCookies();
        int counter = 1;
        boolean visitsCookieExist = false;
        for (Cookie c : cookies) {
            if ("visits".equals(c.getName())) {
                visitsCookieExist = true;
                response.getWriter().println("Witaj, odwiedziłeś nas już " + c.getValue() + " razy");
                counter = Integer.parseInt(c.getValue()) + 1;
                Cookie cookie = new Cookie("visits", String.valueOf(counter));
                response.addCookie(cookie);
                break;
            }
        }
        if (!visitsCookieExist) {
            response.getWriter().println("Witaj pierwszy raz na naszej stronie");
            Cookie cookie = new Cookie("visits", String.valueOf(counter));
            cookie.setMaxAge(365 * 24 * 3600);
            response.addCookie(cookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
