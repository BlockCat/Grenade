package BlockCat.battlemc.grenade;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;



public class GrenadePlayerlistener implements Listener{


	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		World world = player.getWorld();
		double speedFactor = 1.5;
		Location handLocation = player.getLocation();
		handLocation.setY(handLocation.getY() + 1);

		Vector direction = handLocation.getDirection();

		Entity entity = null;
		boolean perms = player.isOp() || player.hasPermission("grenade.throw");
		if(perms && event.getMaterial() == Material.TNT && event.getAction() == Action.LEFT_CLICK_AIR){
			entity = world.spawn(handLocation, TNTPrimed.class);
			entity.setVelocity(direction.multiply(speedFactor));
			if (player.getGameMode() != GameMode.CREATIVE){
				player.getInventory().removeItem(new ItemStack(Material.TNT , 1 ));
			}
			//((TNTPrimed) entity).setFuseTicks(plugin.getCannon(player).getFuse());
		}		
	}

	@EventHandler
	public void onPlayerCommandPreprocess (PlayerCommandPreprocessEvent event) {

		if (event.getMessage().equalsIgnoreCase("/grenade"))
			throwGrenade(event.getPlayer());
		return;
	}

	public static void throwGrenade(Player player) {
		World world = player.getWorld();
		double speedFactor = 1.5;
		Location handLocation = player.getLocation();
		handLocation.setY(handLocation.getY() + 1);

		Vector direction = handLocation.getDirection();

		Entity entity = null;
		boolean perms = player.isOp() || player.hasPermission("grenade.throw");
		if(perms){
			entity = world.spawn(handLocation, TNTPrimed.class);
			entity.setVelocity(direction.multiply(speedFactor));
		}
	}
}
