package dev.hybridbridging;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Raycaster {
    private static final double REACH = 6.0d;
    private static final double CROSSHAIR_DISTANCE = 4.5d;

    private Raycaster() {
    }

    public static BlockHitResult raycast(PlayerEntity player, World world, double reach) {
        if (player == null || world == null) {
            return null;
        }
        Vec3d start = player.getCameraPosVec(1.0f);
        Vec3d end = start.add(player.getRotationVector().multiply(reach));
        HitResult hit = world.raycast(new RaycastContext(start, end, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player));
        if (hit.getType() == HitResult.Type.BLOCK) {
            return (BlockHitResult) hit;
        }
        return null;
    }

    public static BlockHitResult tryFallbackPlacement(
            PlayerEntity player,
            World world,
            BlockPos origin,
            Direction movementDirection,
            boolean preferDiagonal,
            BridgingConfig config
    ) {
        if (player == null || world == null || config == null) {
            return null;
        }

        Vec3d eye = player.getEyePos();
        Vec3d crosshair = eye.add(player.getRotationVector().multiply(CROSSHAIR_DISTANCE));
        List<PlacementCandidate> candidates = new ArrayList<>();

        for (int dx = -config.fallbackSearchRadius; dx <= config.fallbackSearchRadius; dx++) {
            for (int dy = -config.fallbackSearchRadius; dy <= config.fallbackSearchRadius; dy++) {
                for (int dz = -config.fallbackSearchRadius; dz <= config.fallbackSearchRadius; dz++) {
                    BlockPos current = origin.add(dx, dy, dz);
                    BlockState state = world.getBlockState(current);
                    if (state.isAir()) {
                        continue;
                    }
                    for (Direction direction : Direction.values()) {
                        BlockPos offset = current.offset(direction);
                        if (!world.getBlockState(offset).isAir()) {
                            continue;
                        }
                        if (offset.equals(player.getBlockPos())) {
                            continue;
                        }
                        Vec3d candidatePoint = Vec3d.ofBottomCenter(offset);
                        double distance = candidatePoint.distanceTo(crosshair);
                        if (distance > config.placementTolerance + config.fallbackSearchRadius) {
                            continue;
                        }
                        boolean isForward = direction == movementDirection;
                        double score = PlacementLogic.scoreCandidate(
                                direction,
                                movementDirection,
                                isForward,
                                preferDiagonal,
                                candidatePoint,
                                eye,
                                config.placementTolerance
                        );
                        candidates.add(new PlacementCandidate(offset, direction, score));
                    }
                }
            }
        }

        candidates.sort(Comparator.comparingDouble(PlacementCandidate::score).reversed());
        for (PlacementCandidate candidate : candidates) {
            BlockPos placePos = candidate.pos();
            if (world.getBlockState(placePos).isAir() && !placePos.equals(player.getBlockPos())) {
                return new BlockHitResult(Vec3d.ofCenter(placePos), candidate.direction(), placePos, false);
            }
        }
        return null;
    }

    public static double reach() {
        return REACH;
    }

    private record PlacementCandidate(BlockPos pos, Direction direction, double score) {
    }
}
