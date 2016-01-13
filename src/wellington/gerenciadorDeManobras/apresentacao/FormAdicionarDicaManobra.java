/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wellington.gerenciadorDeManobras.entidade.Dica;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.negocio.DicaBO;

/**
 *
 * @author Wellington
 */
public class FormAdicionarDicaManobra extends javax.swing.JFrame {

    private Dica dicaEmEdicao;
    private int idManobra=0;
    private int idUsuario;
    private FormCadastrarEditarTreino formCadastrarEditarTreino;
    /**
     * Creates new form FormAdicionarDicaManobra
     */
    public FormAdicionarDicaManobra() {
        initComponents();
    }

    FormAdicionarDicaManobra(FormCadastrarEditarTreino formCadastrarEditarTreino, int id, int idUsuario) {
        this.idUsuario = idUsuario;
        this.formCadastrarEditarTreino = formCadastrarEditarTreino;
        this.idManobra = id;
        initComponents();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDicaManobra = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnSalvarDica = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        lblinfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Dica");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicione uma dica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtDicaManobra.setColumns(20);
        txtDicaManobra.setRows(5);
        jScrollPane2.setViewportView(txtDicaManobra);

        jLabel1.setText("Caso você fique possa relembrar como executa-la corretamente.");

        btnSalvarDica.setText("Salvar");
        btnSalvarDica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDicaActionPerformed(evt);
            }
        });

        btnFechar.setText("Voltar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lblinfo.setText("info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvarDica, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblinfo))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lblinfo)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarDica, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(556, 367));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarDicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDicaActionPerformed
        try {
            this.inserirDica();
        } catch (SQLException ex) {
            Logger.getLogger(FormAdicionarDicaManobra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarDicaActionPerformed

    public void inserirDica() throws SQLException{
        this.veririficarCampoDica();
        this.recuperarDica();
        this.dicaEmEdicao.setIdManobra(idManobra);
        DicaBO dicaBO = new DicaBO();
        dicaBO.incluirNovaDica(dicaEmEdicao);
        JOptionPane.showMessageDialog(this, "Dica cadastrada com sucesso", "Nova dica", JOptionPane.INFORMATION_MESSAGE);
       // this.formCadastrarEditarTreino.sugerirNovoTreino();
        this.dispose();
    
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvarDica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblinfo;
    private javax.swing.JTextArea txtDicaManobra;
    // End of variables declaration//GEN-END:variables

   

    private void recuperarDica() {
        this.dicaEmEdicao = new Dica();
        this.dicaEmEdicao.setDescricao(txtDicaManobra.getText());
        this.dicaEmEdicao.setIdUsuario(idUsuario);
        
    }

    private void veririficarCampoDica() {
        if(txtDicaManobra.getText().trim().isEmpty()){
        this.lblinfo.setText("Infome sua dica para a manobra q acaba de concluir o treino!");
        throw new CampoObrigatorioException();
        }
    }
}
