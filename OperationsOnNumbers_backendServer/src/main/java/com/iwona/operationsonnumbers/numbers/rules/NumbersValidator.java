package com.iwona.operationsonnumbers.numbers.rules;

import java.math.BigDecimal;

import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Component;

import com.iwona.operationsonnumbers.numbers.response.AbstractResponse;

@Component
public class NumbersValidator {

    public void validateAddition(final String numberText1, final String numberText2, final AbstractResponse response) {
        if (!GenericValidator.isDouble(numberText1)) {
            response.addMessage("Number1: incorrect numeric value");
        }
        if (!GenericValidator.isDouble(numberText2)) {
            response.addMessage("Number2: incorrect numeric value");
        }
    }

    public void validateSubtraction(final String numberText1, final String numberText2, final AbstractResponse response) {
        if (!GenericValidator.isDouble(numberText1)) {
            response.addMessage("Number1: incorrect numeric value");
        }
        if (!GenericValidator.isDouble(numberText2)) {
            response.addMessage("Number2: incorrect numeric value");
        }
    }

    public void validateMultiplication(final String numberText1, final String numberText2, final AbstractResponse response) {
        if (!GenericValidator.isDouble(numberText1)) {
            response.addMessage("Number1: incorrect numeric value");
        }
        if (!GenericValidator.isDouble(numberText2)) {
            response.addMessage("Number2: incorrect numeric value");
        }
    }

    public void validateDivision(final String numberText1, final String numberText2, final AbstractResponse response) {
        if (!GenericValidator.isDouble(numberText1)) {
            response.addMessage("Number1: incorrect numeric value");
        }
        if (!GenericValidator.isDouble(numberText2)) {
            response.addMessage("Number2: incorrect numeric value");
        } else if (new BigDecimal(numberText2).compareTo(BigDecimal.ZERO) == 0) {
            response.addMessage("Number2: value 0 not allowed");
        }
    }

}
