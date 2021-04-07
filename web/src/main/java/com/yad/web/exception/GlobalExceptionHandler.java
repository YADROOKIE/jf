package com.yad.web.exception;


import com.yad.web.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody  // 返回 json数据
    public R error(Exception e){
        e.printStackTrace();
        return  R.error().message("全局异常");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R Aerror(Exception e){
        e.printStackTrace();
        return  R.error().message("特定异常处理");
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R Myerror(MyException e){
        e.printStackTrace();
        return  R.error().message(e.getMsg()).code(e.getCode());
    }
}