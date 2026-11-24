import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestorVideojuego {
    public static final String[] CATEGORIAS =
            {"Acción", "Estrategia", "RPG", "Plataformas", "Simulación"};
    public static final int ANIO_MIN = 1980;
    public static final int VOTOS_INICIALES = 0;
    private final ArrayList<Videojuego> videojuegos = new ArrayList<>();
    private boolean cargaInicialHecha = false;
    public static int anioMax() { return Year.now().getValue(); }
    public void cargarInicial() {

        if (cargaInicialHecha) return;
        videojuegos.add(new Videojuego(2100, "Elden Ring", "FromSoftware", "RPG", 2022, 15));
        videojuegos.add(new Videojuego(2110, "Celeste", "Maddy Makes Games", "PLATAFORMAS", 2018, 9));
        videojuegos.add(new Videojuego(2120, "Age of Empires IV", "Relic Entertainment", "ESTRATEGIA", 2021, 12));
        videojuegos.add(new Videojuego(2130, "Stardew Valley", "ConcernedApe", "SIMULACION", 2016, 25));
        videojuegos.add(new Videojuego(2140, "Doom Eternal", "id Software", "ACCION", 2020, 14));
        videojuegos.add(new Videojuego(2150, "The Witcher 3", "CD Projekt Red", "RPG", 2015, 18));
        videojuegos.add(new Videojuego(2160, "Cuphead", "Studio MDHR", "PLATAFORMAS", 2017, 10));
        videojuegos.add(new Videojuego(2170, "Civilization VI", "Firaxis Games", "ESTRATEGIA", 2016, 7));
        videojuegos.add(new Videojuego(2180, "Cities Skylines II", "Colossal Order", "SIMULACION", 2023, 6));
        videojuegos.add(new Videojuego(2190, "Hades", "Supergiant Games", "ACCION", 2020, 20));
        videojuegos.add(new Videojuego(2200, "Baldurs Gate 3", "Larian Studios", "RPG", 2023, 22));
        videojuegos.add(new Videojuego(2210, "Ori and the Will of the Wisps", "Moon Studios", "PLATAFORMAS", 2020, 11));
        videojuegos.add(new Videojuego(2220, "XCOM 2", "Firaxis Games", "ESTRATEGIA", 2016, 4));
        videojuegos.add(new Videojuego(2230, "Planet Zoo", "Frontier Developments", "SIMULACION", 2019, 8));
        videojuegos.add(new Videojuego(2240, "Sekiro Shadows Die Twice", "FromSoftware", "ACCION", 2019, 13));
        videojuegos.add(new Videojuego(2250, "Cyberpunk 2077", "CD Projekt Red", "RPG", 2020, 16));
        videojuegos.add(new Videojuego(2260, "Super Meat Boy", "Team Meat", "PLATAFORMAS", 2010, 3));
        videojuegos.add(new Videojuego(2270, "StarCraft II", "Blizzard", "ESTRATEGIA", 2010, 5));
        videojuegos.add(new Videojuego(2280, "Microsoft Flight Simulator", "Asobo Studio", "SIMULACION", 2020, 2));
        videojuegos.add(new Videojuego(2290, "Devil May Cry 5", "Capcom", "ACCION", 2019, 17));
        ordenarPorCodigoDescendente();
        cargaInicialHecha = true;
    }

    public List<Videojuego> getVideojuegos() { return Collections.unmodifiableList(videojuegos); }
    public int cantidad() { return videojuegos.size(); }
    public void ordenarPorCodigoDescendente() {
        videojuegos.sort(Comparator.comparingInt(Videojuego::getCodigoID).reversed());
    }

    private void insertarOrdenado(Videojuego v) {
        int pos = 0;
        while (pos < videojuegos.size() && videojuegos.get(pos).getCodigoID() > v.getCodigoID()) pos++;
        videojuegos.add(pos, v);
    }

    private static void validarDatos(String nombre, String estudio, String categoria, int anio) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre es obligatorio.");
        if (estudio == null || estudio.trim().isEmpty())
            throw new IllegalArgumentException("El estudio es obligatorio.");
        boolean ok = false;
        for (String c : CATEGORIAS) if (c.equals(categoria)) ok = true;
        if (!ok) throw new IllegalArgumentException("La categoría no es válida.");
        if (anio < ANIO_MIN || anio > anioMax())
            throw new IllegalArgumentException("El año debe estar entre " + ANIO_MIN + " y " + anioMax() + ".");
    }

    public void registrar(int codigoID, String nombre, String estudio, String categoria, int anio) {
        if (codigoID <= 0) throw new IllegalArgumentException("El código debe ser positivo.");
        validarDatos(nombre, estudio, categoria, anio);
        if (busquedaBinaria(codigoID) != -1)
            throw new IllegalArgumentException("Ya existe un videojuego con el código " + codigoID + ".");
        insertarOrdenado(new Videojuego(codigoID, nombre.trim(), estudio.trim(), categoria, anio, VOTOS_INICIALES));
    }

    public List<Videojuego> buscarPorTexto(String texto) {
        if (texto == null || texto.trim().isEmpty())
            throw new IllegalArgumentException("Ingrese un texto de búsqueda.");
        List<Videojuego> res = new ArrayList<>();
        for (Videojuego v : videojuegos) {
            if (v.getNombre().contains(texto) || v.getEstudio().contains(texto)) res.add(v);
        }
        return res;
    }

    public int busquedaBinaria(int codigoID) {
        int bajo = 0, alto = videojuegos.size() - 1;
        while (bajo <= alto) {
            int medio = (bajo + alto) >>> 1;
            int c = videojuegos.get(medio).getCodigoID();
            if (c == codigoID) return medio;
            if (c > codigoID) bajo = medio + 1;
            else alto = medio - 1;
        }
        return -1;
    }

    public Videojuego buscarPorCodigo(int codigoID) {
        if (codigoID <= 0) throw new IllegalArgumentException("El código debe ser positivo.");
        int idx = busquedaBinaria(codigoID);
        return idx == -1 ? null : videojuegos.get(idx);
    }

    public void editar(int codigoID, String nombre, String estudio, String categoria, int anio) {
        Videojuego v = buscarPorCodigo(codigoID);
        if (v == null) throw new IllegalArgumentException("El videojuego no existe.");
        validarDatos(nombre, estudio, categoria, anio);
        v.setNombre(nombre.trim());
        v.setEstudio(estudio.trim());
        v.setCategoria(categoria);
        v.setAnioLanzamiento(anio);
    }

    public boolean eliminar(int codigoID) {
        if (codigoID <= 0) return false;
        int idx = busquedaBinaria(codigoID);
        if (idx == -1) return false;
        videojuegos.remove(idx);
        return true;
    }

    public int restarVotos(int codigoID, int cantidad) {
        if (cantidad < 1 || cantidad > 3)
            throw new IllegalArgumentException("La cantidad debe estar entre 1 y 3.");
        Videojuego v = buscarPorCodigo(codigoID);
        if (v == null) throw new IllegalArgumentException("Seleccione un videojuego válido.");
        if (v.getVotos() < cantidad)
            throw new IllegalArgumentException("El videojuego solo tiene " + v.getVotos() + " voto(s).");
        v.setVotos(v.getVotos() - cantidad);
        return v.getVotos();
    }

    public List<Videojuego> ranking() {
        List<Videojuego> copia = new ArrayList<>(videojuegos);
        copia.sort(Comparator.comparingInt(Videojuego::getVotos).reversed());
        return copia;
    }
}

