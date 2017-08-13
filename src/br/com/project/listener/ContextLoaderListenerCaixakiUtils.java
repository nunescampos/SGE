package br.com.project.listener;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/*
 Listener e classe utilitaria para que seja possivel acessar os componentes de injecao de dependencia onde não é possivel ter a injeção 
 por exemplo dentro de paginas JSP
 Ex:
	EntidadeController  entidadeController = (EntidadeController) ContextLoaderListenerCaixakiUtils.getBean("entidadeController")
 */
@ApplicationScoped
public class ContextLoaderListenerCaixakiUtils extends
		org.springframework.web.context.ContextLoaderListener implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static WebApplicationContext getWac() {
		return WebApplicationContextUtils
				.getWebApplicationContext(getCurrentWebApplicationContext().getServletContext());
	}
	
	public static Object getBean(String idNomeBean) {
		return getWac().getBean(idNomeBean);
	}
	
	public static Object getBean(Class<?> classe) {
		return getWac().getBean(classe);
	}

}
