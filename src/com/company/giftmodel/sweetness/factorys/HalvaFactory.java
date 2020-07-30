package com.company.giftmodel.sweetness.factorys;

import com.company.giftmodel.sweetness.sweetnessChildren.Halva;
import com.company.giftmodel.sweetness.Sweetness;

public class HalvaFactory implements SweetnessFactory {

    @Override
    public Halva createSweetness() {
        return new Halva();
    }
}
