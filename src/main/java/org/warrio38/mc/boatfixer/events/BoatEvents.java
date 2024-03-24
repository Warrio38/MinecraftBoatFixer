package org.warrio38.mc.boatfixer.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class BoatEvents implements Listener {
    @EventHandler
    public void onVehicleMove(VehicleMoveEvent event){
        Entity vehicle = event.getVehicle();
        boatFixer(vehicle);
    }
    @EventHandler
    public void onBoatPlace(EntityPlaceEvent event){
        Entity entity = event.getEntity();
        boatFixer(entity);
    }
    public void boatFixer(Entity entityBoat){
        if(entityBoat.getType().equals((EntityType.BOAT))){
            List<Entity> entities = entityBoat.getNearbyEntities(32.0,32.0,32.0);
            entities.removeIf(entity -> !entity.getType().equals(EntityType.BOAT));
            if(entities.size() >= 15){
                for(Entity entity : entities){
                    Boat boat = (Boat) entity;
                    if(boat.getPassengers().isEmpty()){
                        Location boatLoc = boat.getLocation();
                        Material boatMaterial = Material.getMaterial(boat.getBoatType().name() + "_BOAT");
                        ItemStack boatItem = new ItemStack(boatMaterial);
                        boatLoc.getWorld().dropItemNaturally(boatLoc,boatItem);
                        boat.remove();
                    }
                }
            }
        }
    }
}
