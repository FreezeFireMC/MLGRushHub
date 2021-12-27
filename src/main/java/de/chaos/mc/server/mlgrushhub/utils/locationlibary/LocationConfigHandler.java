package de.chaos.mc.server.mlgrushhub.utils.locationlibary;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
public class LocationConfigHandler {

    @Getter private File locationsFile;
    @Getter private YamlConfiguration locationConfig;

    public void loadConfig() {
        locationsFile = new File(MLGRushHub.getInstance().getDataFolder(), "locations.yml");
        locationConfig = YamlConfiguration.loadConfiguration(locationsFile);

        if (!MLGRushHub.getInstance().getDataFolder().exists()) {
            MLGRushHub.getInstance().getDataFolder().mkdir();
        }

        if (!locationsFile.exists()) {
            try {
                locationsFile.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        saveLocationFile();
    }


    public void saveMap(String name, Location location) {
        locationConfig.set(name, location);
        saveLocationFile();
    }

    public Location readLocation(String name) {
        if (locationsFile.length() == 0) {
            return null;
        }

        Location location = locationConfig.getSerializable(name, Location.class);
        return location;
    }

    public void saveLocationFile() {
        try {
            if (!locationsFile.exists()) locationsFile.createNewFile();
            locationConfig.save(locationsFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}