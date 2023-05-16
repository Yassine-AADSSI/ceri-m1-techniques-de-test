package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IRocketPokemonFactoryTest {
    private IPokemonFactory rocketPokemonFactory;
    private Pokemon pokemon1;

    @Before
    public void setUp() throws PokedexException {
        rocketPokemonFactory = new RocketPokemonFactory();
        pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon rocket = rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(pokemon1.getIndex(), rocket.getIndex());
        assertEquals(pokemon1.getCp(), rocket.getCp());
        assertEquals(pokemon1.getHp(), rocket.getHp());
        assertEquals(pokemon1.getDust(), rocket.getDust());
        assertEquals(pokemon1.getCandy(), rocket.getCandy());

        Pokemon rocket2 = rocketPokemonFactory.createPokemon(-1, 0, 0, 0, 0);
        assertEquals(rocket2.getIndex(), -1);
        assertEquals(rocket2.getName(), "Ash's Pikachu");
        assertEquals(rocket2.getAttack(), 1000);
        assertEquals(rocket2.getDefense(), 1000);
        assertEquals(rocket2.getStamina(), 1000);
        assertEquals(rocket2.getCp(), 0);
        assertEquals(rocket2.getHp(), 0);
        assertEquals(rocket2.getDust(), 0);
        assertEquals(rocket2.getCandy(), 0);
        assertEquals(rocket2.getIv(), 0, 0);
        
        
        
        
        Pokemon missingno = rocketPokemonFactory.createPokemon(1000, 0, 0, 0, 0);
        assertEquals(missingno.getName(), "MISSINGNO");
        
    }

}
