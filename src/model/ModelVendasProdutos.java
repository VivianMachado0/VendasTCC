package model;
/**
 *
 * @author Vivian Machado
 */
public class ModelVendasProdutos {

    private int idProduto;
    private int produto;
    private int vendas;
    private double venProValor;
    private int venProQuantidade;

    /**
    * Construtor
    */
    public ModelVendasProdutos(){}

    /**
    * seta o valor de idVendaProduto
    * @param pIdVendaProduto
    */
    public void setIdVendaProduto(int pIdVendaProduto){
        this.idProduto = pIdVendaProduto;
    }
    /**
    * @return pk_idVendaProduto
    */
    public int getIdVendaProduto(){
        return this.idProduto;
    }

    /**
    * seta o valor de produto
    * @param pProduto
    */
    public void setProduto(int pProduto){
        this.produto = pProduto;
    }
    /**
    * @return fk_produto
    */
    public int getProduto(){
        return this.produto;
    }

    /**
    * seta o valor de vendas
    * @param pVendas
    */
    public void setVendas(int pVendas){
        this.vendas = pVendas;
    }
    /**
    * @return fk_vendas
    */
    public int getVendas(){
        return this.vendas;
    }

    /**
    * seta o valor de venProValor
    * @param pVenProValor
    */
    public void setVenProValor(double pVenProValor){
        this.venProValor = pVenProValor;
    }
    /**
    * @return venProValor
    */
    public double getVenProValor(){
        return this.venProValor;
    }

    /**
    * seta o valor de venProQuantidade
    * @param pVenProQuantidade
    */
    public void setVenProQuantidade(int pVenProQuantidade){
        this.venProQuantidade = pVenProQuantidade;
    }
    /**
    * @return venProQuantidade
    */
    public int getVenProQuantidade(){
        return this.venProQuantidade;
    }

    @Override
    public String toString(){
        return "ModelVendasProdutos {" + "::idVendaProduto = " + this.idProduto + "::produto = " + this.produto + "::vendas = " + this.vendas + "::venProValor = " + this.venProValor + "::venProQuantidade = " + this.venProQuantidade +  "}";
    }
}