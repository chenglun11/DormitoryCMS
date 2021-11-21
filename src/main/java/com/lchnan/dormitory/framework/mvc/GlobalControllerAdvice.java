package com.lchnan.dormitory.framework.mvc;

import com.lchnan.dormitory.framework.exception.MyException;
import com.lchnan.dormitory.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Result handle(RuntimeException exception) {
		exception.printStackTrace();
		return Result.fail(exception.getMessage());
	}

	@ExceptionHandler(MyException.class)
	@ResponseBody
	public Result handle(MyException exception) {
		exception.printStackTrace();
		return Result.fail(Result.TOKEN_ERROR, exception.getMessage());
	}

}
