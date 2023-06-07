package HW4_Tests;

import HW4.AreaTriangle;
import HW4.NotTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;

public class TriangleTest {

//    static Logger logger = LoggerFactory.getLogger(AreaTriangle.class);

    @Test
    void test() throws NotTriangle {
        AreaTriangle areaTriangle = new AreaTriangle();
        Assertions.assertEquals(12, areaTriangle.area(6, 5, 5));
        Assertions.assertThrows(NotTriangle.class, () -> areaTriangle.area(0, 5, 5));
        Assertions.assertThrows(NotTriangle.class, () -> areaTriangle.area(-6, 5, 5));
        Assertions.assertThrows(NotTriangle.class, () -> areaTriangle.area(1, 2, 5));
    }

    @ParameterizedTest
    @CsvSource({"6, 5, 5, 12", "5, -5, 3, 12", "5, 5, 0, 12", "1, 2, 5, 6"})
    void testWithCsvSource(int a, int b, int c, float result) throws NotTriangle {
        AreaTriangle areaTriangle = new AreaTriangle();
        Assertions.assertEquals(result, areaTriangle.area(a, b, c));
    }


    @ParameterizedTest
    @CsvSource({"0, 5, 5", "-6, 5, 5", "1, 2, 5"})
    void testWithCsvSourceN(int a, int b, int c) throws NotTriangle {
        AreaTriangle areaTriangle = new AreaTriangle();
        Assertions.assertThrows(NotTriangle.class, () -> areaTriangle.area(a, b, c));
    }
}