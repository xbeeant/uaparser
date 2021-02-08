package com.xstudio.ua;

import com.xstudio.ua.entity.UserAgent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaobiao
 * @version 2021/2/1
 */
class UserAgentUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(UserAgentUtilTest.class);

    private static Map<String, Integer> count = new HashMap<>(100);

    @Test
    void loadFile() throws IOException {
        testFile("ua_string.csv");
    }

    private void testFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename)));
        String nextLine;
        UserAgent parse;
        StopWatch clock = new StopWatch();
        clock.start("开始任务");
        while ((nextLine = br.readLine()) != null) {
            if (nextLine.startsWith("#") || StringUtils.isEmpty(nextLine.trim())) {
                continue;
            }
            parse = UserAgentParser.parse(nextLine.trim());
            boolean stop = saveLog(parse);
            if (stop) {
                break;
            }
        }
        clock.stop();
        Set<Map.Entry<String, Integer>> entries = count.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            logger.info("{} {}", entry.getKey(), entry.getValue());
        }

        logger.info(clock.prettyPrint());
    }

    private boolean saveLog(UserAgent parse) {
        if (null == parse.getDevice() || StringUtils.isEmpty(parse.getDevice().getFamily())) {
            logger.error("\n\n{}\ndevice: {}\nengine: {}\nbrowser: {}", parse.getAgent(), parse.getDevice(), parse.getEngine(), parse.getBrowser());
            return true;
        } else {
            count.merge(parse.getDevice().getFamily(), 1, Integer::sum);

            logger.trace("\n\n{}\ndevice: {}\nengine: {}\nbrowser: {}", parse.getAgent(), parse.getDevice(), parse.getEngine(), parse.getBrowser());
            return false;
        }

    }

    @Test
    void parse() {
        StopWatch clock = new StopWatch();
        clock.start("开始任务一");
        UserAgent parse = UserAgentParser.parse("Opera/9.80 (Android 4.0.3; Linux; Opera Mobi/ADR-1210241511) Presto/2.11.355 Version/12.10");
        clock.stop();

        logger.info(clock.prettyPrint());
        Assertions.assertEquals("Opera", parse.getBrowser().getFamily());

        clock.start();

        parse = UserAgentParser.parse("Mozilla/5.0 (Linux; Android 4.0.3; M031 Build/IML74K) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        clock.stop();

        logger.info(clock.prettyPrint());
        Assertions.assertEquals("Opera", parse.getBrowser().getFamily());
    }
}