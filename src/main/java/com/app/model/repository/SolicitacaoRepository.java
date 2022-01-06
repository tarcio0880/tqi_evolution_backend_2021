package com.app.model.repository;

import java.util.List;
import com.app.model.entity.SolicitacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<SolicitacaoModel, Long> {

    List<SolicitacaoModel> findByCadastroId(Long id);

}