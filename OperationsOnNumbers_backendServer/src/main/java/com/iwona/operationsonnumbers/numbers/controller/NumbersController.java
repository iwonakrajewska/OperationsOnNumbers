package com.iwona.operationsonnumbers.numbers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iwona.operationsonnumbers.numbers.request.TwoNumbersRequest;
import com.iwona.operationsonnumbers.numbers.response.AbstractResponse;
import com.iwona.operationsonnumbers.numbers.response.ServerErrorResponseHandler;
import com.iwona.operationsonnumbers.numbers.response.SingleNumberResponse;
import com.iwona.operationsonnumbers.numbers.service.INumbersService;

@RestController
public class NumbersController {

    private static final Logger LOG = LoggerFactory.getLogger(NumbersController.class);

    @Autowired
    INumbersService numbersService;
	@Autowired
	ServerErrorResponseHandler serverErrorResponseHandler;

    @PostMapping("/addition")
    public ResponseEntity<AbstractResponse> addition(@RequestBody final TwoNumbersRequest request) {
        LOG.info("incoming addition request "+ request.toString());
        try{
	        SingleNumberResponse response = numbersService.addNumbers(request.getNumberText1(), request.getNumberText2());
	        return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e) {
			LOG.error("Problem in addition", e);
			return serverErrorResponseHandler.prepareErrorResponse();
		}
    }

    @PostMapping("/subtraction")
    public ResponseEntity<AbstractResponse> subtraction(@RequestBody final TwoNumbersRequest request) {
        LOG.info("incoming subtraction request "+ request.toString());
		try {
	        SingleNumberResponse response = numbersService.subtractNumbers(request.getNumberText1(), request.getNumberText2());
	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    }catch (Exception e) {
			LOG.error("Problem in subtraction", e);
			return serverErrorResponseHandler.prepareErrorResponse();
		}
    }

    @PostMapping("/multiplication")
    public ResponseEntity<AbstractResponse> multiplication(@RequestBody final TwoNumbersRequest request) {
        LOG.info("incoming multiplication request "+ request.toString());
		try {
	        SingleNumberResponse response = numbersService.multiplyNumbers(request.getNumberText1(), request.getNumberText2());
	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    }catch (Exception e) {
			LOG.error("Problem in multiplication", e);
			return serverErrorResponseHandler.prepareErrorResponse();
		}
    }

    @PostMapping("/division")
    public ResponseEntity<AbstractResponse> division(@RequestBody final TwoNumbersRequest request) {
        LOG.info("incoming division request "+ request.toString());
		try {
	        SingleNumberResponse response = numbersService.divideNumbers(request.getNumberText1(), request.getNumberText2());
	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    }catch (Exception e) {
			LOG.error("Problem in division", e);
			return serverErrorResponseHandler.prepareErrorResponse();
		}
    }

}
