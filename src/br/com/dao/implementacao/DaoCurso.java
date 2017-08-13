package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Curso;
import br.com.repository.interfaces.RepositoryCurso;

@Repository
public class DaoCurso extends ImplementacaoCrud<Curso> implements
		RepositoryCurso {
	private static final long serialVersionUID = 1L;
}