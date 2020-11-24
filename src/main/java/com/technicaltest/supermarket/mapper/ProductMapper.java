/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.mapper;

import com.technicaltest.supermarket.entity.Product;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductMapper {
    
    @Insert("INSERT INTO  test_producto ( IdProducto ,  Codigo ,  Nombre ,  ValorUnidad ,  Stock ) VALUES "
            + "( #{product.IdProducto}, #{product.Codigo},#{product.Nombre},#{product.ValorUnidad}, #{product.Stock})")
    Integer insertProduct(@Param("product") Product product) throws Exception;

    @Select("SELECT  IdProducto ,  Codigo ,  Nombre ,  ValorUnidad ,  Stock  FROM  test_producto  "
            + "where Codigo = #{Codigo}")
    Product findByCodigo(@Param("email") String Codigo);

    @Select("SELECT  IdProducto ,  Codigo ,  Nombre , ValorUnidad , Stock  FROM  test_producto"
            + " where IdProducto =#{IdProducto}")
    Product findByIdProducto(@Param("IdProducto") Integer IdProducto);

    @Select("SELECT  IdProducto ,  Codigo ,  Nombre , ValorUnidad , Stock  FROM  test_producto")
    List<Product> getProducts();

    @Update("UPDATE test_producto SET IdProducto = #{product.IdProducto},"
            + "Codigo = #{product.Codigo},Nombre = #{product.Nombre},ValorUnidad = #{product.ValorUnidad},"
            + "Stock = #{product.Stock} WHERE id = #{product.id}")
    Integer updateProduct(@Param("product") Product product) throws Exception;

    @Delete("DELETE from test_producto where IdProducto = #{IdProducto}")
    Integer deleteById(@Param("IdProducto") Integer IdProducto);

    
}
