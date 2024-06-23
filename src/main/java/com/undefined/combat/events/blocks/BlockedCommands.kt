package com.undefined.combat.events.blocks

import com.undefined.api.event.event
import com.undefined.api.extension.string.translateColor
import com.undefined.combat.UndefinedCombat
import com.undefined.combat.manager.isTagged
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerCommandSendEvent

class BlockedCommands {

    init {

        event<PlayerCommandPreprocessEvent> {
            if (!player.isTagged()) return@event
            val command = message.replace("/", "").split(" ")[0]

            if (UndefinedCombat.plugin.configManager.blocked.blockedCommands.contains(command)) {

                isCancelled = true

                player.sendMessage("<reset><#d92323>ʏᴏᴜ ᴄᴀɴ'ᴛ ᴜѕᴇ ᴛʜɪѕ ᴄᴏᴍᴍᴀɴᴅ ɪɴ ᴄᴏᴍʙᴀᴛ".translateColor())

            }
        }
    }

}