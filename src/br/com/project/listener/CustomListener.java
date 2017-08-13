package br.com.project.listener;

import java.io.Serializable;


import org.hibernate.envers.RevisionListener;
import org.springframework.stereotype.Service;

import br.com.framework.utils.UtilFramework;
import br.com.project.model.classes.Entidade;
import br.com.project.model.classes.InformacaoRevisao;

/**
 * Responsável por prover a gravação de auditoria de dados a nivel de aplicação
 * do hibernate envers.
 * 
 * @author Alex
 * 
 */
@Service
public class CustomListener implements RevisionListener, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void newRevision(Object revisionEntity) {
			InformacaoRevisao informacaoRevisao = (InformacaoRevisao) revisionEntity;

			Long codUser = UtilFramework.getThreadLocal().get();
			Entidade user = new Entidade();
			if (codUser != null && codUser != 0L) {
				user.setEnt_codigo(codUser);
				informacaoRevisao.setEntidade(user);
			}
	}

}
