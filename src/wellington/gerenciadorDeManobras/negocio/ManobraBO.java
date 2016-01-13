/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import java.util.List;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.persistencia.ManobraDAO;

/**
 *
 * @author were
 */
public class ManobraBO {

    public void inserir(Manobra manobraEmEdicao) throws SQLException {
        ManobraDAO manobraDAO = new ManobraDAO();
        manobraDAO.inserir(manobraEmEdicao);
    }

    public List<Manobra> buscarTodasManobras(int idUsuario) throws SQLException {
        ManobraDAO manobraDAO = new ManobraDAO();
        return manobraDAO.buscarTodasManobras(idUsuario);
    }

    public void removerManobra(int id) throws SQLException {
        ManobraDAO manobraDAO = new ManobraDAO();
        manobraDAO.removerManobra(id);
    }
    
    public void atualizar(Manobra manobra) throws SQLException{
        ManobraDAO manobraDAO = new ManobraDAO();
        manobraDAO.atualizar(manobra);
    }
    
  

    public void atualizaStatus(int id, int status) throws SQLException {
        ManobraDAO manobraDAO = new ManobraDAO();
        manobraDAO.atualizarStatus(id, status);
    }

  
    
    
}
