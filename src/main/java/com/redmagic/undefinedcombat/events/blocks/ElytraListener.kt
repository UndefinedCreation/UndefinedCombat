package com.redmagic.undefinedcombat.events.blocks

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedapi.scheduler.delay
import com.redmagic.undefinedcombat.UndefinedCombat
import com.redmagic.undefinedcombat.customEvents.PlayerTagEvent
import com.redmagic.undefinedcombat.manager.isTagged
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityToggleGlideEvent
import org.bukkit.event.player.PlayerRiptideEvent

class ElytraListener {
    init {

        event<EntityToggleGlideEvent> {
            val player = entity as Player?: return@event
            if (player.isTagged() && UndefinedCombat.plugin.configManager.blocked.elytra){
                isCancelled = true
                delay(1) { player.isGliding = false }
            }

        }

        event<PlayerTagEvent> {
            if (UndefinedCombat.plugin.configManager.blocked.elytra)
                player.isGliding = false
        }


    }
}