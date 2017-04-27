package com.iwona.operationsonnumbers.numbers.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TwoNumbersRequest {

    private String numberText1;
    private String numberText2;

    public String getNumberText1() {
        return numberText1;
    }

    public void setNumberText1(final String numberText1) {
        this.numberText1 = numberText1;
    }

    public String getNumberText2() {
        return numberText2;
    }

    public void setNumberText2(final String numberText2) {
        this.numberText2 = numberText2;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
