/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.mapper;

import com.technicaltest.supermarket.entity.Invoice;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface InvoiceMapper {
    
    @Insert("INSERT INTO test_factura(IdFactura, IdCliente, FechaVenta, ValorTotal) VALUES "
            + "( #{invoice.IdFactura}, #{invoice.IdCliente},#{invoice.FechaVenta},#{invoice.ValorTotal})")
    Integer insertInvoice(@Param("invoice") Invoice invoice) throws Exception;

    @Select("SELECT  IdFactura ,  IdCliente ,  FechaVenta ,  ValorTotal  FROM  test_factura  "
            + "where Codigo = #{Codigo}")
    Invoice findByCodigo(@Param("email") String Codigo);

    @Select("SELECT  IdFactura ,  IdCliente ,  FechaVenta , ValorTotal  FROM  test_factura"
            + " where IdInvoiceo =#{IdInvoiceo}")
    Invoice findByIdFactura(@Param("IdInvoiceo") Integer IdInvoiceo);

    @Select("SELECT IdFactura, IdCliente, FechaVenta, ValorTotal FROM test_factura")
    List<Invoice> getInvoices();

    @Update("UPDATE test_factura SET IdFactura = #{invoice.IdFactura},"
            + "IdCliente = #{invoice.IdCliente},FechaVenta = #{invoice.FechaVenta},"
            + "ValorTotal = #{invoice.ValorTotal} WHERE IdFactura = #{invoice.IdFactura}")
    Integer updateInvoice(@Param("invoice") Invoice invoice) throws Exception;

    @Delete("DELETE from test_factura where IdFactura = #{IdFactura}")
    Integer deleteById(@Param("IdFactura") Integer IdFactura);
    
}
