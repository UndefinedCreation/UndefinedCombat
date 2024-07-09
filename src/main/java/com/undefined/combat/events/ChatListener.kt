package com.undefined.combat.events

import com.undefined.api.event.event
import org.bukkit.entity.Player
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerQuitEvent
import java.util.UUID

class ChatListener {

    val inChat: HashMap<UUID, String.() -> Unit> = hashMapOf()

    init {

        event<AsyncPlayerChatEvent> {
            if (inChat.containsKey(player.uniqueId)) {
                isCancelled = true

                inChat[player.uniqueId]!!.invoke(message)

                inChat.remove(player.uniqueId)
            }
        }

        event<PlayerQuitEvent> {
            inChat.remove(player.uniqueId)
        }

    }

    fun chatInput(player: Player, output: String.() -> Unit) {
        inChat[player.uniqueId] = output
    }

}