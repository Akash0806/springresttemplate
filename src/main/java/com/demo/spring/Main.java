package com.demo.spring;

import com.demo.spring.config.AppConfig;
import com.demo.spring.config.CityClient;
import com.demo.spring.model.City;
import com.demo.spring.model.CityList;
import org.apache.log4j.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        getLoggerConfig();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CityClient client = applicationContext.getBean(CityClient.class);
        logger.info("Getting list of all city:");
        City city = client.getAllCity();
        logCityListStartedWithT(city);
        applicationContext.close();
    }

    private static void logCityListStartedWithT(City city) {
        if (city != null) {
            List<CityList> list = city.getList();
            logger.info("Completed list of all city : " + list.size());
            Predicate<CityList> cityListPredicate = getCityListPredicate();
            if (list != null && list.size() > 0) {
                logger.info("All City started name with T :");
                list.stream().filter(cityListPredicate).forEach((myPojo) -> {
                    logger.info(myPojo.toString());
                });
            }
        }
        logger.debug("city details : " + city);
    }

    private static Predicate<CityList> getCityListPredicate() {
        return new Predicate<CityList>() {
            public boolean test(CityList c) {
                if (c != null && c.getName() != null && !c.getName().isEmpty() && (c.getName().startsWith("T") || c.getName().startsWith("t"))) {
                    return true;
                }
                return false;
            }
        };
    }

    private static void getLoggerConfig() {
        // creates pattern layout
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
        layout.setConversionPattern(conversionPattern);

        // creates console appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();

        // creates file appender
        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile("applog3.txt");
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();

        // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        rootLogger.addAppender(consoleAppender);
        rootLogger.addAppender(fileAppender);
    }
}
