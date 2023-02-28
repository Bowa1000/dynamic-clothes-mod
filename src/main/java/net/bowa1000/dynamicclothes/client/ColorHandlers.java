package net.bowa1000.dynamicclothes.client;

import net.bowa1000.dynamicclothes.item.ModItems;
import net.bowa1000.dynamicclothes.item.custom.ClothesItem;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

public class ColorHandlers{
	public static void registerItemColor(RegisterColorHandlersEvent.Item event){
		event.register(ClothesItem::getItemColor,ModItems.CLOTHES.get());
	}
}
