package si.um.feri.zzz.sonda2022;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;

import si.um.feri.zzz.sonda2022.assets.AssetDescriptors;
import si.um.feri.zzz.sonda2022.screens.MainMenuScreen;

public class SondaGame extends Game {
	private AssetManager assetManager;
	private SpriteBatch batch;

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		assetManager = new AssetManager();
		assetManager.load(AssetDescriptors.FONT);
		assetManager.load(AssetDescriptors.UI_SKIN);
		assetManager.load(AssetDescriptors.ATLAS_GAME);
		assetManager.finishLoading();
		assetManager.getLogger().setLevel(Logger.DEBUG);

		batch = new SpriteBatch();
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		assetManager.dispose();
		batch.dispose();
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public SpriteBatch getBatch() {
		return batch;
	}
}