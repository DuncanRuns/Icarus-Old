package me.duncanruns.icarusold;

import com.sun.javafx.geom.Vec3d;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class GivePlayerWingsEvent {

    public static final GivePlayerWingsEvent instance = new GivePlayerWingsEvent();

    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent entityJoinWorldEvent) {
        Entity entity = entityJoinWorldEvent.entity;

        if (entity instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) entity;
            if(player.getStatFile().readStat(StatList.minutesPlayedStat) == 0){
                ItemStack wings = new ItemStack(Item.getByNameOrId("backlytra:elytra"),1);
                NBTTagCompound tag1 = new NBTTagCompound();
                tag1.setInteger("Unbreakable",1);
                wings.setTagCompound(tag1);

                ItemStack bow = new ItemStack(Item.getByNameOrId("minecraft:bow"),1);
                bow.addEnchantment(Enchantment.punch,2);
                bow.getTagCompound().setInteger("Unbreakable",1);

                ItemStack arrow1 = new ItemStack(Item.getByNameOrId("minecraft:arrow"),64);
                ItemStack arrow2 = new ItemStack(Item.getByNameOrId("minecraft:arrow"),64);

                player.setCurrentItemOrArmor(3,wings);
                player.replaceItemInInventory(0,bow);
                player.replaceItemInInventory(1,arrow1);
                player.replaceItemInInventory(2,arrow2);
            }
        }
    }
}
