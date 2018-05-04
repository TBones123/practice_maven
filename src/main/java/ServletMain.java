import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletMain")
public class ServletMain extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }
       private DbConnection dbConnection = new DbConnection();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String surname = req.getParameter("surname");
        String id = req.getParameter("id");
        dbConnection.save(username, surname, id);
        req.setAttribute("allUsers", dbConnection.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
        System.out.println(username);
    }
}
