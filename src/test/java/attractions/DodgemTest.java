package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        visitor1 = new Visitor(10,130, 5.00);
        visitor2 = new Visitor(14,130, 5.00);
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void willChargeHalfForUnder12s(){
        assertEquals(2.25, dodgems.priceFor(visitor1), 0.1);
    }

    @Test
    public void wontChargeHalfForUnder12s(){
        assertEquals(4.5, dodgems.priceFor(visitor2), 0.1);
    }
}
