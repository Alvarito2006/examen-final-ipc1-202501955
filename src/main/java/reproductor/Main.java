package reproductor;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        Cancion cancionUno = new Cancion("Luz de ciudad", 210, "Aurora Norte");
        Cancion cancionDos = new Cancion("Camino al sol", 185, "Linea Azul");
        Cancion cancionTres = new Cancion("Noche clara", 240, "Puerto Luna");

        playlist.agregarCancion(cancionUno);
        playlist.agregarCancion(cancionDos);
        playlist.agregarCancion(cancionTres);

        System.out.println();
        playlist.mostrarPlaylist();
    }
}

