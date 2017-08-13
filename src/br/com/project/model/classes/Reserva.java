package br.com.project.model.classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.primefaces.json.JSONObject;

@Audited
@Entity
@Table(name = "reserva")
@SequenceGenerator(name = "reserva_seq", sequenceName = "reserva_seq", initialValue = 1, allocationSize = 1)
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_seq")
	private Long id_reserva;

	@Basic
	@ManyToOne
	@JoinColumn(nullable = false, name = "curso", updatable = false)
	@ForeignKey(name = "curso_fk")
	private Curso curso;

	@Basic
	@ManyToOne
	@JoinColumn(nullable = false, name = "disciplina", updatable = false)
	@ForeignKey(name = "disciplina_fk")
	private Disciplina disciplina;

	@Basic
	@ManyToOne
	@JoinColumn(nullable = false, name = "laboratorio", updatable = false)
	@ForeignKey(name = "laboratorio_fk")
	private Laboratorio laboratorio;

	@Basic
	@ManyToOne
	@JoinColumn(nullable = false, name = "entidade", updatable = false)
	@ForeignKey(name = "entidade_fk")
	private Entidade entidade;

	private String anodb;

	private String semestredb;

	private String horadb;

	private String datareserva;

	private Date data = new Date();

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public String getAnodb() {
		return anodb;
	}

	public void setAnodb(String anodb) {
		this.anodb = anodb;
	}

	public String getSemestredb() {
		return semestredb;
	}

	public void setSemestredb(String semestredb) {
		this.semestredb = semestredb;
	}

	public String getHoradb() {
		return horadb;
	}

	public void setHoradb(String horadb) {
		this.horadb = horadb;
	}

	public String getDatareserva() {
		return datareserva;
	}

	public void setDatareserva(String datareserva) {
		this.datareserva = datareserva;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
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
				+ ((id_reserva == null) ? 0 : id_reserva.hashCode());
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
		Reserva other = (Reserva) obj;
		if (id_reserva == null) {
			if (other.id_reserva != null)
				return false;
		} else if (!id_reserva.equals(other.id_reserva))
			return false;
		return true;
	}

	public JSONObject getJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("anodb", getAnodb());
		map.put("data", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getData()));
		map.put("curso", getCurso().getCursodb());

		map.put("horadb", getHoradb());
		map.put("disciplina", getDisciplina().getDisciplinadb());
		map.put("laboratorio", getLaboratorio().getLaboratoriodb());
		map.put("reservado", new SimpleDateFormat("dd/MM/yyyy - HH:mm").format(getData()) + "hs por " + entidade.getEnt_login());
		return new JSONObject(map);
	}

}
