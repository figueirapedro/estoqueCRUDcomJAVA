/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafioestoque;
import java.util.Scanner;


/**
 *
 * @author Escola
 */
public class DesafioEstoque {

    /**
     * @param args the command line arguments
     */
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
