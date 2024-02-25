package simple.mailService.service;

import simple.mailService.model.Sendable;

/*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/

public interface MailService {
    Sendable processMail(Sendable mail);
}
