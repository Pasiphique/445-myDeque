
public class IndexAddRemoveDeque<T> extends IndexDeque<T> implements IndexableAddRemove<T> {

    public IndexAddRemoveDeque(int size) {
        super(size);
    }

    @Override
    //Add the value at logical location i from the front of the collection
    public void addToFront(int i, T item) {
        if (isEmpty()) {
            front = back = 0;
            data[i] = item;
            N++;
        } else {
            if (size() == data.length) {
                addCapacity();
            } else if (i < 0 || N < (i + 1)) {
                throw new IndexOutOfBoundsException("Illegal index " + i);
            }
            back++;
            for (int x = N - 1; x >= i; x--) {
                data[x + 1] = data[x];
            }
            data[i] = item;
            N++;
        }
    }

    @Override
    //Add the value at logical location i from the back of the collection
    public void addToBack(int i, T item) {
        if (isEmpty()) {
            front = back = 0;

        } else {
            if (size() == data.length) {
                addCapacity();
            }
            if (i < 0 || N < (i + 1)) {

                throw new IndexOutOfBoundsException("Illegal index 5");
            }
            back++;
            for (int x = back - i; x < size(); x++) {
                data[x + 1] = data[x];
            }
            i = back - i;
            data[i] = item;
            N++;

        }

    }

    @Override
    // Remove and return the item at logical location i from the front of the collection
    public T removeFront(int i) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            if (size() == data.length) {
                addCapacity();
            }
            if (i < 0 || N < (i + 1)) {
                throw new IndexOutOfBoundsException("Illegal index " + i);
            }
            T temp = data[i];
            data[i] = null;
            for (int x = i + 1; x < size(); x++) {
                data[x - 1] = data[x];
            }
            N--;
            back--;
            return temp;
        }
    }

    @Override
    // Remove and return the item at logical location i from the back of the collection
    public T removeBack(int i) {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException();

        } else {
            if (size() == data.length) {
                addCapacity();
            }
            if (i < 0 || N < (i + 1)) {

                throw new IndexOutOfBoundsException("Illegal index " + i);
            }
            i = back - i;
            T temp = data[i];
            data[i] = null;
            back--;

            for (int x = i; x < size(); x++) {
                data[x] = data[x + 1];
            }
            N--;
            return temp;
        }

    }

}
