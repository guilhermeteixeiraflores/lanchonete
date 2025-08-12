/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package guilhermeteixeira.lanchonete;

import guilhermeteixeira.lanchonete.controller.Banco;
import guilhermeteixeira.lanchonete.model.Lanche;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author GUILHERME
 */
public class Lanchonete {

    public static void main(String[] args)  {
       Banco b = new Banco();
       Connection conexao = b.conectar();
       
      Lanche l = new Lanche("Café Gelado", 9.90);
      
      b.salvar(l, conexao);
    }      
}
