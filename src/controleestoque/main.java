/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque;

import dao.*;
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

    static String tipoConsulta = "";
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bem Vindo ao registro de Estoque!\n******~~~~~~~******");

        while (tipoConsulta.equalsIgnoreCase("")) {
            System.out.println("Deseja consultar o estoque: Localmente (1) ou Remotamente (2)?\n");
            tipoConsulta = scan.nextLine();

            if (!(tipoConsulta.equalsIgnoreCase("1") || tipoConsulta.equalsIgnoreCase("2"))) {
                tipoConsulta = "";
            }
        }

        Boolean loop = true;

        while (loop) {
            System.out.println("******~~~~~~~******\nMenu:\nListar Produtos (0) | Adicionar Produto (1) | Editar Produto (2) | Excluir Produto (3) | Sair (5)\n");
            String tipo = scan.nextLine();

            switch (tipo) {
                case "0":
                    listar();
                    break;
                case "1":
                    salvar();
                    break;
                case "2":
                    editar();
                    break;
                case "3":
                    excluir();
                    break;
                case "5":
                    loop = false;
                    break;
                default:
                    System.out.println("Insira um número Válido!");
                    break;
            }
        }
    }

    public static void salvar() {
        Produto produto;
        System.out.println("******~~~~~~~******\nCadastro de produto:");
        System.out.println("                     Informe:\n                     Código: ");
        produto = new Produto(scan.nextLine());

        System.out.println("                     Informe:\n                     Data de Entrada: ");
        produto.setDtEntrada(scan.nextLine());

        System.out.println("                     Informe:\n                     Local Compra: ");
        produto.setLocalCompra(scan.nextLine());

        System.out.println("                     Informe:\n                     Tipo: ");
        produto.setTipo(scan.nextLine());

        System.out.println("                     Informe:\n                     Marca: ");
        produto.setMarca(scan.nextLine());

        System.out.println("                     Informe:\n                     Caracteristicas: ");
        produto.setCaracteristicas(scan.nextLine());

        System.out.println("                     Informe:\n                     Tamanho: ");
        produto.setTamanho(scan.nextLine());

        System.out.println("                     Informe:\n                     Cor: ");
        produto.setCor(scan.nextLine());

        System.out.println("                     Informe:\n                     Valor Etiqueta: ");
        produto.setValorEtiqueta(scan.nextLine());

        System.out.println("                     Informe:\n                     Valor Pago: ");
        produto.setValorPago(scan.nextLine());

        System.out.println("                     Informe:\n                     Preço Sugerido: ");
        produto.setPrecoSugerido(scan.nextLine());

        produto.setValorMargem(String.valueOf(Integer.valueOf(produto.getValorPago()) * 2));

        if (tipoConsulta.equalsIgnoreCase("1")) {
            ProdutoDAOTXT x = new ProdutoDAOTXT();
            x.salvar(produto);
        } else {
            ProdutoDAOSQL x = new ProdutoDAOSQL();
            x.salvar(produto);
        }
    }

    public static void editar() {
        System.out.println("******~~~~~~~******\nEditar Produto:\nCadsastre o produto novamente para editar\n");
        salvar();
    }

    public static void excluir() {
        System.out.println("******~~~~~~~******\nExcluir Produto:\nQual o código do produto que deseja excluir?");
        Produto a = new Produto(scan.nextLine());

        if (tipoConsulta.equalsIgnoreCase("1")) {
            ProdutoDAOTXT x = new ProdutoDAOTXT();
            x.deletar(a);
        } else {
            ProdutoDAOSQL x = new ProdutoDAOSQL();
            x.deletar(a);
        }
    }

    public static void listar() {
        System.out.println("******~~~~~~~******\nLista de Produtos\n******~~~~~~~******\n");
        
        if (tipoConsulta.equalsIgnoreCase("1")) {
            ProdutoDAOTXT x = new ProdutoDAOTXT();
            for (Produto a : x.listarTodos()) 
                a.imprimirProduto();
        } else {
            ProdutoDAOSQL x = new ProdutoDAOSQL();
            for (Produto a : x.listarTodos()) 
                a.imprimirProduto();
        }
    }
}
