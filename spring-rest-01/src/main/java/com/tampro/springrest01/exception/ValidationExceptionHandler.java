package com.tampro.springrest01.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tampro.springrest01.response.APIResponse;
import com.tampro.springrest01.response.APIStatus;
import com.tampro.utils.ResponseUtil;

@ControllerAdvice
public class ValidationExceptionHandler {
	//@Autowired
	ResponseUtil responseUtil  = new ResponseUtil();
	
	@ExceptionHandler(value = ApplicationException.class)
	public ResponseEntity<APIResponse> handleApplication(ApplicationException applicationException,
			WebRequest webRequest ){
		ResponseEntity<APIResponse> responseEntity;
		if(applicationException.getApiStatus() == APIStatus.ERR_BAD_REQUEST) {
			responseEntity = responseUtil.badRequestResponse(
					applicationException.getData()
					);
		}else {
			responseEntity = responseUtil.buildResponse(
					applicationException.getApiStatus(), 
					applicationException.getData(),
					HttpStatus.OK);
		}
		return responseEntity;
	}

	 // when missing parameter
//    @Override
//    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
//            HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//        return new ResponseEntity<>(new APIResponse<>(APIStatus.ERR_BAD_REQUEST, null), headers, status);
//    }
//
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<APIResponse> handleUncatchException(Exception ex, WebRequest request) {
//
//        LOGGER.error("handleUncatchException", ex);
//        return responseUtil.buildResponse(APIStatus.ERR_INTERNAL_SERVER, "Please contact System Admin to resolve problem", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
