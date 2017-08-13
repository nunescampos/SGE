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
@Table(name = "curso")
@SequenceGenerator(name = "curso_seq", sequenceName = "curso_seq", initialValue = 1, allocationSize = 1)
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
	private Long id_curso;

	public Long getId_curso() {
		return id_curso;
	}

	private String cursodb;

	public void setId_curso(Long id_curso) {
		this.id_curso = id_curso;
	}

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public void setCursodb(String cursodb) {
		this.cursodb = cursodb;
	}

	public String getCursodb() {
		return cursodb;
	}

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
				+ ((id_curso == null) ? 0 : id_curso.hashCode());
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
		Curso other = (Curso) obj;
		if (id_curso == null) {
			if (other.id_curso != null)
				return false;
		} else if (!id_curso.equals(other.id_curso))
			return false;
		return true;
	}

}
