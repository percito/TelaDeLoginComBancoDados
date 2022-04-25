package Controller;

import DAO.UsuarioDAO;
import Model.Admin;
import Model.Usuario;
import View.AreaADM;
import View.Login;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AreaADMController {

    private AreaADM view;

    public AreaADMController(AreaADM view) {
        this.view = view;

    }

    public void Listar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> usuarios = dao.listarUsuarios();
            DefaultTableModel model = (DefaultTableModel) view.getTabela().getModel();
            model.setNumRows(0);
            for (Usuario v : usuarios) {
                model.addRow(new Object[]{
                    v.getId(),
                    v.getEmail(),
                    v.getCpf(),
                    v.getTelefone(),
                    v.getUsername(),
                    v.getAtivo(),
                    v.getPerguntaSecreta()

                });
            }
            List<Admin> adms = dao.listarADMs();
            DefaultTableModel modelo = (DefaultTableModel) view.getTabela2().getModel();
            modelo.setNumRows(0);
            for (Admin a : adms) {
                modelo.addRow(new Object[]{
                    a.getId(),
                    a.getEmail(),
                    a.getCpf(),
                    a.getTelefone(),
                    a.getUsername(),
                    a.getAtivo(),
                    a.getPerguntaSecreta()

                });
            }
        } catch (Exception e) {

        }
    }

    public void clickTabela() {
        view.getjCodigo().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 0).toString());
        view.getjEmail().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 1).toString());
        view.getJcpf().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 2).toString());
        view.getJtelefone().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 3).toString());
        view.getJusername().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 4).toString());
    }

    public void CadastrarUsuario() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        UsuarioDAO dao = new UsuarioDAO();

        if ((view.getjEmail().getText().isEmpty()) || (view.getJcpf().getText().isEmpty()) || (view.getJtelefone().getText().isEmpty()) || (view.getJusername().getText().isEmpty()) || (view.getjSenha().getText().isEmpty()) || (view.getjResposta().getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos DEVEM ser preenchidos!", "Atenção", JOptionPane.WARNING_MESSAGE);

        }else if(dao.CheckEmail(view.getjEmail().getText())||dao.CheckEmailADM(view.getjEmail().getText())) {
            JOptionPane.showMessageDialog(null, "EMAIL JA CADASTRADO!", "Atençao", JOptionPane.WARNING_MESSAGE);
        } else {
            Usuario usuario = new Usuario();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte MessageDigest[] = md.digest(view.getjSenha().getText().getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : MessageDigest) {
                sb.append(String.format("%02X", 0xFF & b));

            }
            String senhaHex = sb.toString();
            usuario.setEmail(view.getjEmail().getText());
            usuario.setCpf(view.getJcpf().getText());
            usuario.setTelefone((view.getJtelefone().getText()));
            usuario.setUsername(view.getJusername().getText());
            usuario.setSenha(senhaHex);
            usuario.setPerguntaSecreta(view.getjResposta().getText());
            DAO.UsuarioDAO.create(usuario);

        }
    }

    public void CadastrarADM() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        UsuarioDAO dao = new UsuarioDAO();

        if ((view.getjEmail().getText().isEmpty()) || (view.getJcpf().getText().isEmpty()) || (view.getJtelefone().getText().isEmpty()) || (view.getJusername().getText().isEmpty()) || (view.getjSenha().getText().isEmpty()) || (view.getjResposta().getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos DEVEM ser preenchidos!", "Atenção", JOptionPane.WARNING_MESSAGE);

        }else if(dao.CheckEmail(view.getjEmail().getText()) || dao.CheckEmailADM(view.getjEmail().getText())) {
            JOptionPane.showMessageDialog(null, "EMAIL JA CADASTRADO!", "Atençao", JOptionPane.WARNING_MESSAGE);
        }else{
            
            Admin admin = new Admin();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte MessageDigest[] = md.digest(view.getjSenha().getText().getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : MessageDigest) {
                sb.append(String.format("%02X", 0xFF & b));

            }
            String senhaHex = sb.toString();
            
            admin.setEmail(view.getjEmail().getText());
            admin.setCpf(view.getJcpf().getText());
            admin.setTelefone(view.getJtelefone().getText());
            admin.setUsername(view.getJusername().getText());
            admin.setSenha(senhaHex);
            admin.setPerguntaSecreta(view.getjResposta().getText());
            DAO.UsuarioDAO.createADM(admin);

        
        }

    }

    public void EditarADM() {
        Admin admin = new Admin();

        admin.setEmail(view.getjEmail().getText());
        admin.setCpf(view.getJcpf().getText());
        admin.setTelefone(view.getJtelefone().getText());
        admin.setUsername(view.getJusername().getText());
        UsuarioDAO dao = new UsuarioDAO();

        dao.updateADM(admin);
    }

    public void EditarUsuario() {
        Usuario usuario = new Usuario();

        usuario.setEmail(view.getjEmail().getText());
        usuario.setCpf(view.getJcpf().getText());
        usuario.setTelefone(view.getJtelefone().getText());
        usuario.setUsername(view.getJusername().getText());
        UsuarioDAO dao = new UsuarioDAO();
        dao.updateUsuario(usuario);
    }

    public void ApagarCampos() {
        view.getjCodigo().setText(null);
        view.getjEmail().setText(null);
        view.getJcpf().setText(null);
        view.getJtelefone().setText(null);
        view.getJusername().setText(null);
        view.getjResposta().setText(null);
        view.getjSenha().setText(null);
    }

    public void desativar() {
        UsuarioDAO dao = new UsuarioDAO();
        if (dao.Check(view.getjEmail().getText(), view.getJusername().getText())) {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(view.getjCodigo().getText()));
            usuario.setEmail(view.getjEmail().getText());
            usuario.setCpf(view.getJcpf().getText());
            usuario.setTelefone(view.getJtelefone().getText());
            usuario.setUsername(view.getJusername().getText());

            dao.DesativaUsuario(usuario);
        } else {
            Admin admin = new Admin();
            admin.setId(Integer.parseInt(view.getjCodigo().getText()));
            admin.setEmail(view.getjEmail().getText());
            admin.setCpf(view.getJcpf().getText());
            admin.setTelefone(view.getJtelefone().getText());
            admin.setUsername(view.getJusername().getText());

            dao.DesativaAdm(admin);
        }
    }

    public void ClickTabela2() {
        view.getjCodigo().setText(view.getTabela2().getValueAt(view.getTabela2().getSelectedRow(), 0).toString());
        view.getjEmail().setText(view.getTabela2().getValueAt(view.getTabela2().getSelectedRow(), 1).toString());
        view.getJcpf().setText(view.getTabela2().getValueAt(view.getTabela2().getSelectedRow(), 2).toString());
        view.getJtelefone().setText(view.getTabela2().getValueAt(view.getTabela2().getSelectedRow(), 3).toString());
        view.getJusername().setText(view.getTabela2().getValueAt(view.getTabela2().getSelectedRow(), 4).toString());
    }

    public void Sair() {
        new Login().setVisible(true);
        JOptionPane.showMessageDialog(null, "Deslogado");
    }
}
