package si.um.feri.zzz.sonda2022.ecs.system.passive;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;

import si.um.feri.zzz.sonda2022.config.GameConfig;

public class StartUpSystem extends EntitySystem {
    private EntityFactorySystem factory;

    public StartUpSystem() {
        setProcessing(false);
    }

    @Override
    public void addedToEngine(Engine engine) {
        factory = engine.getSystem(EntityFactorySystem.class);
        onStartUp();
    }

    private void onStartUp() {
        factory.createPlayer(GameConfig.GAME_WIDTH / 2f, GameConfig.GAME_HEIGHT / 2f, 0);
    }
}
