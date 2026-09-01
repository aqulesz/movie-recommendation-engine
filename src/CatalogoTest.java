import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CatalogoTest {

    @Test
    public void buscarPorTituloOLanzar_siNoExiste_lanzaExcepcion() {
        Catalogo catalogo = new Catalogo();

        assertThrows(MovieNotFoundException.class, () -> {
            catalogo.buscarPorTituloOLanzar("PeliculaQueNoExiste");
        });
    }

    @Test
    public void recomendar_superheroes_devuelveOrdenadoPorRatingDescendente() {
        Catalogo catalogo = new Catalogo();

        List<Movie> resultado = catalogo.recomendar(m -> m.getGenre().equals("Superheroes"));

        assertEquals("Batman", resultado.get(0).getTitle());
        assertEquals(2, resultado.size());
    }

    @Test
    public void agregarPelicula_LanzarExcepcionSiEsRatingInvalido() {
        Catalogo catalogo = new Catalogo();

        assertThrows(InvalidRatingException.class, () -> {
            catalogo.agregarPelicula(new Movie("Monster Inc.", "Kids", 2007, 15));
        });
    }
}
