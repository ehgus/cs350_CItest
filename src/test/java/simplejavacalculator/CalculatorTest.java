package simplejavacalculator;

//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
    private Calculator calc;

    @Before
    public void setup() {
        calc = new Calculator();
    }

    @Test
    public void add() {
        // 3+2 = 5
        calc.calculateBi(Calculator.BiOperatorModes.add, 3.0);
        assertEquals(calc.calculateEqual(2.0), 5, 0);

        // 10+0 = 10 --> may have to modify Calculator.java code later to improve quality
        calc.calculateBi(Calculator.BiOperatorModes.add, 10.0);
        assertEquals(calc.calculateEqual(0.0), 10, 0);
    }

    @Test
    public void minus() {
        // 3-2 = 1
        calc.calculateBi(Calculator.BiOperatorModes.minus, 3.0);
        assertEquals(calc.calculateEqual(2.0), 1, 0);
    }

    @Test
    public void multiply() {
        // 15*3 = 45
        calc.calculateBi(Calculator.BiOperatorModes.multiply, 15.0);
        assertEquals(calc.calculateEqual(3.0), 45, 0);
    }

    @Test
    public void divide() {
        // 15/3 = 5
        calc.calculateBi(Calculator.BiOperatorModes.divide, 15.0);
        assertEquals(calc.calculateEqual(3.0), 5, 0);

        // 15 / 0 = infinity
        calc.calculateBi(Calculator.BiOperatorModes.divide, 15.0);
        assertEquals(calc.calculateEqual(0.0), Double.POSITIVE_INFINITY, 0);
    }

    @Test
    public void xpowerofy() {
        // 3^3 = 27
        calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 3.0);
        assertEquals(calc.calculateEqual(3.0), 27, 0);
    }

    @Test
    public void square() {
        // 15^2 = 225
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.square, 15.0), 225, 0);
    }

    @Test
    public void squareRoot() {
        // sqrt(25) = 5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, 25.0), 5, 0);

        // sqrt(-25) = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, -25.0), Double.NaN, 0);
    }

    @Test
    public void oneDivideBy() {
        // 1/5 = 0.2
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 5.0), 0.2, 0);
    }

    @Test
    public void abs() {
        // abs(-5) = 5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.abs, -5.0), 5, 0);

        // abs(5) = 5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.abs, 5.0), 5, 0);
    }

    @Test
    public void sin() {
        // sin(0) = 0
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.sin, 0.0), 0, 0);
    }

    @Test
    public void cos() {
        // cos(0) = 1
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.cos, 0.0), 1, 0);
    }

    @Test
    public void tan() {
        // tan(0) = 0
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 0.0), 0, 0);

        // tan(90) = NAN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 90.0), Double.NaN, 0);

        // tan(45)
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 45.0), Math.tan(45), 0);
    }

    @Test
    public void log() {
        // log10(100) = 2
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.log, 100.0), 2, 0);
    }

    @Test
    public void rate() {
        // rate(50) = 0.5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.rate, 50.0), 0.5, 0);
    }

    @Test
    public void equal() {
        assertEquals(calc.calculateEqual(30.0), Double.NaN, 0);

    }

    @Test
    public void reset() {
        // RESET -> NAN
        assertEquals(calc.reset(), Double.NaN, 0);
    }

    /*
    @Test
    public void ui() {
        String[] args = null;
        SimpleJavaCalculator.main(args);

        Double r1 = 0.0;

        try {
            UI uiCal = new UI();
            uiCal.init();
            uiCal.writer(Double.NaN);
            uiCal.writer(30.0);
            r1 = uiCal.reader();
            // after writing NaN, reader() fails.
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(r1, 30, 0);
    }
    */

}
