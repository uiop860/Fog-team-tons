package business.services;

import business.exceptions.UserException;
import business.persistence.CarportDimenstionsMapper;
import business.persistence.Database;

import java.util.HashMap;

public class CarportDimensionsFacade {

    private CarportDimenstionsMapper carportDimenstionsMapper;

    public CarportDimensionsFacade(Database database) {
        this.carportDimenstionsMapper = new CarportDimenstionsMapper(database);
    }

    public HashMap<Integer,Integer> getCarportLengthFromDB() throws UserException {
        HashMap<Integer,Integer> hashMap;

        hashMap = carportDimenstionsMapper.getCarportLengthFromDB();


        return hashMap;
    }

    public HashMap<Integer,Integer> getCarportWidthFromDB() throws UserException{
        HashMap<Integer,Integer> hashMap;
        hashMap = carportDimenstionsMapper.getCarportWidthFromDB();


        return hashMap;
    }

}
