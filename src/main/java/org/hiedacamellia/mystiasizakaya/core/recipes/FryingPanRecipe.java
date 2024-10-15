package org.hiedacamellia.mystiasizakaya.core.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
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

import java.util.List;

public class FryingPanRecipe implements Recipe<RecipeInput> {

	private final ItemStack output;
	private final List<Ingredient> recipeItems;

	public FryingPanRecipe(ItemStack output,List<Ingredient> recipeItems) {
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
	public boolean matches(RecipeInput recipeInput, Level level) {
		return false;
	}

	@Override
	public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
		return null;
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
		return Type.INSTANCE;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	public static class Type implements RecipeType<FryingPanRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "frying_pan_type";
	}

	public static class Serializer implements RecipeSerializer<FryingPanRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		private static final MapCodec<FryingPanRecipe> CODEC = RecordCodecBuilder
				.mapCodec(builder -> builder.group(
						ItemStack.CODEC.fieldOf("output").forGetter(FryingPanRecipe::getResult),
						Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(FryingPanRecipe::getInputItems)
				).apply(builder, FryingPanRecipe::new));
		public static final StreamCodec<RegistryFriendlyByteBuf, FryingPanRecipe> STREAM_CODEC =
				StreamCodec.composite(
						ItemStack.STREAM_CODEC, FryingPanRecipe::getResult,
						ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), FryingPanRecipe::getInputItems,
						FryingPanRecipe::new
				);

		@Override
		public MapCodec<FryingPanRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, FryingPanRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}

}
