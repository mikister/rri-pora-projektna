package si.um.feri.zzz.sonda2022.ecs.system.passive;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import si.um.feri.zzz.sonda2022.assets.AssetDescriptors;

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
}
