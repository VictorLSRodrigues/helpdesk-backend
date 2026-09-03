package com.victor.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.victor.helpdesk.domain.Cliente;
import com.victor.helpdesk.domain.Pessoa;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
