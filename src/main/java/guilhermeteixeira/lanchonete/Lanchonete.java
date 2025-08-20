/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package guilhermeteixeira.lanchonete;

import guilhermeteixeira.lanchonete.controller.Banco;
import guilhermeteixeira.lanchonete.model.Lanche;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import guilhermeteixeira.lanchonete.view.GUIMenu;
import javax.swing.JInternalFrame;
/**
 *
 * @author GUILHERME
 */
public class Lanchonete {

   /* public static void main(String[] args)  {
       Banco b = new Banco();
       Connection conexao = b.conectar();
       
      Lanche l = new Lanche("Café Gelado", 9.90);
      
      b.salvar(l, conexao);
    }  */
    
    public static void main(String args[]){
        
        GUIMenu janelaPrincipal = new GUIMenu();
        
        janelaPrincipal.setVisible(true);
       Banco b = new Banco();
       b.inicializarBanco();
       
    
       ArrayList<Lanche> lanches = b.buscarPorTrechoNome("pastel");
               
       for (Lanche lanche: lanches){
           lanche.apresentarLanche();
       }
              
       b = null;
             
       /*Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable(){
          public void run(){
     janelaPrincipal.setVisible(true);
     janelaPrincipal.getjInternalFrameCadastroLanche().setVisible(false);
     janelaPrincipal.getJInternalFramePesquisar().setVisible(false);
          }
});
}

}
