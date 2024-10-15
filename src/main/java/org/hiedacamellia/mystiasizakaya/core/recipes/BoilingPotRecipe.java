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


public class BoilingPotRecipe extends MIRecipe {

	public BoilingPotRecipe(ItemStack output, List<Ingredient> recipeItems) {
        super(output, recipeItems);
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
