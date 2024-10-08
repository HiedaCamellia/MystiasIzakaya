package org.hiedacamellia.mystiasizakaya.registries;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.resources.ResourceLocation;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.event.MIComponent;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerData;

public class MIComponents implements EntityComponentInitializer {


    public static final ComponentKey<MIComponent> PLAYER_DATA =
            ComponentRegistry.getOrCreate(new ResourceLocation(MystiasIzakaya.MODID,"player_data"), MIComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(PLAYER_DATA, (player) -> new MIPlayerData());
    }


}
