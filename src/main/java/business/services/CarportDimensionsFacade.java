package business.services;

import business.exceptions.UserException;
import business.persistence.CarportDimensionsMapper;
import business.persistence.Database;

import java.util.HashMap;

public class CarportDimensionsFacade {

    private CarportDimensionsMapper carportDimensionsMapper;

    public CarportDimensionsFacade(Database database) {
        this.carportDimensionsMapper = new CarportDimensionsMapper(database);
    }

    public HashMap<Integer,Integer> getCarportLengthFromDB() throws UserException {
        HashMap<Integer,Integer> hashMap;

        hashMap = carportDimensionsMapper.getCarportLengthFromDB();


        return hashMap;
    }

    public HashMap<Integer,Integer> getCarportWidthFromDB() throws UserException{
        HashMap<Integer,Integer> hashMap;
        hashMap = carportDimensionsMapper.getCarportWidthFromDB();


        return hashMap;
    }

}
