package Week6_DefiningClasses.PokemonTrainer;

import java.util.List;

public class Trainer {
    private String trainerName;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String trainerName, int badges, List<Pokemon> pokemonList) {
        this.trainerName = trainerName;
        this.badges = 0;
        this.pokemonList = pokemonList;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public String getTrainerName() {
        return this.trainerName;
    }

    public int getBadges() {
        return this.badges;
    }

    public List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }


}
