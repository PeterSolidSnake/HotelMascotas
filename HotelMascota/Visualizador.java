public class Visualizador
{
    private Reserva reserva1;
    private Reserva reserva2;
    private Reserva reserva3;
    
    public Visualizador(){
        
        reserva1 = null;
        reserva2 = null;
        reserva3 = null;
    }
    
    public Visualizador(Reserva reserva1, Reserva reserva2, Reserva reserva3) {
        this.reserva1 = reserva1;
        this.reserva2 = reserva2;
        this.reserva3 = reserva3;
    }
    
    public Reserva getReserva1(){
        return reserva1;
    }
    public void setReserva1(Reserva reserva1){
        this.reserva1 = reserva1;
    }
    public Reserva getReserva2(){
        return reserva2;
    }
    public void setReserva2(Reserva reserva2){
        this.reserva2 = reserva2;
    }
    public Reserva getReserva3(){
        return reserva3;
    }
    public void setReserva3(Reserva reserva3){
        this.reserva3 = reserva3;
    }
    
    @Override
    public String toString(){
        return "Visualizador{" + "reserva1=" + reserva1 + ", reserva2=" + reserva2 + ", reserva3=" + reserva3 + "}";
    }
    
    
    //RF5: Visualizar reservas: El sistema debe permitir la visualizacion y administracion de reservas activas.
    
    public String listarReservas ( ){
        
        String lista = "";
        
        //CASO 1: Existen 3 reservas activas
        if(this.reserva1 != null && this.reserva2 != null && this.reserva3 != null){
            
            lista = "La lista de reservas activas es: \n" + this.reserva1.toString() + "\n" + this.reserva2.toString() + "\n" + this.reserva3.toString();
            
        }
        
        //CASO 2: Existen 2 reservas activas
        
        else if(this.reserva1 != null && this.reserva2 != null){
            
            lista = "La lista de reservas activas es: \n" + this.reserva1.toString() + "\n" + this.reserva2.toString();
            
        } else if(this.reserva1 != null && this.reserva3 != null){
            
            lista = "La lista de reservas activas es: \n" + this.reserva1.toString() + "\n" + this.reserva3.toString();
            
        } else if(this.reserva2 != null && this.reserva3 != null){
            
            lista = "La lista de reservas activas es: \n" + this.reserva2.toString() + "\n" + this.reserva3.toString();
            
        }
        
        //CASO 3: Existe 1 reserva activa
        
        else if(this.reserva1 != null){
            
            lista = "La lista de reservas activas es: \n" + this.reserva1.toString();
            
        } else if(this.reserva2 != null){
            
            lista = "La lista de reservas activas es: \n" + this.reserva2.toString();
            
        } else if(this.reserva3 != null){
            
            lista = "La lista de reservas activas es: \n" + this.reserva3.toString();
            
        }
        
        //CASO 4: No existen reservas activas
        
        else {
            
            lista = "No existen reservas activas en el sistema.";
            
        }
        
        return lista;
    }
    
    
}