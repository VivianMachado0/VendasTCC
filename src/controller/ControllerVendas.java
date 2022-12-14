package controller;

import model.ModelVendas;
import DAO.DAOVendas;
import java.util.ArrayList;

/**
 *
 * @author Vivian Machado
 */
public class ControllerVendas {

  
   

    private DAOVendas daoVendas = new DAOVendas();

    /**
     * grava Vendas
     *
     * @param pModelVendas
     * @return int
     */
    public int salvarVendasController(ModelVendas pModelVendas) {
        return this.daoVendas.salvarVendasDAO(pModelVendas);
    }

    /**
     * recupera Vendas
     *
     * @param pIdVenda
     * @return ModelVendas
     */
    public ModelVendas getVendasController(int pIdVenda) {
        return this.daoVendas.getVendasDAO(pIdVenda);
    }

    /**
     * recupera uma lista deVendas
     *
     * @param pIdVenda
     * @return ArrayList
     */
    public ArrayList<ModelVendas> getListaVendasController() {
        return this.daoVendas.getListaVendasDAO();
    }

    /**
     * atualiza Vendas
     *
     * @param pModelVendas
     * @return boolean
     */
    public boolean atualizarVendasController(ModelVendas pModelVendas) {
        return this.daoVendas.atualizarVendasDAO(pModelVendas);
    }

    /**
     * exclui Vendas
     *
     * @param pIdVenda
     * @return boolean
     */
    public boolean excluirVendasController(int pIdVenda) {
        return this.daoVendas.excluirVendasDAO(pIdVenda);
    }

    public void gerarRelatorioVenda(int codigoVenda) {
         this.daoVendas.RelatorioVendasDAO(codigoVenda);
    }
     public void gerarRelatorioVendaData(String datai, String dataf) {
         this.daoVendas.RelatorioVendasDataDAO(datai,dataf);
    }

    public void gerarRelatorioVendaCliente(String nome) {
           this.daoVendas.RelatorioVendasClienteDataDAO(nome);
    }

}
