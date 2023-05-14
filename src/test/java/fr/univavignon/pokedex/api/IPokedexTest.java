package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    IPokedex iPokedex;
    IPokemonFactory iPokemonFactory;
    IPokemonMetadataProvider iPokemonMetadataProvider;
    Pokemon pokemon1;
    Pokemon pokemon2;
    List<Pokemon> pokemons = new ArrayList<>();
    List<Pokemon> pokemonsList;
    Comparator<Pokemon> orderByDefense = Comparator.comparing(Pokemon::getDefense);

    @Before
    public void init() throws PokedexException {
        iPokemonFactory = new PokemonFactory();
        iPokemonMetadataProvider = new PokemonMetadataProvider();

        iPokedex = new Pokedex(iPokemonFactory, iPokemonMetadataProvider);

        pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    }

    @Test
    public void addPokemon() {
        assertEquals(iPokedex.addPokemon(pokemon1), 0);
        assertEquals(iPokedex.addPokemon(pokemon2), 1);
    }

    @Test
    public void getPokemon() throws PokedexException {
        assertEquals(iPokedex.getPokemon(0), pokemon1);
        assertEquals(iPokedex.getPokemon(1), pokemon2);
    }

    @Test
    public void shouldReturnSize()
    {
        assertEquals(iPokedex.size(), 2);
    }

    @Test
    public void getPockemons(){
        assertEquals(iPokedex.getPokemons(), pokemons);
        assertTrue(iPokedex.getPokemons().contains(pokemon1));
        assertTrue(iPokedex.getPokemons().contains(pokemon2));
    }


    @Test
    public void testOrderPokemons(){
        // Appel de la méthode getPokemons avec un tri par défense
        List<Pokemon> sortedByDefense = iPokedex.getPokemons();

        // Vérification que la liste retournée est triée par ordre croissant de défense
        List<Pokemon> expected = Arrays.asList(pokemon1, pokemon2);
        assertEquals(expected, sortedByDefense);
    }





}
