package business.services;

import business.entities.OrderList;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderListMapper;

public class OrderListFacade {

    private OrderListMapper orderListMapper;

    public OrderListFacade(Database database) {
        this.orderListMapper = new OrderListMapper(database);
    }

    public OrderList calculateCarport(double carportWidth, double carportLength, int requestID) throws UserException {

        return orderListMapper.calculateCarport(carportWidth,carportLength, requestID);

    }
}
