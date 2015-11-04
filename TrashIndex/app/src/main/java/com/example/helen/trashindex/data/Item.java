package com.example.helen.trashindex.data;

import java.util.ArrayList;

/**
 * Created by marvin on 11/3/15.
 */
public abstract class Item {
    public abstract boolean isLeaf();

    public int getTrashIndex()
    {
        return trashIndex;
    }

    protected String barcode;
    protected String name;
    protected int trashIndex;
}
