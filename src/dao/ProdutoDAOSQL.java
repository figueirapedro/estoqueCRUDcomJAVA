/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import modelo.Produto;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author upper
 */
public class ProdutoDAOSQL {

    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;

    public ProdutoDAOSQL() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Produto objProd) {
        try {
            String sql;
            if (String.valueOf(objProd.getCodigo()).isEmpty()) {
                sql = "INSERT INTO estoque(codigo,data_entrada,local_compra,tipo,marca,caracteristicas,tamanho,cor,valor_etiqueta,valor_pago,valor_margem,preco_sugerido) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objProd.getCodigo());
                stmt.setString(2, objProd.getDtEntrada());
                stmt.setString(3, objProd.getLocalCompra());
                stmt.setString(4, objProd.getTipo());
                stmt.setString(5, objProd.getMarca());
                stmt.setString(6, objProd.getCaracteristicas());
                stmt.setString(7, objProd.getTamanho());
                stmt.setString(8, objProd.getCor());
                stmt.setString(9, objProd.getValorEtiqueta());
                stmt.setString(10, objProd.getValorPago());
                stmt.setString(11, objProd.getValorMargem());
                stmt.setString(12, objProd.getPrecoSugerido());
                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE estoque SET data_entrada = ?, local_compra = ?, tipo = ?, marca = ?, caracteristicas = ?, tamanho = ?, cor = ?, valor_etiqueta = ?, valor_pago = ?, valor_margem = ?, preco_sugerido = ? WHERE estoque.codigo = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(12, objProd.getCodigo());
                stmt.setString(1, objProd.getDtEntrada());
                stmt.setString(2, objProd.getLocalCompra());
                stmt.setString(3, objProd.getTipo());
                stmt.setString(4, objProd.getMarca());
                stmt.setString(5, objProd.getCaracteristicas());
                stmt.setString(6, objProd.getTamanho());
                stmt.setString(7, objProd.getCor());
                stmt.setString(8, objProd.getValorEtiqueta());
                stmt.setString(9, objProd.getValorPago());
                stmt.setString(10, objProd.getValorMargem());
                stmt.setString(11, objProd.getPrecoSugerido());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void deletar(Produto objProd) {
        try {
            String sql;
            if (!String.valueOf(objProd.getCodigo()).isEmpty()) {
                sql = "DELETE FROM estoque WHERE usuario.codigo = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objProd.getCodigo());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList buscar(Produto objProd) {
        try {
            String sql = "";
            if (!objProd.getMarca().isEmpty()) {
                sql = "SELECT * FROM usuario WHERE nome LIKE '%" + objProd.getMarca() + "%' ";

            } else if (!objProd.getTipo().isEmpty()) {
                sql = "SELECT * FROM usuario WHERE cpf LIKE '%" + objProd.getTipo() + "%' ";
            } else if (!objProd.getCaracteristicas().isEmpty()) {
                sql = "SELECT * FROM usuario WHERE cpf LIKE '%" + objProd.getCaracteristicas() + "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("codigo"),
                    rs.getString("data_entrada"),
                    rs.getString("local_compra"),
                    rs.getString("tipo"),
                    rs.getString("marca"),
                    rs.getString("caracteristicas"),
                    rs.getString("tamanho"),
                    rs.getString("cor"),
                    rs.getString("valor_etiqueta"),
                    rs.getString("valor_pago"),
                    rs.getString("valor_margem"),
                    rs.getString("preco_sugerido"),
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }

    }

    public ArrayList listarTodos() {
        try {

            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM estoque");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("codigo"),
                    rs.getString("data_entrada"),
                    rs.getString("local_compra"),
                    rs.getString("tipo"),
                    rs.getString("marca"),
                    rs.getString("caracteristicas"),
                    rs.getString("tamanho"),
                    rs.getString("cor"),
                    rs.getString("valor_etiqueta"),
                    rs.getString("valor_pago"),
                    rs.getString("valor_margem"),
                    rs.getString("preco_sugerido"),
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }
    }

    public static void testarConexao() throws SQLException {
        try (Connection objConnection = new ConnectionFactory().getConnection()) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! ");
        }
    }
    
}
