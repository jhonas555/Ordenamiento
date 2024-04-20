package Logico;

import java.util.Objects;

public class Ubicacion {

	   private String nombre; // Nombre de la ubicaci�n
	    private double coordenadaX; // Coordenada X de la ubicaci�n
	    private double coordenadaY; // Coordenada Y de la ubicaci�n


	    public Ubicacion(String nombre, double coordenadaX, double coordenadaY) {
	        this.nombre = nombre;
	        this.coordenadaX = coordenadaX;
	        this.coordenadaY = coordenadaY;
	    }


	     // Obtiene el nombre de la ubicaci�n.

	    public String getNombre() {
	        return nombre;
	    }


	     // Establece el nombre de la ubicaci�n.
	    

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	     // Obtiene la coordenada X de la ubicaci�n.

	    public double getCoordenadaX() {
	        return coordenadaX;
	    }


	     // Establece la coordenada X de la ubicaci�n.

	    public void setCoordenadaX(double coordenadaX) {
	        this.coordenadaX = coordenadaX;
	    }


	     // Obtiene la coordenada Y de la ubicaci�n.

	    public double getCoordenadaY() {
	        return coordenadaY;
	    }


	    // Establece la coordenada Y de la ubicaci�n.

	    public void setCoordenadaY(double coordenadaY) {
	        this.coordenadaY = coordenadaY;
	    }

	     // Calcula la distancia euclidiana entre la ubicaci�n actual y otra ubicaci�n dada.

	    public double calcularDistancia(Ubicacion otraUbicacion) {
	        double dx = this.coordenadaX - otraUbicacion.coordenadaX;
	        double dy = this.coordenadaY - otraUbicacion.coordenadaY;
	        return Math.sqrt(dx * dx + dy * dy);
	    }

	    public String toString() {
	        return "Ubicacion{" +
	                "nombre='" + nombre + '\'' +
	                ", coordenadaX=" + coordenadaX +
	                ", coordenadaY=" + coordenadaY +
	                '}';
	    }

	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Ubicacion otraUbicacion = (Ubicacion) obj;
	        return Double.compare(otraUbicacion.coordenadaX, coordenadaX) == 0 &&
	                Double.compare(otraUbicacion.coordenadaY, coordenadaY) == 0 &&
	                Objects.equals(nombre, otraUbicacion.nombre);
	    }



	    public int hashCode() {
	        return Objects.hash(nombre, coordenadaX, coordenadaY);
	    }
}
