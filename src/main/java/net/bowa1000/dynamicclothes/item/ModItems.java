package net.bowa1000.dynamicclothes.item;

import net.bowa1000.dynamicclothes.DynamicClothes;
import net.bowa1000.dynamicclothes.item.custom.ClothesItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class ModItems{
	ModItems(){}
	public static final DeferredRegister<Item> ITEMS=DeferredRegister.create(ForgeRegistries.ITEMS,DynamicClothes.MOD_ID);
	public static final RegistryObject<Item> CLOTHES=ITEMS.register("clothes",()->new ClothesItem(new Item.Properties()
		.tab(CreativeModeTab.TAB_MISC)
		.stacksTo(16)
	));
	public static void register(IEventBus eventBus){
		ITEMS.register(eventBus);
	}
}
