package simple.mailService.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import simple.mailService.model.Sendable;
import simple.mailService.model.impl.MailMessage;
import simple.mailService.service.MailService;;

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
