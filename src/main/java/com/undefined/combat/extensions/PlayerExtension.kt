package com.undefined.combat.extensions


import com.undefined.api.extension.sendActionBar
import com.undefined.api.extension.string.toComponent
import com.undefined.combat.UndefinedCombat
import org.bukkit.entity.Player



fun Player.sendActionbarCombat(string: String){
    if (UndefinedCombat.plugin.configManager.settings.actionbar){
        sendActionBar(string)
    }
}