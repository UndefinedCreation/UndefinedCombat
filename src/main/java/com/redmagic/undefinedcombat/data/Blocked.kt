package com.redmagic.undefinedcombat.data

import com.redmagic.undefinedcombat.UndefinedCombat

class Blocked(val plugin: UndefinedCombat) {
    var elytra = plugin.undefinedConfig.getBoolean("blocked.elytra")
    var riptide = plugin.undefinedConfig.getBoolean("blocked.riptide")
    var enderpearl = plugin.undefinedConfig.getBoolean("blocked.ender-pearls")

    fun save(){
        plugin.undefinedConfig.set("blocked.elytra", elytra)
        plugin.undefinedConfig.set("blocked.riptide", riptide)
        plugin.undefinedConfig.set("blocked.enderpearl", enderpearl)
    }
}