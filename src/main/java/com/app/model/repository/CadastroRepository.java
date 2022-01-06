package com.app.model.repository;

import com.app.model.entity.CadastroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<CadastroModel, Long> {
}