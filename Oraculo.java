package supermariobros;

public class Oraculo extends Personaje {

    public Oraculo(String nombre) {
        super(nombre);
    }

    public String responder(Personaje ald, int opc, int num) {
        String respuesta = new String();
        switch (opc) {
            case 1:
                if (num < ald.getEjeX()) {
                    respuesta = "Si";
                } else {
                    respuesta = "No";
                }
                break;
            case 2:
                if (num > ald.getEjeX()) {
                    respuesta = "Si";
                } else {
                    respuesta = "No";
                }
                break;
            default:
                if (num == ald.getEjeX()) {
                    respuesta = "Si";
                } else {
                    respuesta = "No";
                }

        }
        return respuesta;
    }
}
