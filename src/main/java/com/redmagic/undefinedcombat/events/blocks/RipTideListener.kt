package com.redmagic.undefinedcombat.events.blocks

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedcombat.UndefinedCombat
import com.redmagic.undefinedcombat.manager.isTagged
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

class RipTideListener {
    init {

        event<PlayerInteractEvent> {
            if (player.isTagged() && UndefinedCombat.plugin.configManager.blocked.riptide) {
                if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) return@event

                if (hand!! == EquipmentSlot.HAND && player.itemInHand.type == Material.TRIDENT) {
                    block(this, player.itemInHand)
                    return@event
                }

                if (hand!! == EquipmentSlot.OFF_HAND && player.inventory.itemInOffHand.type == Material.TRIDENT){
                    block(this, player.inventory.itemInOffHand)
                    return@event
                }
            }
        }
    }

    private fun block(e: PlayerInteractEvent, itemStack: ItemStack){
        if (!itemStack.hasItemMeta()) return
        if (!itemStack.itemMeta.enchants.containsKey(Enchantment.RIPTIDE)) return
        e.isCancelled = true
    }

}