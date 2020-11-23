/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEST_PRODUCTO")
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Integer IdProducto;
    private String Codigo;
    private String Nombre;
    private float ValorUnidad;
    private Integer Stock;
    
}
