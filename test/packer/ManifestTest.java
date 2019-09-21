package packer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManifestTest {

    // Test data Manifests
    Manifest testManifest0 = new Manifest();
    // Test data Products
    Product product0 = new Product("chocolate", 34, false, true);
    Product product1 = new Product("Tuna", 100, false, false);
    Product product2 = new Product("Janola", 2, true, false);
    Product product3 = new Product("Chocolate chip cookie", 1, false, false);
    Product product4 = new Product("Easter Bunnie", 1, false, false);


    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }


    @Test
    public void testGetTotalWeight() {
        System.out.println("testing");
        testManifest0.addProduct(product0, 2);
        testManifest0.addProduct(product1, 3);
        Assert.assertEquals(368, testManifest0.getTotalWeight(), 0.0001);
    }

    @Test
    public void testGetHeaviestUnder() {
        testManifest0.addProduct(product0, 2);
        testManifest0.addProduct(product1, 3);
        Assert.assertEquals("chocolate", testManifest0.getHeaviestUnder(99).getName());
        Assert.assertEquals("Tuna", testManifest0.getHeaviestUnder(100).getName());
    }

    @Test
    public void testIsEmpty(){
        testManifest0.addProduct(product0, 5);
        Assert.assertFalse(testManifest0.isEmpty());
    }

    @Test
    public void testToString(){
        testManifest0.addProduct(product0, 10);
        Assert.assertEquals("chocolate x 10", testManifest0.toString());
    }

    @Test
    public void testIsFragile() {
        testManifest0.addProduct(product0, 10);
        testManifest0.addProduct(product1, 2);
        Assert.assertTrue(testManifest0.hasFragileItems());
    }
}