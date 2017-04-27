package com.iwona.operationsonnumbers.numbers.service;

import com.iwona.operationsonnumbers.numbers.response.SingleNumberResponse;

public interface INumbersService {

    SingleNumberResponse addNumbers(String numberText1, String numberText2);

    SingleNumberResponse subtractNumbers(String numberText1, String numberText2);

    SingleNumberResponse multiplyNumbers(String numberText1, String numberText2);

    SingleNumberResponse divideNumbers(String numberText1, String numberText2);

}
