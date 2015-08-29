package com.gaurikad;

import java.util.List;

import javax.persistence.EntityManager;

public class CarHandler {
 
 public void addCar(String _sBrand, String _sModel, int _iYear){
  
  Car car = new Car();
  car.setBrand(_sBrand);
  car.setModel(_sModel);
  car.setYear(new Integer(_iYear));
  
  EntityManager em = EMF.get().createEntityManager();
  em.getTransaction().begin();
  em.persist(car);
  em.getTransaction().commit();
  
 }
 
 public List<Car> getAllCars(){
  
  EntityManager em = EMF.get().createEntityManager();
  em.getTransaction().begin();
  List<Car> result = em.createQuery( "select car from Car car", Car.class ).getResultList();
  
  em.getTransaction().commit();
  
  return result;
 }
 
}
