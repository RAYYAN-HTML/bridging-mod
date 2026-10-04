package dev.hybridbridging;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class BridgingDetection {
    private static final double EDGE_LOOK_DISTANCE = 2.5d;

    private BridgingDetection() {
    }

    public static boolean shouldUseEdgeAssistance(PlayerEntity player, World world, BlockPos feetPos, Direction facing) {
        if (player == null || world == null || feetPos == null || facing == null) {
            return false;
        }
        if (!player.isOnGround() && !player.isSneaking()) {
            return false;
        }

        BlockPos ahead = feetPos.offset(facing);
        if (!world.getBlockState(ahead).isAir()) {
            return false;
        }

        Vec3d eye = player.getEyePos();
        Vec3d lookTarget = eye.add(player.getRotationVector().multiply(4.0d));
        double distanceToGap = lookTarget.distanceTo(Vec3d.ofCenter(ahead));
        return distanceToGap < EDGE_LOOK_DISTANCE;
    }
}
