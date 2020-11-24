/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.mapper;


import com.technicaltest.supermarket.entity.DetailInvoice;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface DetailInvoiceMapper {
    
    @Insert("INSERT INTO test_factura_detalle(IdFacturaDetalle, IdFactura, IdProducto, Cantidad, ValorUnidad, ValorTotal) VALUES "
            + "( #{detailInvoice.IdFacturaDetalle}, #{detailInvoice.IdFactura},#{detailInvoice.IdProducto},#{detailInvoice.Cantidad}"
            + "#{detailInvoice.ValorUnidad},#{detailInvoice.ValorTotal})")
    Integer insertDetailInvoice(@Param("detailInvoice") DetailInvoice detailInvoice) throws Exception;

    @Select("SELECT  IdFacturaDetalle, IdFactura, IdProducto, Cantidad, ValorUnidad, ValorTotal FROM  test_factura_detalle "
            + "where IdFactura = #{IdFactura}")
    DetailInvoice findByIdFactura(@Param("IdFactura") Integer IdFactura);

    @Select("SELECT IdFacturaDetalle, IdFactura, IdProducto, Cantidad, ValorUnidad, ValorTotal "
            + " FROM test_factura_detalle")
    List<DetailInvoice> getInvoices();

    @Update("UPDATE test_factura_detalle SET IdFactura = #{detailInvoice.IdFactura},"
            + "IdProducto = #{detailInvoice.IdProducto},Cantidad = #{detailInvoice.Cantidad},"
            + "ValorUnidad = #{detailInvoice.ValorUnidad}, ValorTotal = #{detailInvoice.ValorTotal}"
            + " WHERE IdFactura = #{detailInvoice.IdFactura}")
    Integer updateDetailInvoice(@Param("detailInvoice") DetailInvoice detailInvoice) throws Exception;
    
    @Delete("DELETE from test_factura_detalle where IdFactura = #{IdFactura}")
    Integer deleteByIdFactura(@Param("IdFactura") Integer IdFactura);
    
     @Delete("DELETE from test_factura_detalle where IdFacturaDetalle = #{IdFacturaDetalle}")
    Integer deleteByIdFacturaDetalle(@Param("IdFacturaDetalle") Integer IdFacturaDetalle);
    
}
