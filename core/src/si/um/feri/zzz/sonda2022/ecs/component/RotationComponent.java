package si.um.feri.zzz.sonda2022.ecs.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

public class RotationComponent implements Component, Poolable {
    public float roll; // around x axis
    public float pitch; // around y axis
    public float yaw; // around z axis

    @Override
    public void reset() {
        roll = 0;
        pitch = 0;
        yaw = 0;
    }
}
