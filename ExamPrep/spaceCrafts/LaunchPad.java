package ExamPrep.spaceCrafts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public void addSpacecraft(Spacecraft spacecraft){
        if (this.spacecrafts.size()>=this.capacity){
            System.out.println("This launchpad is at full capacity!");
            return;
        }

        this.spacecrafts.add(spacecraft);
    }

    public boolean removeSpacecraft(String name){
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getName().equals(name)) {
                this.spacecrafts.remove(spacecraft);
                return true;
            }
        }
        return false;
    }

    public String getHeaviestSpacecraft(){
        if (this.spacecrafts.size()<=0){
            return null;
        }

        int heaviestSpaceCraft = 0;
        Spacecraft maxSpaceCraft = null;
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getWeight()>heaviestSpaceCraft) {
                heaviestSpaceCraft = spacecraft.getWeight();
                maxSpaceCraft = spacecraft;
            }
        }

        return String.format("%s - %dkg.", maxSpaceCraft.getName(), maxSpaceCraft.getWeight());
    }

    public Spacecraft getSpacecraft(String name){
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getName().equals(name)) {
                return spacecraft;
            }
        }
        return null;
    }

    public int getCount(){
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType){
        /*List<Spacecraft> result = new ArrayList<>();
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getMissionType().equals(missionType)) {
                result.add(spacecraft);
            }
        }*/
        List<Spacecraft> resultList = this.spacecrafts.stream().
                filter(spaceCraft-> spaceCraft.getMissionType().equals(missionType)).
                collect(Collectors.toList());

        if (resultList.isEmpty()){
            System.out.println("There are no spacecrafts to respond this criteria.");
        }

        return resultList;
    }

    public String getStatistics(){
        if (this.spacecrafts.isEmpty()){
            return "Spacecrafts launched from " + this.name + ":\n" + "none";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Spacecrafts launched from ").append(this.name).append(":\n");
        for (int i = 0; i < this.spacecrafts.size(); i++) {
            sb.append(i + 1).append(". ").append(this.spacecrafts.get(i).getName()).append("\n");
        }

        return sb.toString().trim();
    }


}

