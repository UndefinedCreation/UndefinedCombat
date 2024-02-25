package com.redmagic.undefinedcombat.data

import com.redmagic.undefinedcombat.UndefinedCombat

class Settings(val plugin: UndefinedCombat) {
    var timer = plugin.config.getInt("settings.timer")
    var bypass = plugin.config.getBoolean("settings.bypass")
    var bossbar = plugin.config.getBoolean("settings.bossbar")
    var actionbar = plugin.config.getBoolean("settings.actionbar")
    var killOnQuit = plugin.config.getBoolean("settings.kill-on-quit")

    fun saveSettings() {
        plugin.config.set("settings.timer", timer)
        plugin.config.set("settings.bypass", bypass)
        plugin.config.set("settings.bossbar", bossbar)
        plugin.config.set("settings.actionbar", actionbar)
        plugin.config.set("settings.kill-on-quit", killOnQuit)
    }
}