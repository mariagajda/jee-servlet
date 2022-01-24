import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/servlet312")
public class Servlet312 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String languageFromForm = request.getParameter("language");

        Cookie cookie = new Cookie("language", languageFromForm);
        cookie.setMaxAge(24 * 3600);
        response.addCookie(cookie);

    }
}
