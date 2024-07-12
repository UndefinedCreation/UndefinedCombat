package com.undefined.combat.data

import com.undefined.api.extension.string.translateColor
import com.undefined.combat.UndefinedCombat
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class Blocked(val plugin: UndefinedCombat) {
    var elytra = plugin.undefinedConfig.getBoolean("blocked.elytra")
    var riptide = plugin.undefinedConfig.getBoolean("blocked.riptide")
    var enderpearl = plugin.undefinedConfig.getBoolean("blocked.ender-pearls")

    var whitelist = plugin.undefinedConfig.getBoolean("blocked.whitelist-commands").or(false)
    val blockedCommands: MutableList<String> = plugin.undefinedConfig.getStringList("blocked.commands")

    fun save(){
        plugin.undefinedConfig.set("blocked.elytra", elytra)
        plugin.undefinedConfig.set("blocked.riptide", riptide)
        plugin.undefinedConfig.set("blocked.ender-pearls", enderpearl)
        plugin.undefinedConfig.set("blocked.commands", blockedCommands)
        plugin.undefinedConfig.set("blocked.whitelist-commands", whitelist)
    }


    fun createItemStackList(): List<ItemStack> = blockedCommands.map {
        val stack = ItemStack(Material.PAPER)
        val meta = stack.itemMeta!!
        meta.setDisplayName("<reset><#34eb71>${it}".translateColor())
        meta.lore = listOf(" ", "<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ʀᴇᴍᴏᴠᴇ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ".translateColor())
        meta.persistentDataContainer.set(UndefinedCombat.nameSpace, PersistentDataType.STRING, it)
        stack.itemMeta = meta
        stack
    }
}