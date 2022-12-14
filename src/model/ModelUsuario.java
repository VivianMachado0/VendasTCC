package model;
/**
 *
 * @author Vivian Machado
 */
public class ModelUsuario {

    private int idUsuario;
    private String usuNome;
    private String usuLogin;
    private String usuSenha;

    /**
    * Construtor
    */
    public ModelUsuario(){}

    /**
    * seta o valor de idUsuario
    * @param pIdUsuario
    */
    public void setIdUsuario(int pIdUsuario){
        this.idUsuario = pIdUsuario;
    }
    /**
    * @return pk_idUsuario
    */
    public int getIdUsuario(){
        return this.idUsuario;
    }

    /**
    * seta o valor de usuNome
    * @param pUsuNome
    */
    public void setUsuNome(String pUsuNome){
        this.usuNome = pUsuNome;
    }
    /**
    * @return usuNome
    */
    public String getUsuNome(){
        return this.usuNome;
    }

    /**
    * seta o valor de usuLogin
    * @param pUsuLogin
    */
    public void setUsuLogin(String pUsuLogin){
        this.usuLogin = pUsuLogin;
    }
    /**
    * @return usuLogin
    */
    public String getUsuLogin(){
        return this.usuLogin;
    }

    /**
    * seta o valor de usuSenha
    * @param pUsuSenha
    */
    public void setUsuSenha(String pUsuSenha){
        this.usuSenha = pUsuSenha;
    }
    /**
    * @return usuSenha
    */
    public String getUsuSenha(){
        return this.usuSenha;
    }

    @Override
    public String toString(){
        return "ModelUsuario {" + "::idUsuario = " + this.idUsuario + "::usuNome = " + this.usuNome + "::usuLogin = " + this.usuLogin + "::usuSenha = " + this.usuSenha +  "}";
    }
}