package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class ListerCollaborateursController extends HttpServlet {

	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private final DepartementService deptService = Constantes.DEPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Collaborateur> collaborateurs;
		List<Departement> departements = deptService.getListeDepartements();
		String selectedDept = "all";
		String searchValue = null;
		
		/** Little hack to init a list of collaborateurs : */
		if (collabService.listerCollaborateurs().isEmpty()) {
			collabService._init(departements);
		}

		String recherche = req.getParameter("recherche");
		String nomDept = req.getParameter("departement");

		if (!"".equals(recherche)) {
			// cas ou l'utiliasteur effectue une recherche par nom et prenom
			searchValue = recherche;
			collaborateurs = collabService.queryByName(recherche);
		} else if (!"".equals(nomDept) && !"all".equals(nomDept)) {
			// cas ou l'utilisateur fait une recherche par departement (si all est
			// selectionné, tous les collaborateurs sont renvoyés)
			Optional<Departement> optDept = deptService.getDeptByName(nomDept);
			if(optDept.isPresent()) {
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
