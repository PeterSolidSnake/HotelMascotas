public class Cuidador extends Persona{
   
    private int codigoCuidador;
    private String especialidad;
    
    public Cuidador(){
        
        super();
        codigoCuidador = 0;
        especialidad = null;
    }
    
    public Cuidador(String nombre, String apellido, int nuip, int codigoCuidador, String especialidad) {
        super(nombre, apellido, nuip);
        this.codigoCuidador = codigoCuidador;
        this.especialidad = especialidad;
    }
    
    public int getCodigoCuidador() {
        return codigoCuidador;
    }
    public void setCodigoCuidador(int codigoCuidador) {
        this.codigoCuidador = codigoCuidador;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return "Cuidador{" + "nombre=" + getNombre() + ", apellido=" + getApellido() + ", nuip=" + getNuip() + ", codigoCuidador=" + codigoCuidador + ", especialidad=" + especialidad + "}";
    }
}
    
