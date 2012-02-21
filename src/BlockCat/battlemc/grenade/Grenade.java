package BlockCat.battlemc.grenade;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;

public class Grenade extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	private PluginManager pm;
	public static PermissionHandler permissions;
	private final GrenadePlayerlistener playerListener = new GrenadePlayerlistener();
	
	@Override
	public void onDisable() {
		log.info("{Grenade} disabled.");
		
	}

	@Override
	public void onEnable() {
		pm = this.getServer().getPluginManager();
		pm.registerEvents(playerListener, this);
		
	}

}
