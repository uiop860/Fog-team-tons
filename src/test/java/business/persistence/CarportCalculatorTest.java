package business.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarportCalculatorTest {

    static int length;
    static int width;

    @BeforeAll
    static void setUpParameters(){

        length = 500;
        width = 420;

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


        Assertions.assertEquals(5,antalSpær);


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

        int tapladeSplitter = 100;
        double antalTagplader;
        int sidsteTagpladeWidth;

        antalTagplader = Math.ceil(width/tapladeSplitter);

        sidsteTagpladeWidth = width % tapladeSplitter;

        Assertions.assertEquals(5,antalTagplader);

    }

    @Test
    public void sidsteTagpladeBeregner(){

        int tapladeSplitter = 100;
        double antalTagplader;
        int sidsteTagpladeWidth;

        antalTagplader = Math.ceil(width/tapladeSplitter);

        sidsteTagpladeWidth = width % tapladeSplitter;

        Assertions.assertEquals(20,sidsteTagpladeWidth);

    }




}
