package dittonut.__simpleName__

import io.papermc.paper.command.brigadier.CommandSourceStack
import org.incendo.cloud.CommandManager
import org.incendo.cloud.kotlin.extension.buildAndRegister

fun registerCommands(manager: CommandManager<CommandSourceStack>) {
    manager.buildAndRegister("__simpleName__") {
        literal("reload")
        permission("__simpleName__.reload")
        handler { ctx ->

        }
    }
}