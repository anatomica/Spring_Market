package com.anatomica.market.beans;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {
    public static Logger logger = Logger.getLogger("file");

    @Before("execution(public * com.anatomica.market.services.ProductsService.*(..))")
    public void beforeUserModifyProduct() {
        logger.info("Работа с сервисом продуктов: ");
    }
}
