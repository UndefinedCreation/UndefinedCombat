package com.undefined.combat.events

import com.undefined.api.event.event
import com.undefined.combat.UndefinedCombat
import com.undefined.combat.customEvents.PlayerTagEvent

class BypassListener {
    init {
        event<PlayerTagEvent> {
            if (player.hasPermission("undefined.combat.bypass") && UndefinedCombat.plugin.configManager.settings.bypass)
                isCancelled = true
        }
    }
}