package com.undefined.combat.manager

import com.undefined.api.extension.string.toComponent
import com.undefined.api.extension.string.translateColor
import com.undefined.api.scheduler.repeatingTask
import com.undefined.combat.UndefinedCombat
import com.undefined.combat.customEvents.PlayerTagEvent
import com.undefined.combat.customEvents.PlayerUntagEvent
import com.undefined.combat.extensions.sendActionbarCombat
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.entity.Player
import java.util.*
import kotlin.collections.HashMap

val tagMap: HashMap<UUID, Int> = HashMap()
val bossBarMap: HashMap<UUID, BossBar> = HashMap()

fun Player.tag(time: Int) = startTagCounter(this, time)


fun Player.untag(){
    tagMap[this.uniqueId] = 0
}

fun Player.isTagged() = tagMap.containsKey(uniqueId)

fun Player.getTaggedTime(): String = if (isTagged()) tagMap[uniqueId].toString() else "Not tagged"


fun startTagCounter(player: Player, time: Int){


    if (player.hasPermission("undefined.combat.bypass") && UndefinedCombat.plugin.configManager.settings.bypass)
        return

    if (player.isTagged()){
        tagMap[player.uniqueId] = time
        return
    }

    val event = PlayerTagEvent(player)
    Bukkit.getPluginManager().callEvent(event)
    if (event.isCancelled) return

    if (UndefinedCombat.plugin.configManager.settings.bossbar){
        if (!bossBarMap.containsKey(player.uniqueId)){
            val bossBar = Bukkit.createBossBar("${ChatColor.of("#d92323")}ʏᴏᴜ ᴀʀᴇ ɪɴ ᴄᴏᴍʙᴀᴛ ꜰᴏʀ $time ᴍᴏʀᴇ ѕᴇᴄᴏɴᴅѕ", BarColor.RED, BarStyle.SOLID)
            bossBarMap[player.uniqueId] = bossBar
            bossBar.addPlayer(player)
        }
    }



    tagMap[player.uniqueId] = time

    repeatingTask(20) {

        if (!player.isTagged()){
            cancel()
            return@repeatingTask
        }

        var timeLeft = tagMap[player.uniqueId]!!


        timeLeft -= 1

        if (timeLeft <= 0){
            tagMap.remove(player.uniqueId)
            cancel()
            Bukkit.getPluginManager().callEvent(PlayerUntagEvent(player))

        }else{
            tagMap[player.uniqueId] = timeLeft
        }



        updateMessages(player, timeLeft)
    }
}

fun updateMessages(player: Player, time: Int){

    player.sendActionbarCombat("<reset><#d92323>ʏᴏᴜ ᴀʀᴇ ɪɴ ᴄᴏᴍʙᴀᴛ ꜰᴏʀ $time ᴍᴏʀᴇ ѕᴇᴄᴏɴᴅѕ".translateColor())

    if (bossBarMap.containsKey(player.uniqueId)){

        val bossBar = bossBarMap[player.uniqueId]!!

        if (time > 0) {
            bossBar.setTitle("${ChatColor.of("#d92323")}ʏᴏᴜ ᴀʀᴇ ɪɴ ᴄᴏᴍʙᴀᴛ ꜰᴏʀ $time ᴍᴏʀᴇ ѕᴇᴄᴏɴᴅѕ")
            bossBar.progress = time.toDouble() / UndefinedCombat.plugin.configManager.settings.timer.toDouble()

            bossBar.addPlayer(player)
        }else{
            bossBar.removeAll()
            bossBarMap.remove(player.uniqueId)
        }
    }
}