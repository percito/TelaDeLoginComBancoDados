/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import conexao.ConectaBD;
import DAO.UsuarioDAO;
import Model.*;
import View.CadastroUsuario;
import View.Login;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jrper
 */
public class CadastroController {

    private CadastroUsuario view;

    public CadastroController(CadastroUsuario view) {
        this.view = view;

    }

    public void salvaUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        UsuarioDAO dao = new UsuarioDAO();

        if ((view.getjEmail().getText().isEmpty()) || (view.getjCpf().getText().isEmpty()) || (view.getjTelefone().getText().isEmpty()) || (view.getjUsername().getText().isEmpty()) || (view.getjSenha().getText().isEmpty()) || (view.getjResposta().getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos DEVEM ser preenchidos!", "Atenção", JOptionPane.WARNING_MESSAGE);

        } else if (dao.CheckEmail(view.getjEmail().getText())) {
            JOptionPane.showMessageDialog(null, "EMAIL JA CADASTRADO!", "Atençao", JOptionPane.WARNING_MESSAGE);
        } else {
             Usuario usuario = new Usuario();
             MessageDigest md= MessageDigest.getInstance("SHA-256");
             byte MessageDigest[]=md.digest(view.getjSenha().getText().getBytes("UTF-8"));
            
            StringBuilder sb= new StringBuilder();
            for(byte b: MessageDigest){
                sb.append(String.format("%02X", 0xFF & b));
                
                
            }
             String senhaHex= sb.toString();
            usuario.setEmail(view.getjEmail().getText());
            usuario.setCpf(view.getjCpf().getText());
            usuario.setTelefone((view.getjTelefone().getText()));
            usuario.setUsername(view.getjUsername().getText());
            usuario.setSenha(senhaHex);
            usuario.setPerguntaSecreta(view.getjResposta().getText());
            DAO.UsuarioDAO.create(usuario);
            new Login().setVisible(true);
           
        }

    }

    public void Voltar() {
         new Login().setVisible(true);
        
    }
}
