package module6._644.mailService.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import module6._644.mailService.model.AbstractSendable;

public class MailBox<Mail> extends HashMap<String, List<Mail>> {
    @Override
    public List<Mail> get(Object name) {
        List<Mail> received = super.get(name);
        if (received == null) {
            received = Collections.<Mail>emptyList();
        }
        return received;
    }

    public void add(AbstractSendable<Mail> mail) {
        this.compute(mail.getTo(), (name, mails) -> {
            if (mails != null) {
                mails.add(mail.getContent());
            } else {
                mails = new ArrayList<>();
                mails.add(mail.getContent());
            }
            return mails;
        });
    }

}
