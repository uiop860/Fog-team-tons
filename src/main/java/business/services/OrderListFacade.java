package business.services;

import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderListMapper;

public class OrderListFacade {

    private OrderListMapper orderListMapper;

    public OrderListFacade(Database database) {
        this.orderListMapper = new OrderListMapper(database);
    }

    public void calculateCarport(int carportWidthID, int carportLengthID) throws UserException {

        orderListMapper.calculateCarport(carportWidthID,carportLengthID);

    }
}
