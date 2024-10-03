
import java.util.Arrays;

public class MyDeque<T> implements DequeInterface<T> {

    protected T[] data;
    protected int front, back, N; // N is number of items

    public MyDeque(int size) {
        data = (T[]) new Object[size];
        front = -1;
        back = -1;
    }

    public MyDeque(MyDeque<T> old) {
        // creating a new array and copying the old data into the new data array
        data = (T[]) new Object[old.data.length];
        for (int i = 0; i < old.size(); i++) {
            data[i] = old.data[i];
        }
        N = old.size();

    }

    public boolean equals(MyDeque<T> rhs) { // checking to see if two arrays are equal
        if (size() != rhs.size()) {
            return false;
        } else {
            for (int i = 0; i <= size() - 1; i++) {

                if (data[i] == rhs.data[i]) {

                } else if (data[i] == null) {
                    return false;

                } else if (rhs.data[i] == null) {
                    return false;
                } else {
                    return false;
                }
            }
            return true;

        }

    }

    public String toString() {
        if (size() > 0) {
            StringBuilder B = new StringBuilder();
            for (int i = 0; i < size(); i++) {
                if (data[i] == null) {
                    data[i] = data[front];
                    data[front] = null;
                    front++;
                }
                B.append(data[i].toString());
                B.append(" ");
            }
            return B.toString();
        } else {
            return new String(" ");
        }
    }

    public void addToBack(T newEntry) {
        if (isFull()) {                     // checking to see if array is full
            addCapacity();
        }
        if (isEmpty()) {
            front = back = 0;
            data[back] = newEntry;
        } else if (back == size() && front != 0) {
            back = 0;
            data[back] = newEntry;
        } else {
            back = (back + 1);
        }
        if (front <= back) {
            data[back] = newEntry;
        } else {
            data[back] = newEntry;
        }
        N++;

    }

    public void addToFront(T newEntry) {
        if (isFull()) {                  // checking to see if array is full
            addCapacity();
        }
        if (isEmpty()) {
            front = back = 0;

        } else {
            front = (front + 1) % data.length;
        }
        data[front] = newEntry;
        N++;
    }

    public int size() {
        return N;               // N is number of items
    }

    public T getFront() {
        if (isEmpty()) {
           return null;
        }
        return data[front];
    }

    public T removeFront() {

        if (isEmpty()) {
            return null;
        }
        T temp = data[front];
        data[front] = null;
        if (front == back) {
            front = back = -1;
        } else if (front == N - 1) {
            front = 0;
        } else {
            front = (front + 1);
        }
        N--;
        return temp;
    }

    public T removeBack() {
        if (isEmpty()) {
           return null;
        } else {
            T temp = data[back];
            data[back] = null;
            back--;
            if (back == -1 || back == 0 || data[back - 1] == null) {
                back = front;
            }
            N--;
            return temp;

        }

    }

    public T getBack() {
        if (isEmpty()) {
            return null;
        }
        return data[back];
    }

    public boolean isEmpty() {
        if (N == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        data = (T[]) new Object[data.length];
        back = 0;
        N = 0;
    }

    public int capacity() {
        return (data.length - N) + N; // returns Number of item plus space left in array
    }

    public void addCapacity() {
        T[] secondArray = (T[]) (new Object[data.length * 2]); // making new array with double the size of old array
        int b = 0;
        int f = front;      
        do {
            secondArray[b++] = data[f];

            f = (f + 1) % data.length;
        } while (f != front);
        front = 0;
        back = data.length - 1;
        data = secondArray;
    }

    private boolean isFull() {
        if (N == data.length) {
            return true;
        }
        return false;
    }
}
