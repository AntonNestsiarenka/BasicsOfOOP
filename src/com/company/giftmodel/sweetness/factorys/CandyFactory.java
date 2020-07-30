package com.company.giftmodel.sweetness.factorys;

import com.company.giftmodel.sweetness.sweetnessChildren.Candy;
import com.company.giftmodel.sweetness.Sweetness;

public class CandyFactory implements SweetnessFactory {

    @Override
    public Candy createSweetness() {
        return new Candy();
    }
}
