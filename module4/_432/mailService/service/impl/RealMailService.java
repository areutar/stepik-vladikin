package module4._432.mailService.service.impl;

import module4._432.mailService.model.Sendable;
import module4._432.mailService.service.MailService;

/*
Класс, в котором скрыта логика настоящей почты
*/

public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}
