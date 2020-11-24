/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.entity;


import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_factura")        
public class Invoice {
    @Id
    @GeneratedValue
    private Integer IdFactura;
    private Integer IdCliente;
    private Date FechaVenta;
    private Long ValorTotal;
    

    public Integer getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(Integer IdFactura) {
        this.IdFactura = IdFactura;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Date getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(Date FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public Long getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Long ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

}
