package module6._611.genericPair;

class Pair<S, T> {
    private S s;
    private T t;

    private Pair(S s, T t) {
        this.s = s;
        this.t = t;
    }

    public static <S, T> Pair<S, T> of(S s, T t) {
        return new Pair<>(s, t);
    }

    public S getFirst() {
        return s;
    }

    public T getSecond() {
        return t;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((s == null) ? 0 : s.hashCode());
        result = prime * result + ((t == null) ? 0 : t.hashCode());
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair<S, T> other = (Pair<S, T>) obj;

        if (s == null) {
            if (other.s != null)
                return false;
        } else if (!s.equals(other.s))
            return false;

        if (t == null) {
            if (other.t != null)
                return false;
        } else if (!t.equals(other.t))
            return false;
        return true;
    }

}
