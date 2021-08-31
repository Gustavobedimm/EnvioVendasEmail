
package casaferemail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JobMail {
    boolean test = true; 
    public JobMail(){
        System.out.println("-------------------------------------------------");
        System.out.println("Casafer Email (Envio programado para 18h)        ");
        System.out.println("Programa feito com o intuito de enviar emails com");
        System.out.println("o valor das vendas diarias para cada vendedor.   ");
        System.out.println("Criado por : Gustavo Bedim Mazutti               ");
        System.out.println("v1.0.0                                           ");
        System.out.println("-------------------------------------------------");
        
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new JobMail.execJob(), 1, 1 * 60000);
    }
    class execJob extends TimerTask {
        
        @Override
        public void run() {
            Date horaAtual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("HH");
            String formattedDate = formato.format(horaAtual);
            
            if(formattedDate.equals("19")){
                test = true;
            }
            
            if(formattedDate.equals("18") && test == true){
                System.out.println("Iniciando envio de E-mails do dia " + getDateNormal());
            test = false;
            ArrayList<Vendedores> listaVendedores = new ArrayList<>();
            DaoNotasVendas dao = new DaoNotasVendas();
            try {
                listaVendedores = dao.vendedores();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JobMail.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Vendedores vendedor : listaVendedores) {
                
                String dataHoje = getDate();
                ArrayList<Pedidos> listaPedidos = new ArrayList();
                Double total = 0.0;
                try {
                    listaPedidos = dao.todosPedidos(dataHoje, dataHoje, vendedor.getVen_Codigo());
                    for(Pedidos p: listaPedidos){
                        total = total + p.getPed_Valor();
                    }
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JobMail.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(total > 0 && !vendedor.getVen_Email().equals("")){
                    System.out.println("Enviando Email para " + vendedor.getVen_Nome() + " Email : " + vendedor.getVen_Email());
                    EnviaMail enviaEmail = new EnviaMail();
                    enviaEmail.EnviandoEmail(vendedor.getVen_Nome(), vendedor.getVen_Email(), total);
                }
            }
            }
        }
    }
    public String getDate() { 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
        Date date = new Date();
        return sdf.format(date); 
    }
    public String getDateNormal() { 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = new Date();
        return sdf.format(date); 
    }
    
    
}
