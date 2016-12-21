package ru.app.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SessionSetZuulPreFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(SessionSetZuulPreFilter.class);

	// @Autowired
	// private SessionRepository repository;

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}
	//
	// @Override
	// public Object run() {
	// RequestContext context = RequestContext.getCurrentContext();
	//
	// HttpSession httpSession = context.getRequest().getSession();
	// //Session session = repository.getSession(httpSession.getId());
	//
	// //context.addZuulRequestHeader("Cookie", "SESSION=" +
	// httpSession.getId());
	//
	// //log.info("ZuulPreFilter session proxy: {}", session.getId());
	//
	// return null;
	// }

}