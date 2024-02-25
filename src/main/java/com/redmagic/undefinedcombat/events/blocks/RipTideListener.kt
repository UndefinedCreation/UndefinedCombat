package com.redmagic.undefinedcombat.events.blocks

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedcombat.UndefinedCombat
import com.redmagic.undefinedcombat.manager.isTagged
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.event.player.PlayerInteractEvent

class RipTideListener {
    init {

        event<PlayerInteractEvent> {
            if (player.isTagged() && UndefinedCombat.plugin.configManager.blocked.riptide){
                if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) return@event
                if (player.itemInHand.type != Material.TRIDENT)return@event
                if (!player.itemInHand.hasItemMeta()) return@event
                if (!player.itemInHand.itemMeta.enchants.containsKey(Enchantment.RIPTIDE)) return@event
                isCancelled = true
            }
        }

    }
}