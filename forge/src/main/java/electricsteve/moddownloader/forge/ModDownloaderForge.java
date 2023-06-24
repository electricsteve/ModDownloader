package electricsteve.moddownloader.forge;

import dev.architectury.platform.forge.EventBuses;
import electricsteve.moddownloader.ModDownloader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModDownloader.MOD_ID)
public class ModDownloaderForge {
    public ModDownloaderForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ModDownloader.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ModDownloader.init();
    }
}