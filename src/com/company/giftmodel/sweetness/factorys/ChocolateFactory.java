package com.company.giftmodel.sweetness.factorys;

import com.company.giftmodel.sweetness.sweetnessChildren.Chocolate;
import com.company.giftmodel.sweetness.Sweetness;

public class ChocolateFactory implements SweetnessFactory {

    @Override
    public Sweetness createSweetness() {
        return new Chocolate();
    }
}
