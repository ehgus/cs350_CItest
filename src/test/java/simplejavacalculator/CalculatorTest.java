package simplejavacalculator;

//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.AWTException;
import java.awt.Robot;
//import java.awt.PointerInfo;
//import java.awt.MouseInfo;
import java.awt.event.InputEvent;

//import javax.swing.text.AbstractWriter;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
    private Calculator calc;
    private UI ui;

    private void click_clear() throws AWTException{
        click(1065, 500);
    }

    private void click_equal() throws AWTException{
        click(1015, 500);
    }

    private void click_num(int num) throws AWTException{
        if (num<0) {
            System.err.println("This negative input is not developed yet");
        }else {
            do {
                int remainder =num%10;
                if (remainder==0){
                    click(850,550);
                }else{
                    click(850+((remainder-1)%3)*50,400+((remainder-1)/3)*50);
                }
                num/=10;
            }while (num!=0);
        }
    }

    private void click_op(Calculator.BiOperatorModes bimode) throws AWTException{
        if (bimode == Calculator.BiOperatorModes.ADD){
            click(1015, 400);
        }else if (bimode == Calculator.BiOperatorModes.MINUS){
            click(1065, 400);
        }else if (bimode == Calculator.BiOperatorModes.MULTIPLY){
            click(1015, 450);
        }else if (bimode == Calculator.BiOperatorModes.DIVIDE){
            click(1065, 450);
        }else if (bimode == Calculator.BiOperatorModes.XPOWEROFY){
            click(1065, 600);
        }
    }

    private static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.setAutoDelay(1);
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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
        //try{
        //    ui = new UI();
        //    ui.init();
        //}
        //catch (Exception e){
        //    assertTrue(false);
        //}
    }

    @Test
    public void add() {
        // 3+2 = 5
        calc.calculateBi(Calculator.BiOperatorModes.ADD, 3.0);
        assertEquals(calc.calculateEqual(2.0), 5, 0);

        // 10+0 = 10 --> may have to modify Calculator.java code later to improve quality
        calc.calculateBi(Calculator.BiOperatorModes.ADD, 10.0);
        assertEquals(calc.calculateEqual(0.0), 10, 0);
    }

    @Test
    public void minus() {
        // 3-2 = 1
        calc.calculateBi(Calculator.BiOperatorModes.MINUS, 3.0);
        assertEquals(calc.calculateEqual(2.0), 1, 0);
    }

    @Test
    public void multiply() {
        // 15*7 = 105
        calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY, 15.0);
        assertEquals(calc.calculateEqual(7.0), 105, 0);
    }

    @Test
    public void divide() {
        // 18/6 = 3
        calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 18.0);
        assertEquals(calc.calculateEqual(6.0), 3, 0);

        // 4/0 = Infinity
        calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 4.0);
        assertEquals(calc.calculateEqual(0.0), Double.POSITIVE_INFINITY, 0);
    }

    @Test
    public void xpowerofy() {
        // 3^3 = 27
        calc.calculateBi(Calculator.BiOperatorModes.XPOWEROFY, 3.0);
        assertEquals(calc.calculateEqual(3.0), 27, 0);
    }

    @Test
    public void square() {
        // 15^2 = 225
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.SQUARE, 15.0), 225, 0);
    }

    @Test
    public void squareRoot() {
        // sqrt(25) = 5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT, 25.0), 5, 0);

        // sqrt(-25) = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT, -25.0), Double.NaN, 0);
    }

    @Test
    public void oneDivideBy() {
        //1/5 = 0.2
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.ONEDIVIDEDBY, 5.0), 0.2, 0);
    }

    @Test
    public void abs() {
        // abs(0-1) = 1
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.ABS, -1.0), 1, 0);

        // abs(1) = 1
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.ABS, 1.0), 1, 0);
    }

    @Test
    public void sin() {
        // sin(0) = 0
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.SIN, 0.0), 0, 0);
    }

    @Test
    public void cos() {
        // cos(0) = 1
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.COS, 0.0), 1, 0);
    }

    @Test
    public void tan() {
        //tan(0) = 0
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.TAN, 0.0), 0, 0);

        // tan(90) = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.TAN, 90.0), Double.NaN, 0);

        // tan(7)
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.TAN, 7.0), Math.tan(7), 0);
    }

    @Test
    public void log() {
        // log10(100) = 2
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.LOG, 100.0), 2, 0);
    }

    @Test
    public void rate() {
        // rate(50) = 0.5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.RATE, 50.0), 0.5, 0);
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
    @Test(timeout = 6000)
    public void gui_simple_test() throws Exception {
        click_clear();
        click_num(3);
        click_op(Calculator.BiOperatorModes.ADD);
        click_num(2);
        click_equal();
        while (true) {
            try {
                assertEquals(ui.reader(),(Double)5.0);
                break;
            }
            catch (NullPointerException e){
                Thread.sleep(10);
                continue;
            }
        }
    }
    */
    /*
    @Test
    public void simpleTest() {
        String[] args = null;
        SimpleJavaCalculator.main(args);
    }
    */
}
