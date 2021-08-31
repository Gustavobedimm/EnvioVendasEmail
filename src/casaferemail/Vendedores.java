
package casaferemail;

public class Vendedores {
    private Integer Ven_Codigo;
    private String Ven_Nome;
    private String Ven_Email;
    private Double TotalVendasPeriodo; //apenas para passagem de parametro

    public Integer getVen_Codigo() {
        return Ven_Codigo;
    }

    public void setVen_Codigo(Integer Ven_Codigo) {
        this.Ven_Codigo = Ven_Codigo;
    }

    public String getVen_Nome() {
        return Ven_Nome;
    }

    public void setVen_Nome(String Ven_Nome) {
        this.Ven_Nome = Ven_Nome;
    }

    public String getVen_Email() {
        return Ven_Email;
    }

    public void setVen_Email(String Ven_Email) {
        this.Ven_Email = Ven_Email;
    }
    
    

    public Double getTotalVendasPeriodo() {
        return TotalVendasPeriodo;
    }

    public void setTotalVendasPeriodo(Double TotalVendasPeriodo) {
        this.TotalVendasPeriodo = TotalVendasPeriodo;
    }

   
    
    
}
