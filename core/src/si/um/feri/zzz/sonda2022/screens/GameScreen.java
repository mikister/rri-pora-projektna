package si.um.feri.zzz.sonda2022.screens;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import si.um.feri.zzz.sonda2022.SondaGame;
import si.um.feri.zzz.sonda2022.common.GameManager;
import si.um.feri.zzz.sonda2022.config.GameConfig;
import si.um.feri.zzz.sonda2022.ecs.system.passive.EntityFactorySystem;
import si.um.feri.zzz.sonda2022.ecs.system.passive.StartUpSystem;

public class GameScreen extends ScreenAdapter {
    private final AssetManager assetManager;
    private final SpriteBatch batch;
    private final SondaGame game;

    private static final Logger log = new Logger(GameScreen.class.getSimpleName(), Logger.DEBUG);

    private OrthographicCamera camera;
    private Viewport viewport;
    private Viewport hudViewport;
    private PooledEngine engine;

    public GameScreen(SondaGame game) {
        assetManager = game.getAssetManager();
        batch = game.getBatch();
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.GAME_WIDTH, GameConfig.GAME_HEIGHT, camera);
        hudViewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        engine = new PooledEngine();

        // passive systems
        engine.addSystem(new EntityFactorySystem(assetManager));
        engine.addSystem(new StartUpSystem());
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        hudViewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();

        ScreenUtils.clear(Color.BLACK);

        if (GameManager.INSTANCE.isGameOver()) {
            engine.update(0);
        } else {
            engine.update(delta);
        }

        if (GameManager.INSTANCE.isGameOver()) {
            game.setScreen(new MainMenuScreen(game));
        }
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        engine.removeAllEntities();
    }
}
