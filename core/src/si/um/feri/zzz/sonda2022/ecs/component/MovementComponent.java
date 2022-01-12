package si.um.feri.zzz.sonda2022.ecs.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

public class MovementComponent implements Component, Poolable {
    public float xSpeed;
    public float ySpeed;
    public float zSpeed;

    public float rollSpeed;
    public float pitchSpeed;
    public float yawSpeed;

    @Override
    public void reset() {
        xSpeed = 0;
        ySpeed = 0;
        zSpeed = 0;

        rollSpeed = 0;
        pitchSpeed = 0;
        yawSpeed = 0;
    }
}
