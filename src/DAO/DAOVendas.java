package DAO;

import model.ModelVendas;
import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Vivian Machado
 */
public class DAOVendas extends ConexaoMySql {

    /**
     * grava Vendas
     *
     * @param pModelVendas
     * @return int
     */
    public int salvarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_vendas ("
                    + "fk_cliente,"
                    + "ven_data_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_desconto"
                    + ") VALUES ("
                    + "'" + pModelVendas.getCliente() + "',"
                    + "'" + pModelVendas.getVenDataVenda() + "',"
                    + "'" + pModelVendas.getVenValorLiquido() + "',"
                    + "'" + pModelVendas.getVenValorBruto() + "',"
                    + "'" + pModelVendas.getVenDesconto() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Vendas
     *
     * @param pIdVendas
     * @return ModelVendas
     */
    public ModelVendas getVendasDAO(int pIdVendas) {
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_vendas,"
                    + "fk_cliente,"
                    + "ven_data_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_desconto"
                    + " FROM"
                    + " tbl_vendas"
                    + " WHERE"
                    + " pk_id_vendas = '" + pIdVendas + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVenDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
     * recupera uma lista de Vendas
     *
     * @return ArrayList
     */
    public ArrayList<ModelVendas> getListaVendasDAO() {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_vendas,"
                    + "fk_cliente,"
                    + "ven_data_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_desconto"
                    + " FROM"
                    + " tbl_vendas"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVenDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * atualiza Vendas
     *
     * @param pModelVendas
     * @return boolean
     */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_vendas SET "
                    + "pk_id_vendas = '" + pModelVendas.getIdVenda() + "',"
                    + "fk_cliente = '" + pModelVendas.getCliente() + "',"
                    + "ven_data_venda = '" + pModelVendas.getVenDataVenda() + "',"
                    + "ven_valor_liquido = '" + pModelVendas.getVenValorLiquido() + "',"
                    + "ven_valor_bruto = '" + pModelVendas.getVenValorBruto() + "',"
                    + "ven_desconto = '" + pModelVendas.getVenDesconto() + "'"
                    + " WHERE "
                    + "pk_id_vendas = '" + pModelVendas.getIdVenda() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Vendas
     *
     * @param pIdVenda
     * @return boolean
     */
    public boolean excluirVendasDAO(int pIdVenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_vendas "
                    + " WHERE "
                    + "pk_id_vendas = '" + pIdVenda + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean RelatorioVendasDAO(int codigoVenda) {
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
                    + "WHERE tbl_vendas.pk_id_vendas = " + codigoVenda + ";"
            );

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/RelatorioVendas.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/VendasTCC/rel/relVendas.pdf");
            File file = new File("C:/VendasTCC/rel/relVendas.pdf");
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

    public boolean RelatorioVendasDataDAO(String datai, String dataf) {
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
                    + "WHERE tbl_vendas_ven_data_venda = " + datai + " BETWEEN " + dataf + ";"
            );

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/RelatorioVendasData.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/VendasTCC/rel/relVendasData.pdf");
            File file = new File("C:/VendasTCC/rel/relVendasData.pdf");
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
                   + "WHERE tbl_cliente.`cli_nome` = " + nome + ";"
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
