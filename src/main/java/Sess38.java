import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/sess38")
public class Sess38 extends HttpServlet {
    int points = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");


        HttpSession session = request.getSession();
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        } else {
            if ((int) session.getAttribute("counter") < boundaryCountriesArray().length - 1) {
                int counter = (int) session.getAttribute("counter") + 1;
                session.setAttribute("counter", counter);
            }
        }
        int sessionCounter = (int) session.getAttribute("counter");
        response.getWriter().append("<form action='sess38' method='post'>")
                .append("Podaj stolicę dla państwa: ")
                .append(boundaryCountriesArray()[sessionCounter][0])
                .append("<input type='text' name='capitalCity'/>")
                .append("<input type='submit' value='Check'/></br>")
                .append("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String capitalCity = request.getParameter("capitalCity");


        HttpSession session = request.getSession();
        int sessionCounter = (int) session.getAttribute("counter");
        if (capitalCity.equals(boundaryCountriesArray()[sessionCounter][1])) {
            points += 1;
            if (sessionCounter < boundaryCountriesArray().length - 1) {
                response.getWriter().append("Correct")
                        .append("<form action='sess38' method='get'>")
                        .append("<input type='submit' value='Next'>")
                        .append("</form>");
            } else {
                response.getWriter().append("Correct.")
                        .append("</br> Poprawnych odpowiedzi: " + points  + "/" + boundaryCountriesArray().length);
            }
        } else {
            if (sessionCounter < boundaryCountriesArray().length - 1) {
                response.getWriter().append("Wrong. Correct answer is: " + boundaryCountriesArray()[sessionCounter][1])
                        .append("<form action='sess38' method='get'>")
                        .append("<input type='submit' value='Next'>")
                        .append("</form>");
            } else {
                response.getWriter().append("Wrong. Correct answer is: " + boundaryCountriesArray()[sessionCounter][1] + "</br>")
                        .append("Poprawnych odpowiedzi: " + points + "/" + boundaryCountriesArray().length);
            }

        }
    }

    public String[][] boundaryCountriesArray() {
        String[][] countries = new String[6][2];
        countries[0][0] = "Germany";
        countries[0][1] = "Berlin";
        countries[1][0] = "Czech Republic";
        countries[1][1] = "Praha";
        countries[2][0] = "Slovakia";
        countries[2][1] = "Bratislava";
        countries[3][0] = "Ukraine";
        countries[3][1] = "Kiev";
        countries[4][0] = "Belarus";
        countries[4][1] = "Minsk";
        countries[5][0] = "Russia";
        countries[5][1] = "Moscow";
        return countries;
    }

    public String isCorrect(String capitalCity, HttpSession session) {
        int counter = (int) session.getAttribute("counter");
        if (boundaryCountriesArray()[counter][1].equals(capitalCity)) {
            return "Correct";
        } else {
            return "Wrong";
        }
    }
}
