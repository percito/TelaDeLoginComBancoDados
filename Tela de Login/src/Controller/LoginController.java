package Controller;

import DAO.UsuarioDAO;
import View.AlterarSenha;
import View.AreaADM;
import View.AreaUsuario;
import View.CadastroUsuario;
import View.Login;
import javax.swing.JOptionPane;

public class LoginController {

    private Login view;

    public LoginController(Login view) {
        this.view = view;

    }

    public void autenticar() {
        UsuarioDAO dao = new UsuarioDAO();
        if (dao.CheckLoginADM(view.getjEmail().getText(), view.getJsenha().getText())) {

            new AreaADM().setVisible(true);

        }else if(dao.CheckLogin(view.getjEmail().getText(), view.getJsenha().getText())){
             
            new AreaUsuario().setVisible(true);
             
        }else{
            JOptionPane.showMessageDialog(null,"Dados incorretos");
            
        }

    }

    public void esqueciSenha() {
        new AlterarSenha().setVisible(true);
    }

    public void Cadastrar() {
        new CadastroUsuario().setVisible(true);

    }

}
