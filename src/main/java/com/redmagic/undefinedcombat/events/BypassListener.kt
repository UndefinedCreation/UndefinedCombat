package com.redmagic.undefinedcombat.events

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedcombat.UndefinedCombat
import com.redmagic.undefinedcombat.customEvents.PlayerTagEvent

class BypassListener {
    init {
        event<PlayerTagEvent> {
            if (player.hasPermission("undefined.combat.bypass") && UndefinedCombat.plugin.configManager.settings.bypass)
                isCancelled = true
        }
    }
}