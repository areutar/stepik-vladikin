package module6._644.mailService.service;

import java.util.function.Consumer;

import module6._644.mailService.model.AbstractSendable;

public class MailService<Mail> implements Consumer<AbstractSendable<Mail>> {
    private final MailBox<Mail> mailBox = new MailBox<>();

    @Override
    public void accept(AbstractSendable<Mail> mail) {
        mailBox.add(mail);
    }

    public MailBox<Mail> getMailBox() {
        return mailBox;
    }

}
