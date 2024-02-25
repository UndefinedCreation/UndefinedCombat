package com.redmagic.undefinedcombat.events.blocks

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedcombat.UndefinedCombat
import com.redmagic.undefinedcombat.manager.isTagged
import org.bukkit.entity.EnderPearl
import org.bukkit.entity.Player
import org.bukkit.event.entity.ProjectileLaunchEvent

class EnderPearlsListener {
    init {
        event<ProjectileLaunchEvent> {
            val enderPearl = entity as EnderPearl?: return@event
            val shooter = enderPearl.shooter as Player?: return@event
            if (shooter.isTagged() && UndefinedCombat.plugin.configManager.blocked.enderpearl)
                isCancelled = true
        }
    }
}