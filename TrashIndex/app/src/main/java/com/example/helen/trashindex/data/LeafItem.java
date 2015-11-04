package com.example.helen.trashindex.data;

/**
 * Created by marvin on 11/3/15.
 */
public class LeafItem extends Item {
    private double months2degrade;

    //leaf
    public LeafItem(String pBar, String pName, double pMonths2degrade)
    {
        barcode = pBar;
        name  = pName;
        months2degrade = pMonths2degrade;
        _calculate();
    }

    public boolean isLeaf()
    {
        return true;
    }

    private void _calculate()
    {
        double temp = Math.floor(5*Math.sqrt(months2degrade));
        if (temp > 1000)
            trashIndex = 1000;
        else
            trashIndex = (int)temp;
    }
}
