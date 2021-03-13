/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.ModelTable;
import modelo.Produto;

/**
 *
 * @author upper
 */
public class main {
    
    public static void main(String[] args) {
        Boolean breakLoop = false;
        Scanner scan = new Scanner(System.in);
        
        while(!breakLoop){
            System.out.println("Bem Vindo ao registro de Estoque!\n******~~~~~~~******");
            System.out.println("Deseja consultar o estoque: Localmente (1) ou Remotamente (2)?");
            scan.nextLine();
        }
    }
    
}
