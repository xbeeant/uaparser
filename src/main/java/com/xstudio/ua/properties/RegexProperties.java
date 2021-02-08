package com.xstudio.ua.properties;

import java.util.List;
import java.util.regex.Pattern;

public class RegexProperties {
    private List<BrowserRegex> browser;

    private List<OsRegex> os;

    private List<DeviceRegex> device;

    private List<EngineRegex> engine;

    private String useragent;

    private Pattern useragentPattern;

    public List<BrowserRegex> getBrowser() {
        return browser;
    }

    public void setBrowser(List<BrowserRegex> browser) {
        this.browser = browser;
    }

    public List<OsRegex> getOs() {
        return os;
    }

    public void setOs(List<OsRegex> os) {
        this.os = os;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
        this.useragentPattern = Pattern.compile(useragent);
    }

    public Pattern getUseragentPattern() {
        return useragentPattern;
    }

    public List<EngineRegex> getEngine() {
        return engine;
    }

    public void setEngine(List<EngineRegex> engine) {
        this.engine = engine;
    }

    public List<DeviceRegex> getDevice() {
        return device;
    }

    public void setDevice(List<DeviceRegex> device) {
        this.device = device;
    }
}
