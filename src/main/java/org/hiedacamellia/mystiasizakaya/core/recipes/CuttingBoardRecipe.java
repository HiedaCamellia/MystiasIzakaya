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

public class CuttingBoardRecipe  extends MIRecipe {


	public CuttingBoardRecipe(ItemStack output, List<Ingredient> recipeItems) {
		super(output, recipeItems);
	}

	@Override
	public RecipeType<?> getType() {
		return MIRecipeType.CUTTING_BOARD.get();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return MIRecipeType.CUTTING_BOARD_SERIALIZER.get();
	}


	public static class Serializer implements RecipeSerializer<CuttingBoardRecipe> {
		private static final MapCodec<CuttingBoardRecipe> CODEC = RecordCodecBuilder
				.mapCodec(builder -> builder.group(
						ItemStack.CODEC.fieldOf("output").forGetter(CuttingBoardRecipe::getResult),
						Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(CuttingBoardRecipe::getInputItems)
				).apply(builder, CuttingBoardRecipe::new));
		public static final StreamCodec<RegistryFriendlyByteBuf, CuttingBoardRecipe> STREAM_CODEC =
				StreamCodec.composite(
						ItemStack.STREAM_CODEC, CuttingBoardRecipe::getResult,
						ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), CuttingBoardRecipe::getInputItems,
						CuttingBoardRecipe::new
				);

		@Override
		public MapCodec<CuttingBoardRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, CuttingBoardRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}

}
