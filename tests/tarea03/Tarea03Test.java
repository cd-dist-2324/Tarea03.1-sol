package tarea03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;



public class Tarea03Test {

    private static Tarea03 app = new Tarea03();

    @BeforeAll
    public static void init() {
        app = new Tarea03();
    }

    @AfterAll
    public static void finish() {
        app = null;
    }

    @Test
    void testC1() throws Exception {

        int[] numeros = null;
        Exception exception = assertThrows(Exception.class, () -> app.encontrarMax(numeros));
        assertEquals(Tarea03.MSG_NULL, exception.getMessage());
    }

    @Test
    void testC2() throws Exception {

        int[] numeros = new int[0];
        Exception exception = assertThrows(Exception.class, () -> app.encontrarMax(numeros));
        assertEquals(Tarea03.MSG_LENGTH_ERROR, exception.getMessage());
    }

    @Test
    void testC3() throws Exception {

        int[] numeros = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
        assertEquals(Integer.MIN_VALUE, app.encontrarMax(numeros));
    }

    @Test
    void testC4() throws Exception {

        int[] numeros = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
        assertEquals(Integer.MAX_VALUE, app.encontrarMax(numeros));
    }

    @Test
    void testC5() throws Exception {

        int[] numeros = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE };
        assertEquals(Integer.MAX_VALUE, app.encontrarMax(numeros));
    }

    @Test
    void testC6() throws Exception {

        int[] numeros = { Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE };
        assertEquals(Integer.MAX_VALUE, app.encontrarMax(numeros));
    }

    @Test
    void testC7() throws Exception {

        int[] numeros = { Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
        assertEquals(Integer.MAX_VALUE, app.encontrarMax(numeros));
    }

    @Test
    void testC8() throws Exception {

        int[] numeros = { 3 };
        Exception exception = assertThrows(Exception.class, () -> app.encontrarMax(numeros));
        assertEquals(Tarea03.MSG_LENGTH_ERROR, exception.getMessage());

    }

    @Test
    void testC9() throws Exception {

        int[] numeros = { 1, 2, 3, 4 };
        Exception exception = assertThrows(Exception.class, () -> app.encontrarMax(numeros));
        assertEquals(Tarea03.MSG_LENGTH_ERROR, exception.getMessage());

    }

    @Test
    void testC10() throws Exception {

        int[] numeros = { 0, -0, 0 };
        int resultado =  app.encontrarMax(numeros);
        assertEquals(-0, resultado);
        assertEquals(0, resultado);

    }

    @Test
    void testC11() throws Exception {

        int[] numeros = { 0, -3, 3 };
        assertEquals(3, app.encontrarMax(numeros));

    }



    @ParameterizedTest
    @CsvSource(value = {
            "3, 7, 2 :7",
            "0,-3,3:3"}, delimiterString = ":")
    public void testEncontrarMaxParam(@ConvertWith(IntArrayConverter.class) int[] input,
                               int expected) throws Exception {
        int resultado = app.encontrarMax(input);
        assertEquals(expected, resultado);
    }
}
