package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class CocheTest {

    /*@Test
    void testEqualsObject() {
        Coche c = new Coche ();   // Arrange
        assertTrue(c.equals(c));  // Action // Assert
    }
    
    @Test
    void testEqualsObjectNull() {
        Coche c = new Coche ();   // Arrange
        Coche c2 = null;
        assertFalse(c.equals(c2));  // Action // Assert
    }
    

    @Test
    void testEqualsObjectString() {
        Coche c = new Coche ();   // Arrange
        String c2 = "";
        assertFalse(c.equals(c2));  // Action // Assert
    }

    
    @Test
    void testEqualsObjectMultiple1() {
        Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche segundo = new Coche ("Toyota", "Corolla", 2022, 22000);
        assertEquals(true, primero.equals(segundo));  // Action // Assert
    }

    @Test
    void testEqualsObjectMultiple2() {
        Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche segundo = new Coche ("Toyota", "Corolla", 2023, 22000);
        assertEquals(false, primero.equals(segundo));  // Action // Assert
    }

    @Test
    void testEqualsObjectMultiple3() {
        Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche segundo = new Coche ("Nissan", "Corolla", 2022, 22000);
        assertEquals(false, primero.equals(segundo));  // Action // Assert
    }

    @Test
    void testEqualsObjectMultiple4() {
        Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche segundo = new Coche ("Toyota", "Auris", 2022, 22000);
        assertEquals(false, primero.equals(segundo));  // Action // Assert
    }

    @Test
    void testEqualsObjectMultiple5() {
        Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche segundo = new Coche ("Toyota", "Corolla", 2022, 32000);
        assertEquals(false, primero.equals(segundo));  // Action // Assert
    }*/
    
    @ParameterizedTest(name = "{index}=> Marca: {1} / Modelo: {2} / Año: {3} / Precio:{4}")
    @MethodSource("cochesGetter")
    void testCocheGetters(Coche coche, String marcaExpected, String modeloExpected, int anoExpected, int precioExpected) {

        /*if (expected == null) {
            assertEquals(expected, result);
            return;
        }*/

        Assert.assertEquals(coche.getMarca(), marcaExpected);
        Assert.assertEquals(coche.getModelo(), modeloExpected);
        Assert.assertEquals(coche.getAño(), anoExpected);
        Assert.assertEquals(coche.getPrecio(), precioExpected);

    }

    static Stream<Arguments> cochesGetter() {

        Coche coche1 = new Coche("Citroen", "Xara", 2008, 2560);
        String marca1Expected = "Citroen";
        String modelo1Expected = "Xara";
        int ano1Expected = 2008;
        int precio1Expected = 2560;
        
        
        return Stream.of(

                Arguments.of(coche1, marca1Expected, modelo1Expected, ano1Expected, precio1Expected)

        );
    }
    
    @ParameterizedTest(name = "{index}=> Marca: {1} / Modelo: {2} / Año: {3} / Precio:{4}")
    @MethodSource("cochesSetter")
    void testCocheSetters(Coche coche, String marcaExpected, String modeloExpected, int anoExpected, int precioExpected) {

        /*if (expected == null) {
            assertEquals(expected, result);
            return;
        }*/

        coche.setMarca("Seat");
        coche.setModelo("Leon");
        coche.setAño(2006);
        coche.setPrecio(1860);
        
        Assert.assertEquals(coche.getMarca(), marcaExpected);
        Assert.assertEquals(coche.getModelo(), modeloExpected);
        Assert.assertEquals(coche.getAño(), anoExpected);
        Assert.assertEquals(coche.getPrecio(), precioExpected);

    }

    static Stream<Arguments> cochesSetter() {

        Coche coche1 = new Coche("Citroen", "Xara", 2008, 2560);
        String marca1Expected = "Seat";
        String modelo1Expected = "Leon";
        int ano1Expected = 2006;
        int precio1Expected = 1860;
        
        
        return Stream.of(

                Arguments.of(coche1, marca1Expected, modelo1Expected, ano1Expected, precio1Expected)

        );
    }
    
    @ParameterizedTest(name = "{0}=> {2}")
    @MethodSource("cochesEquals")
    void testCocheEquals(Object coche1, Object coche2, boolean expected, String name) {

        /*if (expected == null) {
            assertEquals(expected, result);
            return;
        }*/

       Assert.assertEquals(coche1.equals(coche2), expected);

    }

    static Stream<Arguments> cochesEquals() {

        Coche coche11 = new Coche();
        Coche coche21 = new Coche();
        Coche coche22 = null;
        Coche coche31 = new Coche("Toyota", "Corolla", 2022, 22000);
        Coche coche32 = new Coche("Toyota", "Corolla", 2022, 22000);
        Coche coche41 = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche coche42 = new Coche ("Toyota", "Corolla", 2023, 22000);
        Coche coche51 = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche coche52 = new Coche ("Nissan", "Corolla", 2022, 22000);
        Coche coche61 = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche coche62 = new Coche ("Toyota", "Auris", 2022, 22000);
        Coche coche71 = new Coche ("Toyota", "Corolla", 2022, 22000);
        Coche coche72 = new Coche ("Toyota", "Corolla", 2022, 32000);
        Coche coche81 = new Coche();
        String coche82 = "";

        return Stream.of(

                Arguments.of(coche11, coche11, true, "testEqualsObject"),
                Arguments.of(coche21, coche22, false, "testEqualsObjectNull"),
                Arguments.of(coche31, coche32, true, "testEqualsObjectMultiple1"),
                Arguments.of(coche41,coche42,false, "testEqualsObjectMultiple2"),
                Arguments.of(coche51,coche52,false,"testEqualsObjectMultiple3"),
                Arguments.of(coche61,coche62,false,"testEqualsObjectMultiple4"),
                Arguments.of(coche71,coche72,false,"testEqualsObjectMultiple5"),
                Arguments.of(coche81,coche82, false, "testEqualsObjectString")

        );
    }

}
