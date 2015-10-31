package com.example.helen.trashindex.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static public class Product {
        String code;
        String name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        String type;
        double trashIndex;

        public Product(String code, String name, String type, double  trashIndex) {
            this.code = code;
            this.name = name;
            this.type = type;
            this.trashIndex = trashIndex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double  getTrashIndex() {
            return trashIndex;
        }

        public void setTrashIndex(double trashIndex) {
            this.trashIndex = trashIndex;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
    static {
        // Add some sample items.
        /*for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }*/
        addItem(createDummyItem(new Product("037000858041", "Crest Complete Extra Whitening", "Oral Care:Toothpaste", 24.86)));
        addItem(createDummyItem(new Product("012546001250", "Trident Original Flavor", "Food:Chewing Gum", 40.11)));
                addItem(createDummyItem(new Product("096619183289", "Kirkland Whole Fancy Cashews", "Food:Nuts", 24.86)));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    //private static DummyItem createDummyItem(int position) {
    //    return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    //}

    private static DummyItem createDummyItem(Product p) {
        return new DummyItem(p.getCode(), p.getName(), makeDetails(p));
    }

    private static String makeDetails(Product p) {
        StringBuilder builder = new StringBuilder();
        builder.append("Name").append(p.getName());
        builder.append("\n");

        java.util.Formatter myFormatter = new java.util.Formatter();

        myFormatter.format("%1$-20s%2$32s\n", "Product Type",p.getType());

        myFormatter.format("%1$-20s%2$30.2f\n", "Trash Index", p.getTrashIndex());

        myFormatter.format("%1$-20s%2$32s\n", "Product Code",p.getCode());
        builder.append(myFormatter.toString().replace(' ', '.'));
        builder.append("\n");
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
