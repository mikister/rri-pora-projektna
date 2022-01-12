package si.um.feri.zzz.sonda2022.ecs.system.passive;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import si.um.feri.zzz.sonda2022.assets.AssetDescriptors;
import si.um.feri.zzz.sonda2022.assets.RegionNames;
import si.um.feri.zzz.sonda2022.config.GameConfig;
import si.um.feri.zzz.sonda2022.ecs.component.BoundsComponent;
import si.um.feri.zzz.sonda2022.ecs.component.DimensionComponent;
import si.um.feri.zzz.sonda2022.ecs.component.MovementComponent;
import si.um.feri.zzz.sonda2022.ecs.component.PositionComponent;
import si.um.feri.zzz.sonda2022.ecs.component.RotationComponent;
import si.um.feri.zzz.sonda2022.ecs.component.SondaComponent;
import si.um.feri.zzz.sonda2022.ecs.component.TextureComponent;
import si.um.feri.zzz.sonda2022.ecs.component.WorldWrapComponent;

public class EntityFactorySystem extends EntitySystem {
    private final AssetManager assetManager;

    private PooledEngine engine;
    private TextureAtlas gameplayAtlas;

    public EntityFactorySystem(AssetManager assetManager) {
        this.assetManager = assetManager;
        setProcessing(false);
        init();
    }

    private void init() {
        gameplayAtlas = assetManager.get(AssetDescriptors.ATLAS_GAME);
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = (PooledEngine) engine;
    }

    public void createPlayer(float x, float y, float z) {
        PositionComponent position = engine.createComponent(PositionComponent.class);
        position.x = x;
        position.y = y;
        position.z = z;
        RotationComponent rotation = engine.createComponent(RotationComponent.class);
        DimensionComponent dimension = engine.createComponent(DimensionComponent.class);
        dimension.width = GameConfig.PLAYER_SCALE;
        dimension.height = GameConfig.PLAYER_SCALE;
        BoundsComponent bounds = engine.createComponent(BoundsComponent.class);
        bounds.rectangle.setPosition(position.x, position.y);
        bounds.rectangle.setSize(dimension.width, dimension.height);
        MovementComponent movement = engine.createComponent(MovementComponent.class);
        WorldWrapComponent worldWrap = engine.createComponent(WorldWrapComponent.class);
        TextureComponent texture = engine.createComponent(TextureComponent.class);
        texture.region = gameplayAtlas.findRegion(RegionNames.SONDA_CLOSED);
        SondaComponent sondaComponent = engine.createComponent(SondaComponent.class);

        Entity entity = engine.createEntity();
        entity.add(position);
        entity.add(rotation);
        entity.add(dimension);
        entity.add(bounds);
        entity.add(movement);
        entity.add(worldWrap);
        entity.add(texture);
        entity.add(sondaComponent);
        engine.addEntity(entity);
    }
}
