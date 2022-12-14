package DAO;

import model.ModelFormaPagamento;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
 *
 * @author Vivian Machado
 */
public class DAOFormaPagamento extends ConexaoMySql {

    /**
    * grava FormaPagamento
    * @param pModelFormaPagamento
    * @return int
    */
    public int salvarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_forma_pagamento ("
                    + "pk_id_forma_pagamento,"
                    + "for_pag_descricao,"
                    + "for_pag_desconto,"
                    + "for_pag_parcelas,"
                    + "for_pag_situacao"
                + ") VALUES ("
                    + "'" + pModelFormaPagamento.getIdFormaPagamento() + "',"
                    + "'" + pModelFormaPagamento.getForPagDescricao() + "',"
                    + "'" + pModelFormaPagamento.getForPagDesconto() + "',"
                    + "'" + pModelFormaPagamento.getForPagParcelas() + "',"
                    + "'" + pModelFormaPagamento.getForPagSituacao() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera FormaPagamento
    * @param pIdFormaPagamento
    * @return ModelFormaPagamento
    */
    public ModelFormaPagamento getFormaPagamentoDAO(int pIdFormaPagamento){
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_forma_pagamento,"
                    + "for_pag_descricao,"
                    + "for_pag_desconto,"
                    + "for_pag_parcelas,"
                    + "for_pag_situacao"
                 + " FROM"
                     + " tbl_forma_pagamento"
                 + " WHERE"
                     + " pk_id_forma_pagamento = '" + pIdFormaPagamento + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento.setIdFormaPagamento(this.getResultSet().getInt(1));
                modelFormaPagamento.setForPagDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setForPagDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setForPagParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setForPagSituacao(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }

    /**
    * recupera uma lista de FormaPagamento
        * @return ArrayList
    */
    public ArrayList<ModelFormaPagamento> getListaFormaPagamentoDAO(){
        ArrayList<ModelFormaPagamento> listamodelFormaPagamento = new ArrayList();
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_forma_pagamento,"
                    + "for_pag_descricao,"
                    + "for_pag_desconto,"
                    + "for_pag_parcelas,"
                    + "for_pag_situacao"
                 + " FROM"
                     + " tbl_forma_pagamento"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento = new ModelFormaPagamento();
                modelFormaPagamento.setIdFormaPagamento(this.getResultSet().getInt(1));
                modelFormaPagamento.setForPagDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setForPagDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setForPagParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setForPagSituacao(this.getResultSet().getInt(5));
                listamodelFormaPagamento.add(modelFormaPagamento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFormaPagamento;
    }

    /**
    * atualiza FormaPagamento
    * @param pModelFormaPagamento
    * @return boolean
    */
    public boolean atualizarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_forma_pagamento SET "
                    + "pk_id_forma_pagamento = '" + pModelFormaPagamento.getIdFormaPagamento() + "',"
                    + "for_pag_descricao = '" + pModelFormaPagamento.getForPagDescricao() + "',"
                    + "for_pag_desconto = '" + pModelFormaPagamento.getForPagDesconto() + "',"
                    + "for_pag_parcelas = '" + pModelFormaPagamento.getForPagParcelas() + "',"
                    + "for_pag_situacao = '" + pModelFormaPagamento.getForPagSituacao() + "'"
                + " WHERE "
                    + "pk_id_forma_pagamento = '" + pModelFormaPagamento.getIdFormaPagamento() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui FormaPagamento
    * @param pIdFormaPagamento
    * @return boolean
    */
    public boolean excluirFormaPagamentoDAO(int pIdFormaPagamento){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_forma_pagamento "
                + " WHERE "
                    + "pk_id_forma_pagamento = '" + pIdFormaPagamento + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}