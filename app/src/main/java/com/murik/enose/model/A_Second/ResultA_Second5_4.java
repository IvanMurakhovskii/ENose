package com.murik.enose.model.A_Second;

import android.content.Context;

import com.murik.enose.dto.DataByMaxParcelable;
import com.murik.enose.model.resultbyMaxValue.BaseResult;
import com.murik.enose.model.resultbyMaxValue.BaseResultSecond;

public class ResultA_Second5_4 extends BaseResultSecond {


  public ResultA_Second5_4(double A, DataByMaxParcelable inputData, Context context, float coefficient) {
    super(A, inputData, context, coefficient);
    setLegend("5_4");
  }

    public void setResult() {
    setColorYELLOW();
    setPossibleReasons("result");
    }
}
