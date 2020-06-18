package com.company.giftmodel.gift.factorys;

import com.company.giftmodel.gift.Gift;
import com.company.giftmodel.packing.packingChildren.giftPackingChildren.GiftSweetnessPacking;

public interface GiftFactory {

    Gift createGift(String name, GiftSweetnessPacking packing);

}
