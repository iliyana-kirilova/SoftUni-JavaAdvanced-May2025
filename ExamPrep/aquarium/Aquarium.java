package ExamPrep.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void setFishInPool(List<Fish> fishInPool) {
        this.fishInPool = fishInPool;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(Fish fish){
        Fish foundFishByName = findFish(fish.getName());
        if(foundFishByName == null && fishInPool.size() < capacity){
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name){
        Fish fishToRemove = findFish(name);
        return fishInPool.remove(fishToRemove);
    }

    public Fish findFish(String name) {
        Fish fishToReturn = null;
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishToReturn = fish;
                break;
            }
        }
        return fishToReturn;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", name, size));

        for (Fish fish : fishInPool) {
            sb.append(fish.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }

}
