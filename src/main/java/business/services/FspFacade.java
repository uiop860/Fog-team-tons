package business.services;

import business.entities.Fsp;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.FspMapper;

import java.util.List;

public class FspFacade
{
    FspMapper fspMapper;

    public FspFacade(Database database)
    {
        this.fspMapper = new FspMapper(database);
    }

    public Fsp createFSp(int width, int height, String name, String road, int houseNumber, int zipCode, String city, int phone, String email) throws UserException
    {
        Fsp fsp = new Fsp(width, height, name, road, houseNumber, zipCode, city, phone, email);
        fspMapper.createFsp(fsp);
        return fsp;
    }

    public List<Fsp> getfsp() throws UserException
    {
        return fspMapper.getAllFsp();
    }
}
