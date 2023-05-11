package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokedexFactory iPokedexFactory;
    private IPokemonMetadataProvider iPokemonMetadataProvider;
    private IPokemonFactory iPokemonFactory;
    private IPokedex pokedex;

    @Before
    public void init() {

        //iPokedexFactory = mock(IPokedexFactory.class) ;
        IPokedexFactory iPokedexFactory = new PokedexFactory();

        //iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonMetadataProvider iPokemonMetadataProvider = new PokemonMetadataProvider();

        IPokemonFactory iPokemonFactory = new PokemonFactory();
        //iPokemonFactory = mock(IPokemonFactory.class);

        //pokedex = mock(IPokedex.class);
        IPokedex pokedex = new Pokedex(iPokemonFactory, iPokemonMetadataProvider);
        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory)).thenReturn(pokedex);

    }

    @Test
    public void createPokedex() {
        assertEquals(iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory), pokedex);
    }


}
