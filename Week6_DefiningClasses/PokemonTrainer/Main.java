package Week6_DefiningClasses.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int badges = 0;
        Map<String , Trainer> trainerMap = new LinkedHashMap<>();

        while (!command.equals("Tournament")){
            String trainerName = command.split("\\s+")[0];
            String pokemonName = command.split("\\s+")[1];
            String pokemonElement = command.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(command.split("\\s+")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainerMap.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName,badges, new ArrayList<>());
                trainer.addPokemon(pokemon);
                trainerMap.put(trainerName, trainer);
            } else {
                Trainer trainer = trainerMap.get(trainerName);
                trainer.addPokemon(pokemon);
            }
            command = scanner.nextLine();
        }

        String action = scanner.nextLine();
        while (!action.equals("End")){
            for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
                Trainer currentTrainer = entry.getValue();

                boolean hasElement = false;
                for (Pokemon pokemon : currentTrainer.getPokemonList()) {
                    if (pokemon.getPokemonElement().equals(action)) {
                        hasElement = true;
                        break;
                    }

                }

                switch (action){
                    case "Fire":{
                        actionToDo(currentTrainer, hasElement);
                        break;
                    }
                    case "Water":{
                        actionToDo(currentTrainer, hasElement);
                        break;
                    }
                    case "Electricity":{
                        actionToDo(currentTrainer, hasElement);
                        break;
                    }
                }
            }
            action = scanner.nextLine();
        }

        trainerMap.values().stream().sorted((trainer1, trainer2)->
            //Integer.compare(a,b) сравнява две стойности и връща като Comparator
            Integer.compare(trainer2.getBadges(), trainer1.getBadges()))
            .forEach(trainer -> {
            System.out.printf("%s %d %d%n", trainer.getTrainerName(), trainer.getBadges(), trainer.getPokemonList().size());
        });
    }

    private static void actionToDo(Trainer currentTrainer, boolean hasElement) {
        if (hasElement){
            currentTrainer.setBadges(currentTrainer.getBadges()+1);
        } else {//Ако няма - намаля здравето на всички покемони с 10 и премахни покемони с 0 или по-малко живот
            currentTrainer.getPokemonList().removeIf(pokemon -> {
                pokemon.setPokemonHealth(pokemon.getPokemonHealth() -10);
                return pokemon.getPokemonHealth()<=0;
            });
        }
    }
}
