package br.com.srv.implementacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.repository.interfaces.RepositoryTurma;
import br.com.srv.interfaces.SrvTurma;

public class SrvTurmaImpl implements SrvTurma {
private static final long serialVersionUID = 1L;
@Autowired 
private RepositoryTurma repositoryTurma;

public void setRepositoryTurma(RepositoryTurma repositoryTurma) {

this.repositoryTurma= repositoryTurma;
}
}