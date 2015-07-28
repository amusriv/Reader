package com.example.myproject;
import java.io.IOException;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import com.reader.Reader.dbAccess;
import com.reader.Reader.GotoLink;

//@WebServlet("/ReaderServlet")
@SuppressWarnings("serial")
public class ReaderServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\n\n\n!!!!!POST REACHED!!!!\n\n\n");		
		dbAccess db = new dbAccess();	
		
		GotoLink link = new GotoLink();
		link.setUrl(db.getLink());
		Gson gson = new Gson();
		resp.setContentType("application/json");		
		gson.toJson(link);
		//resp.getWriter().print(gson.toJson(link));	    
		System.out.println("\n\n\n" +  gson.toJson(link) + "\n\n\n\n");
		resp.getWriter().print(gson.toJson(link));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
		System.out.println("\n\n\n!!!!!POST REACHED!!!!\n\n\n");		
		dbAccess db = new dbAccess();			
		response.sendRedirect(db.getLink());
		System.out.println("REDIRECT SENT!");
	}

	
}
