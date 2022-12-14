
package controller;

import DAO.DaoProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author Vivian Machado
 */
public class ControllerProdutos{
    
    private DaoProdutos  daoProdutos = new DaoProdutos();
        
    /**
     * Salvar produtos controller
     * @param pModelProdutos
     * @return int
     */
    public  int salvarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }
    //Fim - Salvar produtos controller
    
    /**
     * Excluir um produto pelo o codigo
     * @param pCodigo
     * @return boolean
     */
    public boolean excluirProdutoController(int pCodigo){
        return this.daoProdutos.excluirProdutoDAO(pCodigo);
    }
    //Fim - Excluir um produto pelo o codigo
    
    /**
     * Alterar um produto
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.alterarProdutoDAO(pModelProdutos);
    }
    //Fim - Alterar um produto
    
    /**
     * Retornar produto pelo codigo
     * @param pCodigo
     * @return model produto
     */
    public ModelProdutos retornarProdutoController(int pCodigo){
        return this.daoProdutos.retornarProdutoDAO(pCodigo);
    }
    //Fim - Retornar produto pelo codigo
    
    /**
     * Retornar produto pelo codigo
     * @param pNomeProduto
     * @return model produto
     */
    public ModelProdutos retornarProdutoController(String pNomeProduto){
        return this.daoProdutos.retornarProdutoDAO(pNomeProduto);
    }
    //Fim - Retornar produto pelo codigo
    
    /**
     * retornar uma lista de produtos
     * @return lista model produtos
     */
    public ArrayList<ModelProdutos> retornarListaProdutoController(){
        return this.daoProdutos.retornarListaProdutosDAO();
    }
    //Fim - retornar uma lista de produtos

    /**
     * Alterar lista de produto no banco
     * @param pListaModelProdutos
     * @return 
     */
    public boolean alterarEstoqueProdutoController(ArrayList<ModelProdutos> pListaModelProdutos) {
        return this.daoProdutos.alterarEstoqueProdutosDAO(pListaModelProdutos);
    }

     public boolean gerarRelatorioProduto() {
        return this.daoProdutos.gerarRelatorioProdutos();
    }
}
