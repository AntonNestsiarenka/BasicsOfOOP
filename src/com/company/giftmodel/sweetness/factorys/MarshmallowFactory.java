package com.company.giftmodel.sweetness.factorys;

import com.company.giftmodel.sweetness.sweetnessChildren.Marshmallow;
import com.company.giftmodel.sweetness.Sweetness;

public class MarshmallowFactory implements SweetnessFactory {

    @Override
    public Marshmallow createSweetness() {
        return new Marshmallow();
    }
}
