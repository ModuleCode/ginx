package server;

import com.modulecode.utils.Global;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GobalTest {
    @Test
    public void testFile() {
        Global.global.reloadGinxConfig();
    }
}
