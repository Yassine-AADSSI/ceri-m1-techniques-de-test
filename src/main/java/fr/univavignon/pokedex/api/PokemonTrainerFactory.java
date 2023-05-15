package fr.univavignon.pokedex.api;
/**
 * Cette classe représente Trainer.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory{


    /**
     * Creates and returns a PokemonTrainer instance.
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Used for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory()));
    }
}
