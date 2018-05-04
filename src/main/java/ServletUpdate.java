import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdate")
public class ServletUpdate extends HttpServlet {
    private DbConnection dbConnection = new DbConnection();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        String[] split = url.split("/");
        String id = split[split.length - 1];
        Integer currid = Integer.valueOf(id);
        Department user = dbConnection.findOne(currid);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String newname = req.getParameter("newname");
        String newsurname = req.getParameter("newsurname");
        String parameter = req.getParameter("ids");
        dbConnection.update(id, newname,newsurname, parameter);

        req.setAttribute("allUsers", dbConnection.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);


    }
}
