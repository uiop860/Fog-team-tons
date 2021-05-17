package business.persistence;

import business.entities.Material;
import business.entities.OrderList;
import business.exceptions.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarportCalculatorTest {

    static int length;
    static double width;
    private final static String USER = "managesql";
    private final static String PASSWORD = "tt420";
    private final static String URL = "jdbc:mysql://206.81.26.54:3306/fog_db?serverTimezone=CET";
    private static Database database;

    @BeforeAll
    static void setUpParameters() throws ClassNotFoundException {

        length = 500;
        width = 240;
        database = new Database(USER,PASSWORD,URL);

    }

    @Test
    public void stolpeBeregner(){

        int lengthAfterMinus = length-120;
        int stolpeSplitter = 310;
        int antalStolper = 0;
        int hjørneStolper = 2;
        int stolpeMellemrum;

        if (lengthAfterMinus < stolpeSplitter * 2 && lengthAfterMinus > stolpeSplitter) {
            antalStolper = 1;

        }else if(lengthAfterMinus < stolpeSplitter * 3 && lengthAfterMinus > stolpeSplitter * 2){
            antalStolper = 2;
        }

        if(antalStolper == 0){
            stolpeMellemrum = lengthAfterMinus;
        } else {
            stolpeMellemrum =  lengthAfterMinus/(antalStolper+1);
        }

        antalStolper += hjørneStolper;
        antalStolper *= 2;

        Assertions.assertEquals(6,antalStolper);

    }

    @Test
    public void stolpeMellemrumBeregner(){

        int lengthAfterMinus = length-120;
        int stolpeSplitter = 310;
        int antalStolper = 0;
        int hjørneStolper = 2;
        int stolpeMellemrum;

        if (lengthAfterMinus < stolpeSplitter * 2 && lengthAfterMinus > stolpeSplitter) {
            antalStolper = 1;

        }else if(lengthAfterMinus < stolpeSplitter * 3 && lengthAfterMinus > stolpeSplitter * 2){
            antalStolper = 2;
        }

        if(antalStolper == 0){
            stolpeMellemrum = lengthAfterMinus;
        } else {
            stolpeMellemrum =  lengthAfterMinus/(antalStolper+1);
        }

        antalStolper += hjørneStolper;
        antalStolper *= 2;

        Assertions.assertEquals(190,stolpeMellemrum);

    }

    @Test
    public void spærBeregner(){

        int spærSplitter = 55;
        double antalSpær = 0;

        antalSpær = Math.ceil(length/spærSplitter);

        int spærMellemrum = (int) (length/antalSpær);


        Assertions.assertEquals(9,antalSpær);


    }

    @Test
    public void spærMellemrumBeregner(){

        int spærSplitter = 55;
        double antalSpær = 0;

        antalSpær = Math.ceil(length/spærSplitter);

        int spærMellemrum = (int) (length/antalSpær);


        Assertions.assertEquals(48,spærMellemrum);

    }

    @Test
    public void tagpladeBeregner(){

        double tapladeSplitter = 100;
        double antalTagplader;
        int sidsteTagpladeWidth;

        antalTagplader = Math.ceil(width/tapladeSplitter);

        System.out.println(antalTagplader);

        /*sidsteTagpladeWidth = width % tapladeSplitter;*/

        Assertions.assertEquals(3,antalTagplader);

    }

    /*@Test
    public void sidsteTagpladeBeregner(){

        int tapladeSplitter = 100;
        double antalTagplader;
        int sidsteTagpladeWidth;

        antalTagplader = Math.ceil(width/tapladeSplitter);

        sidsteTagpladeWidth = width % tapladeSplitter;

        Assertions.assertEquals(20,sidsteTagpladeWidth);

    }

    @Test
    public void calculateCarport() throws UserException, SQLException {

        Connection connection = database.connect();

        System.out.println(connection.isValid(10));

        OrderListMapper orderListMapper = new OrderListMapper(database);

        OrderList orderList = orderListMapper.calculateCarport(width,length,1);

        List<Material> materialList = orderList.getMaterialList();

        for (Material i: materialList) {

            System.out.print(i.getName()+" ");
            System.out.print(i.getTotalPrice());
            System.out.println();

        }
    }*/
}