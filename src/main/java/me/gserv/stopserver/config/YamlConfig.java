package me.gserv.stopserver.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class YamlConfig {
    private final Yaml yaml;
    private final File file;

    public final Map data;

    public YamlConfig(File file) throws IOException {
        this.file = file;
        this.yaml = new Yaml(new SafeConstructor());
        this.data = (Map) this.yaml.load(new FileReader(this.file));
    }

    public YamlConfig(File file, String input) throws IOException {
        this.file = file;
        this.yaml = new Yaml(new SafeConstructor());
        this.data = (Map) this.yaml.load(input);
    }

    public void save() throws IOException {
        this.yaml.dump(this.data, new FileWriter(this.file));
    }
}
