package com.luisjava.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Message {
	
	private Integer idMessage;
	private String idUser;
	private String mensaje;
	private static final AtomicInteger count = new AtomicInteger(0); 
	//private LocalDateTime timestamp;
	
	public Message(String idUser, String mensaje) {
		idMessage = count.incrementAndGet(); 
		idUser = idUser;
		mensaje = mensaje;
		// TODO Auto-generated constructor stub
	}

	public Integer getIdMessage() {
		return this.idMessage;
	}
	
	public String getIdUser() {
		return this.idUser;
	}
	
	public String getMensaje() {
		return this.mensaje;
	}
	
	/*
	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}*/
	
	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}
	
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public void setIdMessage(String mensaje) {
		this.mensaje = mensaje;
	}
	
	/*
	public void setIdMessage(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}*/
	
}
