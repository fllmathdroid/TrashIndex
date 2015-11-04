package com.example.helen.trashindex.data;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by marvin on 11/3/15.
 */
public class Data {
    public static HashMap<String, Item> products = new HashMap<>();
    public final static int UNKNOWN_ITEM = 1001;

    public static void loadProducts() throws IOException
    {
        readLeafItems("../Leaves.json");
        readCompositeItems("../Composites.json");
    }

    public static int getTrashIndex(String itemCode) throws IOException
    {
        if (products.size() == 0)
        {
            loadProducts();
        }
        Item item = products.get(itemCode);
        if (item == null)
        {
            return UNKNOWN_ITEM;
        }
        return item.getTrashIndex();
    }

    private static void readLeafItems(String leafFile) throws IOException {
        try (Reader reader = new InputStreamReader(Data.class.getResourceAsStream(leafFile))) {
            Gson gson = new GsonBuilder().create();
            LeafItem[] data = gson.fromJson(reader, LeafItem[].class);
            for (LeafItem item : data) {
                products.put(item.barcode, item);
            }
        }
    }

    private static void readCompositeItems(String compositeFile) throws IOException {
        try (Reader reader = new InputStreamReader(Data.class.getResourceAsStream(compositeFile))) {
            Gson gson = new GsonBuilder().create();
            CompositeItem[] data = gson.fromJson(reader, CompositeItem[].class);
            for (CompositeItem item : data)
                products.put(item.barcode, item);
        }
    }
}
