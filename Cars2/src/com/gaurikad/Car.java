package com.gaurikad;

import javax.persistence.Entity;
import com.google.appengine.api.datastore.Key;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

 private String brand;
 private String model;
 private Integer year;
 
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Key key;
 
 public Key getKey() {
        return key;
    }
 
 public String getBrand() {
  return brand;
 }
 public void setBrand(String brand) {
  this.brand = brand;
 }
 public String getModel() {
  return model;
 }
 public void setModel(String model) {
  this.model = model;
 }
 public Integer getYear() {
  return year;
 }
 public void setYear(Integer year) {
  this.year = year;
 }

}