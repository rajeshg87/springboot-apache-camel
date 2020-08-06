package com.rajesh.camel.springapachecamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SimpleCamelRoute extends RouteBuilder {

    @Autowired
    Environment environment;

    @Override
    public void configure() throws Exception {
                from("{{copy.file.from.route}}")
                        .id("FileCopy")
                        .log("Processing File ${file:name} in "+environment.getProperty("env"))
                        .log("${body}")
                .to("{{copy.file.to.route}}")
                ;

                from("{{timer.task}}")
                        .id("Rajesh Timer Call")
                    .log("Timer invoked ------> ${id}")
                ;

    }
}
