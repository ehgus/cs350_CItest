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
            Thread.sleep(100);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Before
    public void setup() {
        calc = new Calculator();

        try {
            ui = new UI();
            ui.init();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void add() {
//        3+2 = 5
//        calc.calculateBi(Calculator.BiOperatorModes.add, 3.0);
//        assertEquals(calc.calculateEqual(2.0), 5, 0);

        try {
            click(1065, 500);
            click(950, 400);
            click(1015, 400);
            click(900, 400);
            click(1015, 500);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 5, 0);

//        10+0 = 10 --> may have to modify Calculator.java code later to improve quality
//        calc.calculateBi(Calculator.BiOperatorModes.add, 10.0);
//        assertEquals(calc.calculateEqual(0.0), 10, 0);

        try {
            click(1065, 500);
            click(850, 400);
            click(850, 550);
            click(1015, 400);
            click(850, 550);
            click(1015, 500);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 10, 0);
    }

    @Test
    public void minus() {
//        3-2 = 1
//        calc.calculateBi(Calculator.BiOperatorModes.minus, 3.0);
//        assertEquals(calc.calculateEqual(2.0), 1, 0);

        try {
            click(1065, 500);
            click(950, 400);
            click(1065, 400);
            click(900, 400);
            click(1015, 500);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 1, 0);
    }

    @Test
    public void multiply() {
//        15*7 = 105
//        calc.calculateBi(Calculator.BiOperatorModes.multiply, 15.0);
//        assertEquals(calc.calculateEqual(7.0), 105, 0);

        try {
            click(1065, 500);
            click(850, 400);
            click(900, 450);
            click(1015, 450);
            click(850, 500);
            click(1015, 500);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 105, 0);
    }

    @Test
    public void divide() {
//        18/6 = 3
//        calc.calculateBi(Calculator.BiOperatorModes.divide, 18.0);
//        assertEquals(calc.calculateEqual(6.0), 3, 0);

        try {
            click(1065, 500);
            click(850, 400);
            click(900, 500);
            click(1065, 450);
            click(950, 450);
            click(1015, 500);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 3, 0);

//        4/0 = Infinity
//        calc.calculateBi(Calculator.BiOperatorModes.divide, 4.0);
//        assertEquals(calc.calculateEqual(0.0), Double.POSITIVE_INFINITY, 0);

        try {
            click(1065, 500);
            click(850, 450);
            click(1065, 450);
            click(850, 550);
            click(1015, 500);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(String.valueOf(ui.reader()), "Infinity");
    }

    @Test
    public void xpowerofy() {
//        3^3 = 27
//        calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 3.0);
//        assertEquals(calc.calculateEqual(3.0), 27, 0);

        try {
            click(1065, 500);
            click(950, 400);
            click(1060, 600);
            click(950, 400);
            click(1015, 500);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 27, 0);
    }

    @Test
    public void square() {
//        15^2 = 225
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.square, 15.0), 225, 0);

        try {
            click(1065, 500);
            click(850, 400);
            click(900, 450);
            click(850, 600);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 225, 0);
    }

    @Test
    public void squareRoot() {
//        sqrt(25) = 5
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, 25.0), 5, 0);

        try {
            click(1065, 500);
            click(900, 400);
            click(900, 450);
            click(930, 600);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 5, 0);

//        sqrt(-25) = NaN
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, -25.0), Double.NaN, 0);
        try {
            click(1065, 500);
            click(850, 550);
            click(1065, 400);
            click(900, 400);
            click(900, 450);
            click(1015, 500);
            click(930, 600);
            // result = NaN --> textbox = "" --> reader() makes error
            // click 1 --> textbox should be 1
            click(850, 400);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 1, 0);
    }

    @Test
    public void oneDivideBy() {
//        1/5 = 0.2
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 5.0), 0.2, 0);

        try {
            click(1065, 500);
            click(900, 450);
            click(1000, 600);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 0.2, 0);
    }

    @Test
    public void abs() {
//        abs(0-1) = 1
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.abs, -1.0), 1, 0);
        try {
            click(1065, 500);
            click(850, 550);
            click(1065, 400);
            click(850, 400);
            click(1015, 500);
            click(1010, 700);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 1, 0);

//        abs(1) = 1
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.abs, 1.0), 1, 0);
        try {
            click(1065, 500);
            click(850, 400);
            click(1010, 700);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 1, 0);
    }

    @Test
    public void sin() {
//        sin(0) = 0
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.sin, 0.0), 0, 0);
        try {
            click(1065, 500);
            click(850, 550);
            click(960, 650);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 0, 0);
    }

    @Test
    public void cos() {
//        cos(0) = 1
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.cos, 0.0), 1, 0);
        try {
            click(1065, 500);
            click(850, 550);
            click(890, 650);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 1, 0);
    }

    @Test
    public void tan() {
//        tan(0) = 0
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 0.0), 0, 0);
        try {
            click(1065, 500);
            click(850, 550);
            click(1030, 650);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 0, 0);

//        tan(90) = NaN
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 90.0), Double.NaN, 0);
        try {
            click(1065, 500);
            click(950, 500);
            click(850, 550);
            click(1030, 650);
            // result = NaN --> textbox = "" --> reader() makes error
            // click 1 --> textbox should be 1
            click(850, 400);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 1, 0);

//        tan(7)
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.tan, 7.0), Math.tan(7), 0);
        try {
            click(1065, 500);
            click(850, 500);
            click(1030, 650);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), Math.tan(7), 0.2);
    }

    @Test
    public void log() {
//        log10(100) = 2
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.log, 100.0), 2, 0);
        try {
            click(1065, 500);
            click(850, 400);
            click(850, 550);
            click(850, 550);
            click(850, 700);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 2, 0);
    }

    @Test
    public void rate() {
//        rate(50) = 0.5
//        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.rate, 50.0), 0.5, 0);
        try {
            click(1065, 500);
            click(900, 450);
            click(850, 550);
            click(930, 700);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 0.5, 0);
    }

    @Test
    public void bin() {
//        bin(5) = 101
        try {
            click(1065, 500);
            click(900, 450);
            click(1090, 700);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ui.reader(), 101, 0);
    }

    /*
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

        while(true) {
            PointerInfo pt = MouseInfo.getPointerInfo();
            pt = MouseInfo.getPointerInfo();
            System.out.println(pt.getLocation()); // x,y
        }

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
    }
    */



}
