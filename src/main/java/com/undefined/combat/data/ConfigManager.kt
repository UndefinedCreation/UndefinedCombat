package com.undefined.combat.data

import com.undefined.combat.UndefinedCombat
import java.io.File

class ConfigManager(val plugin: UndefinedCombat) {

    var settings = Settings(plugin)
    var blocked = Blocked(plugin)

    var actionBar = plugin.undefinedConfig.getString("messages.action-bar")!!
    var bossBar = plugin.undefinedConfig.getString("messages.boss-bar")!!

    fun save(){
        settings.saveSettings()
        blocked.save()

        plugin.undefinedConfig.set("messages.action-bar", actionBar)
        plugin.undefinedConfig.set("messages.boss-bar", bossBar)

        plugin.saveConfigFile()
    }

}