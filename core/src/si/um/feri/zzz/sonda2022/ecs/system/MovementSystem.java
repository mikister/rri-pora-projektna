package si.um.feri.zzz.sonda2022.ecs.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

import si.um.feri.zzz.sonda2022.common.Mappers;
import si.um.feri.zzz.sonda2022.ecs.component.MovementComponent;
import si.um.feri.zzz.sonda2022.ecs.component.PositionComponent;
import si.um.feri.zzz.sonda2022.ecs.component.RotationComponent;

public class MovementSystem extends IteratingSystem {
    private static final Family FAMILY = Family.all(
            PositionComponent.class,
            RotationComponent.class,
            MovementComponent.class).get();

    public MovementSystem() {
        super(FAMILY);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = Mappers.POSITION.get(entity);
        RotationComponent rotation = Mappers.ROTATION.get(entity);
        MovementComponent movement = Mappers.MOVEMENT.get(entity);

        position.x += movement.xSpeed;
        position.y += movement.ySpeed;
        position.z += movement.zSpeed;

        rotation.roll += movement.rollSpeed;
        rotation.pitch += movement.pitchSpeed;
        rotation.yaw += movement.yawSpeed;
    }
}
