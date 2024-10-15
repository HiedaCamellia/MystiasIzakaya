package org.hiedacamellia.mystiasizakaya.core.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import org.hiedacamellia.mystiasizakaya.registries.MIRecipeType;

import java.util.List;

public class GrillRecipe  extends MIRecipe {

	public GrillRecipe(ItemStack output, List<Ingredient> recipeItems) {
		super(output, recipeItems);
	}

	@Override
	public RecipeType<?> getType() {
		return MIRecipeType.GRILL.get();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return MIRecipeType.GRILL_SERIALIZER.get();
	}


	public static class Serializer implements RecipeSerializer<GrillRecipe> {
		private static final MapCodec<GrillRecipe> CODEC = RecordCodecBuilder
				.mapCodec(builder -> builder.group(
						ItemStack.CODEC.fieldOf("output").forGetter(GrillRecipe::getResult),
						Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(GrillRecipe::getInputItems)
				).apply(builder, GrillRecipe::new));
		public static final StreamCodec<RegistryFriendlyByteBuf, GrillRecipe> STREAM_CODEC =
				StreamCodec.composite(
						ItemStack.STREAM_CODEC, GrillRecipe::getResult,
						ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), GrillRecipe::getInputItems,
						GrillRecipe::new
				);

		@Override
		public MapCodec<GrillRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, GrillRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}

}
