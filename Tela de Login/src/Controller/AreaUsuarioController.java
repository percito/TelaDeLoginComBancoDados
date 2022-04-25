
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import View.AreaUsuario;
import View.Login;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AreaUsuarioController {
    private  AreaUsuario view;

    public AreaUsuarioController(AreaUsuario view) {
        this.view = view;
    }

    public void Listar() {
        
        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> usuario1 = dao.listarUsuario(view.getJEmail().getText());
            DefaultTableModel model = (DefaultTableModel) view.getTabela().getModel();
            model.setNumRows(0);
            for (Usuario v : usuario1) {
                model.addRow(new Object[]{
                    v.getId(),
                    v.getEmail(),
                    v.getCpf(),
                    v.getTelefone(),
                    v.getUsername(),
                    v.getAtivo()

                });
            }
        } catch (Exception e) {

        }
    }

    public void clicar() {
        view.getjCodigo().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 0).toString());
        view.getJEmail().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 1).toString());
         view.getJcpf().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 2).toString());
        view.getjTelefone().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 3).toString());
        view.getJUsername().setText(view.getTabela().getValueAt(view.getTabela().getSelectedRow(), 4).toString());
    }

    public void Editar() {
        Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(view.getjCodigo().getText()));
        usuario.setEmail(view.getJEmail().getText());
        usuario.setCpf(view.getJcpf().getText());
        usuario.setTelefone(view.getjTelefone().getText());
        usuario.setUsername(view.getJUsername().getText());
        UsuarioDAO dao = new UsuarioDAO();
        dao.updateUsuario(usuario);
    }

    public void Desativar() {
       Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(view.getjCodigo().getText()));
        usuario.setEmail(view.getJEmail().getText());
        usuario.setCpf(view.getJcpf().getText());
        usuario.setTelefone(view.getjTelefone().getText());
        usuario.setUsername(view.getJUsername().getText());
        UsuarioDAO dao = new UsuarioDAO();
        dao.DesativaUsuario(usuario);
    }

    public void sair() {
        new Login().setVisible(true);
        JOptionPane.showMessageDialog(null,"Deslogado");
    }

    
    
    
}
