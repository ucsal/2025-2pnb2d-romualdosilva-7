package br.com.mariojp.solid.dip;
public class Main {
    public static void main(String[] args) {
        System.setProperty("DRY_RUN", "true"); 

        MailSender mailSender;
        if ("true".equalsIgnoreCase(System.getProperty("DRY_RUN"))) {
            mailSender = new NoopMailSender();
        } else {
            mailSender = new SmtpClient();
        }

        var notifier = new EmailNotifier(mailSender);
        notifier.welcome(new User("Ana", "ana@example.com"));
        System.out.println("Email enviado!");
    }
}