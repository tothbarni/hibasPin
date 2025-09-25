package modell;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PinModell {

    private final StringBuilder szamjegyek = new StringBuilder(4);
    private boolean mentve = false;

    public boolean hozzaadSzamjegy(String szoveg) {
        if (szamjegyek.length() < 4) {
            szamjegyek.append(szoveg);
            return true;
        }
        return false;
    }

    public boolean keszVan() {
        return szamjegyek.length() == 4;
    }

    public String pinErtek() {
        return szamjegyek.toString();
    }

    public int[] getGombIndexek() {
        int[] indexek = new int[szamjegyek.length()];
        for (int i = 0; i < szamjegyek.length(); i++) {
            indexek[i] = szamjegyek.charAt(i) - '0';
        }
        return indexek;
    }

    public void alaphelyzetbeAllit() {
        szamjegyek.setLength(0);
        mentve = false;
    }

    public void mentes() throws IOException {
        if (!mentve && keszVan()) {
            Path utvonal = Paths.get("pin.txt");
            Files.write(utvonal, szamjegyek.toString().getBytes(StandardCharsets.UTF_8));
            mentve = true;
        }
    }
}


