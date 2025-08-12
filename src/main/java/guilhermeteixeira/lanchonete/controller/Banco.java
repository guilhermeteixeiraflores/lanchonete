/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guilhermeteixeira.lanchonete.controller;

import guilhermeteixeira.lanchonete.model.Lanche;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GUILHERME
 */
public class Banco {
    private String url;
    private final String usuario;
    private final String senha ;
    
    public Banco(){
        url = "jdbc:mysql://localhost:3306";
        usuario = "root";
        senha = "root";
        
    }
    
    /**
     *
     * @return
     */
    public Connection conectar(){
        try {
          
               Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão com o banco de dados Estabelecida! com sucesso!");
            
            return conexao;
        } catch (SQLException e){
            
            
            System.out.println("Não foi possivel conectar no banco de dados");
            return null;
        }
    } 

    public void salvar(Lanche lanche, Connection conexao){
        String sql = "INSERT INTO lanche(nome, preco) VALUES(?, ?)";
        
           try {
               PreparedStatement stmt = conexao.prepareStatement(sql);
               
               stmt.setString(1, lanche.getNome());
               stmt.setDouble(2, lanche.getPreco());
               
               int linhasAfetadas = stmt.executeUpdate();
               if (linhasAfetadas > 0) {
                   System.out.println("O Lanche foi salvo com Sucesso!");
               }
           } catch(SQLException e){
                 System.out.println("O Lanche não foi salvo no banco de dados!");
           }
    }
      
            public void inicializarBanco(String url, String usuario, String senha){
                try {
                    Connection conexao = DriverManager.getConnection(url, usuario, senha);
                    Statement stmt = conexao.createStatement();
                    
                 try {
                       InputStream is = new FileInputStream ("banco.sql");
                        InputStreamReader isr = new InputStreamReader(is);
                        try (BufferedReader br = new BufferedReader (isr)) {
                            String linha;
                            StringBuilder sql = new StringBuilder();
                            
                            linha = br.readLine();
                            
                            while (linha != null){
                                System.out.println(linha);
                                sql.append(linha).append("\n");
                                
                                if (linha.trim().endsWith(";")){
                                    stmt.execute(sql.toString());
                                    sql.setLength(0);
                                }
                                
                                linha = br.readLine();
                            }
                            stmt.close();
                        }
                    } catch(IOException | SQLException e){
                        System.out.println("Não foi possivel ler o arquivo banco.sql");
                    }
                    
                } catch (SQLException e){
                    System.out.println("Erro ao conectar no banco de dados metrodo inicializar Banco");
                
                }
            }
}

