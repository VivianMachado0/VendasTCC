/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import model.ModelCliente;
import model.ModelVendas;
import model.ModelVendasCliente;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Vivian Machado
 */
public class DAOVendasCliente extends ConexaoMySql {

    public ArrayList<ModelVendasCliente> getListaVendasClienteDAO() {
        //instanciar os conteúdo, chamar os conteúdo
        ArrayList<ModelVendasCliente> listaModelVendasClientes = new ArrayList<>();
        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "tbl_vendas.pk_id_vendas,"
                    + "tbl_vendas.fk_cliente,"
                    + "tbl_vendas.ven_data_venda,"
                    + "tbl_vendas.ven_valor_liquido,"
                    + "tbl_vendas.ven_valor_bruto,"
                    + "tbl_vendas.ven_desconto,"
                    + "tbl_cliente.pk_id_cliente,"
                    + "tbl_cliente.cli_nome,"
                    + "tbl_cliente.cli_endereco,"
                    + "tbl_cliente.cli_bairro,"
                    + "tbl_cliente.cli_cidade,"
                    + "tbl_cliente.cli_uf,"
                    + "tbl_cliente.cli_cep,"
                    + "tbl_cliente.cli_telefone"
                    + " FROM "
                    + " tbl_vendas INNER JOIN tbl_cliente "
                    + "ON  tbl_cliente.pk_id_cliente = tbl_vendas.fk_cliente; "//O inner join está comparando os valores onde identificado (tbl_vendas.fk_cliente) 
                    + ";" // é igual ao valor da chave estrangeira (tbl_vendas.fk_cliente).
            );

            while (this.getResultSet().next()) {
                //Venda
                modelVendas = new ModelVendas(); //Ele recebe uma nova venda
                modelCliente = new ModelCliente(); //Ele recebe um novo cliente
                modelVendasCliente = new ModelVendasCliente();  //Ele recebe uma nova venda e cliente
                //setar os valores da sql declara logo acima
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVenDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
                //Cliente
                //setar os valores da sql declara logo acima
                modelCliente.setIdCliente(this.getResultSet().getInt(7));
                modelCliente.setCliNome(this.getResultSet().getString(8));
                modelCliente.setCliEndereco(this.getResultSet().getString(9));
                modelCliente.setCliBairro(this.getResultSet().getString(10));
                modelCliente.setCliCidade(this.getResultSet().getString(11));
                modelCliente.setCliUf(this.getResultSet().getString(12));
                modelCliente.setCliCep(this.getResultSet().getString(13));
                modelCliente.setCliTelefone(this.getResultSet().getString(14));
                //Setar cliente e venda, modelVendasCliente está recebendo valore de modelVendas e modelCliente
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelCliente(modelCliente);

                listaModelVendasClientes.add(modelVendasCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelVendasClientes;
    }

    public boolean RelatorioVendasClienteDataDAO(String nome) {
        try {
            this.conectar();
            this.executarSQL(
                     "SELECT"
                    + " tbl_cliente.`pk_id_cliente` AS tbl_cliente_pk_id_cliente,"
                    + " tbl_cliente.`cli_nome` AS tbl_cliente_cli_nome,"
                    + " tbl_cliente.`cli_endereco` AS tbl_cliente_cli_endereco,"
                    + " tbl_cliente.`cli_bairro` AS tbl_cliente_cli_bairro,"
                    + " tbl_cliente.`cli_cidade` AS tbl_cliente_cli_cidade,"
                    + " tbl_cliente.`cli_uf` AS tbl_cliente_cli_uf,"
                    + " tbl_cliente.`cli_cep` AS tbl_cliente_cli_cep,"
                    + " tbl_cliente.`cli_telefone` AS tbl_cliente_cli_telefone,"
                    + " tbl_produto.`pk_id_produto` AS tbl_produto_pk_id_produto,"
                    + " tbl_produto.`pro_nome` AS tbl_produto_pro_nome,"
                    + "  tbl_produto.`pro_valor` AS tbl_produto_pro_valor,"
                    + "  tbl_vendas.`pk_id_vendas` AS tbl_vendas_pk_id_vendas,"
                    + "  tbl_vendas.`ven_data_venda` AS tbl_vendas_ven_data_venda,"
                    + "  tbl_vendas.`ven_desconto` AS tbl_vendas_ven_desconto,"
                    + "  tbl_vendas_produtos.`pk_id_venda_produto` AS tbl_vendas_produtos_pk_id_venda_produto,"
                    + "   tbl_vendas_produtos.`ven_pro_quantidade` AS tbl_vendas_produtos_ven_pro_quantidade,"
                    + "   tbl_vendas_produtos.`fk_produto` AS tbl_vendas_produtos_fk_produto,"
                    + "   tbl_vendas.`ven_valor_liquido` AS tbl_vendas_ven_valor_liquido,"
                    + "   tbl_vendas.`ven_valor_bruto` AS tbl_vendas_ven_valor_bruto,"
                    + "   tbl_vendas_produtos.`fk_vendas` AS tbl_vendas_produtos_fk_vendas,"
                    + "   tbl_vendas_produtos.`ven_pro_valor` AS tbl_vendas_produtos_ven_pro_valor"
                    + " FROM"
                    + " `tbl_cliente` tbl_cliente INNER JOIN `tbl_vendas` tbl_vendas ON tbl_cliente.`pk_id_cliente` = tbl_vendas.`fk_cliente`"
                    + "  INNER JOIN `tbl_vendas_produtos` tbl_vendas_produtos ON tbl_vendas.`pk_id_vendas` = tbl_vendas_produtos.`fk_vendas`"
                    + "  INNER JOIN `tbl_produto` tbl_produto ON tbl_vendas_produtos.`fk_produto` = tbl_produto.`pk_id_produto`"
                   + "WHERE tbl_vendas.pk_id_vendas = " + nome + ";"
          
            );

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/RelatorioVendasCliente.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/VendasTCC/rel/relVendasNomeCliente.pdf");
            File file = new File("C:/VendasTCC/rel/relVendasNomeCliente.pdf");
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {

                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
            return true;//JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

}
