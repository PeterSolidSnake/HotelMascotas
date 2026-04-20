public class Persona
{

    private String nombre;
    private String apellido;
    private int nuip;
    
    public Persona(){
        
        nombre = null;
        apellido = null;
        nuip = 0;
    }
    
    public Persona(String nombre, String apellido, int nuip) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nuip = nuip;
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNuip() {
        return nuip;
    }

    public void setNuip(int nuip) {
        this.nuip = nuip;
    }
    
     @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", nuip=" + nuip + "}";
    }
}