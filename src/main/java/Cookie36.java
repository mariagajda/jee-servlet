import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/rememberMe")
public class Cookie36 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Cookie[] cookies = request.getCookies();
        String userNameFromCookie = null;
        for (Cookie c : cookies) {
            if ("userName".equals(c.getName())) {
                userNameFromCookie = c.getValue();
            }

        }
        if (userNameFromCookie == null) {
            response.getWriter().append("<form action='/rememberMe' method='post'>")
                    .append("<Label>Name: <input type='text' name='name'/></Label></br>")
                    .append("<Label>Zapamiętaj mnie <input type='checkbox' name='rememberMe'/></Label?</br>")
                    .append("<input type='submit' value='wyslij'/>")
                    .append("</form>");
        } else {
            response.getWriter().append("Cześć " + userNameFromCookie)
                    .append(". Twoje dane zostały wczytane z ciasteczka");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String rememberMe = request.getParameter("rememberMe");
        response.getWriter().println("Cześć " + name);
        if (rememberMe != null) {
            Cookie cookie = new Cookie("userName", name);
            cookie.setMaxAge(24 * 3600);
            response.addCookie(cookie);
        }
    }
}
