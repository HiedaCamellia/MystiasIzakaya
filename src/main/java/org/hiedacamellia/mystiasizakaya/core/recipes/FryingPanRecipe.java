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

public class FryingPanRecipe  extends MIRecipe {


	public FryingPanRecipe(ItemStack output,List<Ingredient> recipeItems) {
		super(output, recipeItems);
	}

	@Override
	public RecipeType<?> getType() {
		return MIRecipeType.FRYING_PAN.get();
	}
	@Override
	public RecipeSerializer<?> getSerializer() {
		return MIRecipeType.FRYING_PAN_SERIALIZER.get();
	}

	public static class Serializer implements RecipeSerializer<FryingPanRecipe> {
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
