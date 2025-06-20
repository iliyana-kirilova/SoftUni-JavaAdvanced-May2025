package ExamPrep.vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive){
        if (this.locomotives.size()>= this.capacity){
            System.out.println("This train station is full!");
            return;
        }

        if (this.railGauge != locomotive.getGauge()){
            int diff = Math.abs(this.railGauge - locomotive.getGauge());
            System.out.println("The rail gauge of this station does not match the locomotive gauge! Difference: " + diff + " mm.");
            return;
        }

        this.locomotives.add(locomotive);
    }

    public boolean removeLocomotive(String name){
        for (Locomotive locomotive : this.locomotives) {
            if (locomotive.getName().equals(name)) {
                this.locomotives.remove(locomotive);
                return true;
            }
        }

        return false;
    }

    public String getFastestLocomotive(){
        if (this.locomotives.size()<=0){
            return "There are no locomotives.";
        }

        int fastestLocomotive = 0;
        Locomotive fastestSpeedLoco = null;

        for (Locomotive locomotive : this.locomotives) {
            if (locomotive.getMaxSpeed()> fastestLocomotive){
                fastestLocomotive= locomotive.getMaxSpeed();
                fastestSpeedLoco = locomotive;

            }
        }

        return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.",
                                fastestSpeedLoco.getName(), fastestSpeedLoco.getMaxSpeed());
    }

    public Locomotive getLocomotive(String name){
        for (Locomotive locomotive : this.locomotives) {
            if (locomotive.getName().equals(name)){
                return locomotive;
            }
        }

        return null;
    }

    public int getCount(){
        return this.locomotives.size();
    }

    public String getOldestLocomotive(){
        if (this.locomotives.isEmpty()) {
            return "There are no locomotives.";
        }

        Locomotive oldest = locomotives.stream()
                .min(Comparator.comparing(Locomotive::getBuildDate))
                .orElse(null);

        return oldest.getName();
    }


    public String getStatistics(){
        if (this.locomotives.isEmpty()) {
            return "There are no locomotives departing from " + this.name + " station.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Locomotives departed from ").append(this.name).append(":\n");
        for (int i = 0; i < this.locomotives.size(); i++) {
            sb.append(i + 1).append(". ").append(this.locomotives.get(i).getName()).append("\n");
        }

        return sb.toString().trim();
    }
}
