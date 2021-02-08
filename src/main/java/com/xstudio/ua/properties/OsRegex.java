package com.xstudio.ua.properties;

import java.util.regex.Pattern;

/**
 * @author xiaobiao
 * @date 2021/02/02
 */
public class OsRegex {
    private String family;

    private String regex;

    private Pattern pattern;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }

    public Pattern getPattern() {
        return pattern;
    }
}
