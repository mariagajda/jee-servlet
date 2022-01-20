import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/servlet31")
public class Servlet31 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amount = Double.parseDouble(request.getParameter("amount"));
        String conversionType = request.getParameter("currency");
        response.getWriter().println(currencyConverter(conversionType, amount));
    }

    public double currencyConverter(String conversionType, double amount) {
        Map<String, Double> conversionMap = new HashMap<>();
        conversionMap.put("EUR-USD", 1.1335);
        conversionMap.put("USD-EUR", 0.8758);
        conversionMap.put("EUR-PLN", 4.5086);
        conversionMap.put("PLN-EUR", 0.2218);
        conversionMap.put("USD-PLN", 3.9618);
        conversionMap.put("PLN-USD", 0.2524);

        double convertedAmount = 0.0;
        for (Map.Entry<String, Double> entry : conversionMap.entrySet()) {
            String key = entry.getKey();
            double converter = entry.getValue();

            if (conversionType.equals(key)) {
                convertedAmount = amount * converter;
            }
        }
        return convertedAmount;
    }
}
