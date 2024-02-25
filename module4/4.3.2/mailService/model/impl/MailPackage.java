package simple.mailService.model.impl;

import simple.mailService.model.Package;

/*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/

public class MailPackage extends AbstractSendable {
    private final Package content;

    public MailPackage(String from, String to, Package pkg) {
        super(from, to);
        this.content = pkg;
    }

    public Package getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        MailPackage that = (MailPackage) o;

        if (!content.equals(that.content))
            return false;

        return true;
    }

}