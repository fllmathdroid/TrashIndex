package com.example.helen.trashindex.data;

import java.io.IOException;

/**
 * Created by marvin on 11/3/15.
 */
public class CompositeItem extends Item {
    private String[] leaves;
    private double[] leavesFractions;

    //composite
    public CompositeItem(String pBar, String pName, String[] pLeafs, double[] pFractions) throws IOException
    {
        barcode = pBar;
        name  = pName;
        leaves = pLeafs;
        leavesFractions = pFractions;
        _calculate();
    }

    public boolean isLeaf()
    {
        return false;
    }

    private void _calculate() throws IOException
    {
        trashIndex = 0;
        for (int i=0; i<leaves.length; i++)
        {
            int leafIndex = Data.getTrashIndex(leaves[i]);
            double weight = leavesFractions[i];
            trashIndex += leafIndex*weight;
        }
    }
}
