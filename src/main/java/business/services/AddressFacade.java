package business.services;

import business.entities.Address;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.AddressMapper;
import business.persistence.Database;

public class AddressFacade
{
    AddressMapper addressMapper;

    public AddressFacade(Database database)
    {
        this.addressMapper = new AddressMapper(database);
    }

    public Address createAddress(Address address, String email) throws UserException
    {

        addressMapper.createAddress(address, email);
        return address;
    }
}
