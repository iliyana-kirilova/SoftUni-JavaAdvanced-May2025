package Week7_Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;
    public int size;

    public CustomList(){
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
        this.size++;
    }

    public T remove(int index) {
        this.size--;
        return this.list.remove(index);
    }


    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.list, index1, index2);
    }

    public int countGreaterThen(T elementToCompare) {
        int count = 0;
        for (T element : this.list) {
            if (element.compareTo(elementToCompare)>0){
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = this.list.get(0);

        for (T element : this.list) {
            if ( element.compareTo(max)>0){
                max=element;
            }
        }
        return max;

    }

    public T getMin() {
        T min = this.list.get(0);

        for (T element : this.list) {
            if ( element.compareTo(min)<0){
                min=element;
            }
        }
        return min;
        
    }

    public T get(int index) {
        return this.list.get(index);
    }
}
