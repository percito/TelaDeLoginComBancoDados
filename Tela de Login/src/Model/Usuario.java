
package Model;
    
public class Usuario {
    private int id;
    private String email;
    private String cpf;
    private String telefone;
    private String username;
    private String senha;
    private String PerguntaSecreta;
    private int ativo=1;
    public Usuario(){}
    public Usuario(String email,String cpf,String telefone,String username,String senha,String PerguntaSecreta){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerguntaSecreta() {
        return PerguntaSecreta;
    }

    public void setPerguntaSecreta(String PerguntaSecreta) {
        this.PerguntaSecreta = PerguntaSecreta;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
}
