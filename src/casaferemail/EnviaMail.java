/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaferemail;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author bedim
 */
public class EnviaMail {
    
public void EnviandoEmail(String nome, String email, Double valor){
    try {   
            String valorVenda = formtarDecimal(valor);
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String dataHoje = formatador.format(data);
            //usuario e senha do seu gmail
            final String usuario = "casafercascavel@gmail.com";
            final String senha = "19952705";
            //config. do gmail
             Properties mailProps = new Properties();
            mailProps.put("mail.transport.protocol", "smtp");
            mailProps.put("mail.smtp.starttls.enable", "true");
            mailProps.put("mail.smtp.host", "smtp.gmail.com");
            mailProps.put("mail.smtp.auth", "true");
            mailProps.put("mail.smtp.user", usuario);
            mailProps.put("mail.debug", "true");
            mailProps.put("mail.smtp.port", "465");
            mailProps.put("mail.smtp.socketFactory.port", "465");
            mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            mailProps.put("mail.smtp.socketFactory.fallback", "false");
            //eh necessario autenticar
            Session mailSession = Session.getInstance(mailProps, new Authenticator() {

                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usuario, senha);
                }
            });
            mailSession.setDebug(false);
            //config. da mensagem
            Message mailMessage = new MimeMessage(mailSession);
            //remetente
            mailMessage.setFrom(new InternetAddress(usuario, "CASAFER"));
            //destinatario
            mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            //mensagem que vai no corpo do email
            //partes do email
            //assunto do email
            mailMessage.setSubject("Relatorio Diario " + dataHoje);
            //seleciona o conteudo 
            mailMessage.setContent("<div class=\"rps_6bb9\"><div><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"padding:0px; margin:0 auto; width:100%; max-width:640px\"><tbody><tr><td width=\"590\" style=\"padding:0px; margin:0px\"><table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"x_x_logo\" style=\"padding:11px 15px 8px 15px; background-color:#343a40\"><a href=\"\" target=\"_blank\" rel=\"noopener noreferrer\" data-auth=\"NotApplicable\" data-linkindex=\"0\" data-ogsc=\"\" style=\"color: rgb(228, 159, 255) !important;\"><img data-imagetype=\"External\" src=\"https://http2.mlstatic.com/storage/mshops-appearance-api/images/56/750361056/logo-2021070616101959000.png\" alt=\"\" border=\"0\" width=\"100\"> </a></td></tr></tbody></table><table bgcolor=\"rgb(0, 104, 31)\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" data-ogsb=\"\" data-ogab=\"#64c574\" style=\"background-color: rgb(46, 204, 113) !important;\"><tbody><tr><td align=\"center\" height=\"45\"></td></tr><tr><td class=\"x_x_title\" style=\"padding:20px 0 45px 0; text-align:center; color:#ffffff!important\"><span style=\"font-family:'Proxima-nova',Helvetica,Arial,sans-serif; font-size:20px; font-weight:300; color:#ffffff!important; display:inline-block; overflow:hidden; text-decoration:none; padding:0 8%\">Muito bem "+ nome +"! Hoje "+ dataHoje +" voce vendeu R$ "+valorVenda+ " :)</span> </span></td></tr><tr><td style=\"text-align:center; padding:0\"><div id=\"x_x_responsive-width\" class=\"x_x_responsive-width\" width=\"78% !important\" style=\"margin: 0px auto; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; background-color: rgb(51, 51, 51) !important; border-left: 1px solid rgb(237, 237, 237); width: 78% !important;\" data-ogsb=\"rgb(255, 255, 255)\"></div></td></tr></tbody></table></td></tr></tbody></table><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"padding:0px; margin:0 auto; width:100%; max-width:640px\"><tbody><tr><td width=\"590\" style=\"padding:0px; margin:0px\"><table bgcolor=\"rgb(54, 54, 54)\" width=\"100%\" cellspacing=\"10\" cellpadding=\"0\" border=\"0\" style=\"background-color: rgb(54, 54, 54) !important;\" data-ogsb=\"\" data-ogab=\"#f8f8f8\"><tbody><tr><td align=\"center\" style=\"font-family: &quot;Proxima Nova&quot;, Arial, Helvetica, sans-serif; font-size: 18px; text-align: center; color: rgb(185, 185, 185) !important; padding: 0px 0px 5px; font-weight: 600;\" data-ogsc=\"rgb(102, 102, 102)\">Mais detalhes</td></tr><tr><td align=\"center\"><p style=\"text-decoration: none; font-family: &quot;Proxima Nova&quot;, Arial, Helvetica, sans-serif; font-weight: 100; font-size: 14px; text-align: center; color: rgb(185, 185, 185) !important; margin: 0px;\" data-ogsc=\"rgb(102, 102, 102)\">CasaFer Materiais para Construcao, Rua manaus 2771, Cancelli, Cascavel-PR, </p></td></tr></tbody></table></td></tr></tbody></table></div></div>", "text/html");
            //envia o email
            Transport.send(mailMessage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro no Envio !\n" + e);
        }

}
public static String formtarDecimal(double saldo) {
    DecimalFormat df = new DecimalFormat("0.00");
    df.setMaximumFractionDigits(2);
    String teste = df.format(saldo);
    return teste;
   }
}

