/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import wellington.gerenciadorDeManobras.entidade.Dica;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.negocio.DicaBO;
import wellington.gerenciadorDeManobras.negocio.ManobraBO;

/**
 *
 * @author Wellington
 */
public class GerenciarDicas extends javax.swing.JFrame {

    private List<Dica> dicas;
    private DicaBO dicaBO;
    private List<Manobra> manobras;
    private GerenciarManobrasTelaInicial gerenciarManobrasTelaInicial;
    private int idUsuario;
    /**
     * Creates new form GerenciarDicas
     */
    public GerenciarDicas() throws SQLException {
        initComponents();
        this.carregarTabelaDeDicas();
    }

    GerenciarDicas(GerenciarManobrasTelaInicial gerenciarManobrasTelaInicial, int idUsuario) throws SQLException {
       this.idUsuario = idUsuario;
        this.gerenciarManobrasTelaInicial = gerenciarManobrasTelaInicial;
        initComponents();
        this.carregarTabelaDeDicas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDicas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDicas = new javax.swing.JTable();
        btnExcluirRequisito = new javax.swing.JButton();
        btnFecharTela = new javax.swing.JButton();
        lblDica = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlDicas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciar Dicas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tabelaDicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaDicas);

        btnExcluirRequisito.setText("Excluir");
        btnExcluirRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirRequisitoActionPerformed(evt);
            }
        });

        btnFecharTela.setText("Voltar");
        btnFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTelaActionPerformed(evt);
            }
        });

        lblDica.setText("Info");

        javax.swing.GroupLayout pnlDicasLayout = new javax.swing.GroupLayout(pnlDicas);
        pnlDicas.setLayout(pnlDicasLayout);
        pnlDicasLayout.setHorizontalGroup(
            pnlDicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDicasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlDicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDica, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDicasLayout.createSequentialGroup()
                                .addComponent(btnExcluirRequisito)
                                .addGap(18, 18, 18)
                                .addComponent(btnFecharTela)))))
                .addContainerGap())
        );
        pnlDicasLayout.setVerticalGroup(
            pnlDicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDicasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFecharTela, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirRequisitoActionPerformed
        this.excluirRequisito();
    }//GEN-LAST:event_btnExcluirRequisitoActionPerformed

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharTelaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluirRequisito;
    private javax.swing.JButton btnFecharTela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDica;
    private javax.swing.JPanel pnlDicas;
    private javax.swing.JTable tabelaDicas;
    // End of variables declaration//GEN-END:variables

    private void carregarTabelaDeDicas() throws SQLException {
        this.dicaBO = new DicaBO();
        this.dicas = this.dicaBO.buscarTodasDicas();
        ModeloTabelaDicas modelo = new ModeloTabelaDicas();
        tabelaDicas.setModel(modelo);
    }

    private void excluirRequisito() {
        
          try {
            int linhaSelecionada = tabelaDicas.getSelectedRow();
            if (linhaSelecionada != -1) {
                Dica dicaSelecionada = dicas.get(linhaSelecionada);

                int resposta;
                String mensagem = "Desseja excluir a dica selecionada";
                String titulo = "Exclusão de dica";
                resposta = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_NO_OPTION) {
                    DicaBO dicaBO = new DicaBO();
                    dicaBO.removerDica(dicaSelecionada.getId());
                    mensagem = "Dica excluída com sucesso!";
                    JOptionPane.showMessageDialog(this, mensagem, "Exclusão de dica", JOptionPane.INFORMATION_MESSAGE);
                    this.carregarTabelaDeDicas();
                }
            } else {
                String mensagem = "Selecione uma categoria antes!";
                JOptionPane.showMessageDialog(this, mensagem, "Exclusão de categoria", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Exclusão de categoria ", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    //classe interna
    private class ModeloTabelaDicas extends AbstractTableModel {

        @Override
        public String getColumnName(int coluna) {
            if (coluna == 0) {
                return "Manobra";
            } else {
                return "Dica";
            }
        }

        @Override
        public int getRowCount() {
            return dicas.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try {
                DicaBO dicaBO = new DicaBO();
                dicas = dicaBO.buscarTodasDicas();
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarRequisitos.class.getName()).log(Level.SEVERE, null, ex);
            }

            Dica d = dicas.get(rowIndex);
            if (columnIndex == 0) {
                try {
                    ManobraBO manobraBO = new ManobraBO();
                    manobras = manobraBO.buscarTodasManobras(idUsuario);

                    for (Dica dica : dicas) {
                        for (Manobra m : manobras) {
                            if (d.getIdManobra() == m.getId()) {
                                return m.getNome();
                            }
                        }

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(GerenciarDicas.class.getName()).log(Level.SEVERE, null, ex);
                }
                return "Problemas para exibir o nome da manobra";

            } else {
                for (Dica dica : dicas) {
                    if (d.getIdManobra() == dica.getIdManobra()) {
                        return dica.getDescricao();
                    }
                }
                return " ";
            }
        }
    }
}