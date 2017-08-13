package br.com.project.geral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Entidade;
import br.com.project.model.classes.Laboratorio;
import br.com.repository.interfaces.RepositoryLaboratorio;
import br.com.srv.interfaces.SrvLaboratorio;

@Controller
public class LaboratorioController extends ImplementacaoCrud<Laboratorio>
		implements InterfaceCrud<Laboratorio> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SrvLaboratorio srvLaboratorio;
	@Autowired
	private RepositoryLaboratorio repositoryLaboratorio;

	public void setSrvLaboratorio(SrvLaboratorio srvLaboratorio) {
		this.srvLaboratorio = srvLaboratorio;
	}

	public void setRepositoryLaboratorio(
			RepositoryLaboratorio repositoryLaboratorio) {
		this.repositoryLaboratorio = repositoryLaboratorio;
	}

	@RequestMapping(value = "laboratorioSalvar", method = RequestMethod.POST)
	public String laboratorioSalvar(Laboratorio entidade, Model modelAndView)
			throws Exception {
		entidade = merge(entidade);
		modelAndView.addAttribute("laboratorio", entidade);
		return "laboratorio";

	}

	@RequestMapping(value = "laboratorio", method = RequestMethod.GET)
	public String laboratorio(Entidade entidade, Model modelAndView) {

		return "laboratorio";

	}

}
