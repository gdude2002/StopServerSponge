package me.gserv.stopserver;

import me.gserv.stopserver.config.YamlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.event.Subscribe;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;

@Plugin(id="stopserver", name="StopServer")
public class StopServerPlugin {
    private YamlConfig config;

    public final Game game;
    public final PluginContainer pluginContainer;

    @Inject
    public Logger logger;

    @Inject @Named("GeneralConfigDir")
    public File main_config_dir;
    @Inject @Named("PluginConfigFile")
    public File rec_config_file;
    @Inject @Named("PluginConfigDir")
    public File rec_config_dir;


    @Inject
    public StopServerPlugin(Game game, PluginContainer pluginContainer) {
        this.game = game;
        this.pluginContainer = pluginContainer;

        this.logger =  LoggerFactory.getLogger("StopServer");
    }

    @Subscribe
    public void onPreInit(PreInitializationEvent e) {
        boolean result = this.loadConfig();

        if (!result) {
            this.logger.warn("Unable to load configuration!");
        } else {
            this.logger.info("Loaded successfully");
            this.logger.info("Time: " + (String) this.config.data.get("time"));
            this.logger.info("Tick rate: " + (Integer) this.config.data.get("tickrate"));
            this.logger.info("Version: " + (String) this.config.data.get("version"));
        }
    }

    public boolean loadConfig() {
        if (!rec_config_dir.exists()) {
            if (!rec_config_dir.mkdir()) {
                this.logger.error("Unable to create configuration folder");
                return false;
            }
        }

        File configFile = new File(rec_config_dir.getPath() + "/config.yml");

        if (!configFile.exists()) {
            try {
                InputStream input = getClass().getResourceAsStream("/config.yml");
                String fileData = Utils.convertStreamToString(input);
                input.close();

                FileWriter writer = new FileWriter(configFile);
                writer.write(fileData);
                writer.flush();
                writer.close();

                this.config = new YamlConfig(configFile);

                return true;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            try {
                this.config = new YamlConfig(configFile);

                return true;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return false;
    }
}
