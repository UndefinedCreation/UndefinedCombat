package com.redmagic.undefinedcombat.command

import com.redmagic.undefinedapi.command.CommandTabUtil
import com.redmagic.undefinedapi.command.CommandType
import com.redmagic.undefinedapi.command.UndefinedCommand
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedcombat.UndefinedCombat
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AdminCommand: UndefinedCommand("admincombat", permission = "undefined.combat.admin.command", commandType = CommandType.PLAYER) {
    override fun execute(sender: CommandSender, args: Array<out String>) {
        val player = sender as Player?: return
        player.openMenu(UndefinedCombat.plugin.adminGUI)
    }

    override fun tabComplete(sender: CommandSender, args: Array<out String>): CommandTabUtil = CommandTabUtil(listOf(), 0)
}