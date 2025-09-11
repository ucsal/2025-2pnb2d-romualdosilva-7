package br.com.mariojp.solid.dip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailNotifierTest {
    @Test
    void dry_run_should_not_touch_smtp() {
        System.setProperty("DRY_RUN", "true");
        System.clearProperty("SMTP_AVAILABLE");

        MailSender mailSender = new NoopMailSender();
        var notifier = new EmailNotifier(mailSender);

        assertDoesNotThrow(() -> notifier.welcome(new User("Ana", "ana@example.com")),
                "Após refatoração (DIP), DRY_RUN deve evitar SMTP real");
    }
}