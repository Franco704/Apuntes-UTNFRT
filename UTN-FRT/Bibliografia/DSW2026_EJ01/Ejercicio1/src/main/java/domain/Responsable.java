package domain;

public class Responsable {
    private String nombre;
    private String documento;
    private String telefono;

    public Responsable(String nombre, String documento, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }
}
