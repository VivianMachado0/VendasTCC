package model;
/**
 *
 * @author Vivian Machado
 */
public class ModelFormaPagamento {

    private int idFormaPagamento;
    private String forPagDescricao;
    private float forPagDesconto;
    private int forPagParcelas;
    private int forPagSituacao;

    /**
    * Construtor
    */
    public ModelFormaPagamento(){}

    /**
    * seta o valor de idFormaPagamento
    * @param pIdFormaPagamento
    */
    public void setIdFormaPagamento(int pIdFormaPagamento){
        this.idFormaPagamento = pIdFormaPagamento;
    }
    /**
    * @return pk_idFormaPagamento
    */
    public int getIdFormaPagamento(){
        return this.idFormaPagamento;
    }

    /**
    * seta o valor de forPagDescricao
    * @param pForPagDescricao
    */
    public void setForPagDescricao(String pForPagDescricao){
        this.forPagDescricao = pForPagDescricao;
    }
    /**
    * @return forPagDescricao
    */
    public String getForPagDescricao(){
        return this.forPagDescricao;
    }

    /**
    * seta o valor de forPagDesconto
    * @param pForPagDesconto
    */
    public void setForPagDesconto(float pForPagDesconto){
        this.forPagDesconto = pForPagDesconto;
    }
    /**
    * @return forPagDesconto
    */
    public float getForPagDesconto(){
        return this.forPagDesconto;
    }

    /**
    * seta o valor de forPagParcelas
    * @param pForPagParcelas
    */
    public void setForPagParcelas(int pForPagParcelas){
        this.forPagParcelas = pForPagParcelas;
    }
    /**
    * @return forPagParcelas
    */
    public int getForPagParcelas(){
        return this.forPagParcelas;
    }

    /**
    * seta o valor de forPagSituacao
    * @param pForPagSituacao
    */
    public void setForPagSituacao(int pForPagSituacao){
        this.forPagSituacao = pForPagSituacao;
    }
    /**
    * @return forPagSituacao
    */
    public int getForPagSituacao(){
        return this.forPagSituacao;
    }

    @Override
    public String toString(){
        return "ModelFormaPagamento {" + "::idFormaPagamento = " + this.idFormaPagamento + "::forPagDescricao = " + this.forPagDescricao + "::forPagDesconto = " + this.forPagDesconto + "::forPagParcelas = " + this.forPagParcelas + "::forPagSituacao = " + this.forPagSituacao +  "}";
    }
}