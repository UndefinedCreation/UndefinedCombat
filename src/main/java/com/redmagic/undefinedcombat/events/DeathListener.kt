package com.redmagic.undefinedcombat.events

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedcombat.manager.isTagged
import com.redmagic.undefinedcombat.manager.untag
import org.bukkit.event.entity.PlayerDeathEvent

class DeathListener {
    init {

        event<PlayerDeathEvent> {
            if (player.isTagged())
                player.untag()
        }

    }
}