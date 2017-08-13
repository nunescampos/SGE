package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Reserva;
import br.com.repository.interfaces.RepositoryReserva;

@Repository
public class DaoReserva extends ImplementacaoCrud<Reserva> implements
		RepositoryReserva {
	private static final long serialVersionUID = 1L;
}