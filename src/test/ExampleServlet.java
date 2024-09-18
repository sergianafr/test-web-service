package test;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/data")  
public class ExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Récupération du paramètre "input"
        String input = request.getParameter("input");
        if (input == null) {
            input = "default";
        }

        // Définir le type de contenu de la réponse comme JSON
        response.setContentType("application/json");

        // Création de la réponse JSON
        String jsonResponse = "{\"response\": \" nom " + input + "\"}";

        // Envoi de la réponse
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}

