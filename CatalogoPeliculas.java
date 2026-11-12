import java.util.List;

public interface CatalogoPeliculas {
    ServicioStreaming getServicio();

    List<String> obtenerPeliculas();
}