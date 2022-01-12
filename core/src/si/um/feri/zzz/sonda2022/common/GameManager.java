package si.um.feri.zzz.sonda2022.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import si.um.feri.zzz.sonda2022.SondaGame;

public class GameManager {
    public static final GameManager INSTANCE = new GameManager();

    private final Preferences PREFS;

    private GameManager() {
        PREFS = Gdx.app.getPreferences(SondaGame.class.getSimpleName());
    }
}
