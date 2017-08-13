package br.com.project.geral.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.srv.interfaces.SrvLogin;

@Controller
public class LoginController extends ImplementacaoCrud<Object> implements
		InterfaceCrud<Object> {
	private static final long serialVersionUID = 1L;
	@Resource
	private SrvLogin srvLogin;

	public void setSrvLogin(SrvLogin srvLogin) {
		this.srvLogin = srvLogin;
	}

	private void carregarCombos(Model modelAndView) throws Exception {
		modelAndView
				.addAttribute(
						"professores",
						super.findListByQueryDinamica("from Entidade where tipo = 'PROFESSOR'"));
		modelAndView.addAttribute("cursos",
				super.findListByQueryDinamica("from Curso"));
		modelAndView.addAttribute("disciplinas",
				super.findListByQueryDinamica("from Disciplina"));
		modelAndView.addAttribute("laboratorios",
				super.findListByQueryDinamica("from Laboratorio"));
		modelAndView.addAttribute("cursos",
				super.findListByQueryDinamica("from Curso"));
	}


	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession(true).setAttribute("usuarioLogado", null);
		request.getSession(true).invalidate();
		return "/index";

	}
	
}
