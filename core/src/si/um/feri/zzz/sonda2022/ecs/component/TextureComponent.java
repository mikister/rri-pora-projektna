package si.um.feri.zzz.sonda2022.ecs.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool.Poolable;

public class TextureComponent implements Component, Poolable {
    public TextureRegion region;

    @Override
    public void reset() {
        region = null;
    }
}
