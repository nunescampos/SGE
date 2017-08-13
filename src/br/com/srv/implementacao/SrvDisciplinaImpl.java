package br.com.srv.implementacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.repository.interfaces.RepositoryDisciplina;
import br.com.srv.interfaces.SrvDisciplina;

public class SrvDisciplinaImpl implements SrvDisciplina {
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositoryDisciplina repositoryDisciplina;

	public void setRepositoryDisciplina(
			RepositoryDisciplina repositoryDisciplina) {

		this.repositoryDisciplina = repositoryDisciplina;
	}
}