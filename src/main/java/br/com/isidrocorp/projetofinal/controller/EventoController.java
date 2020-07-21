package br.com.isidrocorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetofinal.dao.EventoDAO;
import br.com.isidrocorp.projetofinal.model.Evento;

@RestController
public class EventoController {
	
	@Autowired
	EventoDAO dao;
	
	@GetMapping("/eventos")
	public ArrayList<Evento> recuperarTodos(){
		ArrayList<Evento> lista;
		lista = (ArrayList<Evento>)dao.findByOrderByData();
	
		return lista;
	}

}
