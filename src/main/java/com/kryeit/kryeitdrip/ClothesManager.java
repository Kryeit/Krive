package com.kryeit.kryeitdrip;

import java.util.ArrayList;
import java.util.List;

public class ClothesManager {
    private final List<Clothe> clothesList;
    private static ClothesManager instance;

    private ClothesManager() {
        this.clothesList = new ArrayList<>();
        this.clothesList.add(Clothe.hoodie());
    }

    public static ClothesManager getInstance() {
        if (instance == null) {
            instance = new ClothesManager();
        }
        return instance;
    }

    public void addClothes(Clothe clothes) {
        this.clothesList.add(clothes);
    }

    public List<Clothe> getClothesList() {
        return clothesList;
    }
}