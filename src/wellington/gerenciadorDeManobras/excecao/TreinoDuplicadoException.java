/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.excecao;

/**
 *
 * @author Wellington
 */
public class TreinoDuplicadoException extends GerenciadorException {
    
    public TreinoDuplicadoException() {
        super("Treino desta manobra já existe!");
    }
    
}
