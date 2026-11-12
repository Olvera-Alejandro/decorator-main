public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Ana");
        usuario.activarSuscripcion(ServicioStreaming.DISNEY);
        usuario.activarSuscripcion(ServicioStreaming.WARNER);
 
        CatalogoPeliculas disney = new SuscripcionDecorator(new CatalogoDisney(), usuario);
        CatalogoPeliculas paramount = new SuscripcionDecorator(new CatalogoParamount(), usuario);
        CatalogoPeliculas warner = new SuscripcionDecorator(new CatalogoWarner(), usuario);
 
        consultar(disney);
        consultar(paramount);
        consultar(warner);
 
        System.out.println("\n--- Activando Paramount ---");
        usuario.activarSuscripcion(ServicioStreaming.PARAMOUNT);
        consultar(paramount);
    }
 
    private static void consultar(CatalogoPeliculas catalogo) {
        String servicio = catalogo.getServicio().getNombre();
        try {
            System.out.println("Acceso permitido a " + servicio + ": " + catalogo.obtenerPeliculas());
        } catch (IllegalStateException e) {
            System.out.println("Acceso denegado: " + e.getMessage());
        }
    }
}
 