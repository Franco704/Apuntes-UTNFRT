package domain;

public class VehiculoElectrico extends Vehiculo {
    private double kwhBase;

    public VehiculoElectrico(String patente, String marca, String modelo, int anio, double capacidadCarga,
                             Sucursal sucursal, double kwhBase) {
        super(VehiculoTipo.ELECTRICO, patente, marca, modelo, anio, capacidadCarga, sucursal);
        this.kwhBase = kwhBase;
    }

    @Override
    public double calcularConsumo(double kilometros) {
        double total = (kilometros / 100.0) * kwhBase;

        if (capacidadCarga > 1200) {
            total += total * 0.15;
        }

        return total;
    }
}
