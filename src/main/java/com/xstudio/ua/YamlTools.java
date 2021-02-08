package com.xstudio.ua;

import com.xstudio.ua.properties.RegexProperties;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class YamlTools {

    /**
     * 以文件路径为条件的构造函数
     *
     * @param resource 文件路径
     */
    public static RegexProperties load(String resource) {
        Yaml yaml = new Yaml(new Constructor(RegexProperties.class));
        InputStream inputStream = YamlTools.class
                .getClassLoader()
                .getResourceAsStream(resource);
        RegexProperties regexProperties = yaml.load(inputStream);
        return regexProperties;
    }

}
