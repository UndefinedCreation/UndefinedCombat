package com.undefined.combat.events

import com.undefined.api.event.event
import com.undefined.combat.manager.isTagged
import com.undefined.combat.manager.untag
import org.bukkit.event.entity.PlayerDeathEvent

class DeathListener {
    init {

        event<PlayerDeathEvent> {
            if (entity.isTagged())
                entity.untag()
        }

    }
}