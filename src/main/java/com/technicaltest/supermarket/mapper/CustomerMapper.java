/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.mapper;

import com.technicaltest.supermarket.entity.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CustomerMapper {
    
    
    @Select("SELECT IdCliente, Identifiacion, Nombres, Apellidos, Direccion, Telefono, Email FROM test_cliente "
            + "where IdCliente = #{IdCliente}")
    Customer findByIdCliente(@Param("IdCliente") Integer IdCliente);

    @Select("SELECT IdCliente, Identifiacion, Nombres, Apellidos, Direccion, Telefono, Email FROM test_cliente "
            + " FROM test_cliente")
    List<Customer> getCustomers();
  
    
}
