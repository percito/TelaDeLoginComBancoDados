package DAO;

import Model.Admin;
import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Usuario;
import conexao.ConectaBD;
import javax.swing.JOptionPane;
import View.CadastroUsuario;
import View.Login;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioDAO {

    public static void create(Usuario usuario) {
        String QUERY = "INSERT INTO usuario (email, cpf, telefone,usuario,senha,PerguntaSecreta,ativo)"
                + " VALUES (?, ?, ?, ?, ?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getCpf());
            preparedStatement.setString(3, usuario.getTelefone());
            preparedStatement.setString(4, usuario.getUsername());
            preparedStatement.setString(5, usuario.getSenha());
            preparedStatement.setString(6, usuario.getPerguntaSecreta());
            preparedStatement.setInt(7, usuario.getAtivo());

            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String QUERY = "SELECT * FROM usuario WHERE ativo != 0";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);

            resultSet = preparedStatement.executeQuery(QUERY);

            while (resultSet.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(resultSet.getInt("id"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setUsername(resultSet.getString("usuario"));
                usuario.setAtivo(resultSet.getInt("ativo"));
                usuario.setPerguntaSecreta(resultSet.getString("PerguntaSecreta"));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    public void updateUsuario(Usuario usuario) {
        String QUERY = "UPDATE usuario SET email=?,cpf=?,telefone=?,usuario=? WHERE email = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getCpf());
            preparedStatement.setString(3, usuario.getTelefone());
            preparedStatement.setString(4, usuario.getUsername());
            preparedStatement.setString(5, usuario.getEmail());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "ALTERADO COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void DesativaUsuario(Usuario usuario) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("Update usuario SET ativo=0 WHERE id = ?");
            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "CONTA DESATIVADA COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public boolean CheckLogin(String email, String senha) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;

        try {
            MessageDigest md= MessageDigest.getInstance("SHA-256");
             byte MessageDigest[]=md.digest(senha.getBytes("UTF-8"));
            
            StringBuilder sb= new StringBuilder();
            for(byte b: MessageDigest){
                sb.append(String.format("%02X", 0xFF & b));
                
                
            }
              String SenhaHex=sb.toString();
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("SELECT * FROM usuario where email=? and senha=? ");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, SenhaHex);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public boolean TestarResposta(String email, String PerguntaSecreta) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("SELECT * FROM usuario where email=? and PerguntaSecreta=?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, PerguntaSecreta);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public void updateSenha(String email, String PerguntaSecreta, String senha) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            MessageDigest md= MessageDigest.getInstance("SHA-256");
             byte MessageDigest[]=md.digest(senha.getBytes("UTF-8"));
            
            StringBuilder sb= new StringBuilder();
            for(byte b: MessageDigest){
                sb.append(String.format("%02X", 0xFF & b));
                
                
            }
              String SenhaHex=sb.toString();
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("Update usuario SET senha=? WHERE email=? and PerguntaSecreta=?");

            preparedStatement.setString(1, SenhaHex);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, PerguntaSecreta);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "SENHA ALTERADA COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void createADM(Admin admin) {
        String QUERY = "INSERT INTO admin (email, cpf, telefone,usuario,senha,PerguntaSecreta,ativo)"
                + " VALUES (?, ?, ?, ?, ?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);

            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getCpf());
            preparedStatement.setString(3, admin.getTelefone());
            preparedStatement.setString(4, admin.getUsername());
            preparedStatement.setString(5, admin.getSenha());
            preparedStatement.setString(6, admin.getPerguntaSecreta());
            preparedStatement.setInt(7, admin.getAtivo());

            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "ADM CADASTRADO COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean CheckLoginADM(String email, String senha) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;

        try {
             MessageDigest md= MessageDigest.getInstance("SHA-256");
             byte MessageDigest[]=md.digest(senha.getBytes("UTF-8"));
            
            StringBuilder sb= new StringBuilder();
            for(byte b: MessageDigest){
                sb.append(String.format("%02X", 0xFF & b));
                
                
            }
              String SenhaHex=sb.toString();
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("SELECT * FROM admin where email=? and senha=? and ativo=1");

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, SenhaHex);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public List<Admin> listarADMs() {
        List<Admin> adms = new ArrayList<Admin>();
        String QUERY = "SELECT * FROM admin WHERE ativo != 0";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);

            resultSet = preparedStatement.executeQuery(QUERY);

            while (resultSet.next()) {
                Admin admin = new Admin();

                admin.setId(resultSet.getInt("id"));
                admin.setEmail(resultSet.getString("email"));
                admin.setCpf(resultSet.getString("cpf"));
                admin.setTelefone(resultSet.getString("telefone"));
                admin.setUsername(resultSet.getString("usuario"));
                admin.setAtivo(resultSet.getInt("ativo"));
                admin.setPerguntaSecreta(resultSet.getString("PerguntaSecreta"));

                adms.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adms;
    }

    public void updateADM(Admin admin) {
        String QUERY = "UPDATE admin SET email=?,cpf=?,telefone=?,usuario=? WHERE email = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getCpf());
            preparedStatement.setString(3, admin.getTelefone());
            preparedStatement.setString(4, admin.getUsername());
            preparedStatement.setString(5, admin.getEmail());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "DADOS DO ADM ALTERADO COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void DesativaAdm(Admin admin) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("Update admin SET ativo=0 WHERE id = ?");
            preparedStatement.setInt(1, admin.getId());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "CONTA DE ADM DESATIVADA COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public boolean Check(String email, String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("SELECT * FROM usuario where email=? and usuario=? and ativo=1");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public boolean CheckEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
           
            preparedStatement = connection.prepareStatement("SELECT * FROM usuario where email=?");

            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                check = true;
            }
        } catch (SQLException ex) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public boolean TestarRespostaADM(String email, String PerguntaSecreta) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("SELECT * FROM admin where email=? and PerguntaSecreta=?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, PerguntaSecreta);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public void updateSenhaADM(String email, String PerguntaSecreta, String senha) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            MessageDigest md= MessageDigest.getInstance("SHA-256");
             byte MessageDigest[]=md.digest(senha.getBytes("UTF-8"));
            
            StringBuilder sb= new StringBuilder();
            for(byte b: MessageDigest){
                sb.append(String.format("%02X", 0xFF & b));
                
                
            }
               String SenhaHex=sb.toString();
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("Update admin SET senha=? WHERE email=? and PerguntaSecreta=?");

            preparedStatement.setString(1, SenhaHex);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, PerguntaSecreta);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "SENHA ALTERADA COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
public List<Usuario> listarUsuario(String email) {
        List<Usuario> usuario1 = new ArrayList<Usuario>();
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
            preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE email=?");
            preparedStatement.setString(1, email);
            preparedStatement.execute();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(resultSet.getInt("id"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setUsername(resultSet.getString("usuario"));
                usuario.setAtivo(resultSet.getInt("ativo"));
                usuario.setPerguntaSecreta(resultSet.getString("PerguntaSecreta"));

                usuario1.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuario1;
    }
 public boolean CheckEmailADM(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;

        try {
            connection = conexao.ConectaBD.createConnectionMySQL();
           
            preparedStatement = connection.prepareStatement("SELECT * FROM admin where email=?");

            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                check = true;
            }
        } catch (SQLException ex) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }
}
