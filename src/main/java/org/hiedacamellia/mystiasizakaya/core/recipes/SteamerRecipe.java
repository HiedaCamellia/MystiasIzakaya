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

public class SteamerRecipe extends MIRecipe{

	public SteamerRecipe(ItemStack output, List<Ingredient> recipeItems) {
		super(output, recipeItems);
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
