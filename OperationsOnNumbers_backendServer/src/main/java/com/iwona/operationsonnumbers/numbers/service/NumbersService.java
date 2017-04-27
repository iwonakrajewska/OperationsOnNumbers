package com.iwona.operationsonnumbers.numbers.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iwona.operationsonnumbers.numbers.response.SingleNumberResponse;
import com.iwona.operationsonnumbers.numbers.rules.NumbersValidator;

@Service
public class NumbersService implements INumbersService {

    @Autowired
    private NumbersValidator numbersValidator;

    @Override
    public SingleNumberResponse addNumbers(final String numberText1, final String numberText2) {
        SingleNumberResponse response = new SingleNumberResponse();
        numbersValidator.validateAddition(numberText1, numberText2, response);
        if (response.hasMessages()) {
            return response;
        }
        response.setNumberText(new BigDecimal(numberText1).add(new BigDecimal(numberText2)).toString());
        return response;
    }

    @Override
    public SingleNumberResponse subtractNumbers(final String numberText1, final String numberText2) {
        SingleNumberResponse response = new SingleNumberResponse();
        numbersValidator.validateSubtraction(numberText1, numberText2, response);
        if (response.hasMessages()) {
            return response;
        }
        response.setNumberText(new BigDecimal(numberText1).subtract(new BigDecimal(numberText2)).toString());
        return response;
    }

    @Override
    public SingleNumberResponse multiplyNumbers(final String numberText1, final String numberText2) {
        SingleNumberResponse response = new SingleNumberResponse();
        numbersValidator.validateMultiplication(numberText1, numberText2, response);
        if (response.hasMessages()) {
            return response;
        }
        response.setNumberText(new BigDecimal(numberText1).multiply(new BigDecimal(numberText2)).toString());
        return response;
    }

    @Override
    public SingleNumberResponse divideNumbers(final String numberText1, final String numberText2) {
        SingleNumberResponse response = new SingleNumberResponse();
        numbersValidator.validateDivision(numberText1, numberText2, response);
        if (response.hasMessages()) {
            return response;
        }
        response.setNumberText(new BigDecimal(numberText1).divide(new BigDecimal(numberText2), 2, RoundingMode.HALF_EVEN).toString());
        return response;
    }

}
