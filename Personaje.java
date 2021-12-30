package supermariobros;

public abstract class Personaje {

    protected String nombre;
    protected int ejeX;
    protected int ejeY;
    protected String orientacion;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.ejeX = 0;
        this.ejeY = 0;
        this.orientacion = "Derecha";
    }

    public Personaje(String nombre, int ejeX, int ejeY, String orientacion) {
        this.nombre = nombre;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.orientacion = orientacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEjeX() {
        return ejeX;
    }

    public void setEjeX(int ejeX) {
        this.ejeX = ejeX;
    }

    public int getEjeY() {
        return ejeY;
    }

    public void setEjeY(int ejeY) {
        this.ejeY = ejeY;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String saludar() {
        return "Hola, soy " + this.getNombre() + "!";
    }

    public String mostrarUbicacion() {
        return this.getNombre() + " Esta orientado hacia la " + this.getOrientacion()
                + " y se encuentra en la posicion (" + this.getEjeX() + "," + this.getEjeX() + ").";
    }

    public void girar() {
        if (this.getOrientacion().equals("Derecha")) {
            this.setOrientacion("Izquierda");
        } else {
            this.setOrientacion("Derecha");
        }
    }

    public void moverse() {
        if (this.orientacion.equals("Derecha") && (this.ejeX < 51)) {
            this.ejeX++;
        } else if (this.ejeX > (-51)) {
            this.ejeX--;
        }
    }

    @Override
    public String toString() {
        return "Personaje:" + " Nombre: " + nombre;
    }

}
