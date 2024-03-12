package module6._644.mailService.model;

/*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/

public abstract class AbstractSendable<Content>  {

    private final String from;
    private final String to;
    private final Content content;

    public AbstractSendable(String from, String to, Content content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Content getContent() {
        return content;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AbstractSendable<Content> that = (AbstractSendable<Content>) o;

        if (!from.equals(that.from))
            return false;
        if (!to.equals(that.to))
            return false;

        return true;
    }
}
