package br.com.srv.implementacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.repository.interfaces.RepositoryCurso;
import br.com.srv.interfaces.SrvCurso;

public class SrvCursoImpl implements SrvCurso {
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositoryCurso repositoryCurso;

	public void setRepositoryCurso(RepositoryCurso repositoryCurso) {

		this.repositoryCurso = repositoryCurso;
	}
}