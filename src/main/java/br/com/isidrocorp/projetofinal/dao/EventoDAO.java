package br.com.isidrocorp.projetofinal.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.projetofinal.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer> {
	public ArrayList<Evento> findByOrderByData();
	public ArrayList<Evento> findByOrderByNumSeq();
}
