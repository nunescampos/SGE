package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Laboratorio;
import br.com.repository.interfaces.RepositoryLaboratorio;

@Repository
public class DaoLaboratorio extends ImplementacaoCrud<Laboratorio> implements
		RepositoryLaboratorio {
	private static final long serialVersionUID = 1L;
}