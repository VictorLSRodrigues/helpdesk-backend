package com.victor.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.helpdesk.domain.Chamado;
import com.victor.helpdesk.domain.Cliente;
import com.victor.helpdesk.domain.Tecnico;
import com.victor.helpdesk.domain.enums.Perfil;
import com.victor.helpdesk.domain.enums.Prioridade;
import com.victor.helpdesk.domain.enums.Status;
import com.victor.helpdesk.repositories.ChamadoRepository;
import com.victor.helpdesk.repositories.ClienteRepository;
import com.victor.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "victor", "70320415074", "victor@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "cleiton", "29440909099", "cleiton@gmail.com", "321");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	
	}
}
