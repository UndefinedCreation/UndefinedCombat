package com.undefined.combat.data

import com.undefined.combat.UndefinedCombat
import java.io.File

class ConfigManager(val plugin: UndefinedCombat) {


    var settings = Settings(plugin)
    var blocked = Blocked(plugin)

    fun save(){
        settings.saveSettings()
        blocked.save()
        plugin.saveConfigFile()
    }

}