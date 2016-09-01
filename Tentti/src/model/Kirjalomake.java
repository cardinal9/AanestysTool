package model;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Kirjalomake
 */
@WebServlet("/Kirjalomake")
public class Kirjalomake extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kirjalomake() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nimi  = request.getParameter("nimi");
		String tekijatiedot = request.getParameter("tekija");
		String ISBN = request.getParameter("ISBN");
		Kirja Kirj = new Kirja(nimi, tekijatiedot, ISBN);
		
		request.setAttribute("Kirja", Kirj);
		
		
		request.getRequestDispatcher("nayta_kirjan_tiedot.jsp").forward(request, response);
	}

}
