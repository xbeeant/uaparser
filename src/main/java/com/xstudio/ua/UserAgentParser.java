package com.xstudio.ua;

import com.xstudio.ua.entity.*;
import com.xstudio.ua.properties.*;

import java.util.List;
import java.util.regex.Matcher;

/**
 * @author xiaobiao
 * @version 1.0.0
 * @date 2021/02/01
 */
public class UserAgentParser {

    private static final RegexProperties PROPERTIES = YamlTools.load("regexes.yaml");

    private UserAgentParser() {
        throw new IllegalStateException("Utility class");
    }

    public static UserAgent parse(String userAgent) {

        UserAgent agent;
        agent = new UserAgent(userAgent);
        return agent;
    }

    public static Device parseDevice(String systemInformation) {
        Device device = new Device();
        device.setFamily("Other");

        if (null == systemInformation) {
            return device;
        }
        List<DeviceRegex> regexes = PROPERTIES.getDevice();
        for (DeviceRegex regex : regexes) {
            Matcher matcher = regex.getPattern().matcher(systemInformation);
            if (matcher.find()) {
                device.setFamily(regex.getFamily());
                if ("default".equals(regex.getFamily())) {
                    device.setFamily(matcher.group(1));
                }
                device.setVersion(matcher.group(2));
                break;
            }
        }

        return device;
    }

    public static Engine parseEngine(String agent) {
        Engine engine = new Engine();

        if (StringUtils.isEmpty(agent)) {
            return engine;
        }
        List<EngineRegex> regexes = PROPERTIES.getEngine();
        for (EngineRegex regex : regexes) {
            Matcher matcher = regex.getPattern().matcher(agent);
            if (matcher.find()) {
                engine.setFamily(regex.getFamily());
                engine.setVersion(matcher.group(1));
                break;
            }
        }
        return engine;
    }

    public static Browser parsePlatform(String platformDetails) {
        Browser browser = new Browser();

        if (null == platformDetails) {
            return browser;
        }
        List<BrowserRegex> regexes = PROPERTIES.getBrowser();
        for (BrowserRegex browserRegexProperties : regexes) {
            Matcher matcher = browserRegexProperties.getPattern().matcher(platformDetails);
            if (matcher.find()) {
                browser.setFamily(browserRegexProperties.getFamily());
                browser.setVersion(matcher.group(1));
                break;
            }
        }
        return browser;
    }

    /**
     * 解析系统信息
     *
     * @param systemInformation 系统信息
     * @return {@link Device}
     */
    public static Os parseSystemInformation(String systemInformation) {
        Os device = new Os();
        device.setFamily("Other");

        if (null == systemInformation) {
            return device;
        }
        List<OsRegex> regexes = PROPERTIES.getOs();
        for (OsRegex regex : regexes) {
            Matcher matcher = regex.getPattern().matcher(systemInformation);
            if (matcher.find()) {
                device.setFamily(regex.getFamily());
                device.setType(matcher.group(1));
                device.setVersion(matcher.group(2));
                break;
            }
        }

        return device;
    }

}
