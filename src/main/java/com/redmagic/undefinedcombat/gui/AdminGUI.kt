package com.redmagic.undefinedcombat.gui

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toComponent
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedcombat.UndefinedCombat
import net.kyori.adventure.text.Component
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Bukkit
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
                .itemLeft(ItemBuilder(Material.CLOCK).setName("<aqua>{${plugin.configManager.settings.timer}}".toComponent()).build())
                .title("ᴄʜᴀɴɢᴇ ᴛɪᴍᴇʀ")
                .text(plugin.configManager.settings.timer.toString())
                .plugin(plugin)
            builder.onClick { _, clickEvent ->

                val text = clickEvent.text

                try {

                    val timer = text.toInt()

                    plugin.configManager.settings.timer = timer

                }catch (e: NumberFormatException){
                    player.sendMessage("<red>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                }

                return@onClick listOf(AnvilGUI.ResponseAction.run{
                    player.openMenu(plugin.adminGUI)
                })
            }

            builder.open(player)

        })

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
            .addLine(Component.text(" "))
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴛʜᴇ ᴛɪᴍᴇʀ".toComponent()).build(), false)
    }
}