package electricsteve.moddownloader.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

// Make a screen basic screen for now
@Environment(EnvType.CLIENT)
public class DownloadScreen extends Screen {
    // Variables
    private final Screen lastScreen;
    private final Options options;

    public DownloadScreen(Screen screen, Options options) {
        super(Component.translatable("downloadscreen.moddownloader.title"));
        this.lastScreen = screen;
        this.options = options;
    }

    protected void  init() {

    }
}
