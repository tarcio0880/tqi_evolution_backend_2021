package com.app.repository;

import com.app.model.entity.CadastroModel;
import com.app.model.entity.EmprestimoModel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

public interface CadastroRepository extends JpaRepository<CadastroModel, Long> {


}