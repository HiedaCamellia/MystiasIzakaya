package org.hiedacamellia.mystiasizakaya.core.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIIngredient;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITags;
import org.hiedacamellia.mystiasizakaya.core.cooking.get.GetTagFromItemStacks;
import org.hiedacamellia.mystiasizakaya.registries.MIDatacomponet;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

import java.util.*;

import static org.hiedacamellia.mystiasizakaya.core.cooking.BuildTags.getStrings;

public class BoilingPotRecipe implements Recipe<MIRecipeInput> {

	private final ItemStack output;
	private final List<Ingredient> recipeItems;

	public BoilingPotRecipe(ItemStack output, List<Ingredient> recipeItems) {
		this.output = output;
		this.recipeItems = recipeItems;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return NonNullList.copyOf(recipeItems);
	}

	public List<Ingredient> getInputItems() {
		return recipeItems;
	}
	public ItemStack getResult() {
		return output;
	}
	@Override
	public boolean matches(MIRecipeInput recipeInput, Level level) {
		for(Ingredient ingredient : recipeItems){
			if(ingredient.isEmpty()||ingredient==Ingredient.EMPTY)
				continue;
			boolean a=false;
			for(ItemStack itemStack :recipeInput.stack()){
				if(ingredient.test(itemStack)){
					a=true;
					break;
				}
			}
			if(!a){
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack assemble(MIRecipeInput recipeInput, HolderLookup.Provider provider) {
		return output.copy();
	}


	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider provider) {
		return output.copy();
	}

	@Override
	public RecipeType<?> getType() {
		return MIRecipeType.BOILING_POT.get();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return MIRecipeType.BOILING_POT_SERIALIZER.get();
	}

	public static class Serializer implements RecipeSerializer<BoilingPotRecipe> {
		private static final MapCodec<BoilingPotRecipe> CODEC = RecordCodecBuilder
				.mapCodec(builder -> builder.group(
						ItemStack.CODEC.fieldOf("output").forGetter(BoilingPotRecipe::getResult),
						Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(BoilingPotRecipe::getInputItems)
				).apply(builder, BoilingPotRecipe::new));
		public static final StreamCodec<RegistryFriendlyByteBuf, BoilingPotRecipe> STREAM_CODEC =
				StreamCodec.composite(
						ItemStack.STREAM_CODEC, BoilingPotRecipe::getResult,
						ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), BoilingPotRecipe::getInputItems,
						BoilingPotRecipe::new
				);

		@Override
		public MapCodec<BoilingPotRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, BoilingPotRecipe> streamCodec() {
			return STREAM_CODEC;
		}

	}

}
