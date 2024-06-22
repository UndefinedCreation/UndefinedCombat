package com.undefined.combat.events

import com.undefined.api.customEvents.PlayerHitByPlayerEvent
import com.undefined.api.event.event
import com.undefined.combat.UndefinedCombat
import com.undefined.combat.manager.tag

class HitListener {
    init {
        event<PlayerHitByPlayerEvent> {
            hitPlayer.tag(UndefinedCombat.plugin.configManager.settings.timer)
            damager.tag(UndefinedCombat.plugin.configManager.settings.timer)
        }
    }
}