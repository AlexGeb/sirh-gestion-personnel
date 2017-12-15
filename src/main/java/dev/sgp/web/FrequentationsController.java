package dev.sgp.web;

import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.FrequentationService;
import dev.sgp.util.Constantes;

@WebServlet(urlPatterns = { "/collaborateurs/frequentations" })
public class FrequentationsController extends HttpServlet {

	private final FrequentationService freqService = Constantes.FREQ_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, IntSummaryStatistics> visites = freqService.getStatsByPath();
		req.setAttribute("visites", visites);
		req.getRequestDispatcher("/WEB-INF/views/statistiques/frequentations.jsp").forward(req, resp);
	}

}
