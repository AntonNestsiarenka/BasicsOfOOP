package com.company.giftmodel.packing.factorys;

import com.company.giftmodel.packing.packingChildren.GiftPacking;
import com.company.giftmodel.packing.packingChildren.giftPackingChildren.GiftSweetnessPacking;

public class GiftSweetnessPackingFactory implements GiftPackingFactory {

    @Override
    public GiftSweetnessPacking createGiftPacking() {
        return new GiftSweetnessPacking();
    }
}
