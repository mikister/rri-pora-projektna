package si.um.feri.zzz.sonda2022.ecs.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

public class SondaComponent implements Component, Poolable {
    public boolean isHatchOpen;

    @Override
    public void reset() {
        isHatchOpen = false;
    }
}
