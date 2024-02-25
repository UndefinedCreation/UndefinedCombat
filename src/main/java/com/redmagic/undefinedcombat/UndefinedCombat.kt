package com.redmagic.undefinedcombat

import com.redmagic.undefinedapi.UndefinedAPI
import com.redmagic.undefinedcombat.command.AdminCommand
import com.redmagic.undefinedcombat.data.ConfigManager
import com.redmagic.undefinedcombat.events.BypassListener
import com.redmagic.undefinedcombat.events.DeathListener
import com.redmagic.undefinedcombat.events.HitListener
import com.redmagic.undefinedcombat.events.PlayerQuitListener
import com.redmagic.undefinedcombat.events.blocks.ElytraListener
import com.redmagic.undefinedcombat.events.blocks.EnderPearlsListener
import com.redmagic.undefinedcombat.events.blocks.RipTideListener
import com.redmagic.undefinedcombat.gui.AdminGUI
import org.bukkit.Bukkit
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.java.JavaPlugin

class UndefinedCombat : JavaPlugin() {

    companion object{
        lateinit var plugin: UndefinedCombat
    }

    lateinit var configManager: ConfigManager

    lateinit var adminGUI: AdminGUI

    override fun onLoad() {
        Bukkit.getLogger().info("Loading UndefinedCombat")
    }

    override fun onEnable() {
        // Plugin startup logic
        UndefinedAPI(this)

        plugin = this

        configManager = ConfigManager(this)

        adminGUI = AdminGUI()

        events()
        command()
    }

    override fun onDisable() {
        // Plugin shutdown logic

        configManager.save()

    }

    private fun events(){
        HitListener()
        DeathListener()
        BypassListener()
        ElytraListener()
        RipTideListener()
        EnderPearlsListener()
        PlayerQuitListener()

    }

    private fun command(){
        AdminCommand()
    }
}