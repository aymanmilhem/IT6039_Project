package packer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ayman Milhem
 */

public class BoxTest {

    // Test data Customers
    Customer testCustomer10 = new Customer("Ayman", new Address("Kepa Rd.",
            "Orakei", "Auckland","1070",
            new Coordinates(50, 60)));
    Customer testCustomer11 = new Customer("Yanal", new Address("King Kong St.",
            "New Hill", "Christchurch", "3030",
            new Coordinates(3000, 3040)));

    // Test data Depots
    Depot testDepot10 = new Depot("testDepot0", new Address("Queen Street",
            "CBD", "Auckland", "1010",
            new Coordinates(1010, 2020)));

    Depot testDepot11 = new Depot("testDepot1", new Address("Orakei Street",
            "Orakei", "Auckland", "1070",
            new Coordinates(1000, 2000)));

    //Test data Products
    Product testProduct0 = new Product("violin", 4,
            false, true);
    Product testProduct1 = new Product("Liquid Nitrogen", 100,
            true, false);

    // Test data Boxes
    Box testBox10 = new Box(testCustomer10, testDepot10);
    Box testBox11 = new Box(testCustomer11, testDepot11);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }

    /**
     * Test of getlabel method of the Box.java class
     */
    @Test
    public void testGetLabel() {
        System.out.println("Method: getLabel");
        testBox11.addProduct(testProduct1, 3);
        assertEquals("Yanal\nKing Kong St.\nNew Hill\nChristchurch\n3030\nLiquid Nitrogen x 3\n", testBox11.getLabel());
    }

    /**
     * Test of toString method, of the "Box.java" class.
     * Method should return a detailed label with relevant fields
     */
    @Test
    public void testToString() {
        testBox10.addProduct(testProduct0, 5);
        testBox11.addProduct(testProduct1, 3);

        System.out.println("method: toString");
        assertEquals("Ayman\nKepa Rd.\nOrakei\nAuckland\n1070\nviolin x 5\nFRAGILE\n",
                testBox10.toString());
        assertEquals("Yanal\nKing Kong St.\nNew Hill\nChristchurch\n3030\nLiquid Nitrogen x 3\n",
                testBox11.toString());
    }

    @Test
    public void testGetWeight() {
        System.out.println("Method: getWeight()");
        testBox10.addProduct(testProduct1, 10);
        testBox10.addProduct(testProduct0, 5);
        assertEquals(1020, testBox10.getWeight(), 0.0001);
    }

    @Test
    public void testCanFit() {
        System.out.println("Testing Method: canFit()");
        assertTrue(testBox10.canFit(testProduct0, 3));
        assertTrue(testBox10.canFit(testProduct0, 9));
        Assert.assertFalse(testBox10.canFit(testProduct1));
        Assert.assertFalse(testBox10.canFit(testProduct0, 11));
    }

    @Test
    public void testRemainingCapacity() {
        System.out.println("Testing Method: remainingCapacity()");
        testBox10.addProduct(testProduct0, 4);
        assertEquals(24, testBox10.remainingCapacity(), 0);
    }

    @Test
    public void testIsFragile() {
        System.out.println("Method: isFragile");
        testBox11.addProduct(testProduct0);
        testBox11.addProduct(testProduct1);
        assertTrue(testBox11.isFragile());
    }


}

