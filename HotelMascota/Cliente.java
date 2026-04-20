public class Cliente extends Persona
{
    private int codigoCliente;
    private String telefono;
    
    public Cliente(){
        
        super();
        codigoCliente = 0;
        telefono = null;
    }
    
    public Cliente(String nombre, String apellido, int nuip, int codigoCliente, String telefono) {
        super(nombre, apellido, nuip);
        this.codigoCliente = codigoCliente;
        this.telefono = telefono;
    }
    
    public int getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + getNombre() + ", apellido=" + getApellido() + ", nuip=" + getNuip() + ", codigoCliente=" + codigoCliente + ", telefono=" + telefono + "}";
    }
}