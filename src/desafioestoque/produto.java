/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafioestoque;

/**
 *
 * @author Escola
 */
public class produto {
    
    public int cod;
    public String data;
    public String local;
    public enum tipo{
        Vestido,
        Saia,
        Camiseta,
        Calça,
        Short,
        Meia
    };
    public enum marca{
        Nike,
        Adidas,
        Puma,
        Kappa,
        Penalty
    };
    public enum tamanho{
        P,
        M,
        G,
        GG
    };
    public String cor;
    public float valorEtiqueta;
    public float valorCompra;
    public float valorMargem;
    public float Preço;
    
    
}
