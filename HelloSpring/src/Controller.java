import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/index.html")

public class Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String name = req.getParameter("name");		
		
		req.setAttribute("name", "Hello");
		req.getRequestDispatcher("HelloUser.jsp").forward(req, resp);								
	}
}
