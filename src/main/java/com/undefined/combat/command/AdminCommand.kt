package com.undefined.combat.command

import com.undefined.api.command.UndefinedCommand
import com.undefined.api.menu.MenuManager.openMenu
import com.undefined.combat.UndefinedCombat

class AdminCommand {


    init {

        UndefinedCommand("admincombat", "undefined.combat.admin.command")
            .addExecutePlayer {
                openMenu(UndefinedCombat.plugin.adminGUI)
                return@addExecutePlayer false
            }

    }
}