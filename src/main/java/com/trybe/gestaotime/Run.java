package com.trybe.gestaotime;

import com.trybe.gestaotime.dao.AplicacaoBD;
import com.trybe.gestaotime.model.Documento;
import com.trybe.gestaotime.model.Jogador;
import com.trybe.gestaotime.model.Time;
import com.trybe.gestaotime.model.Torcedor;
import java.util.ArrayList;
import java.util.List;

/**Classe Run.*/
public class Run {
  private static AplicacaoBD aplicacaoBd = new AplicacaoBD();
  private static List<Jogador> jogadores = new ArrayList<Jogador>();
  private static List<Torcedor> torcedores = new ArrayList<Torcedor>();

  /**Método principal.*/
  public static void main(String[] args) {
    Documento documento = new Documento();
    documento.setCpf("12345678911");
    documento.setNumeroCarteiraTrabalho("12345678911");
    documento.setNumeroCbf("9");

    Time time = new Time();
    time.setNome("Corinthians");
    
    Torcedor torcedor = new Torcedor();
    torcedor.setNome("Ana Luisa");
    torcedor.setTimes(time);
    
    time.setTorcedores(torcedores);    

    Jogador jogador = new Jogador();
    jogador.setDocumento(documento);
    jogador.setNome("Cássio");
    jogador.setPosicao("goleiro");
    jogador.setTime(time);
    
    time.setJogadores(jogadores);
    
    aplicacaoBd.timeDao().salvar(time);
    aplicacaoBd.torcedorDao().salvar(torcedor);
    aplicacaoBd.documentoDao().salvar(documento);
    aplicacaoBd.jogadorDao().salvar(jogador);
  }
}