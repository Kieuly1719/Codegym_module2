package ss10_DSA_DanhSach.ArrayList;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        if(capacity < DEFAULT_CAPACITY && capacity > 0){
            elements = new Object[capacity];
        }
        else{
            elements = new Object[DEFAULT_CAPACITY];
        }
    }
    public void add(int index, E element){
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        this.elements[index] = element;
        size++;
    }
    public E remove(int index){
        E valueDelete =(E) elements[index];
        int num = size - index - 1;
        Object[] temp = new Object[size-1];
        if(num > 0){
            System.arraycopy(elements, 0, temp, 0, index);
            System.arraycopy(elements, index + 1, temp, index, num);
            size-=1;
        }
        elements = temp;
        return valueDelete;
    }
    public int size(){
        return size;
    }
    public MyList<E> clone(){
        Object[] temp = new Object[size];
        for(int i = 0; i < size; i++){
            temp[i] = this.elements[i];
        }
        MyList<E> m = new MyList<>();
        m.size = this.size;
        m.elements = temp;
        return m;
    }
    public boolean contains(E o) {
        for(int i = 0; i < this.elements.length; i++){
            if(o.equals(this.elements[i])){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E o) {
        if(o == null){
            return -1;
        }
        for(int i = 0; i < this.elements.length; i++){
            if(o.equals(this.elements[i])){
                return i;
            }
        }
        return -1;
    }
    public boolean add(E o){
        ensureCapacity(this.size + 1);
        elements[size] = o;
        size++;
        return true;
    }
    public void ensureCapacity(int minCapacity){
        int newCapacity;
        if(minCapacity > this.elements.length){
            newCapacity = minCapacity;
            Object[] temp = new Object[newCapacity];
            System.arraycopy(elements, 0, temp, 0, size);
            elements = temp;
        }
    }
    public E get(int i){
        return (E) this.elements[i];
    }
    public void clear(){
        Object[] temp = new Object[elements.length];
        this.elements = temp;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < this.elements.length; i++){
            str.append(this.elements[i]);
            str.append(" ");
        }
        return str.toString();
    }
}
