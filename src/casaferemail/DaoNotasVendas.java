
package casaferemail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoNotasVendas {
    Conexao conexao = new Conexao();
    

public ArrayList todasNotas(String dataInicio,String dataFim) throws ClassNotFoundException {
        conexao.Conectar();
        
        ArrayList<NotasVendas> listaNotas = new ArrayList();
        try {
            String query = "SELECT * FROM notasvenda where NF_DataSaida BETWEEN date("+dataInicio+") AND  date("+dataFim+")";
            PreparedStatement pst;
            ResultSet rs;
            pst = conexao.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                NotasVendas nota = new NotasVendas();

                nota.setSer_Codigo(rs.getString("Ser_Codigo"));
                nota.setNF_Numero(rs.getInt("NF_Numero"));
                nota.setNF_DataSaida(rs.getString("NF_DataSaida"));
                nota.setNF_Vendedores(rs.getString("NF_Vendedores"));
                nota.setNF_VlrMercadorias(rs.getDouble("NF_VlrMercadorias"));
                nota.setNF_VlrNota(rs.getDouble("NF_VlrNota"));
                nota.setNF_VlrDesc(rs.getDouble("NF_VlrDesc"));
                nota.setNF_PercDesc(rs.getDouble("NF_PercDesc"));
                nota.setNF_Situcao(rs.getString("NF_Situacao"));
                nota.setOpFis_Codigo(rs.getInt("OpFis_Codigo"));

                listaNotas.add(nota);
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão com o Banco " + e);
        }
        conexao.FecharConexao();
        return listaNotas;
    }
public ArrayList todosPedidos(String dataInicio,String dataFim, Integer codVendedor) throws ClassNotFoundException {
        conexao.Conectar();
        ArrayList<Pedidos> listaPedidos = new ArrayList();
        try {
            String query = "SELECT * FROM pedidosvenda where Ped_Data BETWEEN date("+dataInicio+") AND  date("+dataFim+") AND Ped_Situacao = 'F' AND Ped_Vendedores = " + codVendedor ;
            PreparedStatement pst;
            ResultSet rs;
            pst = conexao.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Pedidos pedido = new Pedidos();
                pedido.setPed_Valor(rs.getDouble("Ped_Valor"));
                pedido.setPed_Vendedores(rs.getInt("Ped_Vendedores"));
                listaPedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão com o Banco " + e);
        }
        conexao.FecharConexao();
        return listaPedidos;
    }
public ArrayList todasNotasPorVendedor(String dataInicio,String dataFim,String codVendedor) throws ClassNotFoundException {
        conexao.Conectar();
        
        ArrayList<NotasVendas> listaNotas = new ArrayList();
        try {
            String query = "SELECT * FROM notasvenda where NF_DataSaida BETWEEN date("+dataInicio+") AND  date("+dataFim+") AND NF_Vendedores = '"+codVendedor+"' ";
            PreparedStatement pst;
            ResultSet rs;
            pst = conexao.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                NotasVendas nota = new NotasVendas();

                nota.setSer_Codigo(rs.getString("Ser_Codigo"));
                nota.setNF_Numero(rs.getInt("NF_Numero"));
                nota.setNF_DataSaida(rs.getString("NF_DataSaida"));
                nota.setNF_Vendedores(rs.getString("NF_Vendedores"));
                nota.setNF_VlrMercadorias(rs.getDouble("NF_VlrMercadorias"));
                nota.setNF_VlrNota(rs.getDouble("NF_VlrNota"));
                nota.setNF_VlrDesc(rs.getDouble("NF_VlrDesc"));
                nota.setNF_PercDesc(rs.getDouble("NF_PercDesc"));
                nota.setNF_Situcao(rs.getString("NF_Situacao"));
                nota.setOpFis_Codigo(rs.getInt("OpFis_Codigo"));

                listaNotas.add(nota);
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão com o Banco " + e);
        }
        conexao.FecharConexao();
        return listaNotas;
    }
public ArrayList vendedores() throws ClassNotFoundException {
        conexao.Conectar();
        
        ArrayList<Vendedores> listaVendedores = new ArrayList();
        try {
            String query = "SELECT * FROM vendedores WHERE Ven_Situacao = 'A'";
            PreparedStatement pst;
            ResultSet rs;
            pst = conexao.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Vendedores vendedores = new Vendedores();

                vendedores.setVen_Codigo(rs.getInt("Ven_Codigo"));
                vendedores.setVen_Nome(rs.getString("Ven_Nome"));
                vendedores.setVen_Email(rs.getString("Ven_Email"));

                listaVendedores.add(vendedores);
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão com o Banco " + e);
        }
        conexao.FecharConexao();
        return listaVendedores;
    }

}
