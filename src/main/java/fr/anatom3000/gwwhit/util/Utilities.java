package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.commandline.ModUpdater;
import net.minecraft.client.gui.screen.ConfirmChatLinkScreen;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

/**
 * DONT USE ANY MC/MOD/MC-RELATED LIB CLASSES HERE
 * safe to use class outside of mc
 * @author ENDERZOMBI102
 */
public final class Utilities {
    public static InputStream getResource(@NotNull String name) {
        return Utilities.class.getResourceAsStream(name);
    }

    /**
     * Given a resource name/path, returns its URL (includes path to jar file)
     * @param name resource to search
     */
    public static URL getResourceURL(@NotNull String name) {
        return Utilities.class.getResource(name);
    }

    /**
     * Checks if an array contains a value
     * @param array array to check
     * @param object obj to search for
     * @return true if found
     */
    public static <T> boolean contains(T[] array, @NotNull T object) {
        if (array == null)
            return false;
        for (T value : array) {
            if ( object.equals(value) )
                return true;
        }
        return false;
    }

    /**
     * Returns the location of the GWWHIT jar
     * @return the path of the jar
     */
    @SuppressWarnings("ConstantConditions")
    public static Path getJarLocation() {
        return Path.of( SafeUtils.doSafely( () -> ModUpdater.class.getProtectionDomain().getCodeSource().getLocation().toURI() ) );
    }
}
