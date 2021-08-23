package com.bell.thyme.controller;

import com.bell.thyme.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    SpringTemplateEngine springTemplateEngine;

    @RequestMapping(value = "/", method= RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE}
    )
    public @ResponseBody String test(@RequestBody Person body) {

        Person requestPerson = new Person(
                body.getFullName(),
                body.getListOfAddress(),
                body.getDULSeries(),
                body.getDULNumber(),
                false);

        Context responseContext = new Context();
        responseContext.setVariable("requestPerson", requestPerson);
        String responseContent = springTemplateEngine.process("personResponse", responseContext);
        return responseContent;
    }
}