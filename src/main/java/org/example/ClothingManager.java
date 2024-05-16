package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClothingManager {
    private List<ClothingItem> clothingItems;

    public ClothingManager(){
        this.clothingItems = new ArrayList<>();
    }
    public void addClothingItem(ClothingItem item){
        clothingItems.add(item);
    }

    public boolean removeClothingItem(ClothingItem item) {
        return clothingItems.remove(item);
    }

    public List<ClothingItem> findClothingByType(String type){
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : clothingItems) {
            if (item.getType().equalsIgnoreCase(type)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<ClothingItem> findClothingBySize(String size){
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : clothingItems) {
            if (item.getSize().equalsIgnoreCase(size)) {
                result.add(item);
            }
        }
        return result;
    }

    public ClothingItem findCheapestItem(){
        if (clothingItems.isEmpty()) {
            return null;
        }
        return clothingItems.stream()
                .min(Comparator.comparingDouble(ClothingItem::getPrice))
                .orElse(null);
    }

}
