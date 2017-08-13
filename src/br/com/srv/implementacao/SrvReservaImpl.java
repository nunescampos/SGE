package br.com.srv.implementacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.repository.interfaces.RepositoryReserva;
import br.com.srv.interfaces.SrvReserva;

public class SrvReservaImpl implements SrvReserva {
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositoryReserva repositoryReserva;

	public void setRepositoryReserva(RepositoryReserva repositoryReserva) {

		this.repositoryReserva = repositoryReserva;
	}
}