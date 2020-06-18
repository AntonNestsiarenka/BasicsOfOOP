package com.company.giftmodel.gift.giftChildren;

import com.company.giftmodel.gift.Gift;
import com.company.giftmodel.packing.packingChildren.giftPackingChildren.GiftSweetnessPacking;

public class GiftSweetness extends Gift {

    public GiftSweetness() {
        super();
        setPacking(new GiftSweetnessPacking());
    }

    public GiftSweetness(String name, GiftSweetnessPacking packing) {
        super(name, packing);
    }


}