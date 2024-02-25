package com.redmagic.undefinedcombat.extensions


import com.redmagic.undefinedapi.extension.string.toComponent
import com.redmagic.undefinedcombat.UndefinedCombat
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player



fun Player.sendActionbar(component: Component){
    if (UndefinedCombat.plugin.configManager.settings.actionbar){
        sendActionBar(component)
    }
}

fun Player.sendActionbar(string: String){
    this.sendActionbar(string.toComponent())
}