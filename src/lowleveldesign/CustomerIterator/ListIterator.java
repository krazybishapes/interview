package lowleveldesign.CustomerIterator;

import java.util.List;

public class ListIterator<T> implements BasicIterator<T>{

    private final List<T> items;
    int index;

    public ListIterator(List<T> items){
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return index < items.size();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new IllegalStateException("No more elements in the list");
        }
        return items.get(index++);
    }
}
