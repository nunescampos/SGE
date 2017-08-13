package br.com.project.geral.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.SendEmail;
import br.com.repository.interfaces.RepositorySendEmail;
import br.com.srv.interfaces.SrvSendEmail;

@Controller
public class SendEmailController extends ImplementacaoCrud<SendEmail> implements
		InterfaceCrud<SendEmail> {
	private static final long serialVersionUID = 1L;
	@Autowired
	private SrvSendEmail srvSendEmail;
	@Autowired
	private RepositorySendEmail repositorySendEmail;

	public void setSrvSendEmail(SrvSendEmail srvSendEmail) {
		this.srvSendEmail = srvSendEmail;
	}

	public void setRepositorySendEmail(RepositorySendEmail repositorySendEmail) {
		this.repositorySendEmail = repositorySendEmail;
	}

	public void sendEmail(SendEmail email) throws Exception {
		srvSendEmail.sendEmail(email);
	}

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(method = RequestMethod.GET)
	public String doSendEmail(HttpServletRequest request) {
		// takes input from e-mail form
		String recipientAddress = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);
		
		// forwards to the view named "Result"
		return "Result";
	}
	
}
