package com.murik.enose.model.common_A;

import android.content.Context;

import com.murik.enose.R;
import com.murik.enose.dto.DataByMaxParcelable;
import com.murik.enose.model.resultbyMaxValue.BaseResultWithCoefficient;

public class A_20_60_GRAY extends BaseResultWithCoefficient {

    public A_20_60_GRAY(double A, DataByMaxParcelable inputData, Context context, float coefficicent) {
        super(A, inputData, context, coefficicent);
        setLegend("IX_G");
    }

    public A_20_60_GRAY(double A, DataByMaxParcelable inputData, Context context, String legend) {
        super(A, inputData, context, 0);
        setLegend(legend);
    }

    public void setResult() {
        setColorGRAY();
        if (getA() == 0.025) {
            setPossibleReasons(getResources(R.string.A_20_60_GRAY_1));
        } else if (getA() >= 0.46 && getA() <= 0.49) {
            setPossibleReasons(getResources(R.string.A_20_60_GRAY_2));
        } else if (getA() >= 0.36 && getA() <= 0.45) {
            setPossibleReasons(getResources(R.string.A_20_60_GRAY_5));
        } else if (getA() >= 0.68 && getA() <= 0.71) {
            setPossibleReasons(getResources(R.string.A_20_60_GRAY_6));
        } else if (getA() >= 0.047 && getA() <= 0.051) {
            setPossibleReasons(getResources(R.string.A_20_60_GRAY_3));
        } else if (getA() >= 0.08 && getA() <= 0.12) {
            setPossibleReasons(getResources(R.string.A_20_60_GRAY_4));
        }
    }
}
