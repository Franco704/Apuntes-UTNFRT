package domain;

public class Sucursal {
     private String codigo;
    private String direccion;
    private String ciudad;
    private Responsable responsable;

    public Sucursal(String codigo, String direccion, String ciudad, Responsable responsable) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.responsable = responsable;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Responsable getResponsable() {
        return responsable;
    }
}
