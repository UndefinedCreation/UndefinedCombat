package com.redmagic.undefinedcombat

import com.redmagic.undefinedapi.UndefinedAPI
import com.redmagic.undefinedapi.event.event
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
import com.redmagic.undefinedcombat.placeholders.TimeLeft
import me.clip.placeholderapi.PlaceholderAPI
import me.clip.placeholderapi.PlaceholderAPIPlugin
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class UndefinedCombat : JavaPlugin() {

    companion object{
        lateinit var plugin: UndefinedCombat
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

        configManager = ConfigManager(this)

        adminGUI = AdminGUI()

        events()
        command()

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            Bukkit.getLogger().info("PlaceHolder have been registered!")
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

    }

    private fun command(){
        AdminCommand()
    }

    fun saveConfigFile(){
        undefinedConfig.save(configFile)
    }
}
