
public class IndexDeque<T> extends MyDeque<T> implements Indexable<T> {

    public IndexDeque(int size) {
        super(size);
    }

    @Override
    public T getFront(int i) {      // gets the front item at that location i
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();

        } else {
            if (i < 0 || N < (i + 1)) {
                throw new IndexOutOfBoundsException("Illegal index 5"); 
            }
            return data[i];
        }
    }

    @Override
    public T getBack(int i) { // gets the back item at location i
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();

        } else {
            if (back < 0 || i > N + 1) {
                throw new IndexOutOfBoundsException();
            }
            if (data[back] == null) {
                back = size() - 1 - i;

            } else {
                back = size()-1 - i;
            }
            return data[back];
        }
    }

    @Override
    // Set the value located at logical location i from the front of the collection
    public void setFront(int i, T item) { 
        front = i;
        if ((front + 1) > N || front < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            data[front] = item;
        }
    }

    @Override
    //Set the value located at logical location i from the back of the collection
    public void setBack(int i, T item) {
       
        if ((i + 1) > N || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            data[back] = item;
        }
    }

    // returns number of items
    public int size() {
        return N;
    }

}
