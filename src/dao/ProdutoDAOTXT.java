/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Produto;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


/**
 *
 * @author Escola
 */
public class ProdutoDAOTXT {

    public void salvar(ArrayList<Produto> dado) {
        String estoque = "";
        
        for(Produto a : dado){
            estoque = estoque + a.produtoParaString();
        }

        try {
            File myObj = new File("estoque.csv");
            
            if (myObj.createNewFile()) 
                System.out.println("Arquivo Criado: " + myObj.getName());
            
            
            FileWriter myWriter = new FileWriter("estoque.csv");
            myWriter.write(estoque);
            myWriter.close();
            System.out.println("Estoque salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void salvar(Produto objProd) {
            
        ArrayList<Produto> dado = new ArrayList();
            
            if(buscar(objProd.getCodigo()) == null){
                dado.add(objProd);
                salvar(dado);            
            } else {
                salvar(editar(objProd));
            }
    }

    public void deletar(Produto objProd) {

        ArrayList<Produto> dado = new ArrayList();
        dado = listarTodos();

        for (Produto a : dado) {
            if (a.getCodigo().equals(objProd.getCodigo())) {
                dado.remove(a);
            }
            salvar(dado);
            
            System.out.println("Produto foi removido!");
            return;
        }

        System.out.println("Produto não foi encontrado!");
    }

    public Produto buscar(String codigo) {

        ArrayList<Produto> dado = new ArrayList();
        dado = listarTodos();

        for (Produto a : dado) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }
        
        return null;
    }
    
     public ArrayList<Produto> editar(Produto objProd) {

        ArrayList<Produto> dado = new ArrayList();
        dado = listarTodos();
        
        int i;
        
        for (Produto a : dado){
            if(a.getCodigo().equals(buscar(objProd.getCodigo()).getCodigo()))
                dado.remove(dado.indexOf(a)); break;
        }
        
        dado.add(objProd);
        
        return dado;        
    }

    public ArrayList<Produto> listarTodos() {
        try {

            ArrayList<Produto> dado = new ArrayList();
            Produto produto;

            File myObj = new File("estoque.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data[] = myReader.nextLine().split(",");

                produto = new Produto(data[0]);
                produto.setDtEntrada(data[1]);
                produto.setLocalCompra(data[2]);
                produto.setTipo(data[3]);
                produto.setMarca(data[4]);
                produto.setCaracteristicas(data[5]);
                produto.setTamanho(data[6]);
                produto.setCor(data[7]);
                produto.setValorEtiqueta(data[8]);
                produto.setValorPago(data[9]);
                produto.setValorMargem(data[10]);
                produto.setPrecoSugerido(data[11]);

                dado.add(produto);

            }

            return dado;
        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("Ocorreu um Erro, retornando...");
            return null;
        }
    }
    
}
