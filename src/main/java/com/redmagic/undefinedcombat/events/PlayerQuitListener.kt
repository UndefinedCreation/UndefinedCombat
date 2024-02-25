package com.redmagic.undefinedcombat.events

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedcombat.UndefinedCombat
import com.redmagic.undefinedcombat.manager.isTagged
import org.bukkit.event.player.PlayerQuitEvent

class PlayerQuitListener {
    init {
        event<PlayerQuitEvent> {
            if (player.isTagged() && UndefinedCombat.plugin.configManager.settings.killOnQuit){
                player.health = 0.0
            }
        }
    }
}