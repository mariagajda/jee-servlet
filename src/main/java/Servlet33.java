import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet33")
public class Servlet33 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        String previousText1 = "";
        String previousText2 = "";
        String previousText3 = "";
        String previousText4 = "";
        String previousText5 = "";
        if (session.getAttribute("text1") != null) {
            previousText1 = (String) session.getAttribute("text1");
        }
        if (session.getAttribute("text2") != null) {
            previousText2 = (String) session.getAttribute("text2");
        }
        if (session.getAttribute("text3") != null) {
            previousText3 = (String) session.getAttribute("text3");
        }
        if (session.getAttribute("text4") != null) {
            previousText4 = (String) session.getAttribute("text4");
        }
        if (session.getAttribute("text5") != null) {
            previousText5 = (String) session.getAttribute("text5");
        }

        PrintWriter writer = response.getWriter();
        writer.append("<form action='servlet33' method='post'>")
                .append("<input type='text' name='text1' value='" + previousText1 + "'/></br>")
                .append("<input type='text' name='text2' value='" + previousText2 + "'/></br>")
                .append("<input type='text' name='text3' value='" + previousText3 + "'/></br>")
                .append("<input type='text' name='text4' value='" + previousText4 + "'/></br>")
                .append("<input type='text' name='text5' value='" + previousText5 + "'/></br>")
                .append("<input type='submit' value='Prześlij'/>")
                .append("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        String text1 = request.getParameter("text1");
        String text2 = request.getParameter("text2");
        String text3 = request.getParameter("text3");
        String text4 = request.getParameter("text4");
        String text5 = request.getParameter("text5");
        session.setAttribute("text1", text1);
        session.setAttribute("text2", text2);
        session.setAttribute("text3", text3);
        session.setAttribute("text4", text4);
        session.setAttribute("text5", text5);

    }
}
