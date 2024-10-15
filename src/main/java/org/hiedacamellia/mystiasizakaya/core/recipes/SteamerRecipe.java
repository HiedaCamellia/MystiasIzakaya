package org.hiedacamellia.mystiasizakaya.core.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

import java.util.List;

public class SteamerRecipe implements Recipe<MIRecipeInput> {

	private final ItemStack output;
	private final List<Ingredient> recipeItems;

	public SteamerRecipe(ItemStack output, List<Ingredient> recipeItems) {
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
		return MIRecipeType.STEAMER.get();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return MIRecipeType.STEAMER_SERIALIZER.get();
	}


	public static class Serializer implements RecipeSerializer<SteamerRecipe> {
		private static final MapCodec<SteamerRecipe> CODEC = RecordCodecBuilder
				.mapCodec(builder -> builder.group(
						ItemStack.CODEC.fieldOf("output").forGetter(SteamerRecipe::getResult),
						Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(SteamerRecipe::getInputItems)
				).apply(builder, SteamerRecipe::new));
		public static final StreamCodec<RegistryFriendlyByteBuf, SteamerRecipe> STREAM_CODEC =
				StreamCodec.composite(
						ItemStack.STREAM_CODEC, SteamerRecipe::getResult,
						ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), SteamerRecipe::getInputItems,
						SteamerRecipe::new
				);

		@Override
		public MapCodec<SteamerRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, SteamerRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}

}
