package simple.mailService.service.impl;

import simple.mailService.model.Sendable;
import simple.mailService.exception.IllegalPackageException;
import simple.mailService.exception.StolenPackageException;
import simple.mailService.model.Package;
import simple.mailService.model.impl.MailPackage;
import simple.mailService.service.MailService;

public class Inspector implements MailService {
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage sentPackage = (MailPackage) mail;
            Package pkg = sentPackage.getContent();
            String content = pkg.getContent();
            if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException(content);
            }
            if (content.contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }

}
