package com.tampro.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tampro.springrest01.response.APIResponse;
import com.tampro.springrest01.response.APIStatus;
 
/*
 *  base
 */
@Component 
public class ResponseUtils {

	public ResponseEntity<APIResponse> badRequestResponse(List<Constant.ParamError> errors) {

        Map<String, String> errMap = null;

        if (errors != null) {

            errMap = new HashMap<>();
            for (Constant.ParamError error : errors) {
                errMap.put(error.getCode(), error.getDesrci());
            }
        }

        return buildResponse(APIStatus.ERR_BAD_REQUEST, errMap, HttpStatus.BAD_REQUEST);
    }
	private APIResponse _createCarShowResponse(APIStatus apiStatus, Object data) {
	    return new APIResponse(data,apiStatus);
	}

	    // base method
	public ResponseEntity<APIResponse> buildResponse(APIStatus apiStatus, Object data, HttpStatus httpStatus) {
	    return new ResponseEntity(_createCarShowResponse(apiStatus, data), httpStatus);
	}
	public ResponseEntity<APIResponse> successResponse(Object data) {
	    return buildResponse(APIStatus.OK, data, HttpStatus.OK);
	}
}
