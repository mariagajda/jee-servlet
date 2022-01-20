import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet("/sess37")
public class Sess37 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Random random = new Random();
        int randomNum1 = random.nextInt(981) + 20;
        int randomNum2 = random.nextInt(981) + 20;

        HttpSession session = request.getSession();

        session.setAttribute("num1", randomNum1);
        session.setAttribute("num2", randomNum2);

        response.getWriter().append("<form action='sess37' method='post'>")
                .append("<label>" + randomNum1 + " + " + randomNum2 + " = " + "<input type='number' name='sum'/></label></br>")
                .append("<label>" + randomNum1 + " - " + randomNum2 + " = " + "<input type='number' name='subtraction'/></label></br>")
                .append("<label>" + randomNum1 + " * " + randomNum2 + " = " + "<input type='number' name='multiplication'/></label></br>")
                .append("<input type='submit' value='Check'/></br>")
                .append("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        int num1 = (int) session.getAttribute("num1");
        int num2 = (int) session.getAttribute("num2");

        int sumFromForm = Integer.parseInt(request.getParameter("sum"));
        int subtractionFromForm = Integer.parseInt(request.getParameter("subtraction"));
        int multiplicationFromForm = Integer.parseInt(request.getParameter("multiplication"));

        int sum = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;


        response.getWriter().append(num1 + "    +    " + num2 + "    =    " + sum + "    " + isCorrect(sum, sumFromForm) + "</br>")
                .append(num1 + " - " + num2 + "    =    " + subtraction + "    " + isCorrect(subtraction, subtractionFromForm) + "</br>")
                .append(num1 + " * " + num2 + "    =    " + multiplication + "    " + isCorrect(multiplication, multiplicationFromForm) + "</br>");

    }

    public String isCorrect(int num, int numFromForm) {
        String outputIsCorrect;
        if (num == numFromForm) {
            outputIsCorrect = "Correct";
        } else {
            outputIsCorrect = "Wrong";
        }
        return outputIsCorrect;
    }
}
