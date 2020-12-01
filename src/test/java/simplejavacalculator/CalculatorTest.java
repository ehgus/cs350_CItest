package simplejavacalculator;

//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test_CG() {
        Calculator calc = new Calculator();

        // 3+2 = 5
        calc.calculateBi(Calculator.BiOperatorModes.add, 3.0);
        assertEquals(calc.calculateEqual(2.0), 5, 0);

        // 10+0 = 10 --> may have to modify Calculator.java code later to improve quality
        calc.calculateBi(Calculator.BiOperatorModes.add, 10.0);
        assertEquals(calc.calculateEqual(0.0), 10, 0);

        // 3-2 = 1
        calc.calculateBi(Calculator.BiOperatorModes.minus, 3.0);
        assertEquals(calc.calculateEqual(2.0), 1, 0);

        // 15*3 = 45
        calc.calculateBi(Calculator.BiOperatorModes.multiply, 15.0);
        assertEquals(calc.calculateEqual(3.0), 45, 0);

        // 15/3 = 5
        calc.calculateBi(Calculator.BiOperatorModes.divide, 15.0);
        assertEquals(calc.calculateEqual(3.0), 5, 0);

        // 3^3 = 27
        calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 3.0);
        assertEquals(calc.calculateEqual(3.0), 27, 0);

        // 15^2 = 225
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.square, 15.0), 225, 0);

        // sqrt(25) = 5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, 25.0), 5, 0);

        // 1/5 = 0.2
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 5.0), 0.2, 0);

        // abs(-5) = 5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.abs, -5.0), 5, 0);

        // abs(5) = 5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.abs, 5.0), 5, 0);

        // 15 / 0 = infinity
        calc.calculateBi(Calculator.BiOperatorModes.divide, 15.0);
        assertEquals(calc.calculateEqual(0.0), Double.POSITIVE_INFINITY, 0);
        //assertEquals(calc.calculateEqual(0.0), java.lang.Double.NaN, 0);
    }

}
