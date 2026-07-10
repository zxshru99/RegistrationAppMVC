

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register")
public class Register extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Model model=new Model();
		model.setUname(uname);
		model.setEmail(email);
		model.setPassword(password);
		int RowAffected=model.register();
		HttpSession session = request.getSession();
		session.setAttribute("name", uname);
		if(RowAffected==0) {
			response.sendRedirect("failure.jsp");
		}
		else {
			response.sendRedirect("success.jsp");
			
		}
		
		
		
	}

}
