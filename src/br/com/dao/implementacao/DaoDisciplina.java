package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Disciplina;
import br.com.repository.interfaces.RepositoryDisciplina;

@Repository
public class DaoDisciplina extends ImplementacaoCrud<Disciplina> implements
		RepositoryDisciplina {
	private static final long serialVersionUID = 1L;
}