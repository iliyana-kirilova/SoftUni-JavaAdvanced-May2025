package ExamPrep.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String hotelName;
    private int capacity;
    private List<Person> peopleList;

    public Hotel(String hotelName, int capacity) {
        this.hotelName = hotelName;
        this.capacity = capacity;
        this.peopleList = new ArrayList<>();
    }

    public void add (Person person){
        if (this.peopleList.size() < this.capacity){
            this.peopleList.add(person);
        }
    }

    public boolean remove (String name){
        boolean isRemoved = false;
        for (Person person : this.peopleList) {
            if (person.getName().equals(name)){
                this.peopleList.remove(person);
                isRemoved = true;
                break;
            }
        }
        return  isRemoved;
    }

    public Person getPerson(String name, String hometown){
        Person personToReturn = null;
        for (Person person : this.peopleList) {
            if (person.getName().equals(name)&& person.getHometown().equals(hometown)){
                personToReturn = person;
                break;
            }
        }
        return personToReturn;
    }

    public int getCount(){
         return this.peopleList.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.hotelName));
        for (Person person : this.peopleList) {
            sb.append(person.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }




}

