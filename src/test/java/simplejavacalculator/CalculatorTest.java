package simplejavacalculator;

//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.PointerInfo;
import java.awt.MouseInfo;
import java.awt.event.InputEvent;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
    private Calculator calc;
    private UI ui;

    public static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.setAutoDelay(1);
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(150);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
        // 15*7 = 105
        calc.calculateBi(Calculator.BiOperatorModes.multiply, 15.0);
        assertEquals(calc.calculateEqual(7.0), 105, 0);
    }

    @Test
    public void divide() {
        // 18/6 = 3
        calc.calculateBi(Calculator.BiOperatorModes.divide, 18.0);
        assertEquals(calc.calculateEqual(6.0), 3, 0);

        // 4/0 = Infinity
        calc.calculateBi(Calculator.BiOperatorModes.divide, 4.0);
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
        //1/5 = 0.2
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 5.0), 0.2, 0);
    }

    @Test
    public void abs() {
        // abs(0-1) = 1
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.abs, -1.0), 1, 0);

        // abs(1) = 1
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.abs, 1.0), 1, 0);
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
        //tan(0) = 0
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 0.0), 0, 0);

        // tan(90) = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 90.0), Double.NaN, 0);

        // tan(7)
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 7.0), Math.tan(7), 0);
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
    
    @Test
    public void test_ui() {
        try {
            ui = new UI();
            ui.init();
            click(1065, 500);
            click(950, 400);
            click(1015, 400);
            click(900, 400);
            click(1015, 500);
            assertEquals(ui.reader(), 5, 0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
