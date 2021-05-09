package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    public String tytul, adresStrony, adresGrafiki, adresMiniaturki, szerokosc, wysokosc;
    public Infografika(String tekst) {
        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);
        if (m.find()) {
            tytul = m.group(1);
        } else {
            tytul = "";
        }

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(tekst);
        if (m.find()) {
            adresStrony = m.group(1);
        } else {
            adresStrony = "";
        }

        pat = Pattern.compile("<media:content\\surl=\"(.*)\"\\stype");
        m = pat.matcher(tekst);
        if (m.find()) {
            adresGrafiki = m.group(1);
        } else {
            adresGrafiki = "";
        }

        pat = Pattern.compile("<media:thumbnail\\surl=\"(.*)\"");
        m = pat.matcher(tekst);
        if(m.find())
        {
            adresMiniaturki = m.group(1);
        }
        else
        {
            adresMiniaturki = "";
        }

        pat = Pattern.compile("width=\"(.*)\" height");
        m = pat.matcher(tekst);
        if(m.find())
        {
            szerokosc = m.group(1);
        }
        else
        {
            szerokosc = "";
        }

        pat = Pattern.compile("height=\"(.*)\"");
        m = pat.matcher(tekst);
        if(m.find())
        {
            wysokosc = m.group(1);
        }
        else
        {
            wysokosc = "";
        }
    }
    public void print()
    {
        System.out.println("Infografika: \nTytuł: " + tytul + "\nAdres strony: " + adresStrony + "\nAdres grafiki: " + adresGrafiki + "\nAdres miniaturki: " + adresMiniaturki + "\nRozmiary: " + szerokosc + "x" + wysokosc );
    }
}
