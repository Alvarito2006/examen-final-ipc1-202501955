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

    public Cancion siguiente() {
        if (actual == null) {
            System.out.println("No hay canciones en la playlist.");
            return null;
        }

        if (actual.getSiguiente() == null) {
            System.out.println("No hay siguiente cancion. Se mantiene la actual.");
            actual.getCancion().reproducir();
            return null;
        }

        actual = actual.getSiguiente();
        actual.getCancion().reproducir();
        return actual.getCancion();
    }

    public Cancion anterior() {
        if (actual == null) {
            System.out.println("No hay canciones en la playlist.");
            return null;
        }

        if (actual.getAnterior() == null) {
            System.out.println("No hay cancion anterior. Se mantiene la actual.");
            actual.getCancion().reproducir();
            return null;
        }

        actual = actual.getAnterior();
        actual.getCancion().reproducir();
        return actual.getCancion();
    }

    public void eliminarActual() {
        if (actual == null) {
            System.out.println("No hay una cancion actual para eliminar.");
            return;
        }

        NodoDoble nodoEliminado = actual;
        NodoDoble nodoAnterior = nodoEliminado.getAnterior();
        NodoDoble nodoSiguiente = nodoEliminado.getSiguiente();

        if (nodoAnterior != null) {
            nodoAnterior.setSiguiente(nodoSiguiente);
        } else {
            cabeza = nodoSiguiente;
        }

        if (nodoSiguiente != null) {
            nodoSiguiente.setAnterior(nodoAnterior);
        } else {
            cola = nodoAnterior;
        }

        if (nodoSiguiente != null) {
            actual = nodoSiguiente;
        } else {
            actual = nodoAnterior;
        }

        nodoEliminado.setAnterior(null);
        nodoEliminado.setSiguiente(null);
        tamanio--;

        System.out.println("Cancion eliminada: " + nodoEliminado.getCancion().getTitulo());
        if (actual != null) {
            System.out.print("Actual despues de eliminar: ");
            actual.getCancion().reproducir();
        } else {
            System.out.println("La playlist quedo vacia.");
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
