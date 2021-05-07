package business.services;

import business.entities.Address;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

public class OrderFacade {

    private OrderMapper orderMapper;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
    }

    private void insertOrderIntoDB(Address address, int length, int width, User user) throws UserException {

        orderMapper.insertOrderIntoDB(address,length,width, user);

    }
}
