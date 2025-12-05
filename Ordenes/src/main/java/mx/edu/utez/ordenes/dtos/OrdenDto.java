package mx.edu.utez.ordenes.dtos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class OrdenDto {

    private double montoTotal;
    private String clienteEmail;
    private Date fechaCreacion;

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
