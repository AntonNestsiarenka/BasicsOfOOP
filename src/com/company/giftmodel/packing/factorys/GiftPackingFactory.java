package com.company.giftmodel.packing.factorys;

import com.company.giftmodel.packing.packingChildren.GiftPacking;

public interface GiftPackingFactory {

    GiftPacking createGiftPacking(double maxWeight, GiftPacking.TypeOfGiftPacking typeOfGiftPacking);
}
