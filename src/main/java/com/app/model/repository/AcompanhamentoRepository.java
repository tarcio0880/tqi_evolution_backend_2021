package com.app.model.repository;

import com.app.model.entity.AcompanhamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcompanhamentoRepository extends JpaRepository<AcompanhamentoModel, Long> {
}