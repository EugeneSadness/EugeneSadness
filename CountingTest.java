package chapter3;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chapter3.Counting.*;
import static org.junit.jupiter.api.Assertions.*;
import chapter3.Filtering.*;
import chapter3.Counting.*;

import java.util.ArrayList;

class CountingTest {

    public ConsignmentOfGoods consigment, consigment2, consigment3;

    @BeforeEach
    void init(){
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

        consigment =  new ConsignmentOfGoods("Food consigment", set1, prod1, prod1, set1);
        consigment2 =  new ConsignmentOfGoods("Food consigment", set1, prod1);
        consigment3 =  new ConsignmentOfGoods("Drink consigment", set3, prod2);
    }


    @Test
    void countByFilterTest() {
        BeginStringFilter filter = new BeginStringFilter("Cola");
        BeginStringFilter filter2 = new BeginStringFilter("Pepsi");
        assertEquals(true , countByFilter(consigment, filter) == 6);
        assertEquals(true , countByFilter(consigment, filter2) == 0);
    }

    @Test
    void countByFilterDeepTest() {
        BeginStringFilter filter = new BeginStringFilter("Cola");
        assertEquals(true , countByFilterDeep(consigment, filter) == 6);
    }

    @Test
    void checkAllWeightedTest() {
        BeginStringFilter filter = new BeginStringFilter("Cola");
        assertEquals(false , checkAllWeighted(consigment));
    }
}