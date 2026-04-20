public class Reserva
{
    private Fecha fecha;
    private int duracionEstadia;
    private boolean alimentoEspecial;
    private boolean paseo;
    private boolean bano;
    private Cuidador cuidador;
    
    public Reserva(){
        
        fecha = null;
        duracionEstadia = 0;
        alimentoEspecial = false;
        paseo = false;
        bano = false;
        cuidador = null;
    }
    
    public Reserva(Fecha fecha, int duracionEstadia, boolean alimentoEspecial, boolean paseo, boolean bano, Cuidador cuidador) {
        this.fecha = fecha;
        this.duracionEstadia = duracionEstadia;
        this.alimentoEspecial = alimentoEspecial;
        this.paseo = paseo;
        this.bano = bano;
        this.cuidador = cuidador;
    }
    
    public Fecha getFecha(){
        return fecha;
    }
    public void setFecha(Fecha fecha){
        this.fecha = fecha;
    }
    public int getDuracionEstadia(){
        return duracionEstadia;
    }
    public void setDuracionEstadia(int duracionEstadia){
        this.duracionEstadia = duracionEstadia;
    }
    public boolean getAlimentoEspecial(){
        return alimentoEspecial;
    }
    public void setAlimentoEspecial(boolean alimentoEspecial){
        this.alimentoEspecial = alimentoEspecial;
    }
    public boolean getPaseo(){
        return paseo;
    }
    public void setPaseo(boolean paseo){
        this.paseo = paseo;
    }
    public boolean getBano(){
        return bano;
    }
    public void setBano(boolean bano){
        this.bano = bano;
    }
    public Cuidador getCuidador(){
        return cuidador;
    }
    public void setCuidador(Cuidador cuidador){
        this.cuidador = cuidador;
    }
    
    @Override
    public String toString(){
        return "Reserva{" + "fecha=" + fecha + ", duracionEstadia=" + duracionEstadia + ", alimentoEspecial=" + alimentoEspecial + ", paseo=" + paseo + ", bano=" + bano + ", cuidador=" + cuidador + "}";
    }
    
    
    //RF2: Reservar estadia: El sistema debe permitir la reserva de estadias indicando fechas y servicios requeridos.
    
    public String mostrarServicios (){
        
        String servicios = "";
        
        //CASO 1: Tiene los 3 servicios adicionales
        if(this.alimentoEspecial == true && this.paseo == true && this.bano == true){
            
            servicios = "Los servicios de la reserva son: Alimento Especial, Paseo y Baño. \n" +
                        "Duracion de la estadia: " + this.duracionEstadia + " dias. \n" +
                        "Fecha de ingreso: " + this.fecha.toString();
            
        }
        
        //CASO 2: Tiene 2 servicios adicionales
        
        else if(this.alimentoEspecial == true && this.paseo == true){
            
            servicios = "Los servicios de la reserva son: Alimento Especial y Paseo. \n" +
                        "Duracion de la estadia: " + this.duracionEstadia + " dias. \n" +
                        "Fecha de ingreso: " + this.fecha.toString();
            
        } else if(this.alimentoEspecial == true && this.bano == true){
            
            servicios = "Los servicios de la reserva son: Alimento Especial y Baño. \n" +
                        "Duracion de la estadia: " + this.duracionEstadia + " dias. \n" +
                        "Fecha de ingreso: " + this.fecha.toString();
            
        } else if(this.paseo == true && this.bano == true){
            
            servicios = "Los servicios de la reserva son: Paseo y Baño. \n" +
                        "Duracion de la estadia: " + this.duracionEstadia + " dias. \n" +
                        "Fecha de ingreso: " + this.fecha.toString();
            
        }
        
        //CASO 3: Tiene 1 servicio adicional
        
        else if(this.alimentoEspecial == true){
            
            servicios = "Los servicios de la reserva son: Alimento Especial. \n" +
                        "Duracion de la estadia: " + this.duracionEstadia + " dias. \n" +
                        "Fecha de ingreso: " + this.fecha.toString();
            
        } else if(this.paseo == true){
            
            servicios = "Los servicios de la reserva son: Paseo. \n" +
                        "Duracion de la estadia: " + this.duracionEstadia + " dias. \n" +
                        "Fecha de ingreso: " + this.fecha.toString();
            
        } else if(this.bano == true){
            
            servicios = "Los servicios de la reserva son: Baño. \n" +
                        "Duracion de la estadia: " + this.duracionEstadia + " dias. \n" +
                        "Fecha de ingreso: " + this.fecha.toString();
            
        }
        
        //CASO 4: No tiene servicios adicionales
        
        else {
            
            servicios = "La reserva no tiene servicios adicionales. \n" +
                        "Duracion de la estadia: " + this.duracionEstadia + " dias. \n" +
                        "Fecha de ingreso: " + this.fecha.toString();
            
        }
        
        return servicios;
    }
    
    
}