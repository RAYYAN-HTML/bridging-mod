package dev.hybridbridging;

import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public final class PlacementLogic {
    private PlacementLogic() {
    }

    public static double scoreCandidate(
            Direction candidate,
            Direction movementDirection,
            boolean isForwardMovement,
            boolean isDiagonal,
            Vec3d hitVec,
            Vec3d playerPos,
            double tolerance
    ) {
        double score = 0.0d;
        if (candidate == Direction.UP) {
            score += 100.0d;
        }
        if (isForwardMovement && candidate == movementDirection) {
            score += 25.0d;
        }
        if (candidate == Direction.NORTH || candidate == Direction.SOUTH || candidate == Direction.EAST || candidate == Direction.WEST) {
            score += 8.0d;
        }
        if (isDiagonal) {
            score += 6.0d;
        }
        if (candidate.getAxis() == Direction.Axis.Y) {
            score += 2.0d;
        }
        double distanceBias = Math.max(0.0d, 1.0d - hitVec.distanceTo(playerPos) / (tolerance + 1.0d));
        score += distanceBias * 10.0d;
        return score;
    }
}
