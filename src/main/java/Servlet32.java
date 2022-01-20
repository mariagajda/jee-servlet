import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet32")
public class Servlet32 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String binaryValue = request.getParameter("binaryValue");

        char[] binaryCharArray = binaryValue.toCharArray();
        boolean isBinary = false;
        for (int i = 0; i < binaryCharArray.length; i++) {
            if (binaryCharArray[i] == '1' || binaryCharArray[i] == '0') {
                isBinary = true;
            } else {
                isBinary = false;
            }
        }
        if(isBinary){
            response.getWriter().println(binaryValue + " to liczba " + convertBinaryToDecimal(binaryValue));
        } else{
            response.getWriter().println("Błąd konwersji. Podana wartość nie jest wartością binarną");
        }
    }

    public int convertBinaryToDecimal(String binaryValue) {
        char[] binaryCharArray = binaryValue.toCharArray();
        int decimalValue = 0;
        for (int i = binaryCharArray.length - 1; i >= 0; i--) {
            if (binaryCharArray[i] == '1') {
                decimalValue += (int) Math.pow(2.0, binaryCharArray.length - i - 1);
            }
        }
        return decimalValue;
    }
}
