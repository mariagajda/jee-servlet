import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/servlet311")
public class Servlet311 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String language = null;
        String languageValue = null;
        boolean languageCookieExist = false;
        for (Cookie c : cookies) {
            if ("language".equals(c.getName())) {
                languageCookieExist = true;
                language = c.getValue();
            }
        }
        if (!languageCookieExist) {
            language = "pl";
        }

        for (Map.Entry<String, String> entry : getLanguageMap().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals(language)) {
                languageValue = value;
            }
        }

        String[] languages = new String [getLanguageMap().size()];
        int i = 0;
        Iterator<Map.Entry<String, String>> it = getLanguageMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry keyValue = it.next();
            String key = (String) keyValue.getKey();
            languages[i] = key;
            i++;
        }

        request.setAttribute("welcome", languageValue);
        request.setAttribute("languages", languages);
        getServletContext().getRequestDispatcher("/index311.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public Map<String, String> getLanguageMap() {
        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Hallo");
        lang.put("es", "Hola");
        lang.put("fr", "Salut");
        return lang;
    }
}
