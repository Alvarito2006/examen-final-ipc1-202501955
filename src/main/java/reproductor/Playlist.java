package reproductor;

public class Playlist {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private NodoDoble actual;
    private int tamanio;

    public void agregarCancion(Cancion cancion) {
        NodoDoble nuevo = new NodoDoble(cancion);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }

        tamanio++;
        System.out.println("Cancion agregada: " + cancion.getTitulo());
    }

    public void mostrarPlaylist() {
        if (cabeza == null) {
            System.out.println("La playlist esta vacia.");
            return;
        }

        System.out.println("Playlist (" + tamanio + " canciones):");
        NodoDoble auxiliar = cabeza;
        int posicion = 1;

        while (auxiliar != null) {
            Cancion cancion = auxiliar.getCancion();
            String marcaActual = auxiliar == actual ? " <- actual" : "";
            System.out.println(posicion + ". " + cancion.getTitulo() + " - "
                    + cancion.getArtista() + " (" + cancion.getDuracion()
                    + " segundos)" + marcaActual);

            auxiliar = auxiliar.getSiguiente();
            posicion++;
        }
    }

    public NodoDoble getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDoble cabeza) {
        this.cabeza = cabeza;
    }

    public NodoDoble getCola() {
        return cola;
    }

    public void setCola(NodoDoble cola) {
        this.cola = cola;
    }

    public NodoDoble getActual() {
        return actual;
    }

    public void setActual(NodoDoble actual) {
        this.actual = actual;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}

