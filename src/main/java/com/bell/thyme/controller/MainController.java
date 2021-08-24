package com.bell.thyme.controller;

import com.bell.thyme.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${mock.firstDelay}")
    private long delay;

    @Autowired
    SpringTemplateEngine springTemplateEngine;

    @RequestMapping(value = "/", method= RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE}
    )
    public @ResponseBody String test(@RequestBody Person body) {

        long startTime = System.currentTimeMillis();

          //имитация времени работы кода
//        try {
//            Thread.sleep((long) (Math.random()*5000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Person requestPerson = new Person(
                body.getFullName(),
                body.getListOfAddress(),
                body.getDULSeries(),
                body.getDULNumber(),
                false);

        Context responseContext = new Context();
        responseContext.setVariable("requestPerson", requestPerson);
        String responseContent = springTemplateEngine.process("personResponse", responseContext);

        long codeWorkingPeriod = System.currentTimeMillis() - startTime;    //время работы кода в мс

        //задержка ответа от заглушки
        try {
            Thread.sleep(delay - codeWorkingPeriod);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return responseContent;
    }
}