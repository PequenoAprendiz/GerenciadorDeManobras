/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.negocio;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Requisito;
import wellington.gerenciadorDeManobras.entidade.Treino;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.excecao.DigitosIncorretosException;
import wellington.gerenciadorDeManobras.excecao.TreinoDuplicadoException;
import wellington.gerenciadorDeManobras.excecao.TreinoJaEditadoException;
import wellington.gerenciadorDeManobras.persistencia.RequisitoDAO;
import wellington.gerenciadorDeManobras.persistencia.TreinoDAO;

/**
 *
 * @author Wellington
 */
public class TreinoBO {

    private TreinoBO treinoBO;
    private List<Treino> treinos;
    private List<String> idManobrasSugeridas;
    private List<Requisito> listaRquisitos;
    private int idUsuario;

    public void inserir(Treino treino, int idUsuario) throws SQLException {
        this.idUsuario = idUsuario;
        this.verificarTreinos(treino);
        TreinoDAO treinoDAO = new TreinoDAO();
        treinoDAO.inserir(treino);
    }

    public void atualizar(Treino treinoEmEdicao) throws SQLException, CampoObrigatorioException, ParseException {
        TreinoDAO treinoDAO = new TreinoDAO();
        treinoDAO.atualizar(treinoEmEdicao);
    }

    public void atualizarNovamente(Treino treinoEmEdicao, int respostaExcecao) throws SQLException, CampoObrigatorioException, ParseException {
        TreinoDAO treinoDAO = new TreinoDAO();
        treinoDAO.atualizar(treinoEmEdicao);
    }

    public void removerTreino(int id) throws Exception {
        TreinoDAO treinoDAO = new TreinoDAO();
        treinoDAO.removerTreino(id);
    }

    public List<Treino> buscarTodosTreinos(int idUsuario) throws SQLException {
        TreinoDAO treinoDAO = new TreinoDAO();
        return treinoDAO.buscarTodosTrienos(idUsuario);
    }

    public List<Requisito> verificaProgresso(Treino treinoEmEdicao) throws SQLException {
        if (treinoEmEdicao.getProgresso() == 100) {
            RequisitoDAO requisitoDAO = new RequisitoDAO();
            listaRquisitos = requisitoDAO.buscarTodosRequisitosEspecificos(); // where idmanobrarequisito == treino em treinoEmEdicao.getIdManobra(
        }
        return listaRquisitos;
    }

    public boolean verificaTreinoConcluido(Treino treinoEmEdicao) throws SQLException, CampoObrigatorioException, ParseException {
        this.treinoBO = new TreinoBO();
        this.treinos = treinoBO.buscarTodosTreinos(idUsuario);
        for (Treino t : treinos) {
            if (treinoEmEdicao.getId() == t.getId() && t.getProgresso() == 100) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void verificarTreinos(Treino treinoEmEdicao) throws SQLException {
        this.treinoBO = new TreinoBO();
        this.treinos = treinoBO.buscarTodosTreinos(idUsuario);
        for (Treino t : treinos) {
            if (treinoEmEdicao.getIdManobra() == t.getIdManobra()) {
                throw new TreinoDuplicadoException();
            }
        }
    }

    private void confirmarEdicao(Treino treinoEmEdicao) throws CampoObrigatorioException, ParseException, SQLException {
        this.treinoBO = new TreinoBO();
        boolean retornoDaVerificacao = treinoBO.verificaTreinoConcluido(treinoEmEdicao);
        if (retornoDaVerificacao) {
            throw new TreinoJaEditadoException();
        }
    }

    public void validarCamposObrigatorios(Treino treinoEmEdicao) {
        if (treinoEmEdicao.getProgresso() == 0 ) {
            String msg = "Preecha o campo progresso!";
            throw new CampoObrigatorioException(msg);
        }
        if (treinoEmEdicao.getQntddias() == 0) {
            String msg = "Preecha o campo Quantidade de dias!";
            throw new CampoObrigatorioException(msg);
        }        
    }

    public void verificaQuantidadeDigitos(Treino treinoEmEdicao) {
        String progresso;
        progresso = Integer.toString(treinoEmEdicao.getProgresso());
        if (progresso.length() > 3) {
            String msg = "Campo progresso deve ser preenchido com até 3 digitos!\n";
            throw new DigitosIncorretosException(msg);
        }

        int x = treinoEmEdicao.getProgresso();
        if (x > 100) {
            String msg = "Campo progresso deve ser preenchido até 100\n";
            throw new DigitosIncorretosException(msg);
        }

        if (treinoEmEdicao.getQntddias() < 0) {
            String msg = "Campo quandtidade de dias deve ter no minimo 2 dias!";
            throw new DigitosIncorretosException(msg);
        }

    }

}
