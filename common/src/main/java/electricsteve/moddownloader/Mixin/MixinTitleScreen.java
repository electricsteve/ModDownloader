package electricsteve.moddownloader.Mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MixinTitleScreen extends Screen {

    protected MixinTitleScreen(Component component) {
        super(component);
    }

    @Inject(at = @At("HEAD"), method = "init")
    protected void OnInitialization(CallbackInfo ci) {

        int l = this.height / 4 + 48;

        // Add a button to Title Screen that gets the newest version of the mod from Modrinth
        this.addRenderableWidget(Button.builder(Component.translatable("menu.moddownloader.moddownloadergui"), (button) -> {
            electricsteve.moddownloader.GetModrinth.GetFromModrinth.GetNewestVersion("P7dR8mSH");
        }).bounds(this.width / 2 + 104, l + 24 * 2, 40, 20).build());
    }
}
