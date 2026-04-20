public class Mascota{
    
    private String nombre;
    private String raza;
    private int edad;
    private boolean necesidadEspecial;
    
    public Mascota(){   
        nombre = null;
        raza = null;
        edad = 0;
        necesidadEspecial = false; 
    }
    
    public Mascota(String nombre, String raza, int edad, boolean necesidadEspecial){
        
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.necesidadEspecial = necesidadEspecial;
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getRaza(){
        return this.raza;
    }
    public void setRaza(String raza){
        this.raza = raza;
    }
    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public boolean getNecesidadEspecial(){
        return this.necesidadEspecial;
    }
    public void setNecesidadEspecial(boolean necesidadEspecial){
        this.necesidadEspecial = necesidadEspecial;
    }
    
    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", necesidadEspecial=" + necesidadEspecial + "}";
    }
}