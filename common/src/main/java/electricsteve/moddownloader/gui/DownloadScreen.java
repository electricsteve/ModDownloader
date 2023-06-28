package electricsteve.moddownloader.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Options;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
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

        int l = this.height / 4 + 48;

        // Add a button to Title Screen that gets the newest version of the mod from Modrinth
        this.addRenderableWidget(Button.builder(Component.translatable("downloadscreen.moddownloader.getLatest"), (button) -> {
            electricsteve.moddownloader.GetModrinth.GetFromModrinth.GetNewestVersion("P7dR8mSH"); // Get the latest version of the mod from Modrinth
        }).bounds(this.width / 2 + 104, l + 24 * 2, 40, 20).build());
    }

    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        this.renderBackground(guiGraphics);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 15, 16777215);
        super.render(guiGraphics, i, j, f);
    }
}
