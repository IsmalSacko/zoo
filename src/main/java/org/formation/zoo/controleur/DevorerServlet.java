package org.formation.zoo.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.zoo.modele.metier.Animal;

/**
 * Servlet implementation class MangerServlet
 */
@WebServlet("/devorer")
public class DevorerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevorerServlet() {
        super();
    
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mangeur = request.getParameter("mangeur");
		String mange = request.getParameter("mange");
		request.setAttribute("mangeurs", mangeur);
		request.setAttribute("manges", mange);
		
		request.setAttribute("devore", Manager.getInstance().devorer(0,1));
		
		
//		request.setAttribute("animauxselectinnes", Manager.getInstance()));
//		request.getServletContext().getRequestDispatcher("/init").forward(request, response);
	}

}
