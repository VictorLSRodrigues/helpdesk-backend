package com.victor.helpdesk.services;


import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.victor.helpdesk.domain.Pessoa;
import com.victor.helpdesk.domain.Tecnico;
import com.victor.helpdesk.domain.dtos.TecnicoDTO;
import com.victor.helpdesk.repositories.PessoaRepository;
import com.victor.helpdesk.repositories.TecnicoRepository;
//import com.victor.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.victor.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id, null));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}
}
