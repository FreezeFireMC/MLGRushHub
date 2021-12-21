package de.chaos.mc.server.mlgrushhub;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import de.chaos.mc.server.mlgrushhub.listener.ConnectionListener;
import de.chaos.mc.server.mlgrushhub.utils.MLGRushPlayerLanguage;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.LanguageLoader;
import de.chaos.mc.server.mlgrushhub.utils.megaUtils.menu.MenuFactory;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.InventoryClickListener;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.InventoryCloseListener;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.MLGRushProfileInv;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.ormlite.UpdateMLGRushInvSortingRepository;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.ormlite.UpdateMLGRushInventorySortingInterface;
import de.chaos.mc.server.mlgrushhub.utils.statsLibary.StatsInterface;
import de.chaos.mc.server.mlgrushhub.utils.statsLibary.StatsRepository;
import de.chaos.mc.serverapi.api.ServerAPI;
import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageInterface;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class MLGRushHub extends JavaPlugin {
    private ServerAPI serverAPI;
    @Getter private static MLGRushHub instance;
    private JdbcPooledConnectionSource connectionSource;
    @Getter private LanguageInterface languageInterface;
    private MLGRushProfileInv mlgRushProfileInv;
    private UpdateMLGRushInvSortingRepository updateInvSortingRepository;
    @Getter private UpdateMLGRushInventorySortingInterface updateInventorySortingInterface;
    public static MenuFactory menuFactory;
    private StatsInterface statsInterface;
    private LanguageLoader languageLoader;
    @Getter private static HashMap<UUID, MLGRushPlayerLanguage> onlinePlayers;

    @Override
    public void onEnable() {
        instance = this;
        serverAPI = new ServerAPI();
        connectionSource = serverAPI.getConnectionSource();
        languageInterface = serverAPI.getLanguageInterface();
        updateInventorySortingInterface = new UpdateMLGRushInvSortingRepository(connectionSource);
        menuFactory = MenuFactory.register(this);
        mlgRushProfileInv = new MLGRushProfileInv(updateInventorySortingInterface, menuFactory, languageInterface);
        statsInterface = new StatsRepository(connectionSource);
        onlinePlayers = new HashMap<>();
        languageLoader = new LanguageLoader(languageInterface);

        registerEvent(new ConnectionListener(updateInventorySortingInterface, statsInterface, languageLoader));
        registerEvent(new InventoryClickListener(updateInventorySortingInterface));
        registerEvent(new InventoryCloseListener(updateInventorySortingInterface, languageInterface));
    }

    public void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, instance);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
