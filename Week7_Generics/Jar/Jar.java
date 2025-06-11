package Week7_Generics.Jar;

import java.util.ArrayDeque;

public class Jar<T> {
    //Т-типът на елементи
    private ArrayDeque<T> elements; // създавам си стек, в който ще съхранявам елементите

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T element){
        this.elements.push(element);
    }

    public T remove(){
         return this.elements.pop();
    }

}
