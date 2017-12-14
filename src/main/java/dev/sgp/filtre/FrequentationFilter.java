package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.sgp.web.EditerCollaborateurController;

public class FrequentationFilter implements Filter {
	private FilterConfig config = null;
	private static final Logger LOG = LoggerFactory.getLogger(FrequentationFilter.class);

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		LOG.debug(path + " : " + (after - before));
	}

	@Override
	public void destroy() {
	}
}
