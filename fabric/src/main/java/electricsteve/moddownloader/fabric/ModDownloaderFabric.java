package electricsteve.moddownloader.fabric;

import electricsteve.moddownloader.ModDownloader;
import net.fabricmc.api.ModInitializer;

public class ModDownloaderFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ModDownloader.init();
    }
}