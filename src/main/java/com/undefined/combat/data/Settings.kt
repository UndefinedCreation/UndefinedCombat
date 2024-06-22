package com.undefined.combat.data

import com.undefined.combat.UndefinedCombat

class Settings(val plugin: UndefinedCombat) {
    var timer = plugin.undefinedConfig.getInt("settings.timer")
    var bypass = plugin.undefinedConfig.getBoolean("settings.bypass")
    var bossbar = plugin.undefinedConfig.getBoolean("settings.bossbar")
    var actionbar = plugin.undefinedConfig.getBoolean("settings.actionbar")
    var killOnQuit = plugin.undefinedConfig.getBoolean("settings.kill-on-quit")

    fun saveSettings() {
        plugin.undefinedConfig.set("settings.timer", timer)
        plugin.undefinedConfig.set("settings.bypass", bypass)
        plugin.undefinedConfig.set("settings.bossbar", bossbar)
        plugin.undefinedConfig.set("settings.actionbar", actionbar)
        plugin.undefinedConfig.set("settings.kill-on-quit", killOnQuit)
    }
}