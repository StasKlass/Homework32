package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClothingManagerTest {

    private ClothingManager manager;

    @BeforeEach
    void setUp() {
        manager = new ClothingManager();
        manager.addClothingItem(new ClothingItem("Гучи", "Майка", "M", 19.99));
        manager.addClothingItem(new ClothingItem("Прада", "Штаны", "L", 29.99));
        manager.addClothingItem(new ClothingItem("Луи Витон", "Шляпа", "S", 9.99));
    }

    @ParameterizedTest
    @CsvSource({
            "Майка, 1",
            "Штаны, 1",
            "Шляпа, 1",
            "unknown, 0"
    })
    void testFindClothingByType(String type, int expectedSize) {
        List<ClothingItem> items = manager.findClothingByType(type);
        assertEquals(expectedSize, items.size());
    }

    @ParameterizedTest
    @CsvSource({
            "M, 1",
            "L, 1",
            "S, 1",
            "XL, 0"
    })
    void testFindClothingBySize(String size, int expectedSize) {
        List<ClothingItem> items = manager.findClothingBySize(size);
        assertEquals(expectedSize, items.size());
    }

    @ParameterizedTest
    @ValueSource(doubles = {9.99})
    void testFindCheapestItem(double expectedPrice) {
        ClothingItem cheapestItem = manager.findCheapestItem();
        assertNotNull(cheapestItem);
        assertEquals(expectedPrice, cheapestItem.getPrice(), 0.01);
    }
}
