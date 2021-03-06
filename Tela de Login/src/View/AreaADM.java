/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.AreaADMController;
import DAO.*;
import Model.Admin;
import Model.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jrper
 */
public class AreaADM extends javax.swing.JFrame {

    private final AreaADMController Controller;

  


    public AreaADM() {
        initComponents();
        Controller= new AreaADMController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtelefone = new javax.swing.JTextField();
        jusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Desativar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jResposta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        Novo = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jSenha = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("email");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jtelefone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        jtelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtelefoneActionPerformed(evt);
            }
        });
        getContentPane().add(jtelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 170, -1));

        jusername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        jusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jusernameActionPerformed(evt);
            }
        });
        getContentPane().add(jusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 170, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jcpf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        jcpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcpfActionPerformed(evt);
            }
        });
        getContentPane().add(jcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 170, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("cpf");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 170, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 195, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("telefone");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        Desativar.setBackground(new java.awt.Color(153, 51, 255));
        Desativar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Desativar.setText("desativar");
        Desativar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Desativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesativarActionPerformed(evt);
            }
        });
        getContentPane().add(Desativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, -1, -1));

        Tabela2.setBackground(new java.awt.Color(204, 204, 204));
        Tabela2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        Tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "codigo", "email", "cpf", "telefone", "usuario", "Ativo", "RespostaSecreta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela2.setSelectionBackground(new java.awt.Color(153, 51, 255));
        Tabela2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabela2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 680, 200));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("desativar usuario:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Dados Pessoais");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 352, 20));

        Editar.setBackground(new java.awt.Color(153, 51, 255));
        Editar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Editar.setText("Editar Usuario");
        Editar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        getContentPane().add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 120, 20));

        tabela.setBackground(new java.awt.Color(204, 204, 204));
        tabela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "email", "cpf", "telefone", "usuario", "ativo", "Resposta Secreta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setSelectionBackground(new java.awt.Color(204, 0, 255));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 680, 210));

        jCodigo.setEditable(false);
        jCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        jCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(jCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 104, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Codigo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jResposta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        jResposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRespostaActionPerformed(evt);
            }
        });
        getContentPane().add(jResposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 170, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Pergunta Secreta");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Senha");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 89, -1, -1));

        Cadastrar.setBackground(new java.awt.Color(153, 51, 255));
        Cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Cadastrar.setText("Cadastrar Usuario");
        Cadastrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(Cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jButton2.setBackground(new java.awt.Color(153, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Editar ADM");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 130, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Tabela ADM:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Tabela Usuario:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jToggleButton1.setBackground(new java.awt.Color(153, 51, 255));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton1.setText("Cadastrar ADM");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 120, 20));

        Novo.setBackground(new java.awt.Color(153, 51, 255));
        Novo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Novo.setText("apagar campos");
        Novo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });
        getContentPane().add(Novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 110, -1));

        jToggleButton2.setBackground(new java.awt.Color(153, 102, 255));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton2.setText("Sair");
        jToggleButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 640, 100, 20));

        jSenha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.magenta, new java.awt.Color(153, 51, 255), new java.awt.Color(153, 51, 255)));
        getContentPane().add(jSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 170, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/image/anexi-fundo-login.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtelefoneActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        Controller.clickTabela();
        
        
    }//GEN-LAST:event_tabelaMouseClicked

    private void jCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCodigoActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO add your handling code here:
        Controller.EditarUsuario();
        


    }//GEN-LAST:event_EditarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Controller.Listar();
    }//GEN-LAST:event_formWindowActivated

    private void DesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesativarActionPerformed
        Controller.desativar();
        
        
    }//GEN-LAST:event_DesativarActionPerformed
    
    private void jcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcpfActionPerformed

    private void jusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jusernameActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        try {
            Controller.CadastrarUsuario();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AreaADM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AreaADM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CadastrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Controller.EditarADM();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRespostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRespostaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRespostaActionPerformed

    private void Tabela2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabela2MouseClicked
        Controller.ClickTabela2();
        
    }//GEN-LAST:event_Tabela2MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            Controller.CadastrarADM();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AreaADM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AreaADM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        Controller.ApagarCampos();
        
    }//GEN-LAST:event_NovoActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
       Controller.Sair();
       this.dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AreaADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaADM().setVisible(true);
            }
        });
    }

    public JPasswordField getjSenha() {
        return jSenha;
    }

    public void setjSenha(JPasswordField jSenha) {
        this.jSenha = jSenha;
    }

    public JTextField getjCodigo() {
        return jCodigo;
    }

    public void setjCodigo(JTextField jCodigo) {
        this.jCodigo = jCodigo;
    }

    public JTextField getjEmail() {
        return jEmail;
    }

    public void setjEmail(JTextField jEmail) {
        this.jEmail = jEmail;
    }

    public JTextField getjResposta() {
        return jResposta;
    }

    public void setjResposta(JTextField jResposta) {
        this.jResposta = jResposta;
    }

    
    

    public JTextField getJcpf() {
        return jcpf;
    }

    public void setJcpf(JTextField jcpf) {
        this.jcpf = jcpf;
    }

    public JTextField getJtelefone() {
        return jtelefone;
    }

    public void setJtelefone(JTextField jtelefone) {
        this.jtelefone = jtelefone;
    }

    public JTextField getJusername() {
        return jusername;
    }

    public void setJusername(JTextField jusername) {
        this.jusername = jusername;
    }

    public JTable getTabela2() {
        return Tabela2;
    }

    public void setTabela2(JTable Tabela2) {
        this.Tabela2 = Tabela2;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Cadastrar;
    private javax.swing.JToggleButton Desativar;
    private javax.swing.JButton Editar;
    private javax.swing.JToggleButton Novo;
    private javax.swing.JTable Tabela2;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jResposta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField jSenha;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField jcpf;
    private javax.swing.JTextField jtelefone;
    private javax.swing.JTextField jusername;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
