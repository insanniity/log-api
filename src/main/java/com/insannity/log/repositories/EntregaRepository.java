package com.insannity.log.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insannity.log.entities.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}
