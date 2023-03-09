package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;

/**Classe JogadorDao que estende GenericDao. */
public class JogadorDao extends GenericDao<Jogador, Integer> {

  public JogadorDao() {
    super(Jogador.class);
  }
}