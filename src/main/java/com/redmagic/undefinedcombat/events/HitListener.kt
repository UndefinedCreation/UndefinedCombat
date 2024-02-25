package com.redmagic.undefinedcombat.events

import com.redmagic.undefinedapi.customEvents.PlayerHitByPlayerEvent
import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedcombat.UndefinedCombat
import com.redmagic.undefinedcombat.manager.tag

class HitListener {
    init {
        event<PlayerHitByPlayerEvent> {
            hitPlayer.tag(UndefinedCombat.plugin.configManager.settings.timer)
            damager.tag(UndefinedCombat.plugin.configManager.settings.timer)
        }
    }
}