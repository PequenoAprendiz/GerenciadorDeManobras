/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import java.util.List;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Treino;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.excecao.ItemSemIdUsuarioException;
import wellington.gerenciadorDeManobras.excecao.ManobraDuplicadaException;
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

    public void atualizar(Manobra manobra) throws SQLException {
        this.verificaIdUsuario(manobra);
    }

    public void atualizaStatus(Treino treino) throws SQLException {
        ManobraDAO manobraDAO = new ManobraDAO();
        manobraDAO.atualizarStatus(treino);
    }

    private void verificaIdUsuario(Manobra manobra) throws SQLException {
        if (manobra.getIdUsuario() == 0) {
            String msg = "Este item está sendo salvo sem um Identificador de Usuario!";
            throw new ItemSemIdUsuarioException(msg);
        } else {
            ManobraDAO manobraDAO = new ManobraDAO();
            manobraDAO.atualizar(manobra);

        }
    }

    public void verificarManobra(Manobra manobra) throws SQLException {
        ManobraBO manobraBO = new ManobraBO();
        List<Manobra> manobras = manobraBO.buscarTodasManobras(manobra.getIdUsuario());
        for (Manobra m : manobras) {
            if (manobra.getNome().equals(m.getNome())) {
                throw new ManobraDuplicadaException();
            }
        }
    }

}
