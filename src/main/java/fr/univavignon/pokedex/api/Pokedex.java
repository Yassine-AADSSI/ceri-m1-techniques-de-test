package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Cette classe représente un Pokedex.
 * Un Pokedex est utilisé pour enregistrer et gérer les informations sur les Pokémon.
 */
public class Pokedex implements IPokedex{

    /*
     * List of pokemons.
     */
    private List<Pokemon> pokemons = new ArrayList<>();;
    /*
     * Factory used to create pokemons.
     */
    private IPokemonFactory pokemonFactory;
    /*
     * Provider used to get pokemon metadata.
     */
    private IPokemonMetadataProvider pokemonMetadataProvider;
    /**
     * Constructor.
     * @param pokemonFactory L'instance de l'interface IPokemonFactory utilisée pour créer des instances de Pokémon.
     * @param pokemonMetadataProvider L'instance de l'interface IPokemonMetadataProvider utilisée pour fournir des métadonnées sur les Pokémon.
     *
     */
    public Pokedex(IPokemonFactory pokemonFactory, IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemons = new ArrayList<>();;
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }


    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Invalid index: " + id);

    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return Collections.unmodifiableList(sortedPokemons);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp,dust, candy);
    }


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
