package supermariobros;

import java.util.Random;

public class Aldeano extends Personaje {

    private String camisa;
    private String pantalon;
    private String gorro;
    private char letra;

    public Aldeano(String nombre, String camisa, String pantalon, String gorro, char letra) {
        super(nombre);
        this.camisa = camisa;
        this.pantalon = pantalon;
        this.gorro = gorro;
        this.letra = letra;
    }

    public Aldeano(String nombre, String camisa, String pantalon, String gorro, char letra, int ejeX, int ejeY, String orientacion) {
        super(nombre, ejeX, ejeY, orientacion);
        this.camisa = camisa;
        this.pantalon = pantalon;
        this.gorro = gorro;
        this.letra = letra;
    }

    public String getCamisa() {
        return camisa;
    }

    public void setCamisa(String camisa) {
        this.camisa = camisa;
    }

    public String getPantalon() {
        return pantalon;
    }

    public void setPantalon(String pantalon) {
        this.pantalon = pantalon;
    }

    public String getGorro() {
        return gorro;
    }

    public void setGorro(String gorro) {
        this.gorro = gorro;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String lanzarMoneda() {
        String respuesta = new String();
        Random moneda = new Random();
        if (moneda.nextInt(2) == 1) {
            respuesta = "Cruz";
        } else {
            respuesta = "Cara";
        }
        return respuesta;
    }

    @Override
    public String toString() {
        return super.toString() + ", Camisa: " + camisa + ", Pantalon: " + pantalon + ", Gorro: " + gorro + ", Letra: " + letra;
    }

}
