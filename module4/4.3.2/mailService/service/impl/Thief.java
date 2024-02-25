package simple.mailService.service.impl;

import simple.mailService.model.Package;
import simple.mailService.model.Sendable;
import simple.mailService.model.impl.MailPackage;
import simple.mailService.service.MailService;

public class Thief implements MailService {
    private final int minValue;
    private int stolenValue = 0;

    public Thief(int minValue) {
        this.minValue = minValue;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage sentPackage = (MailPackage) mail;
            Package pkg = sentPackage.getContent();
            if (pkg.getPrice() >= minValue) {
                Package stolenPkg = new Package(
                        "stones instead of " + pkg.getContent(),
                        0);
                stolenValue += pkg.getPrice();
                return new MailPackage(
                        sentPackage.getFrom(),
                        sentPackage.getTo(),
                        stolenPkg);
            }
        }
        return mail;
    }
}
