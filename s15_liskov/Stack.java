package s15_liskov;

import java.util.ArrayList;

public final class Stack<E> extends ArrayList<E> {
    @Override
    public void add(int _idx, E elem) {
        super.add(elem);
    }

    @Override
    public E remove(int _idx) {
        assert !this.isEmpty();

        int lastIdx = this.size() - 1;
        E elem = this.get(lastIdx);

        super.remove(lastIdx);

        return elem;
    }

    @Override
    public boolean remove(Object _obj) {
        if (this.isEmpty()) {
            return false;
        }

        this.remove(0);

        return true;
    }
}
