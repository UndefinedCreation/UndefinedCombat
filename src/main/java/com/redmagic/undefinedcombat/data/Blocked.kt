package com.redmagic.undefinedcombat.data

import com.redmagic.undefinedcombat.UndefinedCombat

class Blocked(val plugin: UndefinedCombat) {
    val elytra = plugin.config.getBoolean("blocked.elytra")
    val riptide = plugin.config.getBoolean("blocked.riptide")
    val enderpearl = plugin.config.getBoolean("blocked.ender-pearls")

    fun save(){
        plugin.config.set("blocked.elytra", elytra)
        plugin.config.set("blocked.riptide", riptide)
        plugin.config.set("blocked.enderpearl", enderpearl)
    }
}