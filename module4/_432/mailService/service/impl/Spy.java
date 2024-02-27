package module4._432.mailService.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import module4._432.mailService.model.Sendable;
import module4._432.mailService.model.impl.MailMessage;
import module4._432.mailService.service.MailService;;

public class Spy implements MailService {
    private final Logger logger;
    public static final String AUSTIN_POWERS = "Austin Powers";

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            MailMessage mailMsg = ((MailMessage) mail);
            if (AUSTIN_POWERS.equals(mailMsg.getFrom()) ||
                    AUSTIN_POWERS.equals(mailMsg.getTo())) {
                logger.log(
                        Level.WARNING,
                        "Detected target mail correspondence: " +
                                "from {0} to {1} \"{2}\"",
                        new Object[] { mailMsg.getFrom(),
                                mailMsg.getTo(),
                                mailMsg.getMessage() });

            } else {
                logger.log(
                        Level.INFO,
                        "Usual correspondence: " +
                                "from {0} to {1}",
                        new Object[] { mailMsg.getFrom(),
                                mailMsg.getTo() });
            }
        }
        return mail;
    }
}
