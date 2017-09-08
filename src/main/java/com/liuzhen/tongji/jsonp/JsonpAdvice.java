package com.liuzhen.tongji.jsonp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * jsonp
 * Created by liuzhen on 2017/6/19.
 */
@ControllerAdvice(basePackages = "com.liuzhen.tongji.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {
        super("jsonpCallback", "jsonp");
    }
}
