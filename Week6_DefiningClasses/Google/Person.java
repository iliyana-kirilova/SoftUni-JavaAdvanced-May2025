package Week6_DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;


    public Person(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParent(Parents parent) {
        this.parentsList.add(parent);
    }

    public void addChild(Children child) {
        this.childrenList.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n");
        sb.append("Company:\n");
        if (company != null) {
            sb.append(company.toString()).append("\n");
        }
        sb.append("Car:\n");
        if (car !=null){
            sb.append(car.toString()).append("\n");
        }
        sb.append("Pokemon:\n");
        if (!pokemonList.isEmpty()){
            for (Pokemon pokemon : pokemonList) {
                sb.append(pokemon.toString()).append("\n");
            }
        }
        sb.append("Parents:\n");
        if (!parentsList.isEmpty()){
            for (Parents parent : parentsList) {
                sb.append(parent.toString()).append("\n");
            }
        }
        sb.append("Children:\n");
        if (!childrenList.isEmpty()){
            for (Children child : childrenList) {
                sb.append(child.toString()).append("\n");
            }
        }

        return sb.toString();
    }

}
