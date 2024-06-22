package com.undefined.combat.events.blocks

import com.undefined.api.event.event
import com.undefined.combat.UndefinedCombat
import com.undefined.combat.manager.isTagged
import com.undefined.combat.manager.tag
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