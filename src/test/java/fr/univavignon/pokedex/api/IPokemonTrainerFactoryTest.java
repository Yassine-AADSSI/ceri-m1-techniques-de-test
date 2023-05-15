package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex iPokedex;
    private PokemonTrainer pokemonTrainer;


    @Before
    public void setUp() throws PokedexException {
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        iPokedex = mock(IPokedex.class);
        pokemonTrainer = new PokemonTrainer("yassine", Team.MYSTIC, iPokedex);

        when(pokemonTrainerFactory.createTrainer("yassine", Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void testCreateTrainer() throws PokedexException {
        assertEquals(pokemonTrainer, pokemonTrainerFactory.createTrainer("yassine", Team.MYSTIC, pokedexFactory));
        assertEquals("yassine", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertEquals(iPokedex, pokemonTrainer.getPokedex());
    }




}
