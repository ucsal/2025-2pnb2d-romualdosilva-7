package br.com.mariojp.solid.dip;

public class NoopMailSender implements MailSender {
    @Override
    public void send(String to, String subject, String body) {
        // Não faz nada, simula envio
        System.out.println("DRY_RUN ativo: email não enviado para " + to);
    }
}