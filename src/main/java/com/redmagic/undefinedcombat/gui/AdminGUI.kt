package com.redmagic.undefinedcombat.gui

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toComponent
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedcombat.UndefinedCombat
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class AdminGUI: UndefinedMenu("ᴀᴅᴍɪɴ ɢᴜɪ", MenuSize.MINI) {

    private val plugin = UndefinedCombat.plugin

    override fun generateInventory(): Inventory = createInventory {


        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setBypassItem(inventory!!)
        setBossBar(inventory!!)
        setActionBar(inventory!!)
        setKillOnQuit(inventory!!)
        setElytra(inventory!!)
        setRiptide(inventory!!)
        setEnderPearl(inventory!!)
        setTimer(inventory!!)



    }


    private fun getEnabledText(boolean: Boolean): String = when(boolean){
        true -> "<!i><#32e67d>ᴇɴᴀʙʟᴇᴅ"
        false -> "<!i><#d92323>ᴅɪѕᴀʙʟᴇᴅ"
    }

    private fun getMaterial(boolean: Boolean): Material = when(boolean){
        true -> Material.LIME_CONCRETE
        false -> Material.RED_CONCRETE
    }

    private fun setBypassItem(inventory: Inventory){

        inventory.setItem(10, ItemBuilder(getMaterial(plugin.configManager.settings.bypass))
            .setName("<!i><#31aee8>ʙʏᴘᴀѕѕ".toComponent())
            .addLine(Component.text(" "))
            .addLine(getEnabledText(plugin.configManager.settings.bypass).toComponent())
            .addLine(Component.text(" "))
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʙʏᴘᴀѕѕ".toComponent()).build(), false)
    }

    private fun setBossBar(inventory: Inventory){

        inventory.setItem(16, ItemBuilder(getMaterial(plugin.configManager.settings.bossbar))
            .setName("<!i><#31e8ab>ʙᴏѕѕʙᴀʀ".toComponent())
            .addLine(Component.text(" "))
            .addLine(getEnabledText(plugin.configManager.settings.bossbar).toComponent())
            .addLine(Component.text(" "))
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʙᴏѕѕʙᴀʀ".toComponent()).build(), false)
    }

    private fun setActionBar(inventory: Inventory){

        inventory.setItem(15, ItemBuilder(getMaterial(plugin.configManager.settings.actionbar))
            .setName("<!i><#e8a831>ᴀᴄᴛɪᴏɴʙᴀʀ".toComponent())
            .addLine(Component.text(" "))
            .addLine(getEnabledText(plugin.configManager.settings.actionbar).toComponent())
            .addLine(Component.text(" "))
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ᴀᴄᴛɪᴏɴʙᴀʀ".toComponent()).build(), false)
    }

    private fun setKillOnQuit(inventory: Inventory){

        inventory.setItem(14, ItemBuilder(getMaterial(plugin.configManager.settings.killOnQuit))
            .setName("<!i><#e85531>ᴋɪʟʟ ᴏɴ ǫᴜɪᴛ".toComponent())
            .addLine(Component.text(" "))
            .addLine(getEnabledText(plugin.configManager.settings.killOnQuit).toComponent())
            .addLine(Component.text(" "))
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴋɪʟʟ ᴏɴ ǫᴜɪᴛ".toComponent()).build(), false)
    }
    private fun setElytra(inventory: Inventory){

        inventory.setItem(13, ItemBuilder(getMaterial(plugin.configManager.blocked.elytra))
            .setName("<!i><#8f4ae8>ᴇʟʏᴛʀᴀ".toComponent())
            .addLine(Component.text(" "))
            .addLine(getEnabledText(plugin.configManager.blocked.elytra).toComponent())
            .addLine(Component.text(" "))
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴇʟʏᴛʀᴀ".toComponent()).build(), false)
    }

    private fun setRiptide(inventory: Inventory){

        inventory.setItem(12, ItemBuilder(getMaterial(plugin.configManager.blocked.riptide))
            .setName("<!i><#4ae0e8>ʀɪᴘᴛɪᴅᴇ".toComponent())
            .addLine(Component.text(" "))
            .addLine(getEnabledText(plugin.configManager.blocked.riptide).toComponent())
            .addLine(Component.text(" "))
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ʀɪᴘᴛɪᴅᴇ".toComponent()).build(), false)
    }

    private fun setEnderPearl(inventory: Inventory){

        inventory.setItem(11, ItemBuilder(getMaterial(plugin.configManager.blocked.enderpearl))
            .setName("<!i><#ae6aeb>ᴇɴᴅᴇʀ ᴘᴇᴀʀʟ".toComponent())
            .addLine(Component.text(" "))
            .addLine(getEnabledText(plugin.configManager.blocked.enderpearl).toComponent())
            .addLine(Component.text(" "))
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴇɴᴅᴇʀ ᴘᴇᴀʀʟѕ".toComponent()).build(), false)
    }

    private fun setTimer(inventory: Inventory){

        inventory.setItem(22, ItemBuilder(Material.CLOCK)
            .setName("<!i><#6aebb7>ᴛɪᴍᴇʀ".toComponent())
            .addLine(Component.text(" "))
            .addLine("<!i><aqua>ᴛɪᴍᴇʀ  <gray>${plugin.configManager.settings.timer}".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴛʜᴇ ᴛɪᴍᴇʀ".toComponent()).build(), false)
    }
}