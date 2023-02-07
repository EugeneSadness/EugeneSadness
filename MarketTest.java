package chapter3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarketTest {

    @Test
    void testProduct() {
        Product prod1 = new Product("Cola", "good drink");
        Product prod2 = new Product("Cola", "good drink");
        Product prod3 = new Product("Lays", "tasty chips");
        assertEquals(true, prod1.equals(prod2));

        assertEquals(false, prod1.equals(prod3));
        assertEquals(prod1.hashCode(), prod2.hashCode());
        assertEquals(false, prod1.hashCode() == prod3.hashCode());
        System.out.println(prod1.toString());
    }

    @Test
    void testPackage(){
        Package pack1 = new Package("Lays", 0.1);
        Package pack2 = new Package("Lays", 0.1);
        Package pack3 = new Package("Big Package", 0.6);
        assertEquals(true, pack1.equals(pack2));
        assertEquals(false, pack1.equals(pack3));
        assertEquals(pack1.hashCode(), pack2.hashCode());
        assertEquals(false, pack1.hashCode() == pack3.hashCode());
        System.out.println(pack1.toString());
    }

    @Test
    void testWeightGoods(){
        WeightGoods prod1 = new WeightGoods("Cola", "good drink");
        WeightGoods prod2 = new WeightGoods("Cola", "good drink");
        WeightGoods prod3 = new WeightGoods("Lays", "tasty chips");
        assertEquals(true, prod1.equals(prod2));
        assertEquals(false, prod1.equals(prod3));
        assertEquals(prod1.hashCode(), prod2.hashCode());
        assertEquals(false, prod1.hashCode() == prod3.hashCode());
        System.out.println(prod1.toString());
    }

    @Test
    void testPieceGoods(){
        PieceGoods prod1 = new PieceGoods(0.6, "Cola", "good drink");
        PieceGoods prod2 = new PieceGoods(0.6, "Cola", "good drink");
        PieceGoods prod3 = new PieceGoods(0.3, "Lays", "tasty chips");
        assertEquals(true, prod1.equals(prod2));
        assertEquals(false, prod1.equals(prod3));
        assertEquals(prod1.hashCode(), prod2.hashCode());
        assertEquals(false, prod1.hashCode() == prod3.hashCode());
        System.out.println(prod1.toString());
    }

    @Test
    void testPackedWeightGoods(){
        Package pack1 = new Package("Cola", 0.1);
        Package pack2 = new Package("Lays", 0.25);
        Package pack3 = new Package("Lays", 0.5);

        PackedWeightGoods prod1 = new PackedWeightGoods(pack1, 0.6, "Cola", "good drink");
        PackedWeightGoods prod2 = new PackedWeightGoods(pack1, 0.6, "Cola", "good drink");
        PackedWeightGoods prod3 = new PackedWeightGoods(pack2, 0.6, "Lays", "tasty chips");
        PackedWeightGoods prod4 = new PackedWeightGoods(pack3, 1.2, "Lays", "tasty chips");

        assertEquals(true, prod1.equals(prod2));
        assertEquals(false, prod1.equals(prod3));
        assertEquals(false, prod1.equals(prod3));
        assertEquals(false, prod3.equals(prod4));

        assertEquals(prod1.hashCode(), prod2.hashCode());
        assertEquals(false, prod1.hashCode() == prod3.hashCode());
        assertEquals(false, prod3.hashCode() == prod4.hashCode());
        assertEquals(false, prod3.hashCode() == prod4.hashCode());

        System.out.println("Gross weight =" + prod1.getGrossWeight());
        System.out.println("Net weight =" + prod1.getNetWeight());
        assertEquals(prod1.getGrossWeight(), prod2.getGrossWeight());
        assertEquals(prod1.getGrossWeight() ,prod2.getGrossWeight());
        assertEquals(false, prod1.getGrossWeight() == prod3.getGrossWeight());
        assertEquals(prod1.getNetWeight(), prod2.getNetWeight());
        assertEquals(prod1.getNetWeight(), prod3.getNetWeight());

        System.out.println(prod1.toString());
    }

    @Test
    void testPackedPieceGoods(){
        Package pack1 = new Package("Cola", 0.1);
        Package pack2 = new Package("Lays", 0.25);
        Package pack3 = new Package("Lays", 0.5);

        PackedPieceGoods prod1 = new PackedPieceGoods(pack1, 2, 0.6, "Cola", "good drink");
        PackedPieceGoods prod2 = new PackedPieceGoods(pack1, 2, 0.6, "Cola", "good drink");
        PackedPieceGoods prod3 = new PackedPieceGoods(pack2, 2, 0.6, "Lays", "tasty chips");
        PackedPieceGoods prod4 = new PackedPieceGoods(pack3, 1, 1.2, "Lays", "tasty chips");

        assertEquals(true, prod1.equals(prod2));
        assertEquals(false, prod1.equals(prod3));
        assertEquals(false, prod1.equals(prod3));
        assertEquals(false, prod3.equals(prod4));

        assertEquals(prod1.hashCode(), prod2.hashCode());
        assertEquals(false, prod1.hashCode() == prod3.hashCode());
        assertEquals(false, prod3.hashCode() == prod4.hashCode());
        assertEquals(false, prod3.hashCode() == prod4.hashCode());

        System.out.println("Gross weight =" + prod1.getGrossWeight());
        System.out.println("Net weight =" + prod1.getNetWeight());
        assertEquals(prod1.getGrossWeight(), prod2.getGrossWeight());
        assertEquals(prod1.getGrossWeight() ,prod2.getGrossWeight());
        assertEquals(false, prod1.getGrossWeight() == prod3.getGrossWeight());
        assertEquals(prod1.getNetWeight(), prod2.getNetWeight());
        assertEquals(prod1.getNetWeight(), prod3.getNetWeight());

        System.out.println(prod1.toString());
    }

    @Test
    void testSetGoods(){
        Package pack1 = new Package("Cola", 0.1);
        Package pack2 = new Package("Lays", 0.25);
        Package pack3 = new Package("Lays", 0.5);
        Package pack4 = new Package("Big package", 1);

        PackedPieceGoods prod1 = new PackedPieceGoods(pack1, 2, 0.6, "Cola", "good drink");
        PackedPieceGoods prod2 = new PackedPieceGoods(pack1, 2, 0.6, "Cola", "good drink");
        PackedPieceGoods prod3 = new PackedPieceGoods(pack2, 2, 0.6, "Lays", "tasty chips");
        PackedPieceGoods prod4 = new PackedPieceGoods(pack3, 1, 1.2, "Lays", "tasty chips");

        ArrayList<Packable> set = new ArrayList<Packable>();
        set.add(prod1);
        set.add(prod2);
        set.add(prod3);
        set.add(prod4);

        PackedSetGoods set1 = new PackedSetGoods(pack4, set);
        PackedSetGoods set2 = new PackedSetGoods(pack4, set);
        PackedSetGoods set3 = new PackedSetGoods(pack3, set);

        set.add(set2);
        //Swap some products in set
        PackedSetGoods set4 = new PackedSetGoods(pack4, set);
        //

        assertEquals(true, set1.equals(set2));
        assertEquals(false, set1.equals(set3));
        assertEquals(false, set3.equals(set4));

        assertEquals(true, set1.getGrossWeight() == set2.getGrossWeight());
        assertEquals(true, set1.getNetWeight() == set2.getNetWeight());
        assertEquals(false, set1.getGrossWeight() == set3.getGrossWeight());
        assertEquals(true, set1.getNetWeight() == set3.getNetWeight());
        assertEquals(false, set1.getNetWeight() == set4.getNetWeight());

        System.out.println(prod1.toString());
    }

    @Test
    void testConsigment(){
        Package pack1 = new Package("Cola", 0.1);
        Package pack2 = new Package("Lays", 0.25);
        Package pack3 = new Package("Lays", 0.5);
        Package pack4 = new Package("Big package", 1);

        PackedPieceGoods prod1 = new PackedPieceGoods(pack1, 2, 0.6, "Cola", "good drink");
        PackedPieceGoods prod2 = new PackedPieceGoods(pack1, 2, 0.6, "Cola", "good drink");
        PackedPieceGoods prod3 = new PackedPieceGoods(pack2, 2, 0.6, "Lays", "tasty chips");
        PackedPieceGoods prod4 = new PackedPieceGoods(pack3, 1, 1.2, "Lays", "tasty chips");

        ArrayList<Packable> set = new ArrayList<Packable>();
        set.add(prod1);
        set.add(prod2);
        set.add(prod3);
        set.add(prod4);


        PackedSetGoods set1 = new PackedSetGoods(pack4, set);
        PackedSetGoods set2 = new PackedSetGoods(pack4, set);
        PackedSetGoods set3 = new PackedSetGoods(pack3, set);

        ConsignmentOfGoods consigment =  new ConsignmentOfGoods("Food consigment", set1, prod1);
        ConsignmentOfGoods consigment2 =  new ConsignmentOfGoods("Food consigment", set1, prod1);
        ConsignmentOfGoods consigment3 =  new ConsignmentOfGoods("Drink consigment", set3, prod2);

        assertEquals(true, consigment2.equals(consigment));
        assertEquals(false, consigment3.equals(consigment));


        assertEquals(consigment.hashCode(), consigment2.hashCode());
        assertEquals(false,consigment3.hashCode() == consigment2.hashCode());
        System.out.println(prod1.toString());
    }

}