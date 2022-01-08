package com.app.repository;

import com.app.model.entity.AcompanhamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcompanhamentoRepository extends JpaRepository<AcompanhamentoModel, Long> {
}