package br.com.srv.implementacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.repository.interfaces.RepositoryLaboratorio;
import br.com.srv.interfaces.SrvLaboratorio;

public class SrvLaboratorioImpl implements SrvLaboratorio {
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositoryLaboratorio repositoryLaboratorio;

	public void setRepositoryLaboratorio(
			RepositoryLaboratorio repositoryLaboratorio) {

		this.repositoryLaboratorio = repositoryLaboratorio;
	}
}