package br.com.project.report.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.project.model.classes.Mensagem1;

public class EmailUtils {
 
 private static final String HOSTNAME = "smtp.gmail.com";
 private static final String USERNAME = "aluysio8812@gmail.com";
 private static final String PASSWORD = "75BEdg522";
 private static final String EMAILORIGEM = "aluysio8812@gmail.com";
 
 public static Email conectaEmail() throws EmailException {
 Email email = new SimpleEmail();
 email.setHostName(HOSTNAME);
 email.setSmtpPort(587);
 email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
 email.setTLS(true);
 email.setFrom(EMAILORIGEM);
 return email;
 }
 
 public static void enviaEmail(Mensagem1 mensagem) throws EmailException {
 Email email = new SimpleEmail();
 email = conectaEmail();
 email.setSubject(mensagem.getTitulo());
 email.setMsg(mensagem.getMensagem());
 email.addTo(mensagem.getDestino());
 String resposta = email.send();
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso para: " + mensagem.getDestino(), "Informação"));
 }
}