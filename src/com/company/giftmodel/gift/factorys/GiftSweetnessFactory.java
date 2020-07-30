package com.company.giftmodel.gift.factorys;

import com.company.giftmodel.gift.Gift;
import com.company.giftmodel.gift.giftChildren.GiftSweetness;
import com.company.giftmodel.packing.packingChildren.giftPackingChildren.GiftSweetnessPacking;

public class GiftSweetnessFactory implements GiftFactory {

    @Override
    public GiftSweetness createGift() {
        return new GiftSweetness();
    }
}
