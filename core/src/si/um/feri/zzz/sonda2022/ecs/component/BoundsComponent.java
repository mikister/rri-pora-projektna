package si.um.feri.zzz.sonda2022.ecs.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool.Poolable;

public class BoundsComponent implements Component, Poolable {
    public final Rectangle rectangle = new Rectangle(0, 0, 1, 1);

    @Override
    public void reset() {
        rectangle.setPosition(0, 0);
        rectangle.setSize(1, 1);
    }
}
