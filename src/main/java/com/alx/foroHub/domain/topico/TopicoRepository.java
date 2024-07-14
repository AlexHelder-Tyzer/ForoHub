package com.alx.foroHub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
