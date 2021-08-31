
package casaferemail;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    public static String status = "Não conectou...";
    public ResultSet rs;
    public Connection con;

        
        
    //Método de Conexão//
    public void  Conectar() {
                  //atributo do tipo Connection
    try {
            
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "192.168.1.4:3306";    //caminho do servidor do BD
            String mydatabase = "sacomercio";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "casafer";        //nome de um usuário de seu BD
            String password = "707901";      //sua senha de acesso
            con = DriverManager.getConnection(url, username, password);

        if (con != null) {
            status = ("STATUS--->Conectado com sucesso!");
        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
        }
    }

    public static String statusConection() {
        return status;
    }

    public boolean FecharConexao() {
        try {
            con.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
