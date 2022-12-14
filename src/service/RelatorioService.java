package service;

/**
 *
 * @author Vivian Machado
 */
import conexoes.ConexaoMySql;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioService implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String FOLDER_RELATORIOS = "/relatorios";
    private String caminhoArquivoRelatorio = null;
    private JRExporter exporter = null;
    private File arquivoGerado = null;

    public String gerarRelatorio(HashMap parametrosRelatorio,
            String nomeRelatorioJasper, String tipoExportar) throws Exception {
        String caminhoRelatorio = this.getClass()
                .getResource(FOLDER_RELATORIOS).getPath();
        /*) " caminho completo até o relatório compilado indicado */

        String caminhoArquivosJasper = caminhoRelatorio + File.separator
                + nomeRelatorioJasper + ".jasper";

        /* Faz o carregamento do relatório */
        JasperReport relatorioJasper = (JasperReport) JRLoader
                .loadObjectFromFile(caminhoArquivosJasper);

        /* Carrega o arquivo 
        JasperPrint impressoraJasper = JasperFillManager.filLReport(
                relatorioJasper, parametrosRelatorio,ConexaoMySql.conectar());}*/
        return null;

    }
}
