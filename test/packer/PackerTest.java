package packer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 *
 * @author Ayman Milhem
 */

public class PackerTest {
    Packer testPacker = new Packer();
    Customer testCustomer0 = new Customer("Almond Agricultural", new Address("Symonds St.", "CBD", "Auckland", "1119", new Coordinates(4,5)));
    Customer getTestCustomer1 = new Customer("Hungry Chicken Dairy", new Address("Quay St.", "Waterfornt", "Wellington", "20009", new Coordinates(300, 500)));
    Depot testDepot0 = new Depot("AKL City Centre", new Address("Fort St.", "CBD", "Auckland", "1118", new Coordinates(309, 490)));
    Depot getTestDepot1 = new Depot("One Tree Hill", new Address("Bare Hill St.", "Maungakiekie", "Auckland", "1076", new Coordinates(600, 700)));
    Product testProduct0 = new Product("Chicken Fodder", 3, false, false);
    Product testProduct1 = new Product("Helium Tank", 15, true, false);
    Manifest testManifest0 = new Manifest();

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer class...");
    }

    @Test
    public void testPacker() {
        System.out.println("Testing Method packProducts()");
        Manifest testManifest1 = new Manifest();
        testManifest1.addProduct(testProduct1, 2);
        List<Box> returnedList = testPacker.packProducts(testCustomer0, testDepot0, testManifest1);
        Assert.assertEquals("[Almond Agricultural\nSymonds St.\nCBD\nAuckland\n1119\nHelium Tank x 1\nHEAVY\n, Almond Agricultural\nSymonds St.\nCBD\nAuckland\n1119\nHelium Tank x 1\nHEAVY\n]", returnedList.toString());
    }
}

