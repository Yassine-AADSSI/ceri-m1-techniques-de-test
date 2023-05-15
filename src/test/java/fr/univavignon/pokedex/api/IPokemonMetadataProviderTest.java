package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metaData;
    private PokemonMetadata pokemon1;
    private PokemonMetadata pokemon2;

    @Before
    public void setUp() throws PokedexException {
        //metaData = mock(IPokemonMetadataProvider.class);
        metaData = new PokemonMetadataProvider();

        pokemon1 = new PokemonMetadata(0,"Bulbizarre",126,126,90);
        pokemon2 = new PokemonMetadata(133,"Aquali",186,168,260);
    }

    @Test
    public void testMetadata() throws PokedexException {
        assertEquals(metaData.getPokemonMetadata(0).getName(), pokemon1.getName());
        assertEquals(metaData.getPokemonMetadata(133).getDefense(), pokemon2.getDefense());


    }
}
