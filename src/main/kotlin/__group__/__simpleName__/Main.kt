package dittonut.__simpleName__

import org.bukkit.plugin.java.JavaPlugin
import org.incendo.cloud.execution.ExecutionCoordinator
import org.incendo.cloud.paper.PaperCommandManager
import java.util.logging.Logger


lateinit var plugin: __main_class__
    private set
lateinit var logger: Logger
    private set

class __main_class__ : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        plugin = this
        dittonut.__simpleName__.logger = logger

        val commandManager = PaperCommandManager.builder()
            .executionCoordinator(ExecutionCoordinator.simpleCoordinator())
            .buildOnEnable(this)
        registerCommands(commandManager)

        if (!dataFolder.exists()) dataFolder.mkdirs()
        ConfigManager.load()

        server.scheduler.runTaskTimer(this, Runnable {
            ConfigManager.save()
        }, 0L, 600L) // 600틱 = 30초
    }

    override fun onDisable() {
        // Plugin shutdown logic
        ConfigManager.save()
    }
}
