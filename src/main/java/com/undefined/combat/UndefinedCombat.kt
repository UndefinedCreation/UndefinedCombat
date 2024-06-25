package com.undefined.combat

import com.undefined.api.UndefinedAPI

import com.undefined.combat.command.AdminCommand
import com.undefined.combat.data.ConfigManager
import com.undefined.combat.events.BypassListener
import com.undefined.combat.events.DeathListener
import com.undefined.combat.events.HitListener
import com.undefined.combat.events.PlayerQuitListener
import com.undefined.combat.events.blocks.BlockedCommands
import com.undefined.combat.events.blocks.ElytraListener
import com.undefined.combat.events.blocks.EnderPearlsListener
import com.undefined.combat.events.blocks.RipTideListener
import com.undefined.combat.gui.AdminGUI
import com.undefined.combat.placeholders.TimeLeft
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class UndefinedCombat : JavaPlugin() {

    companion object{
        lateinit var plugin: UndefinedCombat
        lateinit var nameSpace: NamespacedKey
    }

    lateinit var configManager: ConfigManager

    lateinit var adminGUI: AdminGUI
    lateinit var undefinedConfig: FileConfiguration

    private lateinit var configFile: File

    override fun onLoad() {
        Bukkit.getLogger().info("Loading UndefinedCombat")
    }

    override fun onEnable() {
        // Plugin startup logic
        UndefinedAPI(this)

        configFile = File(this.dataFolder, "config.yml")
        if (!configFile.exists()){
            configFile.parentFile.mkdir()
            saveResource("config.yml", false)
        }
        undefinedConfig = YamlConfiguration.loadConfiguration(configFile)

        plugin = this

        nameSpace = NamespacedKey(this, "blocked")

        configManager = ConfigManager(this)

        adminGUI = AdminGUI()

        events()
        command()

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            Bukkit.getLogger().info("Placeholder has been registered!")
            TimeLeft().register()
        }

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
        BlockedCommands()

    }

    private fun command(){
        AdminCommand()
    }

    fun saveConfigFile(){
        undefinedConfig.save(configFile)
    }
}
