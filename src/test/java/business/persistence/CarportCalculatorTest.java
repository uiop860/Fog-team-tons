package business.persistence;

import business.entities.Material;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarportCalculatorTest {

    public int carportLength;
    public int carportWidth;
    public Material material;

    @BeforeEach
    public void prepareTest() {
        carportLength = 420;
        carportWidth = 690;
    }

    @Test
    public void testCalculatePole() {
        material = new Material(1, "97x97 mm. trykimp. Stolpe", "97x97 mm. trykimp. Stolpe", "Stk", 0.35, "Træ");
        material.calculatePole(carportLength);
        Assertions.assertEquals(4,material.getAmount());
        Assertions.assertEquals(300,material.getSpacing());
        Assertions.assertEquals(420,material.getTotalPrice());
    }

    @Test
    public void calculateRafters() {
        material = new Material(1, "45x195 mm. spærtræ ubh.", "Spær, monteres på rem", "Stk", 0.8495, "Træ");
        material.calculateRafters(carportWidth,carportLength);
        Assertions.assertEquals(9,material.getAmount());
        Assertions.assertEquals(52.5,material.getSpacing());
        Assertions.assertEquals(5275.39,material.getTotalPrice());
    }

    @Test
    public void calculateRoof() {
        material = new Material(1, "Plastmo Ecolite blåtonet", "Tagplader monteres på spær", "Stk", 0.4166, "Træ");
        material.calculateRoof(carportWidth,carportLength);
        Assertions.assertEquals(7,material.getAmount());
        Assertions.assertEquals(90,material.getLastRoofPlateWidth());
        Assertions.assertEquals(1224.8,material.getTotalPrice());
    }

    @Test
    public void calculateBeamOnLongSide() {
        material = new Material(1, "45x195 mm. spærtræ ubh.", "Remme på langsiden, sadles ned i stolper", "Stk", 0.8495, "Træ");
        material.calculateBeamOnLongSide(carportLength);
        Assertions.assertEquals(2,material.getAmount());
        Assertions.assertEquals(713.58,material.getTotalPrice());
    }

    @Test
    public void calculateBeamOnBroadSide() {
        material = new Material(1, "45x195 mm. spærtræ ubh.", "Remme på bredsiden, sadles ned i stolper", "Stk", 0.8495, "Træ");
        material.calculateBeamOnLongSide(carportLength);
        Assertions.assertEquals(2,material.getAmount());
        Assertions.assertEquals(713.58,material.getTotalPrice());
    }
}
