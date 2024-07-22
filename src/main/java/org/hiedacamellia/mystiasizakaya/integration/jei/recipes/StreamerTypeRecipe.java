package org.hiedacamellia.mystiasizakaya.integration.jei.recipes;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class StreamerTypeRecipe implements Recipe<RecipeInput> {

	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;

	public StreamerTypeRecipe(ItemStack output, NonNullList<Ingredient> recipeItems) {
		this.output = output;
		this.recipeItems = recipeItems;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
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

	public static class Type implements RecipeType<StreamerTypeRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "streamer_type";
	}

	public static class Serializer implements RecipeSerializer<StreamerTypeRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		private static final MapCodec<StreamerTypeRecipe> CODEC = RecordCodecBuilder
				.mapCodec(builder -> builder.group(ItemStack.STRICT_CODEC.fieldOf("output").forGetter(recipe -> recipe.output), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap(ingredients -> {
					Ingredient[] aingredient = ingredients.toArray(Ingredient[]::new); // Skip the empty check and create the array.
					if (aingredient.length == 0) {
						return DataResult.error(() -> "No ingredients found in custom recipe");
					} else {
						return DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
					}
				}, DataResult::success).forGetter(recipe -> recipe.recipeItems)).apply(builder, StreamerTypeRecipe::new));
		public static final StreamCodec<RegistryFriendlyByteBuf, StreamerTypeRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

		@Override
		public MapCodec<StreamerTypeRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, StreamerTypeRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static StreamerTypeRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readVarInt(), Ingredient.EMPTY);
			inputs.replaceAll(ingredients -> Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
			return new StreamerTypeRecipe(ItemStack.STREAM_CODEC.decode(buf), inputs);
		}

		private static void toNetwork(RegistryFriendlyByteBuf buf, StreamerTypeRecipe recipe) {
			buf.writeVarInt(recipe.getIngredients().size());
			for (Ingredient ing : recipe.getIngredients()) {
				Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ing);
			}
			ItemStack.STREAM_CODEC.encode(buf, recipe.getResultItem(null));
		}
	}

}
