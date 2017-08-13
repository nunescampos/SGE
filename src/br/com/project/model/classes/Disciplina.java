package br.com.project.model.classes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "disciplina")
@SequenceGenerator(name = "disciplina_seq", sequenceName = "disciplina_seq", initialValue = 1, allocationSize = 1)
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_seq")
	private Long id_disciplina;

	private String disciplinadb;

	public Long getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(Long id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public void setDisciplinadb(String disciplinadb) {
		this.disciplinadb = disciplinadb;
	}

	public String getDisciplinadb() {
		return disciplinadb;
	}

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	protected int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_disciplina == null) ? 0 : id_disciplina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (id_disciplina == null) {
			if (other.id_disciplina != null)
				return false;
		} else if (!id_disciplina.equals(other.id_disciplina))
			return false;
		return true;
	}

}
