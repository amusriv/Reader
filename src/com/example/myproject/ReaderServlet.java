package com.example.myproject;
import java.io.IOException;

import com.reader.Reader.*;

import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import com.reader.Reader.dbAccess;

//@WebServlet("/ReaderServlet")
@SuppressWarnings("serial")

public class ReaderServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");*/
		
		RequestDispatcher view = req.getRequestDispatcher("index.html");
		view.forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //MyClass myClass = new MyClass();
		System.out.println("\n\n\n!!!!!POST REACHED!!!!\n\n\n");		
		dbAccess db = new dbAccess();	
		
		response.sendRedirect(db.getLink());
	      
        /*if (request.getParameter("button1") != null) {
            myClass.function1();
        } else if (request.getParameter("button2") != null) {
            myClass.function2();
        } else if (request.getParameter("button3") != null) {
            myClass.function3();
        } else {
            // ???
        }*/

        //request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
    }

	
}
