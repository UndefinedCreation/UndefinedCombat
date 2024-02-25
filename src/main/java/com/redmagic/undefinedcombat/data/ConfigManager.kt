package com.redmagic.undefinedcombat.data

import com.redmagic.undefinedcombat.UndefinedCombat
import java.io.File

class ConfigManager(val plugin: UndefinedCombat) {


    var settings = Settings(plugin)
    var blocked = Blocked(plugin)

    init {
        plugin.saveDefaultConfig()
    }

    fun save(){
        settings.saveSettings()
        blocked.save()
        plugin.config.save(File(plugin.dataFolder, "config.yml"))
    }

}