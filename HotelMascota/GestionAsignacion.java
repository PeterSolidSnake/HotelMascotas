public class GestionAsignacion
{
    private Cuidador cuidador;
    private Mascota mascota;
    private boolean disponible;
    
    public GestionAsignacion(){
        
        cuidador = null;
        mascota = null;
        disponible = false;
    }
    
    public GestionAsignacion(Cuidador cuidador, Mascota mascota, boolean disponible) {
        this.cuidador = cuidador;
        this.mascota = mascota;
        this.disponible = disponible;
    }
    
    public Cuidador getCuidador(){
        return cuidador;
    }
    public void setCuidador(Cuidador cuidador){
        this.cuidador = cuidador;
    }
    public Mascota getMascota(){
        return mascota;
    }
    public void setMascota(Mascota mascota){
        this.mascota = mascota;
    }
    public boolean getDisponible(){
        return disponible;
    }
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
    
    @Override
    public String toString(){
        return "GestionAsignacion{" + "cuidador=" + cuidador + ", mascota=" + mascota + ", disponible=" + disponible + "}";
    }
    
    
    //RF4: Asignar cuidador: El sistema debe gestionar la asignacion de cuidadores a las mascotas hospedadas.
    
    public String asignarCuidador ( ){
        
        String resultado = "";
        
        //CASO 1: El cuidador esta disponible y existe la mascota
        if(this.cuidador != null && this.mascota != null && this.disponible == true){
            
            resultado = "El cuidador " + this.cuidador.getNombre() + " " + this.cuidador.getApellido() +
                        " ha sido asignado a la mascota " + this.mascota.getNombre() + " exitosamente.";
            
        }
        
        //CASO 2: El cuidador no esta disponible
        
        else if(this.cuidador != null && this.disponible == false){
            
            resultado = "El cuidador " + this.cuidador.getNombre() + " " + this.cuidador.getApellido() +
                        " no esta disponible en este momento.";
            
        }
        
        //CASO 3: No existe el cuidador
        
        else if(this.cuidador == null){
            
            resultado = "No existe un cuidador registrado para realizar la asignacion.";
            
        }
        
        //CASO 4: No existe la mascota
        
        else if(this.mascota == null){
            
            resultado = "No existe una mascota registrada para realizar la asignacion.";
            
        }
        
        return resultado;
    }
    
    
}