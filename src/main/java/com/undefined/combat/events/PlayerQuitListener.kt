package com.undefined.combat.events

import com.undefined.api.event.event
import com.undefined.combat.UndefinedCombat
import com.undefined.combat.manager.isTagged
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