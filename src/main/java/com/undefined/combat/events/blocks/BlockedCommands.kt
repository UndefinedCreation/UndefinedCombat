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

            val list = UndefinedCombat.plugin.configManager.blocked.blockedCommands

            val check = if (UndefinedCombat.plugin.configManager.blocked.whitelist)
                !list.contains(command) else list.contains(command)

            if (check) {

                isCancelled = true

                player.sendMessage("<reset><#d92323>ʏᴏᴜ ᴄᴀɴ'ᴛ ᴜѕᴇ ᴛʜɪѕ ᴄᴏᴍᴍᴀɴᴅ ɪɴ ᴄᴏᴍʙᴀᴛ".translateColor())

            }
        }
    }

}