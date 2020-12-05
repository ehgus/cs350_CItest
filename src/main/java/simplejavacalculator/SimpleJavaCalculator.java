/**
 * @name        Simple Java Calculator
 * @file        SimpleJavaCalculator.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;
import java.util.logging.Logger;


public class SimpleJavaCalculator {
   private static final Logger LOG = Logger.getGlobal();
   public static void main(String[] args) {
      try {
         UI uiCal = new UI();
         uiCal.init();
      }
      catch (Exception e) {
         LOG.info(e.getMessage());   
      }
      
   }
}
