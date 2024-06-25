package com.undefined.combat.placeholders

import com.undefined.combat.manager.getTaggedTime
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.entity.Player

class TimeLeft: PlaceholderExpansion() {

    override fun onPlaceholderRequest(player: Player?, params: String): String =
        if (params.equals("timer", true))
            player?.getTaggedTime() ?: "Player is not online"
        else ""

    override fun getIdentifier(): String = "UndefinedCombat"

    override fun getAuthor(): String = "UndefinedCreation"

    override fun getVersion(): String = "1.0.0"
    override fun persist(): Boolean = true
}