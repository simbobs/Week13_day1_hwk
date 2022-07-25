package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() {
        visitor1 = new Visitor(10,130, 5.00);
        visitor2 = new Visitor(16,210, 10.00);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canRideAsOver12andOver145cm(){
        assertTrue(rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void cantRideAsUnder12andUnder145(){
        assertFalse(rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void willBeChargedDoubleFeeIfOver200(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor2), 0.0);
    }

    @Test
    public void wontBeChargedDoubleFee() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor1), 0.0);
    }

}
