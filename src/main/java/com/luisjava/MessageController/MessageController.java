package com.luisjava.MessageController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisjava.model.Message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/messages/")
public class MessageController {
	
	List<Message> FinalMensajes = new ArrayList<>();
	
	@GetMapping("mostrar")
	public Mono<Message> mostrar(){
		return Mono.just(new Message("001", "Muestra"));
	}
	
	@GetMapping
	public Flux<Message> listar() {
		List<Message> Mensajes = new ArrayList<>();
		Mensajes.add(new Message("001", "Mensaje1"));
		Mensajes.add(new Message("002", "Mensaje2"));
		
		Flux<Message> messageFlux = Flux.fromIterable(Mensajes);
		
		return messageFlux;
	}
	
	@GetMapping("/request")
	public void getRequest(String idUser_aux, String mensaje_aux) {
		FinalMensajes.add(new Message(idUser_aux, mensaje_aux));
	}
	
	@GetMapping("/response")
	public Mono<ResponseEntity<Flux<Message>>> getRespuesta(){
		Flux<Message> responseFlux = Flux.fromIterable(FinalMensajes);
		
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(responseFlux));
	}
}
