package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.confuser.barapi.BarAPI;
import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Someone being a little bitch? Smite them down...", usage = "/<command> [playername] [reason]")
public class Command_smite extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);
        
        if (player == null)
        {
            playerMsg(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        }
        else if (args.length > 1)
        {
            final String reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
            smite(player, reason);
            return true;
        }
        
        else
        {
            smite(player);
            BarAPI.setMessage(sender_p, ChatColor.RED + "" + ChatColor.BOLD + "You forgot the smite reason, don't forget next time!", 120);
            // TFM_Util.playerMsg(sender, "I made smite reasons for a reason, use them please!", ChatColor.RED);
            server.dispatchCommand(sender, "kill " + sender_p);
        }

        return true;
    }

    public static void smite(final Player player, final String reason, final CommandSender sender)
    {
<<<<<<< HEAD
        TFM_Util.bcastMsg(player.getName() + " has been a naughty, naughty boy.\nThey have been punished!", ChatColor.RED);
        final StringBuilder bcast = new StringBuilder()
                .append(ChatColor.LIGHT_PURPLE)
                .append("[Server:")
                .append(sender.getName())
                .append("] ")
                .append(sender.getName())
                .append(", ")
                .append(reason);
=======
        TFM_Util.bcastMsg(String.format("%s has been a naughty, naughty person.\nThey have thus been smitten!\n" ChatColor.RED);
        String full = String.format(ChatColor.RED + "%s They have been punished! %s", player.getName(), reason);
        BarAPI.setMessage((full.length() <= 64 ? full : String.format("%s has been smitten!", player.getName())), 10);
        server.dispatchCommand(sender, "say %s" + sender_p)
>>>>>>> parent of 87a7ca6... Update Command_smite.java
        
        //Deop
        player.setOp(false);

        //Set gamemode to survival:
        player.setGameMode(GameMode.SURVIVAL);

        //Clear inventory:
        player.getInventory().clear();

        //Strike with lightning effect:
        final Location targetPos = player.getLocation();
        final World world = player.getWorld();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
        }

        //Kill:
        player.setHealth(0.0);
    }
    
    public static void smite(final Player player)
    {
        TFM_Util.bcastMsg(player.getName() + " has been a naughty, naughty boy.\nThey have been punished!", ChatColor.RED);
        
        //Deop
        player.setOp(false);

        //Set gamemode to survival:
        player.setGameMode(GameMode.SURVIVAL);

        //Clear inventory:
        player.getInventory().clear();

        //Strike with lightning effect:
        final Location targetPos = player.getLocation();
        final World world = player.getWorld();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
        }

        //Kill:
        player.setHealth(0.0);
    }
}
