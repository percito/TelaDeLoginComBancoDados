package Controller;

import DAO.UsuarioDAO;
import View.AlterarSenha;
import View.Login;
import javax.swing.JOptionPane;

public class AlteraSenhaController {

    private AlterarSenha view;

    public AlteraSenhaController(AlterarSenha view) {
        this.view = view;
        view.getJEmail();
        view.getJSenha();
        view.getjResposta();
    }

    public void Alterar() {
        UsuarioDAO dao = new UsuarioDAO();
        if ((view.getJEmail().getText().isEmpty()) || (view.getjResposta().getText().isEmpty()) || (view.getJSenha().getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos DEVEM  ser preenchidos!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            if (dao.TestarResposta(view.getJEmail().getText(), view.getjResposta().getText())) {
                dao.updateSenha(view.getJEmail().getText(), view.getjResposta().getText(), view.getJSenha().getText());
                new Login().setVisible(true);

            } else if (dao.TestarRespostaADM(view.getJEmail().getText(), view.getjResposta().getText())) {
                dao.updateSenhaADM(view.getJEmail().getText(), view.getjResposta().getText(), view.getJSenha().getText());
                new Login().setVisible(true);
            }else {
                 
                JOptionPane.showMessageDialog(null, "Dados incorretos");
            
            }
        }
           
        
    }

    public void Voltar() {
       new Login().setVisible(true);
    }

}
