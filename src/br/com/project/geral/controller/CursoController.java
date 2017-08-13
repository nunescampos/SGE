package br.com.project.geral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Curso;
import br.com.project.model.classes.Entidade;
import br.com.repository.interfaces.RepositoryCurso;
import br.com.srv.interfaces.SrvCurso;

@Controller
public class CursoController extends ImplementacaoCrud<Curso> implements
		InterfaceCrud<Curso> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SrvCurso srvCurso;
	@Autowired
	private RepositoryCurso repositoryCurso;

	public void setSrvCurso(SrvCurso srvCurso) {
		this.srvCurso = srvCurso;
	}

	public void setRepositoryCurso(RepositoryCurso repositoryCurso) {
		this.repositoryCurso = repositoryCurso;
	}

	@RequestMapping(value = "cursoSalvar", method = RequestMethod.POST)
	public String cursoSalvar(Curso entidade, Model modelAndView)
			throws Exception {
		entidade = merge(entidade);
		modelAndView.addAttribute("curso", entidade);
		return "curso";

	}

	@RequestMapping(value = "curso", method = RequestMethod.GET)
	public String curso(Entidade entidade, Model modelAndView) {

		return "curso";

	}

}
