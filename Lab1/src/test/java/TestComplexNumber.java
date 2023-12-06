import org.junit.jupiter.api.Test;
import org.pocu.ComplexNumber;

import static org.junit.jupiter.api.Assertions.*;

public class TestComplexNumber {

    @Test
    void testIsReal(){
        assertTrue(new ComplexNumber().isReal());
        assertTrue(new ComplexNumber(1.3,0.0).isReal());
        assertFalse(new ComplexNumber(1.3,0.1).isReal());
    }

    @Test
    void testIsImaginary(){
        assertTrue(new ComplexNumber(0.0,-1.3).isImaginary());
        assertFalse(new ComplexNumber(1.3,0.3).isImaginary());
        assertFalse(new ComplexNumber(1.3).isImaginary());
    }

    @Test
    void testEquality(){
        assertEquals(new ComplexNumber(1.1,4.222222),new ComplexNumber(1.1,4.22222));
        assertNotEquals(new ComplexNumber(0.22222),new ComplexNumber(0.2222));
    }

    @Test
    void testGetConjugate(){
        assertEquals(new ComplexNumber(1.1,-23),new ComplexNumber(1.1,23).getConjugate());
        assertEquals(new ComplexNumber(0.0,23),new ComplexNumber(0.0,-23).getConjugate());
    }


    @Test
    void testRoundWithin(){
        ComplexNumber c1 = new ComplexNumber(1.9999999,-2.3333333);
        ComplexNumber c2 = c1.roundWithin();
        assertTrue(Math.abs(c1.real - c2.real) < 0.00001 );
        assertTrue(Math.abs(c1.imaginary - c2.imaginary) < 0.00001 );
    }

    @Test
    void testAdd(){
        ComplexNumber c1 = new ComplexNumber(3.4);
        ComplexNumber c2 = new ComplexNumber(5.1,-0.2);
        ComplexNumber cSum = c1.add(c2);
        assertEquals(new ComplexNumber(8.5,-0.2),cSum);
    }

    @Test
    void testSubtract(){
        ComplexNumber c1 = new ComplexNumber(3.4);
        ComplexNumber c2 = new ComplexNumber(5.1,-0.2);
        ComplexNumber cDiff = c1.subtract(c2);
        assertEquals(new ComplexNumber(-1.7,0.2),cDiff);
    }

    @Test
    void testMultiply(){
        ComplexNumber c1 = new ComplexNumber(4,3);
        ComplexNumber c2 = new ComplexNumber(2,-5);
        ComplexNumber cMultiply1 = c1.multiply(c2);
        ComplexNumber cMultiply2 = c2.multiply(c1);
        ComplexNumber resultMultiply = new ComplexNumber(23,-14);
        assertEquals(resultMultiply,cMultiply1);
        assertEquals(cMultiply1,cMultiply2);
    }

    @Test
    void testDivide(){
        ComplexNumber c1 = new ComplexNumber(1);
        ComplexNumber c2 = new ComplexNumber(2,3);
        ComplexNumber cMultiply1 = c1.divide(c2);
        ComplexNumber resultMultiply = new ComplexNumber(2.0/13,-3.0/13);
        assertEquals(resultMultiply,cMultiply1);
    }

}
