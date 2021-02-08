package com.xstudio.ua.entity;

import com.xstudio.ua.UserAgentParser;

/**
 * @author xiaobiao
 * @version 1.0.0
 * @date 2021/02/01
 */
public class UserAgent {
    private String agent;
    private Browser browser;
    private Device device;
    private Os os;
    private Engine engine;

    public UserAgent() {
    }

    public UserAgent(String userAgent) {
        this.agent = userAgent;
        this.engine = UserAgentParser.parseEngine(agent);
        this.os = UserAgentParser.parseSystemInformation(userAgent);
        this.device = UserAgentParser.parseDevice(userAgent);
        this.browser = UserAgentParser.parsePlatform(agent);
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * 获取 os.
     *
     * @return os 值
     */
    public Os getOs() {
        return os;
    }

    /**
     * 设置 os.
     *
     * <p>通过 getOs() 获取 os</p>
     *
     * @param os os
     */
    public void setOs(Os os) {
        this.os = os;
    }

    @Override
    public String toString() {
        if (null == browser || null == browser.getFamily()) {
            return "{agent:'" + agent + "'}";
        } else {
            return "{browser:" + browser +
                    ", device:" + device +
                    ", engine:" + engine +
                    ", os:" + os +
                    ", agent:'" + agent + '\'' +
                    '}';
        }
    }
}
