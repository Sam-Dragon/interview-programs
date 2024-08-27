package misc.questions.singleton;

public final class SingleTonClassEagerWay implements Cloneable {
    private static final SingleTonClassEagerWay instance = new SingleTonClassEagerWay();

    public static SingleTonClassEagerWay getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}