package icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

public class Icons {
    private static Icon load(String path) {
        return IconLoader.getIcon(path, Icons.class);
    }

    public static final Icon Icon = load("/icons/foo_icon.png");
}
