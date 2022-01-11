package si.um.feri.zzz.sonda2022.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetDescriptors {
    public static final AssetDescriptor<BitmapFont> FONT = new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT,
            BitmapFont.class);

    public static final AssetDescriptor<Skin> UI_SKIN = new AssetDescriptor<Skin>(AssetPaths.UI_SKIN, Skin.class);

    private AssetDescriptors() {
    }
}
