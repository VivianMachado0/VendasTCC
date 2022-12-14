/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class ConexaoMySqlTest {
    
    public ConexaoMySqlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conectar method, of class ConexaoMySql.
     */
    @Test
    public void testConectar() {
        System.out.println("conectar");
        ConexaoMySql instance = new ConexaoMySql();
        Connection expResult = null;
        Connection result = instance.conectar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executarSQL method, of class ConexaoMySql.
     */
    @Test
    public void testExecutarSQL() {
        System.out.println("executarSQL");
        String pSQL = "";
        ConexaoMySql instance = new ConexaoMySql();
        boolean expResult = false;
        boolean result = instance.executarSQL(pSQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executarUpdateDeleteSQL method, of class ConexaoMySql.
     */
    @Test
    public void testExecutarUpdateDeleteSQL() {
        System.out.println("executarUpdateDeleteSQL");
        String pSQL = "";
        ConexaoMySql instance = new ConexaoMySql();
        boolean expResult = false;
        boolean result = instance.executarUpdateDeleteSQL(pSQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertSQL method, of class ConexaoMySql.
     */
    @Test
    public void testInsertSQL() {
        System.out.println("insertSQL");
        String pSQL = "";
        ConexaoMySql instance = new ConexaoMySql();
        int expResult = 0;
        int result = instance.insertSQL(pSQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fecharConexao method, of class ConexaoMySql.
     */
    @Test
    public void testFecharConexao() {
        System.out.println("fecharConexao");
        ConexaoMySql instance = new ConexaoMySql();
        boolean expResult = false;
        boolean result = instance.fecharConexao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isStatus method, of class ConexaoMySql.
     */
    @Test
    public void testIsStatus() {
        System.out.println("isStatus");
        ConexaoMySql instance = new ConexaoMySql();
        boolean expResult = false;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMensagem method, of class ConexaoMySql.
     */
    @Test
    public void testGetMensagem() {
        System.out.println("getMensagem");
        ConexaoMySql instance = new ConexaoMySql();
        String expResult = "";
        String result = instance.getMensagem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatement method, of class ConexaoMySql.
     */
    @Test
    public void testGetStatement() {
        System.out.println("getStatement");
        ConexaoMySql instance = new ConexaoMySql();
        Statement expResult = null;
        Statement result = instance.getStatement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultSet method, of class ConexaoMySql.
     */
    @Test
    public void testGetResultSet() {
        System.out.println("getResultSet");
        ConexaoMySql instance = new ConexaoMySql();
        ResultSet expResult = null;
        ResultSet result = instance.getResultSet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMensagem method, of class ConexaoMySql.
     */
    @Test
    public void testSetMensagem() {
        System.out.println("setMensagem");
        String mensagem = "";
        ConexaoMySql instance = new ConexaoMySql();
        instance.setMensagem(mensagem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCon method, of class ConexaoMySql.
     */
    @Test
    public void testGetCon() {
        System.out.println("getCon");
        ConexaoMySql instance = new ConexaoMySql();
        Connection expResult = null;
        Connection result = instance.getCon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCon method, of class ConexaoMySql.
     */
    @Test
    public void testSetCon() {
        System.out.println("setCon");
        Connection con = null;
        ConexaoMySql instance = new ConexaoMySql();
        instance.setCon(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatement method, of class ConexaoMySql.
     */
    @Test
    public void testSetStatement() {
        System.out.println("setStatement");
        Statement statement = null;
        ConexaoMySql instance = new ConexaoMySql();
        instance.setStatement(statement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultSet method, of class ConexaoMySql.
     */
    @Test
    public void testSetResultSet() {
        System.out.println("setResultSet");
        ResultSet resultSet = null;
        ConexaoMySql instance = new ConexaoMySql();
        instance.setResultSet(resultSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServidor method, of class ConexaoMySql.
     */
    @Test
    public void testGetServidor() {
        System.out.println("getServidor");
        ConexaoMySql instance = new ConexaoMySql();
        String expResult = "";
        String result = instance.getServidor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServidor method, of class ConexaoMySql.
     */
    @Test
    public void testSetServidor() {
        System.out.println("setServidor");
        String servidor = "";
        ConexaoMySql instance = new ConexaoMySql();
        instance.setServidor(servidor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomeDoBanco method, of class ConexaoMySql.
     */
    @Test
    public void testGetNomeDoBanco() {
        System.out.println("getNomeDoBanco");
        ConexaoMySql instance = new ConexaoMySql();
        String expResult = "";
        String result = instance.getNomeDoBanco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomeDoBanco method, of class ConexaoMySql.
     */
    @Test
    public void testSetNomeDoBanco() {
        System.out.println("setNomeDoBanco");
        String nomeDoBanco = "";
        ConexaoMySql instance = new ConexaoMySql();
        instance.setNomeDoBanco(nomeDoBanco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class ConexaoMySql.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        ConexaoMySql instance = new ConexaoMySql();
        String expResult = "";
        String result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class ConexaoMySql.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = "";
        ConexaoMySql instance = new ConexaoMySql();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSenha method, of class ConexaoMySql.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        ConexaoMySql instance = new ConexaoMySql();
        String expResult = "";
        String result = instance.getSenha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSenha method, of class ConexaoMySql.
     */
    @Test
    public void testSetSenha() {
        System.out.println("setSenha");
        String senha = "";
        ConexaoMySql instance = new ConexaoMySql();
        instance.setSenha(senha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
