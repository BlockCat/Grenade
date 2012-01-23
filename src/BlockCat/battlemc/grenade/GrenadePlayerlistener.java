package BlockCat.battlemc.grenade;

import net.minecraft.server.Block;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;



public class GrenadePlayerlistener extends PlayerListener{


	
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		World world = player.getWorld();
		double speedFactor = 1.5;
		Location handLocation = player.getLocation();
		handLocation.setY(handLocation.getY() + 1);
		
		Vector direction = handLocation.getDirection();
		
		Entity entity = null;
		if(player.hasPermission("grenade.throw") && event.getMaterial() == Material.TNT && event.getAction() == Action.LEFT_CLICK_AIR){
			entity = world.spawn(handLocation, TNTPrimed.class);
            entity.setVelocity(direction.multiply(speedFactor));
            player.getInventory().removeItem(new ItemStack(Material.TNT , 1 ));
            


            
            //((TNTPrimed) entity).setFuseTicks(plugin.getCannon(player).getFuse());
		}
		
	 }
}
