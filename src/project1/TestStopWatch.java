package project1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.assertEquals;


public class TestStopWatch {

    @Test
    //Max and Maz
    public void testConstructor1() {

        StopWatch s1 = new StopWatch(1, 7, 222);

        assertEquals(1, s1.getMinutes());
        assertEquals(7, s1.getSeconds());
        assertEquals(222, s1.getMilliseconds());
    }

    @Test
    //Max and Maz
    public void testConstructor2() {

        StopWatch s2 = new StopWatch(42, 22);

        assertEquals(0, s2.getMinutes());
        assertEquals(42, s2.getSeconds());
        assertEquals(22, s2.getMilliseconds());
    }

    @Test
    //Max and Maz
    public void testConstructor3() {

        StopWatch s2 = new StopWatch(3);

        assertEquals(0, s2.getMinutes());
        assertEquals(0, s2.getSeconds());
        assertEquals(3, s2.getMilliseconds());
    }

    @Test
    //Max and Maz
    public void testConstructor4() {

        StopWatch s2 = new StopWatch();

        assertEquals(0, s2.getMinutes());
        assertEquals(0, s2.getSeconds());
        assertEquals(0, s2.getMilliseconds());
    }

    @Test
    //Max and Maz
    public void testConstructor5() {

        StopWatch s2 = new StopWatch("3");

        assertEquals(0, s2.getMinutes());
        assertEquals(0, s2.getSeconds());
        assertEquals(3, s2.getMilliseconds());
    }

    @Test
    //Max and Maz
    public void testConstructor6() {

        StopWatch s2 = new StopWatch("4:3");

        assertEquals(0, s2.getMinutes());
        assertEquals(4, s2.getSeconds());
        assertEquals(3, s2.getMilliseconds());
    }
    //Max and Maz
    @Test
    public void testConstructor7() {

        StopWatch s2 = new StopWatch("5:4:3");

        assertEquals(5, s2.getMinutes());
        assertEquals(4, s2.getSeconds());
        assertEquals(3, s2.getMilliseconds());

    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError1() {
        StopWatch s1 = new StopWatch(-100);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError2() {
        StopWatch s1 = new StopWatch(1001);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError3() {
        StopWatch s1 = new StopWatch(-100, 1);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError4() {
        StopWatch s1 = new StopWatch(1, -10);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError5() {
        StopWatch s1 = new StopWatch(100, 100);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError6() {
        StopWatch s1 = new StopWatch(10, 1003);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError7() {
        StopWatch s1 = new StopWatch(-10, 3, 100);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError8() {
        StopWatch s1 = new StopWatch(10, -3, 100);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError9() {
        StopWatch s1 = new StopWatch(1, 10, -100);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError10() {
        StopWatch s1 = new StopWatch(1, 100, 100);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorError11() {
        StopWatch s1 = new StopWatch(1, 10, 10000);
    }
    //Max and Maz
    @Test
    public void testInc1() {

        StopWatch s2 = new StopWatch(999);

        s2.inc();

        assertEquals(1, s2.getSeconds());
        assertEquals(0, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void testInc2() {

        StopWatch s2 = new StopWatch(2, 4);

        s2.inc();
        s2.inc();
        s2.inc();

        assertEquals(2, s2.getSeconds());
        assertEquals(7, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void testDec1() {

        StopWatch s2 = new StopWatch(2, 4, 1);

        s2.dec();
        s2.dec();

        assertEquals(2, s2.getMinutes());
        assertEquals(3, s2.getSeconds());
        assertEquals(999, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void testDec2() {

        StopWatch s2 = new StopWatch(1, 23);

        s2.dec();
        s2.dec();
        s2.dec();
        s2.dec();
        s2.dec();
        s2.dec();

        assertEquals(1, s2.getSeconds());
        assertEquals(17, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void testAdd1() {

        StopWatch s2 = new StopWatch(1, 23);

        s2.add(100);

        assertEquals(123, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void testAdd2() {

        StopWatch s2 = new StopWatch(1, 900);

        s2.add(100);

        assertEquals(2, s2.getSeconds());
        assertEquals(0, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void testAdd3() {

        StopWatch s2 = new StopWatch();

        s2.add(1000000);

        assertEquals(16, s2.getMinutes());
        assertEquals(40, s2.getSeconds());
        assertEquals(0, s2.getMilliseconds());

    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testAddError1() {
        StopWatch s1 = new StopWatch(1);
        s1.add(-1);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testAddError2() {
        StopWatch s1 = new StopWatch(-1, 100);
        StopWatch s2 = new StopWatch(10, 10);
        s2.add(s1);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testAddError3() {
        StopWatch s1 = new StopWatch(-1, 1, 100);
        StopWatch s2 = new StopWatch(10, 10, 10);
        s2.add(s1);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testSubError1() {
        StopWatch s1 = new StopWatch();
        s1.sub(0);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testSubError2() {
        StopWatch s1 = new StopWatch();
        s1.sub(-1);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testSubError3() {
        StopWatch s1 = new StopWatch(-1, 1, 100);
        StopWatch s2 = new StopWatch(10, 10, 10);
        s2.sub(s1);
    }
    //Max and Maz
    @Test(expected = IllegalArgumentException.class)
    public void testSubError4() {
        StopWatch s1 = new StopWatch(-1, 100);
        StopWatch s2 = new StopWatch(10, 10);
        s2.sub(s1);
    }
    //Max and Maz
    @Test
    public void subtractTest1() {

        StopWatch s2 = new StopWatch(100);

        s2.sub(100);

        assertEquals(0, s2.getMinutes());
        assertEquals(0, s2.getSeconds());
        assertEquals(0, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void subtractTest2() {

        StopWatch s2 = new StopWatch(800);

        s2.sub(500);
        s2.sub(200);

        assertEquals(0, s2.getMinutes());
        assertEquals(0, s2.getSeconds());
        assertEquals(100, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void subtractTest3() {

        StopWatch s2 = new StopWatch(1, 100);

        s2.sub(600);


        assertEquals(0, s2.getMinutes());
        assertEquals(0, s2.getSeconds());
        assertEquals(500, s2.getMilliseconds());

    }
    //Max and Maz
    @Test
    public void testEqualsStopWatch() {

        StopWatch s3 = new StopWatch(2, 3, 4);
        StopWatch s2 = new StopWatch(2, 3, 4);

        Assert.assertTrue(s2.equals(s3));

    }
    //Max and Maz
    @Test
    public void testNotEqualsStopWatch() {

        StopWatch s3 = new StopWatch(2, 3, 4);
        StopWatch s2 = new StopWatch(5, 2, 4);

        Assert.assertFalse(s2.equals(s3));

    }
    //Max and Maz
    @Test
    public void testStaticEqualsStopWatch() {

        StopWatch s3 = new StopWatch(2, 3, 4);
        StopWatch s2 = new StopWatch(2, 3, 4);

        Assert.assertTrue(StopWatch.equals(s2, s3));

    }
    //Max and Maz
    @Test
    public void testStaticNotEqualsStopWatch() {

        StopWatch s3 = new StopWatch(2, 3, 4);
        StopWatch s2 = new StopWatch(5, 2, 4);

        Assert.assertFalse(StopWatch.equals(s2, s3));

    }
    //Max and Maz
    @Test
    public void testCompareto1() {
        StopWatch s3 = new StopWatch(2, 3, 4);
        StopWatch s2 = new StopWatch(2, 3, 5);

        assertEquals(-1, s3.compareTo(s2));
        assertEquals(1, s2.compareTo(s3));
    }
    //Max and Maz
    @Test
    public void testCompareto2() {
        StopWatch s3 = new StopWatch(2, 3, 4);
        StopWatch s2 = new StopWatch(2, 3, 4);

        assertEquals(0, s3.compareTo(s2));
        assertEquals(0, s2.compareTo(s3));
    }
    //Max and Maz
    @Test
    public void testToString1() {
        StopWatch s1 = new StopWatch(2, 32, 404);
        assertEquals("2:32:404", s1.toString());
    }
    //Max and Maz
    @Test
    public void testToString2() {

        StopWatch s1 = new StopWatch(2, 3, 4);
        assertEquals("2:03:004", s1.toString());
    }
    //Max and Maz
    @Test
    public void testToString3() {
        StopWatch s1 = new StopWatch(2, 32, 4);
        assertEquals("2:32:004", s1.toString());
    }
    //Max and Maz
    @Test
    public void testToString4() {
        StopWatch s1 = new StopWatch(2, 32, 42);
        assertEquals("2:32:042", s1.toString());
    }
    //Max and Maz
    @Test
    public void testToString5() {
        StopWatch s1 = new StopWatch(2, 2, 421);
        assertEquals("2:02:421", s1.toString());
    }
    //Max and Maz
    @Test
    public void testToString6() {
        StopWatch s1 = new StopWatch(2, 2, 21);
        assertEquals("2:02:021", s1.toString());
    }
    //Max and Maz
    @Test
    public void testToSaveAndLoad() {

        StopWatch s1 = new StopWatch(2, 5, 7);
        s1.save("StopWatchFile");
        s1 = new StopWatch(0, 1, 0);
        s1.load("StopWatchFile");
        Assert.assertEquals(2, s1.getMinutes());
        Assert.assertEquals(5, s1.getSeconds());
        Assert.assertEquals(7, s1.getMilliseconds());

        s1 = new StopWatch();
        s1.setMinutes(1);
        s1.setSeconds(2);
        s1.setMilliseconds(3);
        s1.save("StopWatchFile");
        s1 = new StopWatch();
        s1.load("StopWatchFile");
        Assert.assertEquals(1, s1.getMinutes());
        Assert.assertEquals(2, s1.getSeconds());
        Assert.assertEquals(3, s1.getMilliseconds());
    }
    //Max and Maz
    @Test
    public void testToSuspend() {
        StopWatch s2 = new StopWatch();
        StopWatch.setSuspended(true);
        Assert.assertTrue(s2.isSuspended());

        s2.inc();
        s2.inc();

        Assert.assertEquals(0, s2.getMilliseconds());
        StopWatch.setSuspended(false);
        Assert.assertFalse(s2.isSuspended());
    }
    /**
     * **********************************************************************
     */
    @Test
    public void testMinutes() {
        StopWatch s = new StopWatch();
        s.setMinutes(99);
        Assert.assertTrue(s.getMinutes() == 99);
    }

    @Test
    public void testZeroMinutes() {
        StopWatch s = new StopWatch();
        s.setMinutes(0);
        Assert.assertTrue(s.getMinutes() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnderMinutes() {
        StopWatch s = new StopWatch();
        s.setMinutes(-99);
    }

    @Test
    public void testSeconds() {
        StopWatch s = new StopWatch();
        s.setSeconds(59);
        Assert.assertTrue(s.getSeconds() == 59);
    }

    @Test
    public void testZeroSeconds() {
        StopWatch s = new StopWatch();
        s.setSeconds(0);
        Assert.assertTrue(s.getSeconds() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnderSeconds() {
        StopWatch s = new StopWatch();
        s.setSeconds(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOverSeconds() {
        StopWatch s = new StopWatch();
        s.setSeconds(60);
    }

    @Test
    public void testMilliseconds() {
        StopWatch s = new StopWatch();
        s.setMilliseconds(999);
        Assert.assertTrue(s.getMilliseconds() == 999);
    }

    @Test
    public void testZeroMilliseconds() {
        StopWatch s = new StopWatch();
        s.setMilliseconds(0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOverMilliseconds() {
        StopWatch s = new StopWatch();
        s.setMilliseconds(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnderMilliseconds() {
        StopWatch s = new StopWatch();
        s.setMilliseconds(-1);
    }

    @Test
    public void testDefaultConstructor() {
        StopWatch s = new StopWatch();
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test
    public void testConstructor3Parameters() {
        StopWatch s = new StopWatch(2, 3, 4);
        Assert.assertTrue(s.getMinutes() == 2);
        Assert.assertTrue(s.getSeconds() == 3);
        Assert.assertTrue(s.getMilliseconds() == 4);
    }

    @Test
    public void testConstructor3Parameters2() {
        StopWatch s = new StopWatch(0, 0, 0);
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3ParametersOverSeconds() {
        StopWatch s = new StopWatch(12, 61, 14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3ParametersOverMilliseconds() {
        StopWatch s = new StopWatch(0, 0, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3ParametersUnderMinutes() {
        StopWatch s = new StopWatch(-1, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3ParametersUnderSeconds() {
        StopWatch s = new StopWatch(0, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3ParametersUnderMilliseconds() {
        StopWatch s = new StopWatch(12, 67, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3ParametersUnderAll() {
        StopWatch s = new StopWatch(-1, -5, -2);
    }

    @Test
    public void testConstructor2Parameters() {
        StopWatch s = new StopWatch(2, 2);
        Assert.assertTrue(s.getSeconds() == 2);
        Assert.assertTrue(s.getMilliseconds() == 2);
    }

    @Test
    public void testConstructor2ParametersZero() {
        StopWatch s = new StopWatch(0, 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2ParametersNegativeSeconds() {
        StopWatch s = new StopWatch(-2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2ParametersNegativeMilliseconds() {
        StopWatch s = new StopWatch(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2ParametersOverMilliseconds() {
        StopWatch s = new StopWatch(0, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2ParametersOverSeconds() {
        StopWatch s = new StopWatch(60, 2);
    }

    @Test
    public void testConstructor1Parameter() {
        StopWatch s = new StopWatch(2);
        Assert.assertTrue(s.getMilliseconds() == 2);
    }

    @Test
    public void testConstructor1Parameter300() {
        StopWatch s = new StopWatch(300);
        Assert.assertTrue(s.getMilliseconds() == 300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1ParameterOverMilliseconds() {
        StopWatch s = new StopWatch(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1ParameterUnderMilliseconds() {
        StopWatch s = new StopWatch(-1);
    }

    // There can only be one test here
    // no more lines of code after "new StopWatch("-2");"
    @Test(expected = IllegalArgumentException.class)
    public void testNegSingleInput2() {
        new StopWatch(-2);
    }

    @Test
    public void testConstructorStringOneNumber() {
        StopWatch s = new StopWatch("444");
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 444);
    }

    @Test
    public void testConstructorStringTwoNumbers() {
        StopWatch s = new StopWatch("4:4");
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 4);
        Assert.assertTrue(s.getMilliseconds() == 4);
    }

    @Test
    public void testConstructorStringThreeNumbers() {
        StopWatch s = new StopWatch("4:4:4");
        Assert.assertTrue(s.getMinutes() == 4);
        Assert.assertTrue(s.getSeconds() == 4);
        Assert.assertTrue(s.getMilliseconds() == 4);
    }

    @Test
    public void testConstructorStringThreeNumbers2() {
        StopWatch s = new StopWatch("11:11:111");
        Assert.assertTrue(s.getMinutes() == 11);
        Assert.assertTrue(s.getSeconds() == 11);
        Assert.assertTrue(s.getMilliseconds() == 111);
    }

    @Test
    public void testConstructorStringZero() {
        StopWatch s = new StopWatch("00:00:000");
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringThreeLetters() {
        StopWatch s = new StopWatch("aaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringMillisecondsAndColon() {
        StopWatch s = new StopWatch(":44");
    }

    //Fail
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorStringMillisecondsAndColon2() {
        StopWatch s = new StopWatch("33:");
    }


    @Test
    public void testConstructorAndToString() {
        StopWatch s = new StopWatch(5, 10, 300);
        assertEquals(s.toString(), "5:10:300");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegDouble1Input() {
        new StopWatch("-59:-23");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegDouble2aInput() {
        new StopWatch("2:-2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAInput() {
        new StopWatch("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringOverSeconds() {
        new StopWatch("00:60:000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringOverMilliseconds() {
        new StopWatch("1000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringOverSecondsTwoParamters() {
        new StopWatch("60:000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringUnderSecondsTwoParamters() {
        new StopWatch("-1:000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringUnderMillisecondsOneParameter() {
        new StopWatch("-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringUnderMillisecondsTwoParameters() {
        new StopWatch("00:-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringUnderMillisecondsThreeParameters() {
        new StopWatch("00:00:-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringUnderSecondsTwoParameters() {
        new StopWatch("-1:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringUnderSecondsThreeParameters() {
        new StopWatch("00:-1:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringUnderMinutesThreeParameters() {
        new StopWatch("-1:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringThreeLettersWithColons() {
        new StopWatch("a:a:a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringTwoLettersWithColons() {
        new StopWatch("b:z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringCharacters() {
        new StopWatch("///");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringCharacters2() {
        new StopWatch("%%%");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringCharactersWithThreeColons() {
        new StopWatch("%:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStringCharactersWithTwoColons() {
        new StopWatch("&:00");
    }

    @Test
    public void testEqual() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(6, 01, 200);
        StopWatch s3 = new StopWatch(5, 50, 200);
        StopWatch s4 = new StopWatch(5, 59, 300);

        Assert.assertFalse(s1.equals(s2));
        Assert.assertTrue(s1.equals(s4));

        Assert.assertTrue(s2.compareTo(s1) > 0);
        Assert.assertTrue(s3.compareTo(s1) < 0);
        Assert.assertTrue(s1.compareTo(s4) == 0);
    }

    @Test
    public void testEqualsStopWatchParameter() {
        StopWatch s1 = new StopWatch(0, 0, 000);
        StopWatch s2 = new StopWatch(0, 0, 000);

        Assert.assertTrue(s1.equals(s2));
    }

    @Test
    public void testEqualsStopWatchParameterOneMillisecond() {
        StopWatch s1 = new StopWatch(0, 0, 001);
        StopWatch s2 = new StopWatch(0, 0, 000);

        Assert.assertFalse(s1.equals(s2));
    }

    @Test
    public void testEqualsStopWatchParameterOneSecond() {
        StopWatch s1 = new StopWatch(0, 1, 000);
        StopWatch s2 = new StopWatch(0, 0, 000);

        Assert.assertFalse(s1.equals(s2));
    }

    @Test
    public void testEqualsStopWatchParameterOneMinute() {
        StopWatch s1 = new StopWatch(1, 0, 000);
        StopWatch s2 = new StopWatch(0, 0, 000);

        Assert.assertFalse(s1.equals(s2)); //QUESTION: WHAT IS THIS?
    }

    @Test
    public void equalsTest() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(5, 59, 300);
        assertEquals(s1, s2);
    }

    //QUESTION - Equals test

    //EQUALS TESTS

    @Test
    public void testEqualsStopWatch2Parameter() {
        StopWatch s = new StopWatch();

        StopWatch s1 = new StopWatch(0, 00, 000);
        StopWatch s2 = new StopWatch(0, 00, 000);

        Assert.assertTrue(s.equals(s1, s2));
    }

    @Test
    public void testEqualsStopWatch2ParameterMilliseconds() {
        StopWatch s = new StopWatch();

        StopWatch s1 = new StopWatch(0, 00, 001);
        StopWatch s2 = new StopWatch(0, 00, 000);

        Assert.assertFalse(s.equals(s1, s2));
    }

    @Test
    public void testEqualsStopWatch2ParameterSeconds() {
        StopWatch s = new StopWatch();

        StopWatch s1 = new StopWatch(0, 01, 000);
        StopWatch s2 = new StopWatch(0, 00, 000);

        Assert.assertFalse(s.equals(s1, s2));
    }

    @Test
    public void testEqualsStopWatch2ParameterMinutes() {
        StopWatch s = new StopWatch();

        StopWatch s1 = new StopWatch(1, 00, 000);
        StopWatch s2 = new StopWatch(0, 00, 000);

        Assert.assertFalse(s.equals(s1, s2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEqualsStopWatch2ParameterNegMin() {
        StopWatch s = new StopWatch();

        StopWatch s1 = new StopWatch(-1, 00, 000);
        StopWatch s2 = new StopWatch(0, 00, 000);

        Assert.assertFalse(s.equals(s1, s2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEqualsStopWatch2ParameterNegSec() {
        StopWatch s = new StopWatch();

        StopWatch s1 = new StopWatch(0, -1, 000);
        StopWatch s2 = new StopWatch(0, 00, 000);

        Assert.assertFalse(s.equals(s1, s2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEqualsStopWatch2ParameterNegMilliSeconds() {
        StopWatch s = new StopWatch();

        StopWatch s1 = new StopWatch(0, 00, -1);
        StopWatch s2 = new StopWatch(0, 00, -1);

        Assert.assertFalse(s.equals(s1, s2));
    }

    //CompareToTests:
    @Test
    public void testCompareToAbove() {
        StopWatch s1 = new StopWatch(5, 59, 999);
        StopWatch s2 = new StopWatch(6, 00, 000);

        Assert.assertTrue(s2.compareTo(s1) > 0);
    }

    @Test
    public void testCompareToSame() {
        StopWatch s1 = new StopWatch(0, 00, 00);
        StopWatch s2 = new StopWatch(0, 00, 00);

        Assert.assertTrue(s2.compareTo(s1) == 0);
    }

    @Test
    public void testCompareToSame2() {
        StopWatch s1 = new StopWatch(5, 59, 999);
        StopWatch s2 = new StopWatch(5, 59, 999);

        Assert.assertTrue(s2.compareTo(s1) == 0);
    }

    @Test
    public void testCompareToBelow() {
        StopWatch s1 = new StopWatch(0, 00, 001);
        StopWatch s2 = new StopWatch(0, 00, 000);

        Assert.assertTrue(s2.compareTo(s1) < 0);
    }

    @Test
    public void testCompareToBelow2() {
        StopWatch s1 = new StopWatch(9, 59, 999);
        StopWatch s2 = new StopWatch(9, 59, 998);

        Assert.assertTrue(s2.compareTo(s1) < 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareToNegativeMilliseconds() {
        StopWatch s1 = new StopWatch(0, 00, -1);
        StopWatch s2 = new StopWatch(0, 00, 000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareToNegativeSeconds() {
        StopWatch s1 = new StopWatch(0, -1, 000);
        StopWatch s2 = new StopWatch(0, 00, 000);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareToNegativeMinutes() {
        StopWatch s1 = new StopWatch(-1, 0, 000);
        StopWatch s2 = new StopWatch(0, 00, 000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareToOverSeconds() {
        StopWatch s1 = new StopWatch(0, 60, 000);
    }

    //FAILED
    @Test
    public void testAddMethod() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        s1.add(2000);
        assertEquals(s1.toString(), "6:01:300");

        s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(2, 2, 300);
        s1.add(s2);
        Assert.assertEquals("8:01:600", s1.toString());

        for (int i = 0; i < 15000; i++)
            s1.inc();
        Assert.assertEquals("8:16:600", s1.toString());
    }

    //test add methods

    @Test
    public void testAddMethodOther() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        s1.add(2000);
        Assert.assertEquals("6:01:300", s1.toString());

        s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(2, 2, 300);
        s1.add(s2);
        Assert.assertEquals("8:01:600", s1.toString());

        for (int i = 0; i < 15000; i++)
            s1.inc();

        Assert.assertEquals("8:16:600", s1.toString());
    }

    @Test
    public void testAddMethodIntParam() {
        StopWatch s1 = new StopWatch(0, 0, 000);
        s1.add(000);
        Assert.assertEquals("0:00:000", s1.toString());
    }

    @Test
    public void testAddMethodIntParamSeconds() {
        StopWatch s1 = new StopWatch(0, 0, 000);
        s1.add(1000);
        assertEquals(s1.toString(), "0:01:000");
    }

    @Test
    public void testAddMethodIntParamMinutes() {
        StopWatch s1 = new StopWatch(0, 0, 000);
        s1.add(60000);
        assertEquals(s1.toString(), "1:00:000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodIntParamNegMilliseconds() {
        StopWatch s1 = new StopWatch(0, 0, 000);
        s1.add(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodIntParamAnotherNegMilliseconds() {
        StopWatch s1 = new StopWatch(0, 0, 000);
        s1.add(-1000);
    }

    //ADD StopWatch (Kelly)
    @Test
    public void testAddMethodStopWatchOther() {
        StopWatch s1 = new StopWatch(0, 00, 000);
        StopWatch s2 = new StopWatch(0, 00, 001);
        s1.add(s2);

        assertEquals(s1.toString(), "0:00:001");
    }

    @Test
    public void testAddMethodStopWatchOtherSecond() {
        StopWatch s1 = new StopWatch(0, 00, 000);
        StopWatch s2 = new StopWatch(0, 01, 001);
        s1.add(s2);

        assertEquals(s1.toString(), "0:01:001");
    }

    @Test
    public void testAddMethodStopWatchOtherMinute() {
        StopWatch s1 = new StopWatch(0, 00, 000);
        StopWatch s2 = new StopWatch(10, 01, 001);
        s1.add(s2);

        assertEquals(s1.toString(), "10:01:001");
    }

    //FAILED
    @Test
    public void testAddMethodStopWatchOtherAll() {
        StopWatch s1 = new StopWatch(0, 00, 998);
        StopWatch s2 = new StopWatch(0, 00, 1);
        s1.add(s2);

        assertEquals(s1.toString(), "0:00:999");
    }

    @Test
    public void testAddMethodStopWatchOtherOverMilliseconds() {
        StopWatch s1 = new StopWatch(0, 00, 999);
        StopWatch s2 = new StopWatch(0, 00, 1);
        s1.add(s2);

        assertEquals(s1.toString(), "0:01:000");
    }

    @Test
    public void testAddMethodStopWatchOtherOverSeconds() {
        StopWatch s1 = new StopWatch(0, 59, 999);
        StopWatch s2 = new StopWatch(0, 00, 01);
        s1.add(s2);

        assertEquals(s1.toString(), "1:00:000");
    }

    @Test
    public void testAddMethodStopWatchOtherOverMinute() {
        StopWatch s1 = new StopWatch(10, 59, 999);
        StopWatch s2 = new StopWatch(0, 00, 01);
        s1.add(s2);

        assertEquals(s1.toString(), "11:00:000");
    }

    @Test
    public void testAddMethodStopWatchOtherMilliseconds() {
        StopWatch s1 = new StopWatch(0, 00, 10);
        StopWatch s2 = new StopWatch(0, 00, 10);
        s1.add(s2);

        assertEquals(s1.toString(), "0:00:020");
    }

    @Test
    public void testAddMethodStopWatchOtherMilliseconds2() {
        StopWatch s1 = new StopWatch(0, 00, 400);
        StopWatch s2 = new StopWatch(0, 00, 9);
        s1.add(s2);

        assertEquals(s1.toString(), "0:00:409");
    }

    @Test
    public void testAddMethodStopWatchOtherSeconds() {
        StopWatch s1 = new StopWatch(0, 20, 10);
        StopWatch s2 = new StopWatch(0, 10, 10);
        s1.add(s2);

        assertEquals(s1.toString(), "0:30:020");
    }

    @Test
    public void testAddMethodStopWatchOtherMinutesBorder() {
        StopWatch s1 = new StopWatch(2, 59, 000);
        StopWatch s2 = new StopWatch(0, 01, 000);
        s1.add(s2);

        assertEquals(s1.toString(), "3:00:000");
    }

    @Test
    public void testAddMethodStopWatchOtherMinutes() {
        StopWatch s1 = new StopWatch(2, 59, 000);
        StopWatch s2 = new StopWatch(5, 01, 000);
        s1.add(s2);

        assertEquals(s1.toString(), "8:00:000");
    }

    //inc tests

    @Test
    public void testIncMilli() {
        StopWatch s1 = new StopWatch(0, 00, 000);
        s1.inc();
        assertEquals(s1.toString(), "0:00:001");
    }

    @Test
    public void testIncSec() {
        StopWatch s1 = new StopWatch(0, 00, 999);
        s1.inc();
        assertEquals(s1.toString(), "0:01:000");
    }

    @Test
    public void testIncMin() {
        StopWatch s1 = new StopWatch(0, 59, 999);
        s1.inc();
        assertEquals(s1.toString(), "1:00:000");
    }

    @Test
    public void testSubParamOtherMilli() {

        StopWatch s1 = new StopWatch(0, 00, 100);
        StopWatch s2 = new StopWatch(0, 00, 001);

        s1.sub(s2);
        assertEquals(s1.toString(), "0:00:099");

    }

    //SUB(Milliseconds) tests (Kelly)
    @Test
    public void testSubMilliseconds() {
        StopWatch s = new StopWatch(0, 00, 1);
        s.sub(1);
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test
    public void testSubMillisecondsSecond() {
        StopWatch s = new StopWatch(0, 1, 0);
        s.sub(1);
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 999);
    }

    @Test
    public void testSubMillisecondsMinute() {
        StopWatch s = new StopWatch(1, 00, 0);
        s.sub(1);
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 59);
        Assert.assertTrue(s.getMilliseconds() == 999);
    }

    @Test
    public void testSubMillisecondsMinute2() {
        StopWatch s = new StopWatch(10, 00, 0);
        s.sub(1);
        Assert.assertTrue(s.getMinutes() == 9);
        Assert.assertTrue(s.getSeconds() == 59);
        Assert.assertTrue(s.getMilliseconds() == 999);
    }

    @Test
    public void testSubMillisecondsMillisecondsNormal() {
        StopWatch s = new StopWatch(0, 00, 400);
        s.sub(100);
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 300);
    }

    @Test
    public void testSubMillisecondsMillisecondsToZero() {
        StopWatch s = new StopWatch(0, 00, 400);
        s.sub(400);
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test
    public void testSubMillisecondsSecondsToZero() {
        StopWatch s = new StopWatch(0, 2, 000);
        s.sub(2000);
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test
    public void testSubMillisecondsMinutesToZero() {
        StopWatch s = new StopWatch(1, 0, 0);
        s.sub(60000);
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    //Failed
    @Test(expected = IllegalArgumentException.class)
    public void testSubMillisecondsMinutesOverZero() {
        StopWatch s = new StopWatch(1, 0, 0);
        s.sub(60001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubMillisecondsFail() {
        StopWatch s1 = new StopWatch(0, 00, 000);
        s1.sub(1);
    }

    //sub tests

    @Test
    public void testSubParamOtherSec() {

        StopWatch s1 = new StopWatch(0, 10, 000);
        StopWatch s2 = new StopWatch(0, 00, 999);

        s1.sub(s2);
        Assert.assertEquals("0:09:001", s1.toString());

    }

    @Test
    public void testSubParamOtherMin() {

        StopWatch s1 = new StopWatch(10, 00, 000);
        StopWatch s2 = new StopWatch(0, 00, 001);

        s1.sub(s2);
        assertEquals(s1.toString(), "9:59:999");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubParamOtherNegMin() {

        StopWatch s1 = new StopWatch(10, 00, 000);
        StopWatch s2 = new StopWatch(0, 00, -001);

        s1.sub(s2);
        assertEquals(s1.toString(), "9:59:999");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubParamOtherNegMilli() {

        StopWatch s1 = new StopWatch(0, 00, 100);
        StopWatch s2 = new StopWatch(0, 00, -001);

        s1.sub(s2);
        assertEquals(s1.toString(), "0:00:099");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubParamOtherNegSec() {

        StopWatch s1 = new StopWatch(0, 10, 000);
        StopWatch s2 = new StopWatch(0, 00, -999);

        s1.sub(s2);
        assertEquals(s1.toString(), "0:09:001");

    }

    //Decrement Tests
    @Test
    public void testDecNormal() {
        StopWatch s = new StopWatch(0, 0, 1);
        s.dec();
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
    }

    @Test
    public void testDecNormal2() {
        StopWatch s = new StopWatch(0, 0, 10);
        s.dec();
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 9);
    }

    @Test
    public void testDecSeconds() {
        StopWatch s = new StopWatch(0, 1, 0);
        s.dec();
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 999);
    }

    //PASSES
    @Test
    public void testDecMinutes() {
        StopWatch s = new StopWatch(1, 0, 0);
        s.dec();
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 59);
        Assert.assertTrue(s.getMilliseconds() == 999);
    }

    //FAILED
    @Test
    public void testDecMinutes2() {
        StopWatch s = new StopWatch(11, 0, 0);
        s.dec();
        Assert.assertTrue(s.getMinutes() == 10);
        Assert.assertTrue(s.getSeconds() == 59);
        Assert.assertTrue(s.getMilliseconds() == 999);
    }

    @Test
    public void testDecThreeTimes() {
        StopWatch s = new StopWatch(0, 0, 4);
        s.dec();
        s.dec();
        s.dec();
        Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecMillisecondsFail() {
        StopWatch s = new StopWatch(0, 0, 0);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecMillisecondsFail2() {
        StopWatch s = new StopWatch(0, 0, 2);
        s.dec();
        s.dec();
        s.dec();
    }

    //test to string
    @Test
    public void testToStringBasic() {
        StopWatch s = new StopWatch(0, 00, 000);

        Assert.assertEquals("0:00:000", s.toString());
    }

    @Test
    public void testToStringBasic2() {
        StopWatch s = new StopWatch(0, 00, 010);   //treated milliseconds as octal

        Assert.assertEquals("0:00:008",s.toString());
    }


    @Test
    public void testToStringSecondsOneDigit() {
        StopWatch s = new StopWatch(0, 9, 000);

        Assert.assertEquals("0:09:000", s.toString());
    }

    @Test
    public void testToStringSecondsTwoDigits() {
        StopWatch s = new StopWatch(0, 19, 000);

        Assert.assertEquals("0:19:000", s.toString());
    }

    @Test
    public void testToStringMillisecondsTwoDigits() {
        StopWatch s = new StopWatch(0, 19, 90);

        Assert.assertEquals("0:19:090", s.toString());
    }

    @Test
    public void testToStringMillisecondsThreeDigits() {
        StopWatch s = new StopWatch(0, 19, 999);

        Assert.assertEquals("0:19:999", s.toString());
    }

    @Test
    public void testToStringAllChange() {
        StopWatch s = new StopWatch(2, 19, 999);

        Assert.assertEquals("2:19:999", s.toString());
    }

    @Test
    public void testToStringBigMin() {
        StopWatch s = new StopWatch(25, 19, 999);

        Assert.assertEquals("25:19:999", s.toString());
    }

    @Test
    public void testCompareTo() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(6, 01, 200);
        StopWatch s3 = new StopWatch(5, 50, 200);
        StopWatch s4 = new StopWatch(5, 59, 300);

        Assert.assertFalse(s1.equals(s2));
        Assert.assertTrue(s1.equals(s4));

        Assert.assertTrue(s2.compareTo(s1) > 0);
        Assert.assertTrue(s3.compareTo(s1) < 0);
        Assert.assertTrue(s1.compareTo(s4) == 0);

    }

    @Test
    public void testLoadSave() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(5, 59, 300);

        s1.save("file1");
        s1 = new StopWatch();  // resets to zero

        s1.load("file1");
        Assert.assertTrue(s1.equals(s2));
    }

    @Test
    public void testMutate() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(5, 59, 300);

        StopWatch.setSuspended(true);
        s1.add(1000);
        Assert.assertTrue(s1.equals(s2));
        StopWatch.setSuspended(false);
    }
}
