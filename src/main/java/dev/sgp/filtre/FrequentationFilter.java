package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.FrequentationService;
import dev.sgp.util.Constantes;
import dev.sgp.web.EditerCollaborateurController;

@WebFilter(urlPatterns = { "/*" })
public class FrequentationFilter implements Filter {
	private static final Logger LOG = LoggerFactory.getLogger(FrequentationFilter.class);

	private FrequentationService freqService = Constantes.FREQ_SERVICE;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		long before = System.currentTimeMillis();
		
		chain.doFilter(req, resp);
		
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		int tempsExecution =  (int) (after - before);
		LOG.debug(path + " : " + tempsExecution);
		VisiteWeb visite = new VisiteWeb(0, path, tempsExecution);
		freqService.addVisite(visite);
	}

	@Override
	public void destroy() {
	}
}
