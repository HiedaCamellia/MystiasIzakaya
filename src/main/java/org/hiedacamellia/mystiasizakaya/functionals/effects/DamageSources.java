package org.hiedacamellia.mystiasizakaya.functionals.effects;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.damagesource.DamageSource;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DamageSources {
    public static final DamageSource CHILI = (new DamageSource("chili"));
}
