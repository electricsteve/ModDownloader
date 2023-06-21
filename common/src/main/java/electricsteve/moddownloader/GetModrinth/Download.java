package electricsteve.moddownloader.GetModrinth;

import electricsteve.moddownloader.ModDownloader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Download {
        public static void DownloadToModsFolder() {
            try {
                URL downloadurl = new URL("TEST");
                File modfile = new File("TEST");

                // Copy bytes from the URL to the destination file.
                FileUtils.copyURLToFile(downloadurl, modfile);
            } catch (IOException e) {
                e.printStackTrace();
                ModDownloader.LOGGER.error("Failed To Download File");
            }
        }
}
