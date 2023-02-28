package net.bowa1000.dynamicclothes;

import net.bowa1000.dynamicclothes.client.ColorHandlers;
import net.bowa1000.dynamicclothes.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.SlotTypeMessage;

@Mod(DynamicClothes.MOD_ID)
public class DynamicClothes{
	public static final String MOD_ID="dynamicclothes";
	public DynamicClothes(){
		IEventBus modEventBus=FMLJavaModLoadingContext.get().getModEventBus();
		ModItems.register(modEventBus);
		modEventBus.addListener(this::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ColorHandlers::registerItemColor);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		MinecraftForge.EVENT_BUS.register(this);
	}
	private void commonSetup(final FMLCommonSetupEvent event){
	}
	private void enqueueIMC(final InterModEnqueueEvent event){
		final SlotTypeMessage.Builder slotType=new SlotTypeMessage.Builder("clothes");
		// final SlotTypeMessage.Builder slotType=new SlotTypeMessage.Builder("body");
		slotType.icon(new ResourceLocation(MOD_ID,"gui/clothes"));
		// slotType.cosmetic();
		InterModComms.sendTo("curios",SlotTypeMessage.REGISTER_TYPE,slotType::build);
	}
}
