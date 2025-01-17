package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    IPokedex iPokedex;

    Pokemon pokemon1;
    Pokemon pokemon2;
    List<Pokemon> pokemons = new ArrayList<>();
    List<Pokemon> pokemonsList;
    Comparator<Pokemon> orderByDefense = Comparator.comparing(Pokemon::getDefense);

    @Before
    public void init() throws PokedexException {

        iPokedex = new Pokedex(new PokemonFactory(), new PokemonMetadataProvider());

        pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void addPokemon() {
        iPokedex.addPokemon(pokemon1);
        iPokedex.addPokemon(pokemon2);
        assertEquals(iPokedex.addPokemon(pokemon1), 0);
        assertEquals(iPokedex.addPokemon(pokemon2), 133);
    }

    @Test
    public void getPokemon() throws PokedexException {
        iPokedex.addPokemon(pokemon1);
        iPokedex.addPokemon(pokemon2);
        assertEquals(iPokedex.getPokemon(0), pokemon1);
        assertEquals(iPokedex.getPokemon(133), pokemon2);
        assertThrows(PokedexException.class, () -> {
            iPokedex.getPokemon(-1);
        });
    }


    @Test
    public void shouldReturnSize()
    {
        iPokedex.addPokemon(pokemon1);
        iPokedex.addPokemon(pokemon2);
        assertEquals(iPokedex.size(), 2);
    }

    @Test
    public void getPockemons(){
        iPokedex.addPokemon(pokemon1);
        iPokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = iPokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(iPokedex.getPokemons().contains(pokemon1));
        assertTrue(iPokedex.getPokemons().contains(pokemon2));
    }


    @Test
    public void testOrderPokemons(){


        iPokedex.addPokemon(pokemon2);
        iPokedex.addPokemon(pokemon1);
        Comparator<Pokemon> orderByDefense = Comparator.comparing(Pokemon::getDefense);
        List<Pokemon> list = iPokedex.getPokemons(orderByDefense);


        // Vérification que la liste retournée est triée par ordre croissant de défense
        List<Pokemon> expected = Arrays.asList(pokemon1, pokemon2);
        assertEquals(expected, list);

        List<Pokemon> pokemons = iPokedex.getPokemons();
        assertEquals(pokemons, iPokedex.getPokemons(PokemonComparators.NAME));
    }
    @Test
    public void testGetPokemonMetadata() throws PokedexException{
        iPokedex.addPokemon(pokemon1);
        PokemonMetadata pokemonMetadata = iPokedex.getPokemonMetadata(0);
        assertEquals(pokemonMetadata.getIndex(),pokemon1.getIndex());
        assertEquals(pokemonMetadata.getName(),pokemon1.getName());
        assertEquals(pokemonMetadata.getDefense(),pokemon1.getDefense());
        assertEquals(pokemonMetadata.getAttack(),pokemon1.getAttack());
        assertEquals(pokemonMetadata.getStamina(),pokemon1.getStamina());
        assertEquals(iPokedex.getPokemonMetadata(0).getName(), pokemon1.getName());

    }


    @Test
    public void testCreatePokemon() throws PokedexException{
        Pokemon pokemon = iPokedex.createPokemon(0,613,64,4000,4);
        assertEquals(pokemon.getIndex(),pokemon1.getIndex());
        assertEquals(pokemon.getCp(),pokemon1.getCp());
        assertEquals(pokemon.getHp(),pokemon1.getHp());
        assertEquals(pokemon.getDust(),pokemon1.getDust());
        assertEquals(pokemon.getCandy(),pokemon1.getCandy());

        assertEquals(0, 0,iPokedex.createPokemon(0, 613,64,4000,4).getIv());
        assertEquals(613,iPokedex.createPokemon(0, 613,64,4000,4).getCp());
        assertEquals(0,iPokedex.createPokemon(0, 613,64,4000,4).getIndex());

    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        iPokedex.getPokemonMetadata(-1);
    }






}
