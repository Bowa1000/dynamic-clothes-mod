package net.bowa1000.dynamicclothes.item.custom;

import java.security.DrbgParameters.NextBytes;
import java.util.Random;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ClothesItem extends Item implements ICurioItem{
	static final String TAG_COLOR="color";
	static final String TAG_DISPLAY="display";
	static final int DEFAULT_COLOR=0xffffff;
	public ClothesItem(Properties properties){
		super(properties);
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level level,Player player,InteractionHand hand){
		if(!level.isClientSide()&&hand==InteractionHand.MAIN_HAND){
			final int color=RandomSource.createNewThreadLocalInstance().nextInt(0x1000000);
			setColor(getDefaultInstance(),color);
		}
		return super.use(level,player,hand);
	}

	static boolean hasCustomColor(ItemStack stack){
		CompoundTag compoundtag=stack.getTagElement(TAG_DISPLAY);
		return compoundtag!=null&&compoundtag.contains(TAG_COLOR,Tag.TAG_INT);
	}
	static int getColor(ItemStack stack){
		CompoundTag compoundtag=stack.getTagElement(TAG_DISPLAY);
		return compoundtag!=null&&compoundtag.contains(TAG_COLOR,Tag.TAG_INT)?compoundtag.getInt(TAG_COLOR):DEFAULT_COLOR;
	}
	static void clearColor(ItemStack stack){
		CompoundTag compoundtag=stack.getTagElement(TAG_DISPLAY);
		if(compoundtag!=null&&compoundtag.contains(TAG_COLOR))compoundtag.remove(TAG_COLOR);
	}
	static void setColor(ItemStack stack,int color){stack.getOrCreateTagElement(TAG_DISPLAY).putInt(TAG_COLOR,color);}
	public static int getItemColor(ItemStack stack,int layer){return layer==0?getColor(stack):0xffffff;}
}
