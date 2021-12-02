package edu.pnu.collection;

import java.util.Arrays;

public class GenericList<T> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;

    public GenericList(){
        data = new Object[DEFAULT_SIZE];
    }
    public GenericList(int size){
        data = new Object[size];
    }
    public void add(T value){
        data[size] = value;
        size++;
    }
    public T find(T item){
        T findItem = null;
        for (int i=0; i<size; i++){
            if (data[i].equals(item)) findItem = (T)data[i];
        }
        return findItem;
    }
    public int getSize() { return size; }
    public Object[] getData() { return data;}
    public String toString(){
        String returnString = new String();
        for (int i=0; i<size; i++){
            returnString += data[i];
        }
        return returnString;
    }
}
