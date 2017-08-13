package br.com.project.geral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Disciplina;
import br.com.project.model.classes.Entidade;
import br.com.repository.interfaces.RepositoryDisciplina;
import br.com.srv.interfaces.SrvDisciplina;

@Controller
public class DisciplinaController extends ImplementacaoCrud<Disciplina>
		implements InterfaceCrud<Disciplina> {

	private static final long serialVersionUID = 1L;
	@Autowired
	private SrvDisciplina srvDisciplina;
	@Autowired
	private RepositoryDisciplina repositoryDisciplina;

	public void setSrvDisciplina(SrvDisciplina srvDisciplina) {
		this.srvDisciplina = srvDisciplina;
	}

	public void setRepositoryDisciplina(
			RepositoryDisciplina repositoryDisciplina) {
		this.repositoryDisciplina = repositoryDisciplina;
	}

	@RequestMapping(value = "disciplinaSalvar", method = RequestMethod.POST)
	public String disciplinaSalvar(Disciplina entidade, Model modelAndView)
			throws Exception {
		entidade = merge(entidade);
		modelAndView.addAttribute("disciplina", entidade);
		return "disciplina";

	}

	@RequestMapping(value = "disciplina", method = RequestMethod.GET)
	public String disciplina(Entidade entidade, Model modelAndView) {

		return "disciplina";

	}

}
