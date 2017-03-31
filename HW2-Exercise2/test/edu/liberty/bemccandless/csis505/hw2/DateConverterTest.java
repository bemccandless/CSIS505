package edu.liberty.bemccandless.csis505.hw2;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bemccandless
 */
public class DateConverterTest {
    
    private DateConverter instance;

    @Before
    public void setUp() {
        instance = new DateConverter();
    }

    @Test
    public void testConvertDate_January() throws InvalidDateException {
        String result = instance.convertDate("01/01/2017");
        assertEquals("January 1, 2017", result);
    }

    @Test
    public void testConvertDate_February() throws InvalidDateException {
        String result = instance.convertDate("02/19/1985");
        assertEquals("February 19, 1985", result);
    }

    @Test
    public void testConvertDate_March() throws InvalidDateException {
        String result = instance.convertDate("03/20/1980");
        assertEquals("March 20, 1980", result);
    }

    @Test
    public void testConvertDate_April() throws InvalidDateException {
        String result = instance.convertDate("04/19/2011");
        assertEquals("April 19, 2011", result);
    }

    @Test
    public void testConvertDate_May() throws InvalidDateException {
        String result = instance.convertDate("05/04/2016");
        assertEquals("May 4, 2016", result);
    }

    @Test
    public void testConvertDate_June() throws InvalidDateException {
        String result = instance.convertDate("06/29/1896");
        assertEquals("June 29, 1896", result);
    }

    @Test
    public void testConvertDate_July() throws InvalidDateException {
        String result = instance.convertDate("07/01/2005");
        assertEquals("July 1, 2005", result);
    }

    @Test
    public void testConvertDate_August() throws InvalidDateException {
        String result = instance.convertDate("08/31/1765");
        assertEquals("August 31, 1765", result);
    }

    @Test
    public void testConvertDate_September() throws InvalidDateException {
        String result = instance.convertDate("09/13/1982");
        assertEquals("September 13, 1982", result);
    }

    @Test
    public void testConvertDate_October() throws InvalidDateException {
        String result = instance.convertDate("10/09/2013");
        assertEquals("October 9, 2013", result);
    }

    @Test
    public void testConvertDate_November() throws InvalidDateException {
        String result = instance.convertDate("11/02/2009");
        assertEquals("November 2, 2009", result);
    }

    @Test
    public void testConvertDate_December() throws InvalidDateException {
        String result = instance.convertDate("12/01/1982");
        assertEquals("December 1, 1982", result);
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Invalid_Month() throws InvalidDateException {
        instance.convertDate("4/19/2011");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Invalid_Day() throws InvalidDateException {
        instance.convertDate("04/190/2011");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Invalid_Year() throws InvalidDateException {
        instance.convertDate("04/19/20119");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Invalid_NonNumeric() throws InvalidDateException {
        instance.convertDate("MM/DD/YYYY");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Invalid_MissingFirstSlash() throws InvalidDateException {
        instance.convertDate("0419/2011");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Invalid_MissingSecondSlash() throws InvalidDateException {
        instance.convertDate("04/192011");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Month_LessThan1() throws InvalidDateException {
        instance.convertDate("00/19/2011");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Invalid_Month_GreaterThan12() throws InvalidDateException {
        instance.convertDate("13/19/2011");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Invalid_Day_LessThan1() throws InvalidDateException {
        instance.convertDate("04/00/2011");
    }

    @Test(expected = InvalidDateException.class)
    public void testConvertDate_Day_GreaterThan31() throws InvalidDateException {
        instance.convertDate("04/32/2011");
    }

}