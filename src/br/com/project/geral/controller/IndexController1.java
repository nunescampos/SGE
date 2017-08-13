package br.com.project.geral.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;

import br.com.project.model.classes.Mensagem1;
import br.com.project.report.util.EmailUtils;

public class IndexController1 {
 
 private Mensagem1 mensagem = new Mensagem1();
 
 public Mensagem1 getMensagem() {
 return mensagem;
 }
 public void setMensagem(Mensagem1 mensagem) {
 this.mensagem = mensagem;
 }
 
 public void enviaEmail() {
 try {
 EmailUtils.enviaEmail(mensagem);
 } catch (EmailException ex) {
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! Occoreu um erro ao enviar a mensagem.", "Erro"));
 Logger.getLogger(IndexController1.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
 
 public void limpaCampos() {
 mensagem = new Mensagem1();
 }
 
}