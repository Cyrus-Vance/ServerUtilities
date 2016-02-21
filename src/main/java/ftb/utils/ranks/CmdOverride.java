package ftb.utils.ranks;

import ftb.lib.FTBLib;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

/**
 * Created by LatvianModder on 21.02.2016.
 */
public class CmdOverride implements ICommand
{
	public final ICommand parent;
	
	public CmdOverride(ICommand c)
	{
		parent = c;
	}
	
	public String getCommandName()
	{
		return parent.getCommandName();
	}
	
	public String getCommandUsage(ICommandSender p_71518_1_)
	{
		return parent.getCommandName();
	}
	
	public List getCommandAliases()
	{
		return parent.getCommandAliases();
	}
	
	public void processCommand(ICommandSender ics, String[] args)
	{
		parent.processCommand(ics, args);
	}
	
	public boolean canCommandSenderUseCommand(ICommandSender ics)
	{
		FTBLib.dev_logger.info("FTBU: Checking permission for " + parent.getCommandName());
		if(ics instanceof EntityPlayerMP)
		{
			Rank r = Ranks.instance().getRankOf(((EntityPlayerMP) ics).getGameProfile());
			return r.allowCommand(parent, ics);
		}
		
		return parent.canCommandSenderUseCommand(ics);
	}
	
	public List addTabCompletionOptions(ICommandSender ics, String[] args)
	{
		return parent.addTabCompletionOptions(ics, args);
	}
	
	public boolean isUsernameIndex(String[] args, int i)
	{
		return parent.isUsernameIndex(args, i);
	}
	
	public int compareTo(Object o)
	{
		return parent.compareTo(o);
	}
}
