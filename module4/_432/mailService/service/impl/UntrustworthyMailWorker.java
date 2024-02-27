package module4._432.mailService.service.impl;

import module4._432.mailService.model.Sendable;
import module4._432.mailService.service.MailService;

public class UntrustworthyMailWorker implements MailService {
    private final MailService[] thirdParties;
    private final MailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] thirdParties) {
        this.thirdParties = thirdParties;
    }

    public MailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable result = mail;
        for (MailService service : thirdParties) {
            result = service.processMail(result);
        }
        return realMailService.processMail(result);
    }
}
