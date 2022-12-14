
package controller;

import DAO.DAOVendasCliente;
import java.sql.Date;
import java.util.ArrayList;
import model.ModelVendasCliente;

/**
 *
 * @author Vivian Machado
 */
public class ControllerVendasCliente {

    private DAOVendasCliente dAOVendasCliente = new DAOVendasCliente();

     public void gerarRelatorioVenda(Date dataInicial, Date dataFinal) {
    //    this.dAOVendasCliente.RelatorioVendasDatasDAO(dataInicial, dataFinal);
    }

    public ArrayList<ModelVendasCliente> getListaVendasClienteController() {
        return this.dAOVendasCliente.getListaVendasClienteDAO();
    }

    public void gerarRelatorioVendaCliente(String nome) {
       this.dAOVendasCliente.RelatorioVendasClienteDataDAO(nome);
    }

}
