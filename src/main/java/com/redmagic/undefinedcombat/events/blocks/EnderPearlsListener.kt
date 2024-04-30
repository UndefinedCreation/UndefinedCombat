package com.redmagic.undefinedcombat.events.blocks

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedcombat.UndefinedCombat
import com.redmagic.undefinedcombat.manager.isTagged
import com.redmagic.undefinedcombat.manager.tag
import org.bukkit.entity.EnderPearl
import org.bukkit.entity.Player
import org.bukkit.event.entity.ProjectileLaunchEvent

class EnderPearlsListener {
    init {
        event<ProjectileLaunchEvent> {
            if (entity is EnderPearl) {
                val enderPearl = entity as EnderPearl
                val shooter = enderPearl.shooter as Player

                if (shooter.isTagged()){

                    shooter.tag(UndefinedCombat.plugin.configManager.settings.timer)

                    if (UndefinedCombat.plugin.configManager.blocked.enderpearl)
                        isCancelled = true
                }

            }
        }

    }
}