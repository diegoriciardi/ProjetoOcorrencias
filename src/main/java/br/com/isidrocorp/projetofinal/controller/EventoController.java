package br.com.isidrocorp.projetofinal.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetofinal.dao.EventoDAO;
import br.com.isidrocorp.projetofinal.dto.VolumeAlarmes;
import br.com.isidrocorp.projetofinal.model.Evento;

@RestController
public class EventoController {

	@Autowired
	EventoDAO dao;

	@GetMapping("/eventos")
	public ArrayList<Evento> recuperarTodos() {
		ArrayList<Evento> lista;
		lista = (ArrayList<Evento>) dao.findByOrderByData();

		return lista;
	}

	@GetMapping("/eventos/alarmes/resumo")
	public ArrayList<VolumeAlarmes> recuperarResumoPorAlarme() {
		return dao.getAllWithName();
	}

	@GetMapping("/eventos/alarmes/janeiro")
	public ArrayList<VolumeAlarmes> recuperarDeJaneiro() {
		try {
			Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020");
			Date fim    = new SimpleDateFormat("dd/MM/yyyy").parse("31/01/2020");

			return dao.getAllWithNameByPeriod(inicio, fim);
		} catch (Exception ex) {
			return null;
		}
	}

}
