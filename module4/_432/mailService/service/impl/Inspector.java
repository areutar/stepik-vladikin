package module4._432.mailService.service.impl;

import module4._432.mailService.model.Sendable;
import module4._432.mailService.exception.IllegalPackageException;
import module4._432.mailService.exception.StolenPackageException;
import module4._432.mailService.model.Package;
import module4._432.mailService.model.impl.MailPackage;
import module4._432.mailService.service.MailService;

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
