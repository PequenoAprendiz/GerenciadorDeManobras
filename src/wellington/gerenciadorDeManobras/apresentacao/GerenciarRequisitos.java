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
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Requisito;
import wellington.gerenciadorDeManobras.negocio.ManobraBO;
import wellington.gerenciadorDeManobras.negocio.RequisitoBO;

/**
 *
 * @author Wellington
 */
public class GerenciarRequisitos extends javax.swing.JFrame {

    private List<Requisito> requisitos;
    private List<Manobra> manobras;

    /**
     * Creates new form GerenciarRequisitos
     */
    public GerenciarRequisitos() throws SQLException {
        this.prepararTela();
    }

    public void prepararTela() throws SQLException {
        try {
            this.initComponents();
            this.carregarTabelaDeRequisitos();
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Manobras cadastrados", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRequisitos = new javax.swing.JTable();
        btnAlterarRequisito = new javax.swing.JButton();
        btnExcluirRequisito = new javax.swing.JButton();
        btnFecharTela = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Requisitos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tabelaRequisitos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaRequisitos);

        btnAlterarRequisito.setText("Editar");
        btnAlterarRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarRequisitoActionPerformed(evt);
            }
        });

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

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterarRequisito)
                .addGap(18, 18, 18)
                .addComponent(btnExcluirRequisito)
                .addGap(11, 11, 11)
                .addComponent(btnFecharTela)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFecharTela, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void carregarTabelaDeRequisitos() throws SQLException {
        RequisitoBO requisitoBO = new RequisitoBO();
        this.requisitos = requisitoBO.buscarTodosRequisitosEspecificos();
        ModeloTabelaRequisitos modelo = new ModeloTabelaRequisitos();
        tabelaRequisitos.setModel(modelo);
    }


    private void btnExcluirRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirRequisitoActionPerformed
        // this.excluirRequisito();
    }//GEN-LAST:event_btnExcluirRequisitoActionPerformed

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharTelaActionPerformed

    private void btnAlterarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarRequisitoActionPerformed
//        try {
//            this.editarTreino();
//            this.formEditarTreino.setVerificaEditarOuSalvar(1);
//        } catch (SQLException ex) {
//            Logger.getLogger(GerenciarCategorias.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(GerenciarTreinos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnAlterarRequisitoActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarRequisito;
    private javax.swing.JButton btnExcluirRequisito;
    private javax.swing.JButton btnFecharTela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRequisitos;
    // End of variables declaration//GEN-END:variables

    //classe interna
    private class ModeloTabelaRequisitos extends AbstractTableModel {

        @Override
        public String getColumnName(int coluna) {
            if (coluna == 0) {
                return "Manobra";
            } else {
                return "Manobra que você precisa aprender antes";
            }
        }

        @Override
        public int getRowCount() {
            return requisitos.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ManobraBO manobraBO = new ManobraBO();
            try {
                manobras = manobraBO.buscarTodasManobras();
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarRequisitos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Requisito r = requisitos.get(rowIndex);
            
            if (columnIndex == 0) {
                for (Manobra m : manobras) {
                    if (m.getId() == r.getIdManobraRecente()) {
                        return m.getNome();
                    }
                }
                return "sem nome";
            } else{
                for (Manobra m : manobras) {
                    if (m.getId() == r.getIdManobraRequisito()) {
                        return m.getNome();
                    }
                }          
                return " ";
            }
        }
    }
}
