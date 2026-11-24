public class Videojuego {
public int codigoID;
public String nombre;
public String estudio;
public String categoria;
public int anioLanzamiento;
public int votos;

    public Videojuego(int codigoID, String nombre, String estudio, String categoria, int anioLanzamiento, int votos) {
        this.codigoID = codigoID;
        this.nombre = nombre;
        this.estudio = estudio;
        this.categoria = categoria;
        this.anioLanzamiento = anioLanzamiento;
        this.votos = votos;
    }

    public int getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(int codigoID) {
        this.codigoID = codigoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return  codigoID + "|" + nombre + "|" + estudio + "|" + categoria + "|" + anioLanzamiento + "|" + votos;
    }
}
