package Modelo;

public class Ventas {
    private int codigoProducto;
    private String nombreProducto;
    private int cantidadVendida;
    private double precioUnitario;
    private double totalVenta;

    public Ventas(int codigoProducto, String nombreProducto, int cantidadVendida, double precioUnitario, double totalVenta) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;
        this.precioUnitario = precioUnitario;
        this.totalVenta = totalVenta;
    }

    // Getters and Setters
    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
}
