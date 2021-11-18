package com.lchnan.dormitory.framework.mvc;

import com.lchnan.dormitory.framework.exception.exc;
import com.lchnan.dormitory.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Result handle(RuntimeException exception){
		exception.printStackTrace();
		return Result.ok(exception.getMessage());
	}

	@ExceptionHandler(exc.class)
	@ResponseBody
	public Result handle(exc exception){
		exception.printStackTrace();
		return Result.ok(exception.getMessage());
	}
}
