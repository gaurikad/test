package com.gaurikad;

import java.util.List;
import javax.inject.Named;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Api(name = "car"
, version = "v1"
, clientIds = {com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID}
, audiences = {"vehiclecarx.appspot.com"}
, scopes = {"https://www.googleapis.com/auth/userinfo.email"}
)
public class CarEndPoint {

  @ApiMethod(name = "car.add"
    , path = "car/add/{brand}/{model}/{year}"
    , httpMethod = HttpMethod.PUT)
  public void addCar(@Named("brand") String _sbrand
    , @Named("model") String _smodel
    , @Named("year") String _syear) {
   
   CarHandler ch = new CarHandler();
   ch.addCar(_sbrand, _smodel, Integer.parseInt(_syear));
 }  

  // url -->  https://vehiclecarx.appspot.com/_ah/api/car/v1/readall
  // sample url --> https://vehiclecarx.appspot.com/_ah/api/car/v1/readall?fields=items(brand%2Cmodel%2Cyear)
  @ApiMethod(name = "readall"
    , path = "readall"
    , httpMethod = HttpMethod.GET)
  public List <Car> readall(){

   CarHandler ch = new CarHandler();
   List<Car> cars = ch.getAllCars();
   
      return cars;
  }
}
