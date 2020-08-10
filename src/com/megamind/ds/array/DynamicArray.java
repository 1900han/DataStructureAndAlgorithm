package com.megamind.ds.array;

public class DynamicArray<T> {
    private Object[] array;
    private int size;

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        this.array = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T t) {
        add(size, t);
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >=0 and <= size.");
        }
        if (size == array.length) {
            resize(2 * array.length);
        }

        if (size - 1 - index >= 0) System.arraycopy(array, index + 1, array, index + 1 + 1, size - 1 - index);

        array[index] = t;
        size++;
    }

    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return (T) array[index];
    }

    public T getLast() {
        return get(size - 1);
    }

    public T getFirst() {
        return get(0);
    }

    public void set(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        array[index] = t;
    }

    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i] == t) {
                return true;
            }
        }
        return false;
    }

    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i] == t) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        T ret = (T) array[index];
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        array[size] = null;
        if (size == (array.length / 4) && (array.length / 2) != 0) {
            resize(array.length / 2);
        }
        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T t) {
        int index = find(t);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: size = " + size + "capacity = " + array.length + "\n");
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int getCapacity() {
        return array.length;
    }
}
