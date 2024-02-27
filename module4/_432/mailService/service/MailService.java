package module4._432.mailService.service;

import module4._432.mailService.model.Sendable;

/*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/

public interface MailService {
    Sendable processMail(Sendable mail);
}
