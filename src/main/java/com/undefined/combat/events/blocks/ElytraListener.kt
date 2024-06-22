package com.undefined.combat.events.blocks

import com.undefined.api.event.event
import com.undefined.api.scheduler.delay
import com.undefined.combat.UndefinedCombat
import com.undefined.combat.customEvents.PlayerTagEvent
import com.undefined.combat.manager.isTagged
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
            if (com.undefined.combat.UndefinedCombat.plugin.configManager.blocked.elytra)
                player.isGliding = false
        }


    }
}