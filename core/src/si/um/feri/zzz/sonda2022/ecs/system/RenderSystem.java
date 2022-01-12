package si.um.feri.zzz.sonda2022.ecs.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

import si.um.feri.zzz.sonda2022.common.Mappers;
import si.um.feri.zzz.sonda2022.ecs.comparators.ZOrderComparator;
import si.um.feri.zzz.sonda2022.ecs.component.DimensionComponent;
import si.um.feri.zzz.sonda2022.ecs.component.PositionComponent;
import si.um.feri.zzz.sonda2022.ecs.component.RotationComponent;
import si.um.feri.zzz.sonda2022.ecs.component.TextureComponent;

public class RenderSystem extends SortedIteratingSystem {
    private static final Family FAMILY = Family.all(
            PositionComponent.class,
            RotationComponent.class,
            DimensionComponent.class,
            TextureComponent.class).get();

    private final SpriteBatch batch;
    private final Viewport viewport;

    public RenderSystem(SpriteBatch batch, Viewport viewport) {
        super(FAMILY, ZOrderComparator.INSTANCE);
        this.batch = batch;
        this.viewport = viewport;
    }

    @Override
    public void update(float deltaTime) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        super.update(deltaTime);
        batch.end();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = Mappers.POSITION.get(entity);
        RotationComponent rotation = Mappers.ROTATION.get(entity);
        DimensionComponent dimension = Mappers.DIMENSION.get(entity);
        TextureComponent texture = Mappers.TEXTURE.get(entity);

        batch.draw(texture.region,
                position.x, position.y,
                dimension.width / 2, dimension.height / 2,
                dimension.width, dimension.height,
                1, 1,
                rotation.yaw);
    }
}
