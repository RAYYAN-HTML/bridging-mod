package dev.hybridbridging;

import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlacementLogicTest {
    @Test
    void prefersUpwardPlacement() {
        Vec3d hit = new Vec3d(0.0d, 64.0d, 0.0d);
        Vec3d eye = new Vec3d(0.0d, 65.0d, 0.0d);

        double upScore = PlacementLogic.scoreCandidate(Direction.UP, Direction.NORTH, false, false, hit, eye, 0.25d);
        double northScore = PlacementLogic.scoreCandidate(Direction.NORTH, Direction.NORTH, true, false, hit, eye, 0.25d);

        assertTrue(upScore > northScore);
    }

    @Test
    void diagonalBiasIncreasesScore() {
        Vec3d hit = new Vec3d(1.0d, 64.0d, 1.0d);
        Vec3d eye = new Vec3d(0.0d, 65.0d, 0.0d);

        double withDiagonal = PlacementLogic.scoreCandidate(Direction.EAST, Direction.NORTH, false, true, hit, eye, 0.25d);
        double withoutDiagonal = PlacementLogic.scoreCandidate(Direction.EAST, Direction.NORTH, false, false, hit, eye, 0.25d);

        assertTrue(withDiagonal > withoutDiagonal);
    }
}
