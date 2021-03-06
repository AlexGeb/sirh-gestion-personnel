package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;
import dev.sgp.util.FormValidator;

@WebServlet(urlPatterns = { "/collaborateurs/lister" })
public class ListerCollaborateursController extends HttpServlet {

	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private final DepartementService deptService = Constantes.DEPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Collaborateur> collaborateurs;
		List<Departement> departements = deptService.getListeDepartements();
		String selectedDept = "all";
		String searchValue = null;

		String recherche = req.getParameter("recherche");
		String nomDept = req.getParameter("departement");

		if (FormValidator.isNotNullAndNotEmpty(recherche)) {
			// cas ou l'utiliasteur effectue une recherche par nom et prenom
			searchValue = recherche;
			collaborateurs = collabService.queryByName(recherche);
		} else if (FormValidator.isNotNullAndNotEmpty(nomDept) && !"all".equals(nomDept)) {
			// cas ou l'utilisateur fait une recherche par departement (si all est
			// selectionné, tous les collaborateurs sont renvoyés)
			Optional<Departement> optDept = deptService.getDeptByName(nomDept);
			if (optDept.isPresent()) {
				selectedDept = optDept.get().getNom();
			}
			collaborateurs = collabService.queryByDept(nomDept);
		} else {
			collaborateurs = collabService.listerCollaborateurs();
		}

		req.setAttribute("collaborateurs", collaborateurs);
		req.setAttribute("departements", departements);
		req.setAttribute("selectedDept", selectedDept);
		req.setAttribute("searchValue", searchValue);

		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
	}
}
