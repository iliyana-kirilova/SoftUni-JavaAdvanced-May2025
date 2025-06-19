package tanks;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.tanks = new ArrayList<>();
        this.area = area;
    }

    public String addTank(Tank tank) {
        for (Tank entry : this.tanks) {
            if (entry.getBrand().equals(tank.getBrand()) &&
                    entry.getModel().equals(tank.getModel())) {
                return "Tank with this brand and model already exists!";
            }
        }

        if (this.type.equals("Swamp") && tank.getWeight() > 14000) {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        }

        this.tanks.add(tank);
        return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
    }

    public  boolean removeTank(String brand, String model){
        for (Tank tank : this.tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                this.tanks.remove(tank);
                return true;
            }
        }

        return false;
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber){
        List<String> searchedTanks = new ArrayList<>();
        for (Tank tank : this.tanks) {
            if (tank.getBarrelCaliber()>barrelCaliber){
                searchedTanks.add(tank.getBrand());
            }
        }

        if (!searchedTanks.isEmpty()){
            String printSearchedTanks = String.join(", ", searchedTanks);
             return String.format("Tanks with caliber more than %dmm: %s", barrelCaliber, printSearchedTanks);
        }

        return "There are no tanks with the specified caliber.";
    }

    public Tank getTankByBrandAndModel(String brand, String model){
        for (Tank tank : this.tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                return tank;
            }
        }
        return null;
    }

    public String getTheMostArmoredTank(){
        if (this.tanks.size()<=0){
            return null;
        }

        int mostArmoredTank = 0;
        Tank mostArmored = null;

        for (Tank tank : this.tanks) {
            if (tank.getArmor()>mostArmoredTank){
                mostArmoredTank = tank.getArmor();
                mostArmored = tank;
            }
        }

        return String.format("%s %s is the most armored tank with %dmm. armor thickness.",
                                mostArmored.getBrand(), mostArmored.getModel(), mostArmored.getArmor());
    }

    public int getCount(){
        return this.tanks.size();
    }

    public String getStatistics(){
        if (this.tanks.isEmpty()) {
            return String.format("There are no tanks in the %s.", type.toLowerCase());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tanks located in the %s:%n", this.type.toLowerCase()));
        for (Tank tank : this.tanks) {
            sb.append(String.format("-- %s %s%n", tank.getBrand(), tank.getModel()));
        }
        return sb.toString().trim();
    }

}
