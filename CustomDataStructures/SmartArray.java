package CustomDataStructures;

import java.util.function.Consumer;

//описваме как ще изглежда и какви функции ще притежава нашия умен масив.
public class SmartArray {
    //полета -> характеристики на умния масив
    private int[] data; //съхранваме всички цели числа, които принадлежат към масива
    private int size; //текущия брой на числата в нашия умен масив
    private int capacity; //колко е брой на елементите в масива

    // констуктор
    public SmartArray() {
        this.size = 0;
        this.capacity = 4;
        this.data = new int[this.capacity]; //нов масив, който има максимален размер
    }

    //методи - действия, които можем да извършваме с нашия умен масив
    public void add(int element){ //добавя дадения елемент в масива
        //data = [4, 5, 6, 7]
        // size = 4
        //capacity = 5;

        //проверяваме дали имаме място в масива за дадения елелмент
        if (this.size == this.capacity){
            //учеличаваме размера на масива
            increaseCapacity();
        }
        //имаме място, където да добавим елемента
        this.data[size] = element;
        this.size++;
    }

    private void increaseCapacity() {
        this.capacity *=2;
        int[] temporaryArray = new int[this.capacity]; //създавам масив с нов брой елелменти
        for (int position = 0; position <this.data.length ; position++) { //обхождам стария и презаписвам елементите в новия
            temporaryArray[position] = this.data[position];
        }

        this.data = temporaryArray;
    }

    public int get(int index){ //връща елемента на дадена позиция
        //data = [4, 5, 6, 7]
        // size = 4
        //capacity = 6;

        //валидираме дали индексът. който ще достъпим е валиден
        validateIndex(index);
        return this.data[index]; //ако не хвърли грешка имаме валиден индекс
    }

    private  void validateIndex(int index){
        if (index<0 || index >=this.size){
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    public int remove(int index){ //премахва и връща елемента на дадената позиция
        //data = [4, 5, 6, 7]
        // size = 4
        //capacity = 4;

        //валидираме индекса, на който ще премахваме елемент
        validateIndex(index);
        //щом пропускаме метода за валидираме(не хвърля грешка)-> имаме валиден индекс
        // index = 2;
        //data = [4, 5, 7]

        int indexToRemove = this.data[index];//взимаме индекса, който ще премахнем
        //измествам всички елементи с 1 наляво
        for (int position = index; position <this.size -1 ; position++) {
            this.data[position] = this.data[position+1];
        }

        //намаляме капацитета и запълваме до капацитета
        //data = [4, 5, 7]
        // size = 3;
        //capacity = 4;
        this.data[this.size -1] =0;
        this.size--;

        return indexToRemove;
    }

    public boolean contains(int element){ //проверява дали даден елемент е в масива
        //data = [4, 5, 6, 7]
        // size = 4
        //capacity = 6;
        for (int number : this.data) {
            if (number == element){
                return true;
            }
        }

        return false;
    }

    public void add(int element, int index) {
        //data = [4, 5, 6, 7]
        //size = 4
        //capacity = 4;

        //проверка за капацитет на масива
        if (this.size == this.capacity){
            increaseCapacity();
        }

        //измествам всички елементи на дясно
        //element = 10 to index = 2;

        for (int position = this.size-1; position <=index ; position--) {
                this.data[position+1] = this.data[position];
        }
        this.data[index] = element;
        this.size++;

    }

    public void forEach (Consumer<Integer> consumer){ //метод, който преминава през всеки един елемент
        for (int position = 0; position <= this.size -1 ; position++) {
            int currentElement = this.data[position];
            consumer.accept(currentElement);
            
        }
    }





}
