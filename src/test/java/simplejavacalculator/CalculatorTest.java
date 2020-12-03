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

    @Test
    public void ui() {
        String[] args = null;
        SimpleJavaCalculator.main(args);

        try {
            ui = new UI();
            ui.init();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        while(true) {
            PointerInfo pt = MouseInfo.getPointerInfo();
            pt = MouseInfo.getPointerInfo();
            System.out.println(pt.getLocation()); // x,y
        }
        */

        /*
        1 (850, 400)
        2 (900, 400)
        3 (950, 400)
        4 (850, 450)
        5 (900, 450)
        6 (950, 450)
        7 (850, 500)
        8 (900, 500)
        9 (950, 500)
        0 (850, 550)
        + (1015, 400)
        - (1065, 400)
        * (1015, 450)
        / (1065, 450)
        = (1015, 500)
        C (1065, 500)
        x*x (850, 600)
        sqrt (930, 600)
        1/x (1000, 600)
        x^y (1060, 600)
        cos (890, 650)
        sin (960, 650)
        tan (1030, 650)
        log (850, 700)
        x% (930, 700)
        abs (1010, 700)
        bin (1090, 700)
         */

        try {
            // 3+2 = 5
            click(1065, 500);
            click(950, 400);
            click(1015, 400);
            click(900, 400);
            click(1015, 500);
            Thread.sleep(10);
            assertEquals(ui.reader(), 5, 0);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }



}
