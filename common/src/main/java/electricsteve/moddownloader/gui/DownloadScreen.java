package electricsteve.moddownloader.gui;

import electricsteve.moddownloader.GetModrinth.GetFromModrinth;
import net.minecraft.client.Options;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;


// Make a screen basic screen for now
public class DownloadScreen extends Screen {
    // Variables
    private final Screen lastScreen;
    private final Options options;
    protected EditBox modrinthID;
    private String modrinthResponse;
    private String dynamicText;

    public DownloadScreen(Screen screen, Options options) {
        super(Component.translatable("downloadscreen.moddownloader.title"));
        this.lastScreen = screen;
        this.options = options;
    }

    public void tick() {
        this.modrinthID.tick();
    }

    protected void  init() {
        // Add a text input box to The Screen
        this.modrinthID = new EditBox(this.font, this.width / 2 - 100, 22, 200, 20, Component.translatable("downloadscreen.moddownloader.modrinthid"));
        this.addWidget(this.modrinthID);

        modrinthResponse = "Nothing Searched Yet";

        // Add a button to The Screen that gets the newest version of the mod from Modrinth
        this.addRenderableWidget(Button.builder(Component.translatable("downloadscreen.moddownloader.getLatest"), (button) -> {
            this.modrinthResponse = GetFromModrinth.GetNewestVersion(this.modrinthID.getValue()); // Get the latest version of the mod from Modrinth
        }).bounds(this.width / 2 + 104, 22, 40, 20).build());
        // Add a Text Box that shows the value of the modrinthResponse variable

    }

    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        this.renderBackground(guiGraphics);

        guiGraphics.drawCenteredString(font, modrinthResponse, this.width / 2 , 50, 0xFFFFFF);

        this.modrinthID.render(guiGraphics, i, j, f);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 8, 16777215);
        super.render(guiGraphics, i, j, f);
    }
}
