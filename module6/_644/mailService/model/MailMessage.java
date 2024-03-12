package module6._644.mailService.model;

public class MailMessage extends AbstractSendable<String> {

    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }

}
