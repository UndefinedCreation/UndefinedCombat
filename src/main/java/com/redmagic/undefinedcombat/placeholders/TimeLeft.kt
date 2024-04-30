package com.redmagic.undefinedcombat.placeholders

import com.redmagic.undefinedcombat.manager.getTaggedTime
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player

class TimeLeft: PlaceholderExpansion() {

    override fun onPlaceholderRequest(player: Player?, params: String): String =
        if (params == "timer")
            player?.getTaggedTime() ?: "Player is not online"
        else ""

    override fun getIdentifier(): String = "UndefinedCombat"

    override fun getAuthor(): String = "UndefinedCreation"

    override fun getVersion(): String = "1.0.0"
    override fun persist(): Boolean = true
}