package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IPokemonFactoryTest {
    private IPokemonFactory iPokemonFactory;

    @Before
    public void init() {
        iPokemonFactory = new PokemonFactory();
    }

    @Test
    public void createPokemon() throws PokedexException {

        assertEquals(613,iPokemonFactory.createPokemon(0, 613,64,4000,4).getCp());
        assertEquals(0, iPokemonFactory.createPokemon(0, 613,64,4000,4).getIndex());
    }
}