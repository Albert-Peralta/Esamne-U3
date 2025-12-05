package mx.edu.utez.ordenes.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "compra")
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double montoTotal;
    private String clienteEmail;

    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public OrdenCompra() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
