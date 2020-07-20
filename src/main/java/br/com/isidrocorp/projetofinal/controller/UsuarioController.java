package br.com.isidrocorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetofinal.dao.UsuarioDAO;
import br.com.isidrocorp.projetofinal.model.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperarTodos(){
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll();
		for (Usuario u: lista) {
			u.setSenha("******");
		}
		return lista;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> logarUsuario(@RequestBody Usuario userEmailSenha) {
		Usuario res = dao.findByEmailAndSenha(userEmailSenha.getEmail(), 
				                              userEmailSenha.getSenha());
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		else {
			return ResponseEntity.status(403).build();
		}
	}
}
