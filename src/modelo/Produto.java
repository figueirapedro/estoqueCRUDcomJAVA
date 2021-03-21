/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author upper
 */
public class Produto {

    private String codigo;
    private String data_entrada;
    private String local_compra;
    private String tipo;
    private String marca;
    private String caracteristicas;
    private String tamanho;
    private String cor;
    private String valor_etiqueta;
    private String valor_pago;
    private String valor_margem;
    private String preco_sugerido;
    private String[] colunas = new String[]{"codigo", "data_entrada", "local_compra", "tipo",
        "marca", "caracteristicas", "tamanho", "cor", "valor_etiqueta", "valor_pago", "valor_margem",
        "preco_sugerido"};

    public Produto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDtEntrada() {
        return data_entrada;
    }

    public void setDtEntrada(String data_entrada) {
        this.data_entrada = data_entrada;

    }

    public String getLocalCompra() {
        return local_compra;
    }

    public void setLocalCompra(String local_compra) {
        this.local_compra = local_compra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getValorEtiqueta() {
        return valor_etiqueta;
    }

    public void setValorEtiqueta(String valor_etiqueta) {
        this.valor_etiqueta = valor_etiqueta;
    }

    public String getValorPago() {
        return valor_pago;
    }

    public void setValorPago(String valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getValorMargem() {
        return valor_margem;
    }

    public void setValorMargem(String valor_margem) {
        this.valor_margem = valor_margem;
    }

    public String getPrecoSugerido() {
        return preco_sugerido;
    }

    public void setPrecoSugerido(String preco_sugerido) {
        this.preco_sugerido = preco_sugerido;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] Colunas) {
        this.colunas = Colunas;
    }

    public void imprimirProduto() {
        System.out.printf("Código: %s | Data de Entrada: %s | Local da Compra: %s | Tipo: %s | Marca: %s | Caracteristicas: %s | Tamanho: %s | Cor: %s | Valor Etiqueta: %s | Valor Pago: %s | Valor Margem: %s | Preço Sugerido: %s", new Object[]{
            getCodigo(),
            getDtEntrada(),
            getLocalCompra(),
            getTipo(),
            getMarca(),
            getCaracteristicas(),
            getTamanho(),
            getCor(),
            getValorEtiqueta(),
            getValorPago(),
            getValorMargem(),
            getPrecoSugerido()});
    }

    public String produtoParaString() {

        String[] texto = {getCodigo(), getDtEntrada(), getLocalCompra(), getTipo(), getMarca(), getCaracteristicas(), getTamanho(), getCor(), getValorEtiqueta(), getValorPago(), getValorMargem(), getPrecoSugerido(), "\n"};
        String a = String.join(",", texto);
        return a;
    }

}
