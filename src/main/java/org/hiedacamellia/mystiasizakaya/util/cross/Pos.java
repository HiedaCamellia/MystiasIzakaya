package org.hiedacamellia.mystiasizakaya.util.cross;

import net.minecraft.core.BlockPos;

public class Pos {
    public static BlockPos get(double x, double y, double z) {
        return BlockPos.containing(x, y, z);
    }
}
