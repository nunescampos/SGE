package br.com.project.geral.controller;

import javax.servlet.http.HttpServletRequest;

import org.primefaces.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.implementacao.crud.JdbcTemplateImpl;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Entidade;
import br.com.project.model.classes.Reserva;
import br.com.repository.interfaces.RepositoryReserva;
import br.com.srv.interfaces.SrvReserva;

@Controller
public class ReservaController extends ImplementacaoCrud<Reserva> implements
		InterfaceCrud<Reserva> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SrvReserva srvReserva;
	@Autowired
	private RepositoryReserva repositoryReserva;

	@Autowired
	private EntidadeController entidadeController;

	@Autowired
	private JdbcTemplateImpl jdbcTemplateImpl;

	public void setSrvReserva(SrvReserva srvReserva) {
		this.srvReserva = srvReserva;
	}

	public void setRepositoryReserva(RepositoryReserva repositoryReserva) {
		this.repositoryReserva = repositoryReserva;
	}

	@RequestMapping(value = "reservaSalvar", method = RequestMethod.POST)
	public String reservaSalvar(Reserva entidade, Model modelAndView)
			throws Exception {

		int reservas = jdbcTemplateImpl
				.queryForInt("select count (1) from reserva where laboratorio ="
						+ entidade.getLaboratorio().getId_laboratorio()
						+ " and horadb = '"
						+ entidade.getHoradb()
						+ "' "
						+ "and datareserva = '"
						+ entidade.getDatareserva()
						+ "';");
		if (reservas > 0) {
			modelAndView.addAttribute("horarioLivre", false);
		} else {
			modelAndView.addAttribute("horarioLivre", true);
			entidade = merge(entidade);

		}
		modelAndView.addAttribute("reserva", entidade);
		modelAndView
				.addAttribute(
						"professores",
						super.findListByQueryDinamica("from Entidade where tipo = 'PROFESSOR'"));
		modelAndView.addAttribute("cursos",
				super.findListByQueryDinamica("from Curso"));
		modelAndView.addAttribute("disciplinas",
				super.findListByQueryDinamica("from Disciplina"));
		modelAndView.addAttribute("laboratorios",
				super.findListByQueryDinamica("from Laboratorio"));
		modelAndView.addAttribute("cursos",
				super.findListByQueryDinamica("from Curso"));
		return "inicio";

	}

	@RequestMapping(value = "/minhasReservas", method = RequestMethod.GET)
	public String minhasReservas(HttpServletRequest httpSession,
			Model modelAndView) throws Exception {
		Entidade entidade = (Entidade) httpSession.getSession(true)
				.getAttribute("usuarioLogado");
		modelAndView.addAttribute(
				"minhasReservas",
				findListByProperty(Reserva.class, "entidade.ent_codigo",
						entidade.getEnt_codigo()));
		return "minhasReservas";

	}

	@RequestMapping(value = "/todasReservas", method = RequestMethod.GET)
	public String todasReservas(HttpServletRequest httpSession,
			Model modelAndView) throws Exception {
		modelAndView.addAttribute("todasReservas",
				super.findListByQueryDinamica("from Reserva"));
		return "todasReservas";

	}

	@RequestMapping(value = "reserva", method = RequestMethod.GET)
	public String reserva(Reserva entidade, Model modelAndView) {

		return "reserva";

	}

	@RequestMapping(value = "reservasRealizadas", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	String reservasRealizadas(@RequestParam String date, Model model)
			throws Exception {
		JSONArray jsonArray = new JSONArray();
		for (Reserva reserva : super
				.findListByQueryDinamica(" from Reserva where datareserva = '"
						+ date + "'")) {
			jsonArray.put(reserva.getJson());
		}
		return jsonArray.toString();

	}

	@RequestMapping(value = "reservaExcluir", method = RequestMethod.GET)
	public String reservaExcluir(@RequestParam Long id_reserva,
			Model modelAndView, HttpServletRequest httpSession,
			@RequestParam String tela) throws Exception {

		Reserva entidade = super.findById(Reserva.class, id_reserva);
		super.delete(entidade);

		if (tela.equalsIgnoreCase("unica")) {
			Entidade user = (Entidade) httpSession.getSession(true)
					.getAttribute("usuarioLogado");
			modelAndView.addAttribute(
					"minhasReservas",
					findListByProperty(Reserva.class, "entidade.ent_codigo",
							user.getEnt_codigo()));
			return "minhasReservas";

		} else {
			modelAndView.addAttribute("todasReservas",
					findListByQueryDinamica("from Reserva"));
			return "todasReservas";
		}

	}

}
