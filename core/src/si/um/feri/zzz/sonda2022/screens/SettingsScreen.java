package si.um.feri.zzz.sonda2022.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import si.um.feri.zzz.sonda2022.SondaGame;
import si.um.feri.zzz.sonda2022.assets.AssetDescriptors;
import si.um.feri.zzz.sonda2022.config.GameConfig;

public class SettingsScreen extends ScreenAdapter {
    private final AssetManager assetManager;
    private final SpriteBatch batch;
    private final SondaGame game;

    private Viewport viewport;
    private Stage stage;
    private Skin skin;

    public SettingsScreen(SondaGame game) {
        this.game = game;
        assetManager = game.getAssetManager();
        batch = game.getBatch();
    }

    @Override
    public void show() {
        viewport = new FitViewport(GameConfig.UI_WIDTH, GameConfig.UI_HEIGHT);
        stage = new Stage(viewport, game.getBatch());

        skin = assetManager.get(AssetDescriptors.UI_SKIN);

        setupStage();
        Gdx.input.setInputProcessor(stage);
    }

    public void setupStage() {

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLUE);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
    }
}
