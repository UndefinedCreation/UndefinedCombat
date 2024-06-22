package com.undefined.combat.gui

import com.undefined.api.builders.ItemBuilder
import com.undefined.api.extension.string.translateColor
import com.undefined.api.extension.string.translateColor
import com.undefined.api.menu.MenuManager.openMenu
import com.undefined.api.menu.MenuSize
import com.undefined.api.menu.normal.UndefinedMenu
import com.undefined.api.menu.normal.button.Button
import com.undefined.combat.UndefinedCombat
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class AdminGUI: UndefinedMenu("ᴀᴅᴍɪɴ ɢᴜɪ", MenuSize.MINI) {

    private val plugin = UndefinedCombat.plugin

    override fun generateInventory(): Inventory = createInventory {


        val inv = this

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setBypassItem(this)
        setBossBar(this)
        setActionBar(this)
        setKillOnQuit(this)
        setElytra(this)
        setRiptide(this)
        setEnderPearl(this)
        setTimer(this)


        addButton(Button(10){
            plugin.configManager.settings.bypass = !plugin.configManager.settings.bypass
            setBypassItem(inv)
        })
        addButton(Button(16){
            plugin.configManager.settings.bossbar = !plugin.configManager.settings.bossbar
            setBossBar(inv)
        })
        addButton(Button(15){
            plugin.configManager.settings.actionbar = !plugin.configManager.settings.actionbar
            setActionBar(inv)
        })
        addButton(Button(14){
            plugin.configManager.settings.killOnQuit = !plugin.configManager.settings.killOnQuit
            setKillOnQuit(inv)
        })
        addButton(Button(13){
            plugin.configManager.blocked.elytra = !plugin.configManager.blocked.elytra
            setElytra(inv)
        })
        addButton(Button(12){
            plugin.configManager.blocked.riptide = !plugin.configManager.blocked.riptide
            setRiptide(inv)
        })
        addButton(Button(11){
            plugin.configManager.blocked.enderpearl = !plugin.configManager.blocked.enderpearl
            setEnderPearl(inv)
        })
        addButton(Button(22){

            val builder = AnvilGUI.Builder()
                .itemLeft(ItemBuilder(Material.CLOCK).setName("<aqua>{${plugin.configManager.settings.timer}}".translateColor()).build())
                .title("ᴄʜᴀɴɢᴇ ᴛɪᴍᴇʀ")
                .text(plugin.configManager.settings.timer.toString())
                .plugin(plugin)
            builder.onClick { _, clickEvent ->

                val text = clickEvent.text

                try {

                    val timer = text.toInt()

                    plugin.configManager.settings.timer = timer

                }catch (e: NumberFormatException){
                    player.sendMessage("<red>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".translateColor())
                }

                return@onClick listOf(AnvilGUI.ResponseAction.run{
                    player.openMenu(plugin.adminGUI)
                })
            }

            builder.open(player)

        })

    }


    private fun getEnabledText(boolean: Boolean): String = when(boolean){
        true -> "<reset><#32e67d>ᴇɴᴀʙʟᴇᴅ"
        false -> "<reset><#d92323>ᴅɪѕᴀʙʟᴇᴅ"
    }

    private fun getMaterial(boolean: Boolean): Material = when(boolean){
        true -> Material.LIME_CONCRETE
        false -> Material.RED_CONCRETE
    }

    private fun setBypassItem(inventory: Inventory){

        inventory.setItem(10, ItemBuilder(getMaterial(plugin.configManager.settings.bypass))
            .setName("<reset><#31aee8>ʙʏᴘᴀѕѕ".translateColor())
            .addLine(" ")
            .addLine(getEnabledText(plugin.configManager.settings.bypass).translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʙʏᴘᴀѕѕ".translateColor()).build(), false)
    }

    private fun setBossBar(inventory: Inventory){

        inventory.setItem(16, ItemBuilder(getMaterial(plugin.configManager.settings.bossbar))
            .setName("<reset><#31e8ab>ʙᴏѕѕʙᴀʀ".translateColor())
            .addLine(" ")
            .addLine(getEnabledText(plugin.configManager.settings.bossbar).translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʙᴏѕѕʙᴀʀ".translateColor()).build(), false)
    }

    private fun setActionBar(inventory: Inventory){

        inventory.setItem(15, ItemBuilder(getMaterial(plugin.configManager.settings.actionbar))
            .setName("<reset><#e8a831>ᴀᴄᴛɪᴏɴʙᴀʀ".translateColor())
            .addLine(" ")
            .addLine(getEnabledText(plugin.configManager.settings.actionbar).translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ᴀᴄᴛɪᴏɴʙᴀʀ".translateColor()).build(), false)
    }

    private fun setKillOnQuit(inventory: Inventory){

        inventory.setItem(14, ItemBuilder(getMaterial(plugin.configManager.settings.killOnQuit))
            .setName("<reset><#e85531>ᴋɪʟʟ ᴏɴ ǫᴜɪᴛ".translateColor())
            .addLine(" ")
            .addLine(getEnabledText(plugin.configManager.settings.killOnQuit).translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴋɪʟʟ ᴏɴ ǫᴜɪᴛ".translateColor()).build(), false)
    }
    private fun setElytra(inventory: Inventory){

        inventory.setItem(13, ItemBuilder(getMaterial(plugin.configManager.blocked.elytra))
            .setName("<reset><#8f4ae8>ᴇʟʏᴛʀᴀ".translateColor())
            .addLine(" ")
            .addLine(getEnabledText(plugin.configManager.blocked.elytra).translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴇʟʏᴛʀᴀ".translateColor()).build(), false)
    }

    private fun setRiptide(inventory: Inventory){

        inventory.setItem(12, ItemBuilder(getMaterial(plugin.configManager.blocked.riptide))
            .setName("<reset><#4ae0e8>ʀɪᴘᴛɪᴅᴇ".translateColor())
            .addLine(" ")
            .addLine(getEnabledText(plugin.configManager.blocked.riptide).translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ʀɪᴘᴛɪᴅᴇ".translateColor()).build(), false)
    }

    private fun setEnderPearl(inventory: Inventory){

        inventory.setItem(11, ItemBuilder(getMaterial(plugin.configManager.blocked.enderpearl))
            .setName("<reset><#ae6aeb>ᴇɴᴅᴇʀ ᴘᴇᴀʀʟ".translateColor())
            .addLine(" ")
            .addLine(getEnabledText(plugin.configManager.blocked.enderpearl).translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴇɴᴅᴇʀ ᴘᴇᴀʀʟѕ".translateColor()).build(), false)
    }

    private fun setTimer(inventory: Inventory){

        inventory.setItem(22, ItemBuilder(Material.CLOCK)
            .setName("<reset><#6aebb7>ᴛɪᴍᴇʀ".translateColor())
            .addLine(" ")
            .addLine("<reset><aqua>ᴛɪᴍᴇʀ  <gray>${plugin.configManager.settings.timer}".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴛʜᴇ ᴛɪᴍᴇʀ".translateColor()).build(), false)
    }
}