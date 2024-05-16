package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ClothingItemTest {

    @ParameterizedTest
    @CsvSource({
            "Гучи, Футболка, M, 19.99",
            "Прада, Штаны, L, 29.99",
            "Луи Витон, Шляпа, S, 9.99"
    })
    void testClothingItemCreation(String name, String type, String size, double price) {
        ClothingItem item = new ClothingItem(name, type, size, price);
        assertEquals(name, item.getName());
        assertEquals(type, item.getType());
        assertEquals(size, item.getSize());
        assertEquals(price, item.getPrice(), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "Гучи, Футболка",
            "Прада, Штаны",
            "Луи Витон, Шляпа"
    })
    void testSetters(String name, String type) {
        ClothingItem item = new ClothingItem("OldName", "OldType", "M", 19.99);
        item.setName(name);
        item.setType(type);
        assertEquals(name, item.getName());
        assertEquals(type, item.getType());
    }
}
