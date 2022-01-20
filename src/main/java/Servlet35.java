import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet35")
public class Servlet35 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String[] nums = request.getParameterValues("num");
        int sum = 0;
        int product = 1;
        PrintWriter writer = response.getWriter();
        writer.append("Liczby: \n");
        for (int i = 0; i < nums.length; i++) {
            sum += Integer.parseInt(nums[i]);
            product *= Integer.parseInt(nums[i]);
            writer.append(" - " + nums[i] +"\n");
        }
        writer.append("Średnia:\n - " + sum/nums.length + "\n")
                .append("Suma: \n - " + sum + "\n")
                .append("Iloczyn: \n - " + product);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
