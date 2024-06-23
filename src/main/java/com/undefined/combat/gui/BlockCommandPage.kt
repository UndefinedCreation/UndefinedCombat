package com.undefined.combat.gui

import com.undefined.api.builders.ItemBuilder
import com.undefined.api.extension.string.translateColor
import com.undefined.api.menu.MenuManager.openMenu
import com.undefined.api.menu.MenuSize
import com.undefined.api.menu.normal.button.Button
import com.undefined.api.menu.normal.button.ClickData
import com.undefined.api.menu.normal.button.MenuButton
import com.undefined.api.menu.page.UndefinedPageMenu
import com.undefined.api.menu.page.button.PageButton
import com.undefined.api.menu.setRow
import com.undefined.combat.UndefinedCombat
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class BlockCommandPage(val list: List<ItemStack>): UndefinedPageMenu("ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅѕ", MenuSize.LARGE, list) {

    override fun generateInventory(): Inventory = createPageInventory {

        setBackButton(
            PageButton(45, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
                .setName("<reset><#d92323>ʙᴀᴄᴋ ᴀ ᴘᴀɢᴇ".translateColor())
                .addLine(" ")
                .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴀɴ ᴘᴀɢᴇ".translateColor()).build(),
                ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())
        )

        setNextButton(
            PageButton(53, ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
                .setName("<reset><#32e67d>ɴᴇxᴛ ᴘᴀɢᴇ".translateColor())
                .addLine(" ")
                .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ᴛᴏ ᴛʜᴇ ɴᴇxᴛ ᴘᴀɢᴇ".translateColor()).build(), ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())
        )

        setRow(5, ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(50, ItemBuilder(Material.ANVIL)
            .setName("<reset><#9534eb>ᴀᴅᴅ ᴄᴏᴍᴍᴀɴᴅ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴀᴅᴅ ᴀɴ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ".translateColor()).build())

        addButton(Button(50) {

            val builder = AnvilGUI.Builder()
                .itemLeft(ItemBuilder(Material.ANVIL).setName("<reset><#9534eb>ᴄᴏᴍᴍᴀɴᴅ".translateColor()).build())
                .title("ᴀᴅᴅ ᴄᴏᴍᴍᴀɴᴅ")
                .text("ᴄᴏᴍᴍᴀɴᴅ ɴᴀᴍᴇ")
                .plugin(UndefinedCombat.plugin)
            builder.onClick { _, clickEvent ->
                val text = clickEvent.text

                UndefinedCombat.plugin.configManager.blocked.blockedCommands.add(text)
                return@onClick listOf(AnvilGUI.ResponseAction.run{
                    player.openMenu(BlockCommandPage(UndefinedCombat.plugin.configManager.blocked.createItemStackList()))
                })
            }

            builder.open(player)

        })

        setItem(48, ItemBuilder(Material.BARRIER)
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(48, UndefinedCombat.plugin.adminGUI))



    }

    override var clickData: ClickData.() -> Unit = {
        item?.let {
            it.itemMeta?.let {
                if (it.persistentDataContainer.has(UndefinedCombat.nameSpace)) {
                    val s = it.persistentDataContainer.get(UndefinedCombat.nameSpace, PersistentDataType.STRING)
                    UndefinedCombat.plugin.configManager.blocked.blockedCommands.remove(s)
                    player.openMenu(BlockCommandPage(UndefinedCombat.plugin.configManager.blocked.createItemStackList()))
                }
            }
        }
    }
}

