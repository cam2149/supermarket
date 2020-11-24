/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_factura_detalle")
public class DetailInvoice {

    @Id
    @GeneratedValue
    private Integer IdFacturaDetalle;
    private Integer IdFactura;
    private Integer IdProducto;
    private Integer Cantidad;
    private Long ValorUnidad;
    private Long ValorTotal;

    public Integer getIdFacturaDetalle() {
        return IdFacturaDetalle;
    }

    public void setIdFacturaDetalle(Integer IdFacturaDetalle) {
        this.IdFacturaDetalle = IdFacturaDetalle;
    }

    public Integer getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(Integer IdFactura) {
        this.IdFactura = IdFactura;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer IdProducto) {
        this.IdProducto = IdProducto;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Long getValorUnidad() {
        return ValorUnidad;
    }

    public void setValorUnidad(Long ValorUnidad) {
        this.ValorUnidad = ValorUnidad;
    }

    public Long getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Long ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

}
