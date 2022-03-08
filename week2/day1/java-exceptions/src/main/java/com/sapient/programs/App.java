package com.sapient.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class App {

    // @Slf4j annotation adds this line in the compiled output
    // public static final Logger log = LoggerFactory.getLogger(App.class)

    public static void main(String[] args) {
        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is a info message");
        log.warn("This is a warn message");
        log.error("This is a error message");
    }
}
