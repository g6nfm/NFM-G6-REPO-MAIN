
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DecimalFormat;

public class xtGraphics extends Panel implements Runnable {
    /**
     * 
     */
    private static final long serialVersionUID = -6463312620664057856L;
    /**
     * starting colors for the special screen in the credits
     */
    public int credColors[] = {
            25, 50, 100
    };
    /**
     * test image for the network load feature
     */
    public Image aimLogo;
    
    public Graphics2D rd;
    public Medium m;
    public ImageObserver ob;
    public Applet app;
    public int fase;
    public int oldfase;
    public int starcnt;
    public int unlocked;
    public int lockcnt;
    public int opselect;
    public boolean shaded;
    public int flipo;
    public boolean nextc;
    public int gatey;
    public int looped;
    public int sc[];
    public int invisible;
    public int nplayers;
    /**
     * x position of the cars at theh start of a race
     */
    public int xstart[] = {
            350, -350, 350, -350, 350, -350, 0
    };
    /**
     * z position of the cars at theh start of a race
     */
    public int zstart[] = {
            -1540, -1540, -780, -780, 0, 0, 760
    };
    
    /*
     * hm... it would be interesting if there was a ystart...
     * int ystart[] = {
     *      250, 350, 450, 550, 650, 750, 850
     * };
     */
    
    public float proba[] = {
            0.6F, 0.7F, 0.4F, 0.3F, 0.8F, 0, 0.3F, 0.3F, 0.3F, 0.1F, 0.1F, 0.5F, 0, 0
    };
    public float dishandle[] = {
            0.65F, 0.6F, 0.85F, 0.65F, 0.75F, 0.85F, 0.8F, 0.9F, 0.5F, 0.6F, 0.95F, 0.4F, 0.87F, 0.42F
    };
    public float outdam[] = {
            0.67F, 0.85F, 0.45F, 0.5F, 0.55F, 0.6F, 0.75F, 0.80F, 0.89F, 0.90F, 0.79F, 0.95F, 0.77F, 1.0F
    };
    public boolean holdit;
    public int holdcnt;
    public boolean winner;
    public boolean setnumber;
    public int flexpix[];
    public int smokey[];
    public Image fleximg;
    public int flatrstart;
    public Thread runner;
    public int runtyp;
    public Image carsbg;
    public Image inst1;
    public Image inst2;
    public Image inst4;
    public Image inst6;
    public Image inst8;
    public Image instback;
    public Image kaff;
    public Image odmg;
    public Image overlay;
    public Image overlaystatus;
    public Image hunting;
    public Image opwr;
    public Image opos;
    public Image owas;
    public Image olap;
    public Image oyourwasted;
    public Image oyoulost;
    public Image oyouwon;
    public Image oyouwastedem;
    public Image ogameh;
    public Image oloadingmusic;
    public Image oflaot;
    public Image powerbar;
    public Image damagebar;
    public Image wastedtext;
    public Image postext;
    public Image kph;
    public Image laptext;
    public Image timetext;
    public Image dmg;
    public Image pwr;
    public Image pos;
    public Image was;
    public Image lap;
    public Image landrover;
    public Image br;
    public Image select;
    public Image loadingmusic;
    public Image yourwasted;
    public Image youlost;
    public Image youwon;
    public Image youwastedem;
    public Image gameh;
    public Image congrd;
    public Image gameov;
    public Image carstarter;
    public Image carstreetelites;
    public Image carfuriousfour;
    
    public Image statbostart;
    public Image statbose;
    public Image statboff;
    
    public Image statbstart;
    public Image statbse;
    public Image statbff;
    
    public Image brse;
    public Image pgate;
    public Image statb;
    public Image statbo;
    public Image mdness;
    public Image paused;
    public Image radicalplay;
    public Image logocars;
    public Image logomadnes;
    public Image logomadbg;
    public Image lotus;
    public Image byrd;
    public Image opback;
    public Image nfmcoms;
    public Image opti;
    public Image bgmain;
    public Image splash;
    public Image rpro;
    public Image nfmcom;
    public Image flaot;
    public Image fixhoop;
    public Image sarrow;
    public Image stunts;
    public Image racing;
    public Image wasting;
    public Image plus;
    public Image space;
    public Image arrows;
    public Image chil;
    public Image ory;
    public Image kz;
    public Image kx;
    public Image kv;
    public Image kp;
    public Image km;
    public Image kn;
    public Image kenter;
    public Image nfm;
    public Image trackbg[][];
    public Image toyota;
    public Image dude[];
    public Image dudeb[];
    public int duds;
    public int dudo;
    public Image next[];
    public Image back[];
    public Image nextse;
    public Image backse;
    public Image nextstart;
    public Image backstart;
    public Image contin[];
    public Image ostar[];
    public Image star[];
    public  int pcontin;
    public int pnext;
    public int pback;
    public int pstar;
    public Image orank[];
    public Image rank[];
    public Image ocntdn[];
    public Image cntdn[];
    public int gocnt;
    public AudioClip engs[][];
    public boolean pengs[];
    public int enginsignature[] = {
            0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4
    };
    public AudioClip air[];
    public boolean aird;
    public boolean grrd;
    public AudioClip crash[];
    public AudioClip lowcrash[];
    public AudioClip tires;
    public AudioClip checkpoint;
    public AudioClip carfixed;
    public AudioClip powerup;
    public AudioClip three;
    public AudioClip two;
    public AudioClip one;
    public AudioClip go;
    public AudioClip wastd;
    public AudioClip firewasted;
    public boolean pwastd;
    public AudioClip skid[];
    public AudioClip dustskid[];
    public boolean mutes;
    public RadicalMod mainmenu;
    public RadicalMod cars;
    public RadicalMod stracks[];
    public RadicalMidi mtracks[];
    public boolean isMidi[];
    public boolean loadedt[];
    public int lastload;
    public boolean mutem;
    public boolean sunny;
    public boolean macn;
    public boolean arrace;
    public int ana;
    public int cntan;
    public int cntovn;
    public boolean flk;
    public int tcnt;
    public boolean tflk;
    public String say;
    public String say2;
    public boolean wasay;
    public int clear;
    public int posit;
    public int wasted;
    public int laps;
    public int dested[];
    public String names[] = {
        
            "Solstice", "Venomous", "Explorer", "Posiedon", "Vigero", "Diablo", //STARTER
            
            "Swiftslide", "Razorback", "Vulcan", "Iron Bull",
            
            
             "Amethyst", "Rampage", "Apollo", //BIG 3
            
            "Khaos" //FINAL BOSS
            
             //"Poseidon", "Venomous", "The Wanderer", "Maniac", "Bluebird", "Scorpion", "Zorgaro",
            //"Havoc", "Velocity", "Diesel King", "Slipstream", "Rampage", "Angelus", "Dr. Monstaa"
    };
    
    public String specialty[] = {
        
        
         "", "", "", " ", " ", " ", "[ Street Elites ]", "[ Street Elites ]", "[ Street Elites ]", "[ Leader of the Street Elites ]", "[ Furious Four ]", "[ Furious Four ]", "[ Furious Four ] ", "[ Leader of the Furious Four ]"
        
    };
    
    
    
    
    
    public String creators[] = {
        
        "Reed", "GX", "G6", "GX", "KRC", "Chaotic",
        
        "Tunari", "Reed", "Reed", "Harmless", 
        
        "Harmless", "G6", "ACVoong",
        
        "G6"
        
    };
     
    public int currentRotation = -2;
    public int nameOfNewVariable;
    public int dmcnt;
    public boolean dmflk;
    public int pwcnt;
    public boolean pwflk;
    public String adj[][] = {
            {
                    "Cool", "Okay", "Nice"
            }, {
                    "Crazy", "Gnarly", "Insane"
            }, {
                    "Incredible", "Ripping", "Radical"
            }, {
                    "What do you even call that!?", "You are clinically insane...", "Can I get your autograph?"
            }, {
                    "surf style", "off the lip", "bounce back"
            }
    };
    public String exlm[] = {
            "!", "!!", "!!!"
    };
    public String loop;
    public String spin;
    public String asay;
 
    public int auscnt;
    public boolean aflk;
    public int sndsize[] = {
            106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129, 70, 70, 100, 139, 200, 120, 100, 70
    };
    public Image hello;
    public Image sign;
    public Image loadbar;
    public int kbload;
    public int dnload;
    public float shload;
    public int radpx;
    public int pin;
    public int bgmy[] = {
            0, 500
    };
    public int trkx[] = {
            0, 900
    };
    
    float statrate[] = {
        1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F
    };
    
    public int trkl;
    public int trklim;
    public float hipno[] = {
            1.0F, 1.0F, 3F, 1.0F, 1.2F, 1.0F, 1.7F, 1.0F, 1.0F, 8F, 1.5F, 2.0F, 1.2F, 10F, 1.8F, 1.4F, 2.0F, 2.0F, 2.0F, 2.0F, 2.0F, 2.0F, 2.0F, 2.0F, 2.0F
    };
    
    
    
    public int flkat;
    public int movly;
    public int xdu;
    public int ydu;
    public int gxdu;
    public int gydu;
    public int pgatx[] = {
            146, 175, 215, 267, 334, 401, 452, 493, 521
    };
    public int pgaty[] = {
            168, 188, 201, 212, 219, 214, 203, 189, 171
    };
    
   
    public int pgady[];
    public boolean pgas[];
    public int lxm;
    public int lym;
    public int pwait;
    public int stopcnt;
    public int cntwis;
    public int crshturn;
    public int bfcrash;
    public int bfskid;
    public boolean crashup;
    public boolean skidup;
    public int skflg;
    public int dskflg;
    public int flatr;
    public int flyr;
    public int flyrdest;
    public int flang;
    public int flangados;
    public float blackn;
    public float blacknados;
    
    
   
    /**Filter images
     * @param img Image to filter
     * @param type Integer of what filter to apply
     * 
     * @author Kaffeinated
     */
    public void filterImage(Image img, int type) {
        BufferedImage buff_img = new BufferedImage(img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D rd_sep = buff_img.createGraphics();
        rd_sep.drawImage(img, 0, 0, null);
        rd_sep.dispose();
        // now buff_img = BufferedImage img
        if (type == 0) { //////// grayscale
            BufferedImage gray = new BufferedImage(buff_img.getWidth(), buff_img.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
            op.filter(buff_img, gray);
            rd.drawImage(gray, 0, 0, null);
        }
        if (type == 1) { ///////// sepia tone
            BufferedImage sepia = new BufferedImage(buff_img.getWidth(), buff_img.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            int sepiaDepth = 20;
            int w = buff_img.getWidth();
            int h = buff_img.getHeight();
            int[] pixels = new int[w * h * 4];
            buff_img.getRaster().getPixels(0, 0, w, h, pixels);
            for (int x = 0; x < buff_img.getWidth(); x++) {
                for (int y = 0; y < buff_img.getHeight(); y++) {
                    int rgb = buff_img.getRGB(x, y);
                    Color color = new Color(rgb, true);
                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();
                    int gry = (r + g + b) / 3;
                    r = g = b = gry;
                    r = r + (sepiaDepth * 2);
                    g = g + sepiaDepth;
                    if (r > 255) {
                        r = 255;
                    }
                    if (g > 255) {
                        g = 255;
                    }
                    if (b > 255) {
                        b = 255;
                    }
                    b -= 20;
                    if (b < 0) {
                        b = 0;
                    }
                    if (b > 255) {
                        b = 255;
                    }
                    color = new Color(r, g, b, color.getAlpha());
                    sepia.setRGB(x, y, color.getRGB());
                }
            }
            rd.drawImage(sepia, 0, 0, null);
        }
        if (type == 2) { /////////// inverts colors
            BufferedImage invert = new BufferedImage(buff_img.getWidth(), buff_img.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            int w = buff_img.getWidth();
            int h = buff_img.getHeight();
            int[] pixels = new int[w * h * 4];
            buff_img.getRaster().getPixels(0, 0, w, h, pixels);
            for (int x = 0; x < buff_img.getWidth(); x++) {
                for (int y = 0; y < buff_img.getHeight(); y++) {
                    int rgb = buff_img.getRGB(x, y);
                    Color color = new Color(rgb, true);
                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();
                    r = 255 - r;
                    g = 255 - g;
                    b = 255 - b;
                    if (r > 255) {
                        r = 255;
                    }
                    if (r < 0) {
                        r = 0;
                    }
                    if (g > 255) {
                        g = 255;
                    }
                    if (g < 0) {
                        g = 0;
                    }
                    if (b > 255) {
                        b = 255;
                    }
                    if (b < 0) {
                        b = 0;
                    }
                    color = new Color(r, g, b, color.getAlpha());
                    invert.setRGB(x, y, color.getRGB());
                }
            }
            rd.drawImage(invert, 0, 0, null);
        }
        if (type == 3) { /////// alternate invert
            BufferedImage altinvert = new BufferedImage(buff_img.getWidth(), buff_img.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            int w = buff_img.getWidth();
            int h = buff_img.getHeight();
            int[] pixels = new int[w * h * 4];
            buff_img.getRaster().getPixels(0, 0, w, h, pixels);
            for (int x = 0; x < buff_img.getWidth(); x++) {
                for (int y = 0; y < buff_img.getHeight(); y++) {
                    int rgb = buff_img.getRGB(x, y);
                    Color color = new Color(rgb, true);
                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();
                    r = m.csky[0] - r;
                    g = m.csky[1] - g;
                    b = m.csky[2] - b;
                    if (r > 255) {
                        r = 255;
                    }
                    if (r < 0) {
                        r = 0;
                    }
                    if (g > 255) {
                        g = 255;
                    }
                    if (g < 0) {
                        g = 0;
                    }
                    if (b > 255) {
                        b = 255;
                    }
                    if (b < 0) {
                        b = 0;
                    }
                    color = new Color(r, g, b, color.getAlpha());
                    altinvert.setRGB(x, y, color.getRGB());
                }
            }
            rd.drawImage(altinvert, 0, 0, null);
        }
        if (type == 4) { /////// washout type filter
            BufferedImage washout = new BufferedImage(buff_img.getWidth(), buff_img.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            int w = buff_img.getWidth();
            int h = buff_img.getHeight();
            int[] pixels = new int[w * h * 4];
            buff_img.getRaster().getPixels(0, 0, w, h, pixels);
            for (int x = 0; x < buff_img.getWidth(); x++) {
                for (int y = 0; y < buff_img.getHeight(); y++) {
                    int rgb = buff_img.getRGB(x, y);
                    Color color = new Color(rgb, true);
                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();
                    int nr = r / 2;
                    int ng = g / 2;
                    r = nr + r;
                    g = ng + g;
                    b = b + (b / 2);
                    if (r > 255) {
                        r = 255;
                    }
                    if (r < 0) {
                        r = 0;
                    }
                    if (g > 255) {
                        g = 255;
                    }
                    if (g < 0) {
                        g = 0;
                    }
                    if (b > 255) {
                        b = 255;
                    }
                    if (b < 0) {
                        b = 0;
                    }
                    color = new Color(r, g, b, color.getAlpha());
                    washout.setRGB(x, y, color.getRGB());
                }
            }
            rd.drawImage(washout, 0, 0, null);
        }
    }   

    /**Special color effect in credits
     * @param image the image
     * @return image the same image but filtered with color
     * 
     * @author Kaffeinated
     */
    public Image credsnap(Image image) {
        int i = 350; // image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];

        if (credColors[0] < 200) {
            credColors[0] += 5;
        } else {
            do {
                credColors[0] -= 5;
            } while (credColors[0] > 25);
        }
        if (credColors[1] < 100) {
            credColors[1] += 5;
        } else {
            do {
                credColors[1] -= 10;
            } while (credColors[1] > 50);
        }
        if (credColors[2] < 30) {
            credColors[2] += 5;
        } else {
            do {
                credColors[2] -= 5;
            } while (credColors[2] > 100);
        }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
        for (int k = 0; k < j * i; k++) {
            Color color = new Color(ai[k]);
            int l = (int) (color.getRed() * (credColors[0] / 100F));
            if (l > 225) {
                l = 225;
            }
            if (l < 0) {
                l = 0;
            }
            int i1 = (int) (color.getGreen() * (credColors[1] / 100F));
            if (i1 > 225) {
                i1 = 225;
            }
            if (i1 < 0) {
                i1 = 0;
            }
            int j1 = (int) (color.getBlue() * (credColors[2] / 100F));
            if (j1 > 225) {
                j1 = 225;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            Color color2 = new Color(l, i1, j1, 50); /// last is alpha
            ai[k] = color2.getRGB();
        }
        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public int colorinvert(int r, int g, int b) {
        int hex = (0xff << 24) | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
        int neg = 0xFFFFFF - hex;
        return neg;
    }

    /**
     * drawcs for images
     * @param img image to draw
     * @param y y value
     * @author Kaffeinated
     */
    public void paintcs(Image img, int y) {
        rd.drawImage(img, (img.getWidth(null) / 2) - 900, y, null);
    }       
    
    /**
     * draw text over conto
     * @param text text to draw
     * @param contos conto to overlay
     * @author Rafa
     * @author Kaffeinated
     */
    public void drawOver(String text, ContO contos) {
        int x = m.cx + (int) ((contos.x - m.x - m.cx));
        int y = m.cy + (int) ((contos.y - m.y - m.cy));
        int z = m.cz + (int) ((contos.z - m.z - m.cz));

        x = Utility.rotSingle(x, z, m.cx, m.cz, m.xz, RadicalMath.sin(m.xz), RadicalMath.cos(m.xz))[0];
        y = Utility.rotSingle(y, z, m.cy, m.cz, m.zy, RadicalMath.sin(m.zy), RadicalMath.cos(m.zy))[0];
        z = Utility.rotSingle(y, z, m.cy, m.cz, m.zy, RadicalMath.sin(m.zy), RadicalMath.cos(m.zy))[1];

        final int xScreenCoor = Utility.xs(x, z);
        final int yScreenCoor = Utility.cYs(y, z);

        rd.drawString("" + text, xScreenCoor, yScreenCoor); 
    }
    
    public void carspergame(int stage) 
    {
        if( stage == 9 || stage == 12 || stage == 15 || stage == 18 || stage == 21)
        {
            nplayers = 2;
            setnumber = true;
        } else
        {
            fase = 2;
        }
        
        if(!setnumber)
        {
            nplayers = 7;
            setnumber = true;
        } else
        {
            fase = 2;
        }
    }

    public boolean over(Image image, int i, int j, int k, int l) {
        int i1 = image.getHeight(ob);
        int j1 = image.getWidth(ob);
        return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
    }

    public void cantgo(Control control) {
        pnext = 0;
        trackbg(false);
        rd.setFont(new Font("SansSerif", 1, 13));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(476, "This stage will be unlocked when stage " + unlocked + " is complete!", 255, 255, 255, 3);
        int i = 0;
        do {
            rd.drawImage(pgate, 212 + i * 30, 190, null);
        } while (++i < 9);
        rd.setFont(new Font("SansSerif", 1, 11));
        FontHandler.fMetrics = rd.getFontMetrics();
        if (aflk) {
            drawcs(250, "[ Stage " + (unlocked + 1) + " Locked ]", 182, 0, 0, 3);
            aflk = false;
        } else {
            drawcs(250, "[ Stage " + (unlocked + 1) + " Locked ]", 255, 0, 0, 3);
            aflk = true;
        }
        rd.drawImage(select, 273, 45, null);
        rd.drawImage(br, 0, 0, null);
        rd.drawImage(back[pback], 50, 350, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(496, "You can also use Keyboard Arrows and Enter to navigate.", 255, 255, 255, 3);
        lockcnt--;
        if (lockcnt == 0 || control.enter || control.handb || control.left) {
            control.left = false;
            control.handb = false;
            control.enter = false;
            fase = 1;
        }
    }

    public void loadingstage(int i) {
        trackbg(true);
        rd.setFont(new Font("SansSerif", 1, 13));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(200, "Loading Stage " + i + ", please wait...", 182, 0, 0, 3);
        rd.drawImage(select, 273, 45, null);
        if (i <= 12) {
            rd.drawImage(brse, 0, 0, null); 
            }
        if (i >= 13 && i != 25) {
            rd.drawImage(br, 0, 0, null);
            }
        rd.setFont(new Font("SansSerif", 1, 11));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(496, "You can also use Keyboard Arrows and Enter to navigate.", 255, 255, 255, 3);
        app.repaint();
        
       
    }

    public void inst(Control control) {
        if (flipo == 0) {
            flipo = 1;
            bgmy[0] = 0;
            bgmy[1] = 500;
        }
        if (flipo == 2) {
            flipo = 3;
            dudo = 200;
        }
        if (flipo == 4) {
            flipo = 5;
            dudo = 250;
        }
        if (flipo == 6) {
            flipo = 7;
            dudo = 200;
        }
        if (flipo == 8) {
            flipo = 9;
            dudo = 250;
        }
        if (flipo == 10) {
            flipo = 11;
            dudo = 200;
        }
        if (flipo == 12) {
            flipo = 13;
            dudo = 200;
        }
        if (flipo == 14) {
            flipo = 15;
            dudo = 100;
        }
        int i = 0;
        rd.drawImage(instback, 0, 0, null);
        if (aflk) {
            aflk = false;
        } else {
            aflk = true;
        }
        if (flipo != 1) {
            if (dudo > 0) {
                if (aflk) {
                    if (Math.random() > Math.random()) {
                        duds = (int) (Math.random() * 3D);
                    } else {
                        duds = (int) (Math.random() * 2D);
                    }
                }
                dudo--;
            } else {
                duds = 0;
            }
            rd.drawImage(dude[duds], 145, -10, null);
            rd.drawImage(oflaot, 242, 17, null);
        }
        rd.setColor(new Color(0, 0, 0));
        rd.setFont(new Font("SansSerif", 1, 13));
        if (flipo == 3 || flipo == 5) {
            if (flipo == 3) {
                rd.drawString("Hello!  Welcome to G6's world of total madness!!", 312, 42);
                rd.drawString("In NFM G6 there are two ways that you can win a race.", 312, 82);
                rd.drawString("One is by racing and finishing in first place, the other is by", 312, 102);
                rd.drawString("wasting and destroying all of your opponents in the stage!", 312, 122);
            } else {
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("While racing, you will need to focus on going fast and going through", 312, 42);
                rd.drawString("all the checkpoints in the stage. To complete a lap, you must not", 312, 62);
                rd.drawString(" miss a checkpoint. As well, try to keep your power bar full at all ", 312, 82);
                rd.drawString("times. While wasting, you will just need to worry about hunting other", 312, 102);
                rd.drawString("cars down and smashing them to peices and setting them ablaze!", 312, 122);
                rd.setColor(new Color(182, 0, 0));
            }
            rd.drawImage(inst2, 0, 0, null);
            
        }
        if (flipo == 7 || flipo == 9) {
            if (flipo == 7) {
                rd.drawString("Whether you are racing or wasting the other cars you will need", 312, 42);
                rd.drawString("to power up your car.", 312, 62);
                rd.drawString("=> More 'Power' makes your car become faster and stronger!", 312, 82);
                rd.drawString("To power up your car (and keep it powered up) you will need to", 312, 102);
                rd.drawString("perform stunts!", 312, 122);
                
            } else {
                rd.drawString("The better the stunt the more power you get!", 312, 42);
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("Forward looping pushes your car forwards in the air and helps", 312, 62);
                rd.drawString("when racing. Backward looping pushes your car upwards giving it", 312, 82);
                rd.drawString("more hang time in the air making it easier to control its landing.", 312, 102);
                rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 312, 122);
                rd.setColor(new Color(182, 0, 0));
            }
            rd.drawImage(inst4, 0, 0, null);
        }
        if (flipo == 11 || flipo == 13) {
            if (flipo == 11) {
                rd.drawString("When wasting cars, to help you find the other cars in the stage,", 312, 42);
                rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 312, 62);
                rd.drawString("to pointing to the cars.", 312, 82);
                rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 312, 102);
                rd.drawString("jumping through the electrified hoop.", 312, 122);
            } else {
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("You will find that in some stages it's easier to waste the other cars", 312, 42);
                rd.drawString("and in some others it's easier to race and finish in first place.", 312, 62);
                rd.drawString("It is up to you to decide when to waste and when to race.", 312, 82);
                rd.drawString("And remember, 'Power' is an important factor in the game. You", 312, 102);
                rd.drawString("will need it whether you are racing or wasting!", 312, 122);
                rd.setColor(new Color(182, 0, 0));
            }
            rd.drawImage(inst8, 0, 0, null);
        }
        if (flipo == 15) {
            rd.drawImage(inst8, 0, 0, null);
            rd.drawString("There is a total of 25 stages!", 312, 42);
            rd.drawString("Every two stages completed a new car will be unlocked!", 312, 62);
            rd.drawString("I am Coach Insano by the way.", 312, 102);
            rd.drawString("I am your coach and narrator in this game!  Good Luck!", 312, 122);
            
        }
        if (flipo == 1) {
            rd.drawImage(inst1, 0, 0, null);
        }
        if (flipo >= 1 && flipo <= 13) {
            rd.drawImage(next[pnext], 820, 90, null);
        }
        if (flipo >= 3 && flipo <= 15) {
            rd.drawImage(back[pback], 20, 90, null);
        }
        if (flipo == 15) {
            rd.drawImage(contin[pcontin], 750, 440, null);
        }
        if (control.enter || control.right) {
            if (flipo >= 1 && flipo <= 13) {
                flipo++;
            }
            if (control.enter && flipo == 15) {
                flipo = 0;
                fase = oldfase;
                rd.setFont(new Font("SansSerif", 1, 11));
                FontHandler.fMetrics = rd.getFontMetrics();
            }
            control.enter = false;
            control.right = false;
        }
        if (control.left) {
            if (flipo >= 3 && flipo <= 15) {
                flipo -= 3;
            }
            control.left = false;
        }
    }

    public void fleximage(Image image, int i, int j) {
        if (i == 0) {
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 900, 500, flexpix, 0, 900);
            try {
                pixelgrabber.grabPixels();
            } catch (InterruptedException _ex) {
            }
        }
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = (int) (Math.random() * 128D);
        int l1 = (int) (5D + Math.random() * 15D);
        int i2 = 0;
        do {
            Color color = new Color(flexpix[i2]);
            int j2 = 0;
            int k2 = 0;
            int l2 = 0;
            if (k == 0) {
                j2 = color.getRed();
                l = j2;
                k2 = color.getGreen();
                i1 = k2;
                l2 = color.getBlue();
                j1 = l2;
            } else {
                j2 = (int) ((color.getRed() + l * 0.38F * i) / (1.0F + 0.38F * i));
                l = j2;
                k2 = (int) ((color.getGreen() + i1 * 0.38F * i) / (1.0F + 0.38F * i));
                i1 = k2;
                l2 = (int) ((color.getBlue() + j1 * 0.38F * i) / (1.0F + 0.38F * i));
                j1 = l2;
            }
            if (++k == 900) {
                k = 0;
            }
            int i3 = (j2 * 17 + k2 + l2 + k1) / 22;
            int j3 = (k2 * 17 + j2 + l2 + k1) / 22;
            int k3 = (l2 * 17 + j2 + k2 + k1) / 22;
            if (j == 17) {
                i3 = (j2 * 17 + k2 + l2 + k1) / 22;
                j3 = (k2 * 17 + j2 + l2 + k1) / 21;
                k3 = (l2 * 17 + j2 + k2 + k1) / 20;
            }
            if (--l1 == 0) {
                k1 = (int) (Math.random() * 128D);
                l1 = (int) (5D + Math.random() * 15D);
            }
            Color color1 = new Color(i3, j3, k3);
            flexpix[i2] = color1.getRGB();
        } while (++i2 < 0x6ddd0);
        fleximg = createImage(new MemoryImageSource(900, 500, flexpix, 0, 900));
        rd.drawImage(fleximg, 0, 0, null);
    }

    public void arrow(int i, int j, CheckPoints checkpoints, ContO conto[], Control control, boolean flag) { //comeback
       int ai[] = new int[7];
       int ai1[] = new int[7];
       int ai2[] = new int[7];
       /**
		* x resolution divided by two converted to hex
		* http://www.binaryhexconverter.com/decimal-to-hex-converter
		*/
		char c = '\u01C2';
		byte byte0 = -90;
		/**
		 * x resolution plus 30 converted to hex?
		 * http://www.binaryhexconverter.com/decimal-to-hex-converter
		 */
		char c1 = '\u02BC'; //2BC
		int k = 0;
        do {
            ai1[k] = byte0;
        } while (++k < 7); // 7
        ai[0] = c;
        ai2[0] = c1 + 110;
        ai[1] = c - 35;
        ai2[1] = c1 + 50;
        ai[2] = c - 15;
        ai2[2] = c1 + 50;
        ai[3] = c - 15;
        ai2[3] = c1 - 50;
        ai[4] = c + 15;
        ai2[4] = c1 - 50;
        ai[5] = c + 15;
        ai2[5] = c1 + 50;
        ai[6] = c + 35;
        ai2[6] = c1 + 50;
        k = 0;
        int l = 0;
        if (!flag) {
            char c2 = '\0';
            if (checkpoints.x[i] - checkpoints.opx[0] >= 0) {
                c2 = '\264';
            }
            k = (int) (90 + c2 + Math.atan(
                    (double) (checkpoints.z[i] - checkpoints.opz[0]) / (double) (checkpoints.x[i] - checkpoints.opx[0]))
                    / 0.017453292519943295D);
        } else {
            int k1 = -1;
            boolean flag1 = false;
            int l2 = 1;
            do {
                if ((Utility.py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100,
                        checkpoints.opz[l2] / 100) < k1 || k1 == -1) && (!flag1 || checkpoints.onscreen[l2] != 0)
                        && checkpoints.dested[l2] == 0) {
                    l = l2;
                    k1 = Utility.py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100,
                            checkpoints.opz[l2] / 100);
                    if (checkpoints.onscreen[l2] != 0) {
                        flag1 = true;
                    }
                }
            } while (++l2 < nplayers);
            l2 = 0;
            if (checkpoints.opx[l] - checkpoints.opx[0] >= 0) {
                l2 = 180;
            }
            k = (int) (90 + l2 + Math.atan((double) (checkpoints.opz[l] - checkpoints.opz[0])
                    / (double) (checkpoints.opx[l] - checkpoints.opx[0])) / 0.017453292519943295D);
            rd.drawImage(hunting, 0, 0, null);
                    
            rd.setFont(new Font("Adventure", 1, 15));
            FontHandler.fMetrics = rd.getFontMetrics();
            rd.setColor(new Color(255, 255, 255));
              
            drawcs(16, names[sc[l]], 255, 255, 255, 0); //PRESS A

            rd.setFont(new Font("SansSerif", 1, 11));
             FontHandler.fMetrics = rd.getFontMetrics();
            
            /*
             * example use of drawOver
             */
            //drawOver(names[sc[l]], conto[l]);
        }
        for (k += m.xz; k < 0; k += 360) {
        }
        for (; k > 180; k -= 360) {
        }
        if (!flag) {
            if (k > 130) {
                k = 130;
            }
            if (k < -130) {
                k = -130;
            }
        } else {
            if (k > 100) {
                k = 100;
            }
            if (k < -100) {
                k = -100;
            }
        }
        if (Math.abs(ana - k) < 180) {
            if (Math.abs(ana - k) < 10) {
                ana = k;
            } else if (ana < k) {
                ana += 10;
            } else {
                ana -= 10;
            }
        } else {
            if (k < 0) {
                ana += 15;
                if (ana > 180) {
                    ana -= 360;
                }
            }
            if (k > 0) {
                ana -= 15;
                if (ana < -180) {
                    ana += 360;
                }
            }
        }
        Utility.rot(ai, ai2, c, c1, ana, 7);
        k = Math.abs(ana);
        if (!flag) {
            if (k > 7 || j > 0 || j == -2 || cntan != 0) {
                int i1 = 0;
                do {
                    ai[i1] = Utility.cXs(ai[i1], ai2[i1]);
                    ai1[i1] = Utility.cYs(ai1[i1], ai2[i1]);
                } while (++i1 < 7);
                i1 = (int) (255F + 255F * (m.snap[0] / 100F));
                if (i1 > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                int l1 = (int) (120F + 120F * (m.snap[1] / 100F));
                if (l1 > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                int j2 = 0;
                if (j <= 0) {
                    if (k <= 45 && j != -2 && cntan == 0) {
                        i1 = (i1 * k + m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + m.csky[2] * (45 - k)) / 45;
                    }
                    if (k >= 90) {
                        int i3 = (int) (255F + 255F * (m.snap[0] / 100F));
                        if (i3 > 255) {
                            i3 = 255;
                        }
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        i1 = (i1 * (140 - k) + i3 * (k - 90)) / 50;
                        if (i1 > 255) {
                            i1 = 255;
                        }
                    }
                } else if (flk) {
                    i1 = (int) (255F + 255F * (m.snap[0] / 100F));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    flk = false;
                } else {
                    i1 = (int) (117F + 117F * (m.snap[0] / 100F));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    l1 = (int) (0F + 0F * (m.snap[1] / 100F));
                    if (l1 > 255) {
                        l1 = 255;
                    }
                    if (l1 < 0) {
                        l1 = 0;
                    }
                    flk = true;
                }
                rd.setColor(new Color(200, 0, 0));
                rd.fillPolygon(ai, ai1, 7);
                i1 = (int) (255F + 255F * (m.snap[0] / 100F));
                if (i1 > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                l1 = (int) (128F + 128F * (m.snap[1] / 100F));
                if (l1 > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                j2 = 0;
                if (j <= 0) {
                    if (k <= 45 && j != -2 && cntan == 0) {
                        i1 = (i1 * k + m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + m.csky[2] * (45 - k)) / 45;
                    }
                } else if (flk) {
                    i1 = (int) (255F + 255F * (m.snap[0] / 100F));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    l1 = 0;
                }
                rd.setColor(new Color(0, 0, 0));
                rd.drawPolygon(ai, ai1, 7);
            }
        } else {
            int j1 = 0;
            do {
                ai[j1] = Utility.cXs(ai[j1], ai2[j1]);
                ai1[j1] = Utility.cYs(ai1[j1], ai2[j1]);
            } while (++j1 < 7);
            rd.setColor(new Color(conto[l].p[0].c[0],conto[l].p[0].c[1],conto[l].p[0].c[2]));
            rd.fillPolygon(ai, ai1, 7);
            
            j1 = (int) (120F + 120F * (m.snap[0] / 100F));
            if (j1 > 255) {
                j1 = 255;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            int i2 = (int) (114F + 114F * (m.snap[1] / 100F));
            if (i2 > 255) {
                i2 = 255;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int k2 = (int) (255F + 255F * (m.snap[2] / 100F));
            if (k2 > 255) {
                k2 = 255;
            }
            if (k2 < 0) {
                k2 = 0;
            }
            rd.setColor(new Color(0, 0, 0));
            rd.drawPolygon(ai, ai1, 7);
        }
    }

    public void levelhigh(int i, int j, int k, int l, int i1) {
        rd.drawImage(gameh, 352, 15, null);
        byte byte0 = 16; ///////////// change this to 1 to relock the game
        char c = '0';
        char c1 = '`';
        if (l < 50) {
            if (aflk) {
                byte0 = 106;
                c = '\260';
                c1 = '\377';
                aflk = false;
            } else {
                aflk = true;
            }
        }
        if (i != 0) {
            if (k == 0) {
                drawcs(60, "You Wasted 'em!", byte0, c, c1, 0);
            } else if (k == 1) {
                drawcs(60, "Photo Finish!", byte0, c, c1, 0);
            } else {
                drawcs(60, "Photo Finish! So close!", byte0, c, c1, 0);
            }
        } else if (j == 229) {
            drawcs(60, "Wasted!", byte0, c, c1, 0);
        } else if (i1 > 2) {
            drawcs(60, "Stunts!", byte0, c, c1, 0);
        } else {
            drawcs(60, "Best Stunt!", byte0, c, c1, 0);
        }
        drawcs(420, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
    }

    public void playsounds(Madness madness, Control control, int i) {
        if (fase == 0 && starcnt < 35 && cntwis != 8 && !mutes) {
            boolean flag = control.up && madness.speed > 0.0F || control.down && madness.speed < 10F;
            boolean flag1 = madness.skid == 1 && control.handb
                    || Math.abs(madness.scz[0]
                            - (madness.scz[1] + madness.scz[0] + madness.scz[2] + madness.scz[3]) / 4F) > 1.0F
                    || Math.abs(madness.scx[0]
                            - (madness.scx[1] + madness.scx[0] + madness.scx[2] + madness.scx[3]) / 4F) > 1.0F;
            boolean flag2 = false;
            if (control.up && madness.speed < 10F) {
                flag1 = true;
                flag = true;
                flag2 = true;
            }
            if (flag && madness.mtouch) {
                if (!madness.capsized) {
                    if (!flag1) {
                        if (madness.power != 98F) {
                            if (Math.abs(madness.speed) > 0.0F
                                    && Math.abs(madness.speed) <= Madness.swits[madness.cn][0]) {
                                int j = (int) ((3F * Math.abs(madness.speed)) / Madness.swits[madness.cn][0]);
                                if (j == 2) {
                                    if (pwait == 0) {
                                        j = 0;
                                    } else {
                                        pwait--;
                                    }
                                } else {
                                    pwait = 7;
                                }
                                sparkeng(j);
                            }
                            if (Math.abs(madness.speed) > Madness.swits[madness.cn][0]
                                    && Math.abs(madness.speed) <= Madness.swits[madness.cn][1]) {
                                int k = (int) ((3F * (Math.abs(madness.speed) - Madness.swits[madness.cn][0]))
                                        / (Madness.swits[madness.cn][1] - Madness.swits[madness.cn][0]));
                                if (k == 2) {
                                    if (pwait == 0) {
                                        k = 0;
                                    } else {
                                        pwait--;
                                    }
                                } else {
                                    pwait = 7;
                                }
                                sparkeng(k);
                            }
                            if (Math.abs(madness.speed) > Madness.swits[madness.cn][1]
                                    && Math.abs(madness.speed) <= Madness.swits[madness.cn][2]) {
                                int l = (int) ((3F * (Math.abs(madness.speed) - Madness.swits[madness.cn][1]))
                                        / (Madness.swits[madness.cn][2] - Madness.swits[madness.cn][1]));
                                sparkeng(l);
                            }
                        } else {
                            byte byte0 = 2;
                            if (pwait == 0) {
                                if (Math.abs(madness.speed) > Madness.swits[madness.cn][1]) {
                                    byte0 = 3;
                                }
                            } else {
                                pwait--;
                            }
                            sparkeng(byte0);
                        }
                    } else {
                        sparkeng(-1);
                        if (flag2) {
                            if (stopcnt <= 0) {
                                air[5].loop();
                                stopcnt = 10;
                            }
                        } else if (stopcnt <= -2) {
                            air[2 + (int) (m.random() * 3F)].loop();
                            stopcnt = 7;
                        }
                    }
                } else {
                    sparkeng(3);
                }
                grrd = false;
                aird = false;
            } else {
                pwait = 15;
                if (!madness.mtouch && !grrd && m.random() > 0.00000000000002D) {
                    air[(int) (m.random() * 4F)].loop();
                    stopcnt = 5;
                    grrd = true;
                }
                if (!madness.wtouch && !aird) {
                    stopairs();
                    air[(int) (m.random() * 4F)].loop();
                    stopcnt = 10;
                    aird = true;
                }
                sparkeng(-1);
            }
            if (madness.cntdest != 0 && cntwis < 7) {
                if (!pwastd) {
                    wastd.loop();
                    pwastd = true;
                }
            } else {
                if (pwastd) {
                    wastd.stop();
                    pwastd = false;
                }
                if (cntwis == 7 && !mutes) {
                    firewasted.play();
                }
            }
        } else {
            sparkeng(-2);
            if (pwastd) {
                wastd.stop();
                pwastd = false;
            }
        }
        if (stopcnt != -20) {
            if (stopcnt == 1) {
                stopairs();
            }
            stopcnt--;
        }
        if (bfcrash != 0) {
            bfcrash--;
        }
        if (bfskid != 0) {
            bfskid--;
        }
        if (madness.newcar) {
            cntwis = 0;
        }
        if (fase == 0 || fase == 6 || fase == -1 || fase == -2 || fase == -3 || fase == -4 || fase == -5) {
            if (mutes != Control.mutes) {
                mutes = Control.mutes;
            }
            if (Control.mutem != mutem) {
                mutem = Control.mutem;
                if (mutem) {
                    if (loadedt[i - 1]) {
                        if(isMidi[i - 1]) {
                          mtracks[i - 1].setPaused(true);
                          } else {
                           stracks[i - 1].stop();
                       }
                    }
                } else if (loadedt[i - 1]) {
                    System.out.println("We've reached an unmute check...");
                    if(isMidi[i - 1]) {
                     System.out.println("Unmute check > play midi...");
                     mtracks[i - 1].resume();
                      } else {
                        System.out.println("Unmute check > play mod...");
                     stracks[i - 1].resume();
                   }
                }
            }
        }
        if (madness.cntdest != 0 && cntwis < 7) {
            if (madness.dest) {
                cntwis++;
            }
        } else {
            if (madness.cntdest == 0) {
                cntwis = 0;
            }
            if (cntwis == 7) {
                cntwis = 8;
            }
        }
    }

    public void crash(float f, int i) {
        if (bfcrash == 0) {
            if (i == 0) {
                if (Math.abs(f) > 25F && Math.abs(f) < 170F) {
                    if (!mutes) {
                        lowcrash[crshturn].play();
                    }
                    bfcrash = 2;
                }
                if (Math.abs(f) >= 170F) {
                    if (!mutes) {
                        crash[crshturn].play();
                    }
                    bfcrash = 2;
                }
                if (Math.abs(f) > 25F) {
                    if (crashup) {
                        crshturn--;
                    } else {
                        crshturn++;
                    }
                    if (crshturn == -1) {
                        crshturn = 2;
                    }
                    if (crshturn == 3) {
                        crshturn = 0;
                    }
                }
            }
            if (i == -1) {
                if (Math.abs(f) > 25F && Math.abs(f) < 170F) {
                    if (!mutes) {
                        lowcrash[2].play();
                    }
                    bfcrash = 2;
                }
                if (Math.abs(f) > 170F) {
                    if (!mutes) {
                        crash[2].play();
                    }
                    bfcrash = 2;
                }
            }
            if (i == 1) {
                if (!mutes) {
                    tires.play();
                }
                bfcrash = 3;
            }
        }
    }   

    public void replyn() {
        if (aflk) {
            drawcs(30, "Replay  > ", 0, 0, 0, 0);
            aflk = false;
        } else {
            drawcs(30, "Replay  >>", 0, 128, 255, 0);
            aflk = true;
        }
    }

    private Image pressed(Image image) {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
        for (int k = 0; k < j * i; k++) {
            if (ai[k] != ai[j * i - 1]) {
                ai[k] = 0xff000000;
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private Image dodgen(Image image) {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
        for (int k = 0; k < j * i; k++) {
            Color color = new Color(ai[k]);
            int l = color.getRed() * 3 + 90;
            if (l > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
            int i1 = color.getGreen() * 3 + 90;
            if (i1 > 255) {
                i1 = 255;
            }
            if (i1 < 0) {
                i1 = 0;
            }
            int j1 = color.getBlue() * 3 + 90;
            if (j1 > 255) {
                j1 = 255;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            Color color1 = new Color(l, i1, j1);
            ai[k] = color1.getRGB();
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private void smokeypix(byte abyte0[], MediaTracker mediatracker, Toolkit toolkit) {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception _ex) {
        }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, smokey, 0, 466);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
    }

    public void stoploading() {
        loading();
        app.repaint();
        runner.stop();
        runner = null;
        runtyp = 0;
    }

    public void nofocus() {
        rd.setColor(new Color(255, 255, 255));
        rd.setFont(new Font("Adventure", 1, 13));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(14, ">> Game lost its focus.   Click screen with mouse to continue. <<", 100, 100, 100, 3);
        drawcs(495, ">> Game lost its focus.   Click screen with mouse to continue. <<", 100, 100, 100, 3);
    }
    
    public boolean overon(int i, int j, int k, int l, int i1, int j1) {
        return i1 > i && i1 < i + k && j1 > j && j1 < j + l;
    }

    public void pauseimage(Image image) {
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 900, 500, flexpix, 0, 900);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        do {
            Color color = new Color(flexpix[i1]);
            int j1 = 0;
            if (l == 0) {
                j1 = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                k = j1;
            } else {
                j1 = (color.getRed() + color.getGreen() + color.getBlue() + k * 30) / 33;
                k = j1;
            }
            if (++l == 900) {
                l = 0;
            }
            if (i1 > 900 * (65 + j) + 331 && j < 188) {
                //(i1 > 900 * (//8 (Y START VALUE)  + j) + //331 (MIDPOINT) && j < 188)
                int k1 = (j1 + 20) / 3; //RGB
                int l1 = (j1 + 20) / 3; 
                int i2 = (j1 + 20) / 3;
                if (++i == 237) {
                    j++;
                    i = 0;
                }
                Color color2 = new Color(k1, l1, i2);
                flexpix[i1] = color2.getRGB();
            } else {
                Color color1 = new Color(j1, j1, j1);
                flexpix[i1] = color1.getRGB();
            }
        } while (++i1 < 0x6ddd0);
        fleximg = createImage(new MemoryImageSource(900, 500, flexpix, 0, 900));
        rd.drawImage(fleximg, 0, 0, null);
        m.flex = 0;
    }

    public void loadmusic(int i, int j) {
        hipnoload(i, false);
        app.setCursor(new Cursor(3));
        app.repaint();
        boolean flag = false;
        if (i == unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12
                || i == 13 || i == 16)) {
            flag = true;
        }
        if (flag) {
            runtyp = i;
            runner = new Thread(this);
            runner.start();
        }
        if(!loadedt[i - 1])
           {
            System.out.println("Loading music...");
            File f = new File("data/music/stage" + i + ".mid");
            File f2 = new File("data/music/stage" + i + ".mp3");
            File f3 = new File("data/music/stage" + i + ".ogg");
            // this also serves as a check so radicalmidi doesn't throw an error
            if (f.exists()) {
            System.out.println("Initializing midi...");
            isMidi[i - 1] = true;
            mtracks[i - 1] = new RadicalMidi("data/music/stage" + i + ".mid");
            System.out.println("Loading midi...");
            mtracks[i - 1].load();
            loadedt[i - 1] = true;
              } else if (f2.exists()) {
            System.out.println("Initializing mp3...");
            isMidi[i - 1] = true;
            mtracks[i - 1] = new RadicalMidi("data/music/stage" + i + ".mp3");
            System.out.println("Loading mp3...");
            mtracks[i - 1].load();
            loadedt[i - 1] = true;
           } else if (f3.exists()) {
            System.out.println("Initializing/loading ogg...");
            isMidi[i - 1] = true;
            mtracks[i - 1] = new RadicalMidi("data/music/stage" + i + ".ogg");
            loadedt[i - 1] = true;
             } else {
            System.out.println("Initializing mod...");
            isMidi[i - 1] = false;
            stracks[i - 1] = new RadicalMod("data/music/stage" + i + ".radq", app);
          if(stracks[i - 1].loaded == 1)
             {
            loadedt[i - 1] = true;
           }
         }
        }
       
        if (!isMidi[i - 1]) {
        System.out.println("Loading mod...");
        if (i == 1) {
            stracks[0].loadMod(160, 7200, 125, sunny, macn);
        }
        if (i == 2) {
            stracks[1].loadMod(260, 8000, 125, sunny, macn);
        }
        if (i == 3) {
            stracks[2].loadMod(270, 8000, 125, sunny, macn);
        }
        if (i == 4) {
            stracks[3].loadMod(190, 8000, 125, sunny, macn);
        }
        if (i == 5) {
            stracks[4].loadMod(370, 8000, 125, sunny, macn);
        }
        if (i == 6) {
            stracks[5].loadMod(220, 8000, 125, sunny, macn);
        }
        if (i == 7) {
            stracks[6].loadMod(300, 8000, 125, sunny, macn);
        }
        if (i == 8) {
            stracks[7].loadMod(200, 8000, 125, sunny, macn);
        }
        if (i == 9) {
            stracks[8].loadMod(400, 7800, 125, sunny, macn);
        }
        if (i == 10) {
            stracks[9].loadMod(400, 7700, 125, sunny, macn);
        }
        if (i == 11) {
            stracks[10].loadMod(370, 7900, 125, sunny, macn);
        }
        if (i == 12) {
            stracks[11].loadMod(290, 7900, 125, sunny, macn);
        }
        if (i == 13) {
            stracks[12].loadMod(222, 7600, 125, sunny, macn);
        }
        if (i == 14) {
            stracks[13].loadMod(230, 8000, 125, sunny, macn);
        }
        if (i == 15) {
            stracks[14].loadMod(220, 8000, 125, sunny, macn);
        }
        if (i == 16) {
            stracks[15].loadMod(261, 8000, 125, sunny, macn);
        }
        if (i == 17) {
            stracks[16].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 18) {
            stracks[17].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 19) {
            stracks[18].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 20) {
            stracks[19].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 21) {
            stracks[20].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 22) {
            stracks[21].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 23) {
            stracks[22].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 24) {
            stracks[23].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 25) {
            stracks[24].loadMod(400, 7600, 125, sunny, macn);
         }
        }
        if (flag) {
            runner.stop();
            runner = null;
            runtyp = 0;
        }
        System.gc();
        lastload = i - 1;
        if (j == 0) {
            if (loadedt[i - 1]) {
                if (isMidi[i - 1]) {
                  System.out.println("Playing midi...");
                  mtracks[i - 1].play();
                 } else {
                  System.out.println("Playing mod...");
                  stracks[i - 1].play();
               }
            }
            app.setCursor(new Cursor(0));
            fase = 6;
        } else {
            fase = 176;
        }
        pcontin = 0;
        mutem = false;
        mutes = false;
    }

    /**Loads images from images.radq
     * 
     * @author Omar Wally
     */
    public void loadimages() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediatracker = new MediaTracker(app);
        dnload += 12;
        int howManyImages = 0;
        
        try {
            URL url = new URL(app.getCodeBase(), "data/images.radq");
            ZipInputStream zipinputstream = new ZipInputStream(url.openStream());
            for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream
                    .getNextEntry()) {
                int i = (int) zipentry.getSize();
                String s = zipentry.getName();
                byte abyte0[] = new byte[i];
                int j = 0;
                int k;
                for (; i > 0; i -= k) {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }

                if ("kaff.jpg".equals(s)) {
                    kaff = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("cars.png".equals(s)) {
                    carsbg = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("carstarter.png".equals(s)) {
                    carstarter = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("carstreetelites.png".equals(s)) {
                    carstreetelites = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("carfuriousfour.png".equals(s)) {
                    carfuriousfour = loadimage(abyte0, mediatracker, toolkit);
                }
                
                if ("statbostart.gif".equals(s)) {
                    statbostart = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("statbose.gif".equals(s)) {
                    statbose = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("statboff.gif".equals(s)) {
                    statboff = loadimage(abyte0, mediatracker, toolkit);
                }
                
                if ("statbstart.gif".equals(s)) {
                    statbstart = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("statbse.gif".equals(s)) {
                    statbse = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("statbff.gif".equals(s)) {
                    statbff = loadimage(abyte0, mediatracker, toolkit);
                }
                
                
                
                
                
                if ("smokey.gif".equals(s)) {
                    smokeypix(abyte0, mediatracker, toolkit);
                }
                if ("1.gif".equals(s)) {
                    orank[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("gameh.gif".equals(s)) {
                    ogameh = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("gameov.gif".equals(s)) {
                    gameov = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("landrover.png".equals(s)) {
                    landrover = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("lap.gif".equals(s)) {
                    olap = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("paused.gif".equals(s)) {
                    paused = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("select.gif".equals(s)) {
                    select = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("yourwasted.gif".equals(s)) {
                    oyourwasted = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("youwastedem.gif".equals(s)) {
                    oyouwastedem = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("d1.gif".equals(s)) {
                    dude[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("d2.gif".equals(s)) {
                    dude[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("d3.gif".equals(s)) {
                    dude[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("float.gif".equals(s)) {
                    oflaot = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("1c.gif".equals(s)) {
                    ocntdn[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("2c.gif".equals(s)) {
                    ocntdn[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("3c.gif".equals(s)) {
                    ocntdn[3] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("2.gif".equals(s)) {
                    orank[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("3.gif".equals(s)) {
                    orank[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("4.gif".equals(s)) {
                    orank[3] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("5.gif".equals(s)) {
                    orank[4] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("6.gif".equals(s)) {
                    orank[5] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("7.gif".equals(s)) {
                    orank[6] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("bgmain.png".equals(s)) {
                    bgmain = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("br.png".equals(s)) {
                    br = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("brse.png".equals(s)) {
                    brse = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("loadingmusic.gif".equals(s)) {
                    oloadingmusic = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("radicalplay.gif".equals(s)) {
                    radicalplay = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("back.gif".equals(s)) {
                    back[0] = loadimage(abyte0, mediatracker, toolkit);
                    back[1] = bressed(back[0]);
                }
                if ("backstarter.gif".equals(s)) {
                    backstart = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("backse.gif".equals(s)) {
                    backse  = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("continue2.gif".equals(s)) {
                    contin[0] = loadimage(abyte0, mediatracker, toolkit);
                    contin[1] = bressed(contin[0]);
                }
                if ("next.gif".equals(s)) {
                    next[0] = loadimage(abyte0, mediatracker, toolkit);
                    next[1] = bressed(next[0]);
                }
                if ("nextstarter.gif".equals(s)) {
                    nextstart = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("nextse.gif".equals(s)) {
                    nextse = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("pgate.gif".equals(s)) {
                    pgate = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("rpro.gif".equals(s)) {
                    rpro = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("track1.jpg".equals(s)) {
                    trackbg[0][0] = loadimage(abyte0, mediatracker, toolkit);
                    trackbg[1][0] = dodgen(trackbg[0][0]);
                }
                if ("splash.png".equals(s)) {
                    splash = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("track2.jpg".equals(s)) {
                    trackbg[0][1] = loadimage(abyte0, mediatracker, toolkit);
                    trackbg[1][1] = dodgen(trackbg[0][1]);
                }
                if ("toyota.png".equals(s)) {
                    toyota = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("youlost.gif".equals(s)) {
                    oyoulost = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("youwon.gif".equals(s)) {
                    oyouwon = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("0c.gif".equals(s)) {
                    ocntdn[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("damage.gif".equals(s)) {
                    odmg = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("power.gif".equals(s)) {
                    opwr = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("position.gif".equals(s)) {
                    opos = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("wasted.gif".equals(s)) {
                    owas = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("wastedtext.png".equals(s)) {
                    wastedtext = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("laptext.png".equals(s)) {
                    laptext = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("postext.png".equals(s)) {
                    postext = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("timetext.png".equals(s)) {
                    timetext = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("kph.png".equals(s)) {
                    kph = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("powerbar.png".equals(s)) {
                    powerbar = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("damagebar.png".equals(s)) {
                    damagebar = loadimage(abyte0, mediatracker, toolkit);
                }
         
                if ("start1.gif".equals(s)) {
                    ostar[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("start2.gif".equals(s)) {
                    ostar[1] = loadimage(abyte0, mediatracker, toolkit);
                    star[2] = pressed(ostar[1]);
                }
                if ("congrad.gif".equals(s)) {
                    congrd = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("madness.gif".equals(s)) {
                    mdness = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("fixhoop.gif".equals(s)) {
                    fixhoop = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("arrow.gif".equals(s)) {
                    sarrow = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("stunts.gif".equals(s)) {
                    stunts = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("racing.gif".equals(s)) {
                    racing = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("wasting.gif".equals(s)) {
                    wasting = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("plus.gif".equals(s)) {
                    plus = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("space.gif".equals(s)) {
                    space = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("arrows.gif".equals(s)) {
                    arrows = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("chil.gif".equals(s)) {
                    chil = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("ory.gif".equals(s)) {
                    ory = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("overlay.png".equals(s)) {
                    overlay = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("overlaystatus.png".equals(s)) {
                    overlaystatus = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("hunting.png".equals(s)) {
                    hunting = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("inst1.png".equals(s)) {
                    inst1 = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("inst2.png".equals(s)) {
                    inst2 = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("inst4.png".equals(s)) {
                    inst4 = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("inst6.png".equals(s)) {
                    inst6 = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("inst8.png".equals(s)) {
                    inst8 = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("instback.png".equals(s)) {
                    instback = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("kz.gif".equals(s)) {
                    kz = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("kx.gif".equals(s)) {
                    kx = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("kv.gif".equals(s)) {
                    kv = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("kp.gif".equals(s)) {
                    kp = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("km.gif".equals(s)) {
                    km = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("kn.gif".equals(s)) {
                    kn = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("kenter.gif".equals(s)) {
                    kenter = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("nfm.gif".equals(s)) {
                    nfm = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("options.gif".equals(s)) {
                    opti = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("opback.gif".equals(s)) {
                    opback = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("logocars.gif".equals(s)) {
                    logocars = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("logomadmess.gif".equals(s)) {
                    logomadnes = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("logomadbg.gif".equals(s)) {
                    logomadbg = loadimage(abyte0, mediatracker, toolkit);
                }
                 if ("lotus.png".equals(s)) {
                  lotus = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("byrd.gif".equals(s)) {
                    byrd = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("nfmcoms.gif".equals(s)) {
                    nfmcoms = loadimage(abyte0, mediatracker, toolkit);
                }
                if ("nfmcom.gif".equals(s)) {
                    nfmcom = loadimage(abyte0, mediatracker, toolkit);
                }
                howManyImages++;
                dnload += 3;
            }           
            zipinputstream.close();
            System.out.println("Images loaded: " + howManyImages);
        } catch (IOException e) {
            System.out.println("Error Reading Images: " + e);
            e.printStackTrace();
        }
        System.gc();
    }
    
    /**Loads images from the web
     * 
     * @author Kaffeinated
     */
    public void loadnetworkimages() {
        Utility.startTimer();
        dnload += 12;
        try {
            aimLogo = Utility.webGet("http://i59.servimg.com/u/f59/14/03/33/42/logo10.png"); ///aim games logo
            
            /// URL goes here
            // 
            dnload += 3;
        } catch (Exception exception) {
            System.out.println("Error Loading Network Images: " + exception);
        }
        System.gc();
        Utility.stopTimer();
    }

    public void pausedgame(int i, Control control, Record record) {
        rd.drawImage(fleximg, 0, 0, null);
        if (control.up) {
            opselect--;
            if (opselect == -1) {
                opselect = 3;
            }
            control.up = false;
        }
        if (control.down) {
            opselect++;
            if (opselect == 4) {
                opselect = 0;
            }
            control.down = false;
        }
        if (opselect == 0) {
            rd.setColor(new Color(255, 167, 51));
            rd.fillRoundRect(349, 100, 195, 28, 7, 24);
            //x,y,xlen,ylen,linesize,cornersize
            if (shaded) {
                rd.setColor(new Color(225, 200, 255));
            } else {
                rd.setColor(new Color(182, 0, 0));
            }
            rd.drawRoundRect(349, 100, 195, 28, 7, 24);
        }
        if (opselect == 1) {
            rd.setColor(new Color(255, 167, 51));
            rd.fillRoundRect(387, 132, 118, 28, 7, 24);
            if (shaded) {
                rd.setColor(new Color(225, 200, 255));
            } else {
                rd.setColor(new Color(182, 0, 0));
            }
            rd.drawRoundRect(387, 132, 118, 28, 7, 24);
        }
        if (opselect == 2) {
            rd.setColor(new Color(255, 167, 51));
            rd.fillRoundRect(349, 168, 195, 28, 7, 24);
            if (shaded) {
                rd.setColor(new Color(225, 200, 255));
            } else {
                rd.setColor(new Color(182, 0, 0));
            }
            rd.drawRoundRect(349, 168, 195, 28, 7, 24);
        }
        if (opselect == 3) {
            rd.setColor(new Color(255, 167, 51));
            rd.fillRoundRect(395, 201, 107, 28, 7, 24);
            if (shaded) {
                rd.setColor(new Color(225, 200, 255));
            } else {
                rd.setColor(new Color(182, 0, 0));
            }
            rd.drawRoundRect(395, 201, 107, 28, 7, 24);
        }
        rd.drawImage(paused, 331, 65, null);
        if (control.enter || control.handb) {
            if (opselect == 0) {
                if (loadedt[i - 1] && !mutem) {
                      if(isMidi[i - 1]) {
                     System.out.println("Unmute check > play midi...");
                     mtracks[i - 1].resume();
                      } else {
                        System.out.println("Unmute check > play mod...");
                     stracks[i - 1].resume();
                   }
                }
                fase = 0;
            }
            if (opselect == 1) {
                if (record.caught >= 300) {
                    if (loadedt[i - 1] && !mutem) {
                          if(isMidi[i - 1]) {
                       System.out.println("Unmute check > play midi...");
                       mtracks[i - 1].resume();
                        } else {
                       System.out.println("Unmute check > play mod...");
                       stracks[i - 1].resume();
                      }
                    }
                    fase = -1;
                } else {
                    fase = -8;
                }
            }
            if (opselect == 2) {
                if (loadedt[i - 1]) {
                     if(isMidi[i - 1]) {
                          mtracks[i - 1].setPaused(true);
                          } else {
                           stracks[i - 1].stop();
                       }
                }
                oldfase = -7;
                fase = 11;
            }
            if (opselect == 3) {
                if (loadedt[i - 1]) {
                     if(isMidi[i - 1]) {
                          mtracks[i - 1].setPaused(true);
                          } else {
                           stracks[i - 1].stop();
                       }
                }
                fase = 10;
                opselect = 0;
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void credits(Control control) {
        if (flipo == 0) {
            firewasted.play();
            flipo = 1;
            bgmy[0] = 0;
            bgmy[1] = 500;
        }
        if (flipo >= 1 && flipo <= 100) {
            rad(flipo, 0);
            flipo++;
            if (flipo == 100) {
                flipo = 1;
            }
        }
        if (flipo == 101) {
            int i = 0;
            do {
                rd.drawImage(bgmain, 0, bgmy[i], null);
                bgmy[i] -= 10;
                if (bgmy[i] <= -500) {
                    bgmy[i] = 500;
                }
            } while (++i < 2);
            rd.drawImage(mdness, 218, 7, null);
            rd.setFont(new Font("SansSerif", 1, 13));
            FontHandler.fMetrics = rd.getFontMetrics();
            drawcs(65, "At Radicalplay.com", 0, 0, 0, 3);
            drawcs(100, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            drawcs(120, "Everything By Omar Waly", 70, 70, 70, 3);
            rd.setFont(new Font("SansSerif", 1, 13));
            FontHandler.fMetrics = rd.getFontMetrics();
            drawcs(180, "Thanks for Game Testing", 0, 0, 0, 3);
            rd.setFont(new Font("SansSerif", 1, 11));
            FontHandler.fMetrics = rd.getFontMetrics();
            drawcs(200, "Soufy H Abutaleb, Sherif Abouzeid,", 90, 90, 90, 3);
            drawcs(215, "Kareem Mansour, Youssef Wahby,", 90, 90, 90, 3);
            drawcs(230, "Taymour Farid, Mahmoud Waly", 90, 90, 90, 3);
            drawcs(245, "and Mahmoud Ezzeldin (Turbo)", 90, 90, 90, 3);
            rd.setFont(new Font("SansSerif", 1, 13));
            FontHandler.fMetrics = rd.getFontMetrics();
            drawcs(340, "Music was obtained from the ModArchive.org", 0, 0, 0, 3);
            rd.setFont(new Font("SansSerif", 1, 11));
            FontHandler.fMetrics = rd.getFontMetrics();
            drawcs(360, "All tracks where remixed to fit game by Omar Waly", 90, 90, 90, 3);
            drawcs(380, "For more details about the music: http://www.radicalplay.com/madcars/music.html", 90, 90, 90,
                    3);
        }
        if (flipo == 102) {
            int i = 0;
            do {
                rd.drawImage(bgmain, 0, bgmy[i], null);
                bgmy[i] -= 10;
                if (bgmy[i] <= -500) {
                    bgmy[i] = 500;
                }
            } while (++i < 2);
            rd.setFont(new Font("SansSerif", 1, 13));
            FontHandler.fMetrics = rd.getFontMetrics();
            //////////////////////////////////////////////////////////////////////
            drawcs(100, "These files have been edited and enhanced by Kaffeinated", 0, 0, 0, 3);

            drawcs(180, "Thanks for help and suggestions goes to", 0, 0, 0, 3);
            rd.setFont(new Font("SansSerif", 1, 11));
            FontHandler.fMetrics = rd.getFontMetrics();
            drawcs(200, "Chaotic for help with NFMM graphics", 90, 90, 90, 3);
            drawcs(215, "DragShot for his opponent status and desktop hack", 90, 90, 90, 3);
            drawcs(230, "Ten Graves, Phyrexian, and Hyde233 for bug fixes", 90, 90, 90, 3);

            //////////////////////////////////////////////////////////////////////
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(0, 347, 900, 500);
            rd.drawImage(kaff, 0, 347, null);
        }
        if (flipo == 103) {
            int j = 0;
            do {
                rd.drawImage(bgmain, 0, bgmy[j], null);
                bgmy[j] -= 16;
                if (bgmy[j] <= -500) {
                    bgmy[j] = 500;
                }
            } while (++j < 2);
            rd.drawImage(nfmcom, 125, 170, null);
        }
        if (flipo == 102) {
            rd.drawImage(next[pnext], 600, 10, null);
        } else {
            rd.drawImage(next[pnext], 600, 370, null);
        }
        if (control.enter || control.handb || control.right) {
            if (flipo >= 1 && flipo <= 100) {
                flipo = 101;
                app.setCursor(new Cursor(0));
            } else {
                flipo++;
            }
            if (flipo == 104) {
                flipo = 0;
                fase = 10;
            }
            control.enter = false;
            control.handb = false;
            control.right = false;
        }
    }   

    public void stat(Madness madness[],  CheckPoints checkpoints, Control control, ContO conto[], boolean flag)  {    
        if (holdit) {
            holdcnt++;
            if (m.flex != 0) {
                m.flex = 0;
            }
            if (control.enter || holdcnt > 250) {
                fase = -2;
                control.enter = false;
            }
        } else {
            if (holdcnt != 0) {
                holdcnt = 0;
            }
            if (control.enter) {
                if (loadedt[checkpoints.stage - 1]) {
                    if(isMidi[checkpoints.stage - 1]) {
                    mtracks[checkpoints.stage - 1].setPaused(true);
                   } else {
                    stracks[checkpoints.stage - 1].stop();
                  }
                }
                fase = -6;
                control.enter = false;
            }
        }
        if (fase != -2) {
            holdit = false;
            if (checkpoints.wasted == nplayers - 1) {
                if (m.flex != 2) {
                    rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                    rd.fillRect(341, 70, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                    rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                    rd.drawRect(341, 70, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                }
                rd.drawImage(youwastedem, 341, 70, null);
                if (aflk) {
                    drawcs(120, "You Won, all cars have been wasted!", 180, 0, 0, 0);
                    drawcs(140, "You have mastered this stage!", 180, 0, 0, 0);
                    drawcs(420, "Press  [ Enter ]  to continue", 180, 0, 0, 0);
                    aflk = false;
                } else {
                    drawcs(120, "You Won, all cars have been wasted!", 230, 0, 0, 0);
                    drawcs(140, "You have mastered this stage!", 230, 0, 0, 0);
                    drawcs(420, "Press  [ Enter ]  to continue", 230, 0, 0, 0);
                    aflk = true;
                }
                checkpoints.haltall = true;
                holdit = true;
                winner = true;
            }
            if (!holdit && madness[0].dest && cntwis == 8) {
                if (m.flex != 2) {
                    rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                    rd.fillRect(347, 70, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                    rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                    rd.drawRect(347, 70, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                }
                rd.drawImage(yourwasted, 347, 70, null);
                drawcs(420, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                holdit = true;
                winner = false;
            }
            if (!holdit) {
                int i = 0;
                do {
                    if (checkpoints.clear[i] == checkpoints.nlaps * checkpoints.nsp && checkpoints.pos[i] == 0) {
                        if (i == 0) {
                            if (m.flex != 2) {
                                rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                                rd.fillRect(383, 70, youwon.getWidth(ob), youwon.getHeight(ob));
                                rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                                rd.drawRect(383, 70, youwon.getWidth(ob), youwon.getHeight(ob));
                            }
                            rd.drawImage(youwon, 383, 70, null);
                            if (aflk) {
                                drawcs(120, "You finished first, nice job!", 180, 0, 0, 0);
                                drawcs(140, "You have mastered this stage!", 180, 0, 0, 0);
                                drawcs(420, "Press  [ Enter ]  to continue", 180, 0, 0, 0);
                                aflk = false;
                            } else {
                                drawcs(120, "You finished first, nice job!", 230, 0, 0, 0);
                                drawcs(140, "You have mastered this stage!", 230, 0, 0, 0);
                                drawcs(420, "Press  [ Enter ]  to continue", 230, 0, 0, 0);
                                aflk = true;
                            }
                            winner = true;
                        } else {
                            if (m.flex != 2) {
                                rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                                rd.fillRect(386, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                                rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                                rd.drawRect(386, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                            }
                            rd.drawImage(youlost, 386, 70, null);
                            if (aflk) {
                                drawcs(120, "" + names[sc[i]] + " finished first, race over!", 180, 0, 0, 0);
                                drawcs(140, "Better luck next time, maybe take a break and try again?", 180, 0, 0, 0);
                                aflk = false;
                            } else {
                                drawcs(120, "" + names[sc[i]] + " finished first, race over!", 230, 0, 0, 0);
                                drawcs(140, "Better luck next time, maybe take a break and try again?", 230, 0, 0, 0);
                                aflk = true;
                            }
                            winner = false;
                        }
                        drawcs(420, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                        checkpoints.haltall = true;
                        holdit = true;
                    }
                } while (++i < nplayers);
            }
            if (flag) {
                if (checkpoints.stage != 110 && arrace != control.arrace) {
                    arrace = control.arrace;
                    if (arrace) {
                        wasay = true;
                        say = ">> Arrow now pointing at  Cars  <<";
                        tcnt = -5;
                    }
                    if (!arrace) {
                        wasay = false;
                        say = ">> Arrow now pointing at  Track  <<";
                        tcnt = -5;
                        cntan = 20;
                    }
                }
                
                if(!control.toggle){
                         rd.drawImage(overlay, 0, 0, null);
                       } 
                if(starcnt > 0) {
                   rd.setColor(new Color(255, 255, 255));
                   rd.setFont(new Font("Adventure", 1, 35));
                   FontHandler.fMetrics = rd.getFontMetrics();
                   rd.drawString("Loading Opponent Status...",220, 482);
                }
                
                if (!holdit && fase != -6 && starcnt == 0) {
                    
                    int num_cars = nplayers;
                    for (int array_one = 0; array_one < num_cars; array_one++) {
                        boolean flag_status = false;
                        for (int array_two = 0; array_two < num_cars; array_two++) {
                            if (checkpoints.pos[array_two] == array_one && checkpoints.dested[array_two] == 0 && !flag_status) {
                                int y_value = 32; // use to move status up or down
                                int x_value = 105;  // use to move status left or right
                                
                                rd.setFont(new Font("Adventure", 1, 15));
                                FontHandler.fMetrics = rd.getFontMetrics();
                                
                                
 
                                rd.setColor(new Color(255, 255, 255));
                                if (array_one == 0)
                                    rd.drawString("1st",21 + x_value * array_one, 490);
                                if (array_one == 1)
                                    rd.drawString("2nd",21 + x_value * array_one, 490);
                                if (array_one == 2)
                                    rd.drawString("3rd",21 + x_value * array_one, 490);
                                if (array_one >= 3)
                                    rd.drawString((array_one + 1)+"th", 21 + x_value * array_one, 490);
                                    
                                    
                                    
                                rd.setColor(new Color(255, 255, 255));
                                rd.drawString(names[sc[array_two]], 29 + x_value * array_one, 472);
                                if (madness[0].im == array_two){
                                    int red = (int) (159.0F + (159.0F * ((float) m.snap[0] / 100.0F)));
                                    if (red > 255)
                                        red = 255;
                                    if (red < 0)
                                        red = 0;
                                    int green = (int) (207.0F + (207.0F * ((float) m.snap[1] / 100.0F)));
                                    if (green > 255)
                                        green = 255;
                                    if (green < 0)
                                        green = 0;
                                    int blue = (int) (255.0F + (255.0F * ((float) m.snap[2] / 100.0F)));
                                    if (blue > 255)
                                        blue = 255;
                                    if (blue < 0)
                                        blue = 0;
                                    rd.setColor(new Color(182, 0, 0));
                                    rd.drawRect(19 + x_value * array_one, 456, 105, 35);
                                    //rd.drawRect(531 1 less + x_value, 58 1 less + y_value + 30 * array_one, 114, 25);
                                    
                                }
                                if(arrace) {
                                    int dmg = (int)(60F * ((float)madness[array_two].hitmag / (float)madness[array_two].maxmag[sc[array_two]]));
 
                                    int red = 244;
                                    int green = 244;
                                    int blue = 11;
 
                                    if(dmg > 20)
                                        green = (int)(244F - 233F * ((float)(dmg - 20) / 40F));
 
                                    red = (int)((float)red + (float)red * ((float)m.snap[0] / 100F));
                                    if(dmg > 60)
                                        dmg = 60;
                                    if(red > 255)
                                        red = 255;
                                    if(red < 0)
                                        red = 0;
 
                                    green = (int)((float)green + (float)green * ((float)m.snap[1] / 100F));
                                    if(green > 255)
                                        green = 255;
                                    if(green < 0)
                                        green = 0;
 
                                    blue = (int)((float)blue + (float)blue * ((float)m.snap[2] / 100F));
                                    if(blue > 255)
                                        blue = 255;
                                    if(blue < 0)
                                        blue = 0;
 
                                    rd.setColor(new Color(red, green, blue));
                                    rd.fillRect(49 + x_value * array_one, 480, dmg, 5);
 
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawRect(49 + x_value * array_one, 480, 60, 5);
                                } else { //comeback
                                    float power = madness[array_two].power;
 
                                    int red = 128;
                                    if (power == 98F) {
                                        red = 64;
                                    }
                                    int green = (int) (190D + power * 0.37D);
                                    int blue = 244;
 
                                    if (auscnt < 45 && aflk) {
                                        red = 128;
                                        green = 244;
                                        blue = 244;
                                    }
                                    red = (int) (red + red * (m.snap[0] / 100F));
                                    if (red > 255) {
                                        red = 255;
                                    }
                                    if (red < 0) {
                                        red = 0;
                                    }
                                    green = (int) (green + green * (m.snap[1] / 100F));
                                    if (green > 255) {
                                        green = 255;
                                    }
                                    if (green < 0) {
                                        green = 0;
                                    }
                                    blue = (int) (blue + blue * (m.snap[2] / 100F));
                                    if (blue > 255) {
                                        blue = 255;
                                    }
                                    if (blue < 0) {
                                        blue = 0;
                                    }
 
                                    rd.setColor(new Color(red, green, blue));
                                    
                                    //rd.fillRect(565 + x_value, 75 + y_value + 30 * array_one, (int)((power / 98F) * 60F), 5);
                                    
                                    rd.fillRect(49 + x_value * array_one, 480,(int)((power / 98F) * 60F), 5);
                                    
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawRect(49 + x_value * array_one, 480, 60, 5);
                                }
                                flag_status = true;
                            }
                        }
                    }
                    
                    rd.setFont(new Font("SansSerif", 1, 11));
                    FontHandler.fMetrics = rd.getFontMetrics();
                    
                    
                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    arrow(madness[0].point, madness[0].missedcp, checkpoints, conto, control, arrace);
                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                    if (!arrace && auscnt == 45 && madness[0].capcnt == 0) {
                        if (madness[0].missedcp > 0) {
                            if (madness[0].missedcp > 15 && madness[0].missedcp < 50) {
                                if (flk) {
                                    drawcs(70, "Checkpoint Missed!", 255, 0, 0, 0);
                                } else {
                                    drawcs(70, "Checkpoint Missed!", 210, 0, 0, 2);
                                }
                            }
                            madness[0].missedcp++;
                            if (madness[0].missedcp == 70) {
                                madness[0].missedcp = -2;
                            }
                        } else if (madness[0].mtouch && cntovn < 70) {
                            if (Math.abs(ana) > 100) {
                                cntan++;
                            } else if (cntan != 0) {
                                cntan--;
                            }
                            if (cntan > 40) {
                                cntovn++;
                                cntan = 40;
                                if (flk) {
                                    drawcs(90, "Wrong Way!", 255, 0, 0, 0);
                                    flk = false;
                                } else {
                                    drawcs(90, "Wrong Way!", 210, 0, 0, 2);
                                    flk = true;
                                }
                            }
                        }
                    }
                }
                if (m.flex != 2 || m.flex == 2) { //ONSCREEN
                       rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                       
                    
                       
                       //ORANGE COLOR
                       rd.setColor(new Color(182, 0, 0));
                       rd.setFont(new Font("Adventure", 1, 15));
                    
                       //GUI TEXT
                      
                       rd.drawImage(laptext, 14, 21, null);
                       rd.drawImage(wastedtext, 108, 21, null);
                       
                       //TURN WHITE
                       rd.setColor(new Color(255, 255, 255));
                       //GUI TEXT
                       rd.drawImage(damagebar, 677, 21, null);
                       rd.drawImage(powerbar, 677, 47, null);
                       //LAPS
                       
                       rd.drawString("  " + (madness[0].nlaps + 1) + " / " + checkpoints.nlaps + "", 56, 40);
                     
                       rd.drawString("  " + checkpoints.wasted + " / " + (nplayers - 1), 181, 40);
                       //CHANGE SIZE
                       rd.setColor(new Color(182, 0, 0));
                       rd.setFont(new Font("Adventure", 1, 18));
                    
                       //POSITION
                       rd.drawImage(postext, 36, 50, null);
                       
                       //CHANGE WHITE
                       rd.setColor(new Color(255, 255, 255));
                       String suffix = "";
                       int position = checkpoints.pos[0] + 1;
                        if((position - 1) % 10 == 0 && position != 11)
                       {
                          suffix = "st";
                       }
                        if((position - 2) % 10 == 0 && position != 12)
                        {
                          suffix = "nd";
                       }
                        if((position - 3) % 10 == 0 && position != 13)
                        {
                          suffix = "rd";
                       }
                         if(position % 10 == 0 || position % 10 >= 4 || position == 11 || position == 12 || position == 13)
                          {
                           suffix = "th";
                       }
                       //CHANGE SIZE
                       rd.setFont(new Font("Adventure", 1, 30));
                       FontHandler.fMetrics = rd.getFontMetrics();
                       rd.drawString("" + position + suffix + "", 150, 76);
                       //CHANGE BACK}
                       
                       
                    
                       rd.setFont(new Font("Adventure", 1, 22));
                       FontHandler.fMetrics = rd.getFontMetrics();
                       
                       rd.setColor(new Color(182, 0, 0));
                       rd.drawImage(timetext, 27, 414, null);
                       rd.drawImage(kph, 790, 468, null);
                       rd.drawString("", 660,438);
                       //the timer
                       
                       if(!checkpoints.haltall && starcnt == 0) {
                         time++;
                        }
                       
                       int speed =(int) madness[0].speed ;
                       
                       int millis = time * 1000 / 21;
                       String timer = this.getTime(millis);
                      
                       rd.setColor(new Color(255, 255, 255));
                       rd.drawString(timer, 94, 434);
                       
                       
                       rd.drawString("" + speed, 847, 489);
                    
                       rd.setFont(new Font("SansSerif", 1, 11));
                       FontHandler.fMetrics = rd.getFontMetrics();
                    
                      
                    
                 }
                    m.flex++;
                } else {
                    if (posit != checkpoints.pos[madness[0].im]) {
                        rd.drawImage(rank[checkpoints.pos[madness[0].im]], 110, 28, null);
                        posit = checkpoints.pos[madness[0].im];
                    }
                    if (wasted != checkpoints.wasted) {
                        rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                        rd.fillRect(150, 8, 30, 10);
                        rd.setColor(new Color(255, 74, 86));
                        rd.drawString("" + checkpoints.wasted + " / 6", 150, 18);
                        wasted = checkpoints.wasted;
                    }
                    if (laps != madness[0].nlaps) {
                        rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                        rd.fillRect(51, 8, 40, 10);
                        rd.setColor(new Color(134, 33, 207));
                        rd.drawString("" + (madness[0].nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                        laps = madness[0].nlaps;
                    }
                }
                drawstat(Madness.maxmag[madness[0].cn], madness[0].hitmag, madness[0].newcar, madness[0].power);
            }
        if (!holdit) {
                if (starcnt != 0 && starcnt <= 35) {
                    if (starcnt == 35 && !mutes) {
                        three.play();
                    }
                    if (starcnt == 24) {
                        gocnt = 2;
                        if (!mutes) {
                            two.play();
                        }
                    }
                    if (starcnt == 13) {
                        gocnt = 1;
                        if (!mutes) {
                            one.play();
                        }
                    }
                    if (starcnt == 2) {
                        gocnt = 0;
                        if (!mutes) {
                            go.play();
                        }
                    }
                    duds = 0;
                    if (starcnt <= 37 && starcnt > 32) {
                        duds = 1;
                    }
                    if (starcnt <= 26 && starcnt > 21) {
                        duds = 1;
                    }
                    if (starcnt <= 15 && starcnt > 10) {
                        duds = 1;
                    }
                    if (starcnt <= 4) {
                        duds = 2;
                        m.flex = 0;
                    }
                    if (dudo != -1) {
                        rd.drawImage(dudeb[duds], dudo, 0, null);
                    }
                    if (gocnt != 0) {
                        rd.drawImage(cntdn[gocnt], 320, 50, null);
                    } else {
                        rd.drawImage(cntdn[gocnt], 298, 50, null);
                    }
                }
                if (looped != 0 && madness[0].loop == 2) {
                    looped = 0;
                }
                if (madness[0].power < 45F) {
                    if (tcnt == 30 && auscnt == 45 && madness[0].mtouch && madness[0].capcnt == 0) {
                        if (looped != 2) {
                            if (pwcnt < 70 || pwcnt < 160 && looped != 0) {
                                if (pwflk) {
                                    drawcs(110, "Power low, perform stunt!", 255, 227, 156, 0);
                                    pwflk = false;
                                } else {
                                    drawcs(110, "Power low, perform stunt!", 255, 192, 33 ,0);
                                    pwflk = true;
                                }
                            }
                        } else if (pwcnt < 250) {
                            if (pwflk) {
                                drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 255, 192, 33, 0);
                                drawcs(120, "To learn how to preform STUNTS!", 255, 192, 33 ,0);
                                pwflk = false;
                            } else {
                                drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 255, 227, 156, 0);
                                drawcs(120, "To learn how to preform STUNTS!", 255, 227, 156, 0);
                                pwflk = true;
                            }
                        }
                        pwcnt++;
                        if (pwcnt == 300) {
                            pwcnt = 0;
                            if (looped != 0) {
                                looped++;
                                if (looped == 3) {
                                    looped = 1;
                                }
                            }
                        }
                    }
                } else if (pwcnt != 0) {
                    pwcnt = 0;
                }
                if (madness[0].capcnt == 0) {
                    if (tcnt < 30) {
                        if (tflk) {
                            if (!wasay) {
                                drawcs(125, say, 230, 0, 0, 0);

                            } else {
                                drawcs(125, say, 230, 0, 0, 0);
                            }
                            tflk = false;
                        } else {
                            if (!wasay) {
                                drawcs(125, say,  255, 180, 0, 0);
                            } else {
                                drawcs(125, say,  255, 180, 0, 0);
                            }
                            tflk = true;
                        }
                        tcnt++;
                    } else if (wasay) {
                        wasay = false;
                    }
                    if (auscnt < 45) {
                        if (aflk) {
                            drawcs(105, asay, 230, 0, 0, 0);
                            aflk = false;
                        } else {
                            drawcs(105, asay, 255, 180, 0,  0);
                            aflk = true;
                        }
                        auscnt++;
                    }
                    if(arrace) {
                      rd.setFont(new Font("Adventure", 1, 13));
                      FontHandler.fMetrics = rd.getFontMetrics();
                      drawcs(433,">> Car Status now showing Enemy Damage <<", 230, 0, 0, 0);
                    } else {
                      rd.setFont(new Font("Adventure", 1, 13));
                      FontHandler.fMetrics = rd.getFontMetrics();
                      drawcs(433,">> Car Status now showing Power <<", 230, 0, 0, 0);
                      rd.setFont(new Font("SansSerif", 1, 11));
                      FontHandler.fMetrics = rd.getFontMetrics();
                    }
                } else if (tflk) {
                    drawcs(125, "Bad Landing!", 255, 180, 0, 0);
                    tflk = false;
                } else {
                    drawcs(125, "Bad Landing!", 255, 180, 0, 0);
                    tflk = true;
                }
                if (madness[0].trcnt == 10) {
                    loop = "";
                    spin = "";
                    asay = "";
                    int j;
                    for (j = 0; madness[0].travzy > 225; j++) {
                        madness[0].travzy -= 360;
                    }

                    while (madness[0].travzy < -225) {
                        madness[0].travzy += 360;
                        j--;
                    }
                    if (j == 1) {
                        loop = "Frontflip";
                    }
                    if (j == 2) {
                        loop = "Double Frontflip";
                    }
                    if (j == 3) {
                        loop = "Triple Frontflip";
                    }
                    if (j >= 4) {
                        loop = "Ultra Flip";
                    }
                    if (j == -1) {
                        loop = "Backflip";
                    }
                    if (j == -2) {
                        loop = "Double Backflip";
                    }
                    if (j == -3) {
                        loop = "Triple Backflip";
                    }
                    if (j <= -4) {
                        loop = "Mega Flip";
                    }
                    if (j == 0) {
                        if (madness[0].ftab && madness[0].btab) {
                            loop = "Tabletop and reversed Tabletop";
                        } else if (madness[0].ftab || madness[0].btab) {
                            loop = "Tabletop";
                        }
                    }
                    if (j > 0 && madness[0].btab) {
                        loop = "Radical " + loop;
                    }
                    if (j < 0 && madness[0].ftab) {
                        loop = "Radical " + loop;
                    }
                    if (!("").equals(loop)) {
                        asay += " " + loop;
                    }
                    j = 0;
                    for (madness[0].travxy = Math.abs(madness[0].travxy); madness[0].travxy > 270;) {
                        madness[0].travxy -= 360;
                        j++;
                    }

                    if (j == 0 && madness[0].rtab) {
                        if (("").equals(loop)) {
                            spin = "Tabletop";
                        } else {
                            spin = "Flipside";
                        }
                    }
                    if (j == 1) {
                        spin = "Rollspin";
                    }
                    if (j == 2) {
                        spin = "Double Rollspin";
                    }
                    if (j == 3) {
                        spin = "Triple Rollspin";
                    }
                    if (j >= 4) {
                        spin = "Super Rollspin";
                    }
                    j = 0;
                    boolean flag1 = false;
                    for (madness[0].travxz = Math.abs(madness[0].travxz); madness[0].travxz > 90;) {
                        madness[0].travxz -= 180;
                        if ((j += 180) > 900) {
                            j = 900;
                            flag1 = true;
                        }
                    }

                    if (j != 0) {
                        if (("").equals(loop) && ("").equals(spin)) {
                            asay += " " + j;
                            if (flag1) {
                                asay += " and beyond";
                            }
                        } else {
                            if (!("").equals(loop)) {
                                if (("").equals(loop)) {
                                    asay += " " + spin;
                                } else {
                                    asay += " with " + spin;
                                }
                            }
                            asay += " by " + j;
                            if (flag1) {
                                asay += " and beyond";
                            }
                        }
                    } else if (!("").equals(spin)) {
                        if (("").equals(loop)) {
                            asay += " " + spin;
                        } else {
                            asay += " by " + spin;
                        }
                    }
                    if (!("").equals(asay)) {
                        auscnt -= 15;
                    }
                    if (!("").equals(loop)) {
                        auscnt -= 25;
                    }
                    if (!("").equals(spin)) {
                        auscnt -= 25;
                    }
                    if (j != 0) {
                        auscnt -= 25;
                    }
                    if (auscnt < 45) {
                        if (!mutes) {
                            powerup.play();
                        }
                        if (auscnt < -20) {
                            auscnt = -20;
                        }
                        byte byte0 = 0;
                        if (madness[0].powerup > 20F) {
                            byte0 = 1;
                        }
                        if (madness[0].powerup > 40F) {
                            byte0 = 2;
                        }
                        if (madness[0].powerup > 150F) {
                            byte0 = 3;
                        }
                        if (madness[0].surfer) {
                            asay = " " + adj[4][(int) (m.random() * 3F)] + asay;
                        }
                        if (byte0 != 3) {
                            asay = adj[byte0][(int) (m.random() * 3F)] + asay + exlm[byte0];
                        } else {
                            asay = adj[byte0][(int) (m.random() * 3F)];
                        }
                        if (!wasay) {
                            tcnt = auscnt;
                            if (madness[0].power != 98F) {
                                say = "Power Refilled " + (int) ((100F * madness[0].powerup) / 98F) + "%";
                            } else {
                                say = "Power FULL";
                            }
                            if (skidup) {
                                skidup = false;
                            } else {
                                skidup = true;
                            }
                        }
                    }
                }
                if (madness[0].newcar) {
                    if (!wasay) {
                        say = "Car Repaired";
                        tcnt = 0;
                    }
                    if (crashup) {
                        crashup = false;
                    } else {
                        crashup = true;
                    }
                }
                if (clear != madness[0].clear && madness[0].clear != 0) {
                    if (!wasay) {
                        say = "Checkpoint!";
                        tcnt = 15;
                    }
                    clear = madness[0].clear;
                    if (!mutes) {
                        checkpoint.play();
                    }
                    cntovn = 0;
                    if (cntan != 0) {
                        cntan = 0;
                    }
                }
                int k = 1;
                do {
                    if (dested[k] != checkpoints.dested[k]) {
                        dested[k] = checkpoints.dested[k];
                        if (dested[k] == 1) {
                            wasay = true;
                            say = "" + names[sc[k]] + " has been wasted!";
                            tcnt = -15;
                        }
                        if (dested[k] == 2) {
                            wasay = true;
                            say = "You wasted " + names[sc[k]] + "!";
                            tcnt = -15;
                        }
                    }
                } while (++k < nplayers);
                
            }
        }
    

    public void finish(CheckPoints checkpoints, ContO aconto[], Control control) {
        rd.drawImage(fleximg, 0, 0, null);
        if (winner) {
            if (checkpoints.stage == unlocked) {
                if (checkpoints.stage != 25) {
                    rd.drawImage(congrd, 315, 30, null);
                    drawcs(80, "Stage " + checkpoints.stage + " Completed!", 170, 170, 170, 3);
                } else {
                    rd.drawImage(congrd, 315 + (int) (m.random() * 10F), 30, null);
                }
                byte byte0 = 0;
                int i = 0;
                pin = 60;
                if (checkpoints.stage == 3) {
                    byte0 = 6;
                    i = 265;
                    pin = 0;
                    sc[0] = 6;
                }
                if (checkpoints.stage == 6) {
                    byte0 = 7;
                    i = 240;
                    pin = 0;
                    sc[0] = 7;
                }
                if (checkpoints.stage == 9) {
                    byte0 = 8;
                    i = 290;
                    pin = 0;
                    sc[0] = 8;
                }
                if (checkpoints.stage == 12) {
                    byte0 = 9;
                    i = 226;
                    pin = 0;
                    sc[0] = 9;
                }
                if (checkpoints.stage == 15) {
                    byte0 = 10;
                    i = 200;
                    pin = 0;
                    sc[0] = 10;
                }
                if (checkpoints.stage == 18) {
                    byte0 = 11;
                    i = 200;
                    pin = 0;
                    sc[0] = 11;
                }
                if (checkpoints.stage == 21) {
                    byte0 = 12;
                    i = 270;
                    pin = 0;
                    sc[0] = 12;
                }
                if (checkpoints.stage == 24) {
                    byte0 = 13;
                    i = 290;
                    pin = 0;
                    sc[0] = 13;
                }
                if (checkpoints.stage != 25) {
                    rd.setFont(new Font("SansSerif", 1, 13));
                    FontHandler.fMetrics = rd.getFontMetrics();
                    if (aflk) {
                        drawcs(120 + pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked!", 182, 0, 0, 3);
                    } else {
                        drawcs(120 + pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked!", 255, 255, 255, 3);
                    }
                    if (byte0 != 0) {
                        if (aflk) {
                            drawcs(140, "And:", 182, 0, 0, 3);
                        } else {
                            drawcs(140, "And:", 255, 0, 0, 3);
                        }
                        rd.setColor(new Color(255, 170, 0));
                        float f = (float) Math.random();
                        if (f < 0.69999999999999996D) {
                            rd.drawRect(275, 170, 349, 126);
                        } else {
                            rd.fillRect(275, 170, 350, 127);
                        }
                        rd.setColor(new Color(255, 100, 0));
                        rd.fillRect(276, 170, 348, 4);
                        rd.fillRect(276, 170, 4, 125);
                        rd.fillRect(276, 292, 348, 4);
                        rd.fillRect(624, 170, 4, 125);
                        aconto[byte0].y = i;
                        aconto[sc[0]].blackout = false;
                        m.crs = true;
                        m.x = -450;
                        m.y = -260;
                        m.z = -50;
                        m.xz = 0;
                        m.zy = 0;
                        aconto[sc[0]].z = 1000; //zoom car
                        aconto[sc[0]].y = 0 - aconto[sc[0]].grat;; //y positioning - IDK
                        aconto[sc[0]].x = 0; //x positioning
                        aconto[sc[0]].xz = -90; //normal spin
                        //aconto[sc[0]].xy += 0; //barrel roll
                        aconto[sc[0]].zy = 0; //backflips
                        aconto[sc[0]].wzy -= 10; //wheels
                        //custom spin, Thanks IP
                        if (aconto[sc[0]].xy >= 90 || aconto[sc[0]].xy <= 0)
                          {
                             currentRotation *= -1;
                             }
                        aconto[sc[0]].xy += currentRotation;
                        nameOfNewVariable = aconto[sc[0]].xy;
                        m.ground = 2470;
                        aconto[byte0].d(rd);
                  
                        String s = "";
                        if (byte0 == 13) {
                            s = " ";
                        }
                        if (aflk) {
                            drawcs(400, "" + names[byte0] + "" + s + " has been unlocked!", 182, 0, 0, 3);
                        } else {
                            drawcs(400, "" + names[byte0] + "" + s + " has been unlocked!", 255, 0, 0, 3);
                        }
                        pin = 180;
                    }
                    rd.setFont(new Font("SansSerif", 1, 11));
                    FontHandler.fMetrics = rd.getFontMetrics();
                    drawcs(140 + pin, "GAME SAVED", 182, 0, 0, 3);
                    if (pin == 60) {
                        pin = 30;
                    } else {
                        pin = 0;
                    }
                } else {
                    rd.setFont(new Font("SansSerif", 1, 13));
                    FontHandler.fMetrics = rd.getFontMetrics();
                    if (aflk) {
                        drawcs(90, "Woohoooo you finished the game!!!", 144, 167, 255, 3);
                    } else {
                        drawcs(90, "Woohoooo you finished the game!!!", 228, 240, 255, 3);
                    }
                    if (aflk) {
                        drawcs(140, "Your Awesome!", 144, 167, 255, 3);
                    } else {
                        drawcs(142, "Your Awesome!", 228, 240, 255, 3);
                    }
                    if (aflk) {
                        drawcs(190, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
                    } else {
                        drawcs(190, "You're truly a RADICAL GAMER!", 255, 100, 100, 3);
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 205, 900, 62);
                    rd.drawImage(radicalplay, radpx + (int) (8D * Math.random() - 4D), 205, null);
                    if (radpx != 147) {
                        radpx += 40;
                        if (radpx > 900) {
                            radpx = -453;
                        }
                    }
                    if (flipo == 40) {
                        radpx = 148;
                    }
                    flipo++;
                    if (flipo == 70) {
                        flipo = 0;
                    }
                    if (radpx == 147) {
                        rd.setFont(new Font("SansSerif", 1, 11));
                        FontHandler.fMetrics = rd.getFontMetrics();
                        if (aflk) {
                            drawcs(259, "A Game by Radicalplay.com", 144, 167, 255, 3);
                        } else {
                            drawcs(259, "A Game by Radicalplay.com", 228, 240, 255, 3);
                        }
                    }
                    if (aflk) {
                        drawcs(300, "Now get up and dance!", 144, 167, 255, 3);
                    } else {
                        drawcs(300, "Now get up and dance!", 228, 240, 255, 3);
                    }
                    pin = 0;
                }
                if (aflk) {
                    aflk = false;
                } else {
                    aflk = true;
                }
            } else {
                pin = 30;
                rd.drawImage(congrd, 315, 87, null);
                drawcs(137, "Stage " + checkpoints.stage + " Completed!", 170, 170, 170, 3);
                drawcs(154, "" + checkpoints.name + "", 128, 128, 128, 3);
            }
        } else {
            pin = 30;
            rd.drawImage(gameov, 280, 117, null);
            drawcs(167, "Failed to Complete Stage " + checkpoints.stage + "!", 170, 170, 170, 3);
            drawcs(184, "" + checkpoints.name + "", 128, 128, 128, 3);
        }
        rd.drawImage(contin[pcontin], 405, 450 - pin, null);
        if (control.enter || control.handb) {
            fase = 10;
            if (loadedt[checkpoints.stage - 1]) {
                if(isMidi[checkpoints.stage - 1]) {
                  mtracks[checkpoints.stage - 1].setPaused(true);
                 } else {
                  stracks[checkpoints.stage - 1].stop();
                }
            }
            if (checkpoints.stage == unlocked && winner && unlocked != 25) {
                checkpoints.stage++;
                unlocked++;
            }
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
    }
    
    public void sortcars(int i) {
		if (i == 6) {
		    sc[1] = 7;
		    sc[2] = 7;
		    sc[3] = 7;
		    sc[4] = 7;
		    sc[5] = 7;
		    sc[6] = 7;
		  }  else  if (i != 0) {
            int lastcar = nplayers;
            int startingcars = 6;
            
            // get boss car if player is not in the mad party, since that one has no boss car (you play as dr monstaa)
            
    
            if (sc[0] != (int)Math.floor((startingcars + (((float) i / 3) - 0.3f))) && i != 25) {  
                sc[nplayers - 1] = (int)Math.floor((startingcars + (((float) i / 3) - 0.3f)));
               
                if (sc[nplayers - 1] >= 13) {
                    sc[nplayers - 1] = 13 - 1; // you could put -= 5 or something here
                }
                lastcar--; // boss car won't be randomized
            }

            // DEBUG: Prints the range of possible cars to the console
            // System.out.println("Minimum car: " + cd.names[(i - 1) / 2] + ", maximum car: " + cd.names[nplayers + ((i - 1) / 2)] + ", therefore: " + (((i - 1) / 2) - (nplayers + ((i - 1) / 2))) + " car difference");

            // create a list of car ids, each item completely unique
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int k = (int)Math.floor(((((float) i / 3) - 0.3f))); k < (int)Math.floor((startingcars + (((float) i / 3) - 0.3f))); k++) {
                if (k == sc[0])
                    continue;
                list.add(new Integer(k));
            }
            // randomize the order of this list (shuffle it like a deck of cards)
            Collections.shuffle(list);

            // which item of the list should be picked
            int k = 0;

            for (int j = 1; j < lastcar; j++) {

                // get an item from the "deck" - this can be any item as long as it's unique
                sc[j] = list.get(k);
                k++;

                // if there are more cars than tracks, reduce the car index number until it fits.
                // unfortunately i have no idea how to make this work properly so we'll just have to ignore the duplicates here
                while (sc[j] >= 13) {
                    System.out.println("Car " + j + " is out of bounds");
                    sc[j] -= ThreadLocalRandom.current().nextDouble() * 5F;
                }
                //System.out.println("sc of " + j + " is " + sc[j]);
            }
        }
        // this error will never be thrown in a deployment environment
        // it is only here for extra safety
        for (int j = 0; j < 7; j++) {
            if (sc[j] > 13)
                throw new RuntimeException("there are too many tracks and not enough cars");
        }
    }
	
   

    public void sparkeng(int i) {
        i++;
        int j = 0;
        do {
            if (i == j) {
                if (!pengs[j]) {
                    engs[enginsignature[sc[0]]][j].loop();
                    pengs[j] = true;
                }
            } else if (pengs[j]) {
                engs[enginsignature[sc[0]]][j].stop();
                pengs[j] = false;
            }
        } while (++j < 5);
    }

    public void drawcs(int i, String s, int j, int k, int l, int i1) {
         if (i1 != 3 && i1 != 4) {
            j = (int) (j + j * (m.snap[0] / 100F));
            if (j > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            k = (int) (k + k * (m.snap[1] / 100F));
            if (k > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            l = (int) (l + l * (m.snap[2] / 100F));
            if (l > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        if (i1 == 4) {
            j = (int) (j - j * (m.snap[0] / 100F));
            if (j > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            k = (int) (k - k * (m.snap[1] / 100F));
            if (k > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            l = (int) (l - l * (m.snap[2] / 100F));
            if (l > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        if (i1 == 1) {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(s, (450 - FontHandler.fMetrics.stringWidth(s) / 2) + 1, i + 1);
        }
        if (i1 == 2) {
            j = (j * 2 + m.csky[0] * 1) / 3;
            if (j > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            k = (k * 2 + m.csky[1] * 1) / 3;
            if (k > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            l = (l * 2 + m.csky[2] * 1) / 3;
            if (l > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        rd.setColor(new Color(j, k, l));
        rd.drawString(s, 450 - FontHandler.fMetrics.stringWidth(s) / 2, i);
    }   

    public void trackbg(boolean flag) {
        int i = 0;
        trkl++;
        if (trkl > trklim) {
            i = 1;
            trklim = (int) (Math.random() * 40D);
            trkl = 0;
        }
        if (flag) {
            i = 0;
        }
        int j = 0;
        do {
            rd.drawImage(trackbg[i][j], trkx[j], 0, null);
            trkx[j]--;
            if (trkx[j] <= -900) {
                trkx[j] = 900;
            }
        } while (++j < 2);
    }

    public void stageselect(CheckPoints checkpoints, Control control) {
        for (int i = 0; i < 25; i++) {
            mtracks[i] = null;
            stracks[i] = null;
            isMidi[i] = false;
            loadedt[i] = false;
        } 
        
        
        if (checkpoints.stage != 1) {
            rd.drawImage(back[pback], 50, 350, null);
        }
        if (checkpoints.stage != 25) {
            rd.drawImage(next[pnext], 780, 350, null);
        }
        if (checkpoints.stage <= 12) {
            rd.drawImage(nextse, 780, 350, null); 
            if (checkpoints.stage != 1) {
            rd.drawImage(backse, 50, 350, null);
          }
            }
        if (checkpoints.stage >= 13 && checkpoints.stage != 25) {
            if (checkpoints.stage != 25) {
            rd.drawImage(next[pnext], 780, 350, null); 
           }
            rd.drawImage(back[pback], 50, 350, null);
            }
        
        rd.setFont(new Font("SansSerif", 1, 13));
        FontHandler.fMetrics = rd.getFontMetrics();
        
        if (checkpoints.stage <= 12) {
            rd.drawImage(brse, 0, 0, null); 
            }
        if (checkpoints.stage >= 13 && checkpoints.stage != 25) {
            rd.drawImage(br, 0, 0, null);
            }
        
        
        
        if (checkpoints.stage != 25) {
            drawcs(110, "Stage " + checkpoints.stage + "  >", 30, 30, 30, 3);
        } else {
            drawcs(110, "Final Party Stage  >", 30, 30, 30, 3);
        }
        drawcs(130, "<< " + checkpoints.name + " >>", 30, 30, 30, 3);
        rd.drawImage(contin[pcontin], 405, 425, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(496, "You can also use Keyboard Arrows and Enter to navigate.", 255, 255, 255, 3);
        if (control.handb || control.enter) {
            asay = "Stage " + checkpoints.stage + ":  " + checkpoints.name + " ";
            dudo = 150;
            m.trk = false;
            m.focus_point = 500;
            fase = 5;
            control.handb = false;
            control.enter = false;
            cars.stop();
            cars.unloadMod();
        }
        if (control.right && checkpoints.stage < 25) {
            if (checkpoints.stage != unlocked) {
                checkpoints.stage++;
                fase = 58;
                control.right = false;
            } else {
                fase = 4;
                lockcnt = 100;
                control.right = false;
            }
        }
        if (control.left && checkpoints.stage > 1) {
            checkpoints.stage--;
            fase = 58;
            control.left = false;
        }
    }

    public void snap(int i) {
        dmg = loadsnap(odmg);
        pwr = loadsnap(opwr);
        was = loadsnap(owas);
        lap = loadsnap(olap);
        pos = loadsnap(opos);
        int j = 0;
        do {
            rank[j] = loadsnap(orank[j]);
        } while (++j < 7);
        j = 0;
        do {
            cntdn[j] = loadsnap(ocntdn[j]);
        } while (++j < 4);
        yourwasted = loadsnap(oyourwasted);
        youlost = loadsnap(oyoulost);
        youwon = loadsnap(oyouwon);
        youwastedem = loadsnap(oyouwastedem);
        gameh = loadsnap(ogameh);
        loadingmusic = loadopsnap(oloadingmusic, i, 76);
        star[0] = loadopsnap(ostar[0], i, 0);
        star[1] = loadopsnap(ostar[1], i, 0);
        flaot = loadopsnap(oflaot, i, 1);
    }

    private Image loadsnap(Image image) {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
        for (int k = 0; k < j * i; k++) {
            if (ai[k] != 0xffc0c0c0 && ai[k] != ai[j * i - 1]) {
                Color color = new Color(ai[k]);
                int l = (int) (color.getRed() + color.getRed() * (m.snap[0] / 100F));
                if (l > 225) {
                    l = 225;
                }
                if (l < 0) {
                    l = 0;
                }
                int i1 = (int) (color.getGreen() + color.getGreen() * (m.snap[1] / 100F));
                if (i1 > 225) {
                    i1 = 225;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                int j1 = (int) (color.getBlue() + color.getBlue() * (m.snap[2] / 100F));
                if (j1 > 225) {
                    j1 = 225;
                }
                if (j1 < 0) {
                    j1 = 0;
                }
                Color color2 = new Color(l, i1, j1);
                ai[k] = color2.getRGB();
            } else if (ai[k] == 0xffc0c0c0) {
                Color color1 = new Color(m.csky[0], m.csky[1], m.csky[2]);
                ai[k] = color1.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void resetstat(int i) {
        setnumber = false;
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        tcnt = 30;
        wasay = false;
        clear = 0;
        dmcnt = 0;
        pwcnt = 0;
        auscnt = 45;
        pnext = 0;
        pback = 0;
        starcnt = 130;
        gocnt = 3;
        grrd = true;
        aird = true;
        bfcrash = 0;
        cntwis = 0;
        bfskid = 0;
        pwait = 7;
        holdcnt = 0;
        holdit = false;
        winner = false;
        time = 0;
       
        
       
        wasted = 0;
        int j = 0;
        do {
            dested[j] = 0;
        } while (++j < nplayers);
        sortcars(i);
    }
       public void drawstat(int i, int j, boolean flag, float f) {
        int ai[] = new int[4];
        int ai1[] = new int[4];
      
        if (flag) {
            ai[0] = 768;
            ai1[0] = 11;
            ai[1] = 768;
            ai1[1] = 19;
            ai[2] = 865;
            ai1[2] = 19;
            ai[3] = 865;
            ai1[3] = 11;
            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            rd.fillPolygon(ai, ai1, 4);
          }
        if (j > i) {
             j = i;
          }
        
          
          //rd.drawImage(damagebar, 677, 21, null);
          // rd.drawImage(powerbar, 677, 47, null);
          
        int k = (int) (98F * ((float) j / (float) i));
        ai[0] = 764;
        ai1[0] = 30;
        ai[1] = 764;
        ai1[1] = 39;
        ai[2] = 764 + k;
        ai1[2] = 39;
        ai[3] = 764 + k;  //532
        ai1[3] = 30;
        int l = 244;  //255, 74, 86
        int i1 = 244;
        int j1 = 11;
        if (k > 33) {
            i1 = (int) (244F - 233F * ((k - 33) / 65F));
        }
        if (k > 70) {
            if (dmcnt < 10) {
                if (dmflk) {
                    i1 = 113;
                    dmflk = false;
                } else {
                    dmflk = true;
                }
            }
            dmcnt++;
            if (dmcnt > 167D - k * 1.5D) {
                dmcnt = 0;
            }
        }
        //l = (int) (l + l * (m.snap[0] / 100F));
        if (l > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        //i1 = (int) (i1 + i1 * (m.snap[1] / 100F));
        if (i1 > 255) {
            i1 = 255;
        }
        if (i1 < 0) {
            i1 = 0;
        }
        //j1 = (int) (j1 + j1 * (m.snap[2] / 100F));
        if (j1 > 255) {
            j1 = 255;
        }
        if (j1 < 0) {
            j1 = 0;
        }
        
       
        rd.setColor(new Color(l, i1, j1));
        rd.fillPolygon(ai, ai1, 4);
        ai[0] = 764;
        ai1[0] = 56;
        ai[1] = 764;
        ai1[1] = 65;
        ai[2] = (int) (764F + f);
        ai1[2] = 65;
        ai[3] = (int) (764F + f);
        ai1[3] = 56;
        //comeback
        l = 128;
		if (f == 98F) {
			l = 64;
		}
		i1 = (int) (190D + f * 0.37D);
	    j1 = 244;
		if (auscnt < 45 && aflk) {
			l = 128;
			i1 = 244;
			j1 = 244;
	    }
        //l = (int) (l + l * (m.snap[0] / 100F));
        if (l > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        //i1 = (int) (i1 + i1 * (m.snap[1] / 100F));
        if (i1 > 255) {
            i1 = 255;
        }
        if (i1 < 0) {
            i1 = 0;
        }
        //j1 = (int) (j1 + j1 * (m.snap[2] / 100F));
        if (j1 > 255) {
            j1 = 255;
        }
        if (j1 < 0) {
            j1 = 0;
        }
        rd.setColor(new Color(l, i1, j1));
        rd.fillPolygon(ai, ai1, 4);
        if (m.flex == 2 && f != 98F) {
            ai[0] = (int) (532F + f);
            ai1[0] = 31;
            ai[1] = (int) (532F + f);
            ai1[1] = 39;
            ai[2] = 630;
            ai1[2] = 39;
            ai[3] = 630;
            ai1[3] = 31;
            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            rd.fillPolygon(ai, ai1, 4);
        
        }
    }
    
     private Image bressed(Image image) {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
        Color color = new Color(247, 255, 165);
        for (int k = 0; k < j * i; k++) {
            if (ai[k] != ai[j * i - 1]) {
                ai[k] = color.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }
        

    public void loading() {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 900, 500);
        rd.drawImage(sign, 412, 10, this);
        rd.drawImage(hello, 60, 80, this);
    
        rd.setFont(new Font("Adventure", 1, 32));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(440, "Loading game, please wait.", 255, 255, 255, 3);
       
    }

    public xtGraphics(Medium medium, Graphics2D graphics2d, Applet applet) {
        fase = 111;
        oldfase = 0;
        starcnt = 0;
        unlocked = 1;
        lockcnt = 0;
        opselect = 1;
        shaded = false;
        flipo = 0;
        nextc = false;
        gatey = 0;
        looped = 1;
        sc = new int[7];
        holdit = false;
        holdcnt = 0;
        winner = false;
        flexpix = new int[0x6DDD0];
        smokey = new int[0x16fb4];
        flatrstart = 0;
        runtyp = 0;
        trackbg = new Image[2][2];
        dude = new Image[3];
        dudeb = new Image[3];
        duds = 0;
        dudo = 0;
        next = new Image[2];
        back = new Image[2];
        contin = new Image[2];
        ostar = new Image[2];
        star = new Image[3];
        pcontin = 0;
        pnext = 0;
        pback = 0;
        pstar = 0;
        orank = new Image[7];
        rank = new Image[7];
        ocntdn = new Image[4];
        cntdn = new Image[4];
        gocnt = 0;
        engs = new AudioClip[5][5];
        pengs = new boolean[5];
        air = new AudioClip[6];
        aird = false;
        grrd = false;
        crash = new AudioClip[3];
        lowcrash = new AudioClip[3];
        pwastd = false;
        skid = new AudioClip[3];
        dustskid = new AudioClip[3];
        mutes = false;
        stracks = new RadicalMod[25];
        mtracks = new RadicalMidi[25];
        isMidi = new boolean[25];
        loadedt = new boolean[25];
        lastload = -1;
        mutem = false;
        sunny = false;
        macn = false;
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        flk = false;
        tcnt = 30;
        tflk = false;
        say = "";
        wasay = false;
        clear = 0;
        posit = 0;
        wasted = 0;
        laps = 0;
        dested = new int[7];
        dmcnt = 0;
        dmflk = false;
        pwcnt = 0;
        pwflk = false;
        loop = "";
        spin = "";
        asay = "";
        auscnt = 45;
        
        aflk = false;
        kbload = 0;
        dnload = 0;
        shload = 0.0F;
        radpx = 147;
        pin = 60;
        trkl = 0;
        trklim = (int) (Math.random() * 40D);
        flkat = (int) (60D + 140D * Math.random());
        movly = (int) (100D + 100D * Math.random());
        xdu = 272;
        ydu = 2;
        gxdu = 0;
        gydu = 0;
        pgady = new int[9];
        pgas = new boolean[9];
        lxm = -10;
        lym = -10;
        pwait = 7;
        stopcnt = 0;
        cntwis = 0;
        crshturn = 0;
        bfcrash = 0;
        bfskid = 0;
        crashup = false;
        skidup = false;
        skflg = 0;
        dskflg = 0;
        flatr = 0;
        flyr = 0;
        flyrdest = 0;
        flang = 0;
        flangados = 0;
        blackn = 0.0F;
        blacknados = 0.0F;
        m = medium;
        app = applet;
        rd = graphics2d;
        MediaTracker mediatracker = new MediaTracker(app);
        hello = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("data/hello.gif"));
        mediatracker.addImage(hello, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception _ex) {
        }
        sign = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("data/sign.gif"));
        mediatracker.addImage(sign, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception _ex) {
        }
        loadbar = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("data/loadbar.gif"));
        mediatracker.addImage(loadbar, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception _ex) {
        }
        int i = 0;
        do {
            loadedt[i] = false;
            isMidi[i] = false;
        } while (++i < 25);
        
    }

    public void maini(Control control) {
        mainmenu.loadMod(135, 7800, 125, sunny, macn);
        mainmenu.play();
        if (lastload >= 0 && loadedt[lastload]) {
            if (isMidi[lastload]) {
                 mtracks[lastload].unloadMidi();
               } else {
                 stracks[lastload].unloadMod();
             }
        }
        if (flipo == 0) {
            bgmy[0] = 0;
            bgmy[1] = 500;
            app.setCursor(new Cursor(0));
        }
        int i = 0;
        rd.drawImage(bgmain, 0, 0, null);
        rd.drawImage(logocars, 12, 28, null);
        
        flipo++;
        if (flipo > flkat + 36) {
            flipo = 1;
            flkat = (int) (60D + 140D * Math.random());
        }
        if (movly <= 10) {
            if (movly == 10 || movly == 8 || movly == 6 || movly == 4 || movly == 2) {
                gxdu = (int) (xdu + 200 - 500D * Math.random());
                gydu = (int) (ydu + 200 - 500D * Math.random());
                if (movly == 2) {
                    gxdu = 272;
                    gydu = 2;
                }
                movly--;
            }
            xdu += (gxdu - xdu) / 15;
            ydu += (gydu - ydu) / 15;
            if (movly != 1) {
                if (Utility.pys(xdu, gxdu, ydu, gydu) < 20F) {
                    movly--;
                }
            } else {
                if (xdu > gxdu) {
                    xdu--;
                } else {
                    xdu++;
                }
                if (ydu > gydu) {
                    ydu--;
                } else {
                    ydu++;
                }
                if (Utility.pys(xdu, gxdu, ydu, gydu) < 2.0F) {
                    movly--;
                }
            }
            if (movly == 0) {
                xdu = 272;
                ydu = 2;
                movly = (int) (100D + 100D * Math.random());
            }
        } else if (flipo >= movly) {
            movly = 10;
        }       
        rd.drawImage(opback, 179, 212, null);
      
        if (control.up) {
            opselect--;
            if (opselect == -1) {
                opselect = 2;
            }
            control.up = false;
        }
        if (control.down) {
            opselect++;
            if (opselect == 3) {
                opselect = 0;
            }
            control.down = false;
        }
        if (opselect == 0) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(278, 246, 110, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 255, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(182, 0, 0));
                aflk = true;
            }
            rd.drawRoundRect(355, 246, 207, 37, 18, 20);
            //rd.drawRoundRect(xcorner, ycorner, xlength, ylength, 7, 20);
        } else {
            rd.setColor(new Color(255, 255, 255));
            rd.drawRoundRect(355, 246, 207, 37, 18, 20);
        }
        if (opselect == 1) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(234, 275, 196, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 128, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(182, 0, 0));
                aflk = true;
            }
            rd.drawRoundRect(305, 310, 318, 37, 18, 20);
        } else {
            rd.setColor(new Color(255, 255, 255));
            rd.drawRoundRect(305, 310, 318, 37, 18, 20);
        }
        if (opselect == 2) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(290, 306, 85, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(255, 0, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(182, 0, 0));
                aflk = true;
            }
            rd.drawRoundRect(380, 373, 160, 37, 18, 20);
        } else {
            rd.setColor(new Color(255, 255, 255));
            rd.drawRoundRect(380, 373, 160, 37, 18, 20);
        }
        rd.drawImage(opti, 241, 250, null);
        if (control.enter || control.handb) {
            if (opselect == 0) {
                if (unlocked == 1 && oldfase == 0) {
                    oldfase = -9;
                    fase = 11;
                } else {
                    fase = -9;
                }
            }
            if (opselect == 1) {
                oldfase = 10;
                fase = 11;
            }
            if (opselect == 2) {
                fase = 8;
            }
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
        if (shaded) {
            app.repaint();
            try {
                Thread.sleep(100L);
            } catch (InterruptedException _ex) {
            }
        }
    }

    public void blendude(Image image) {
        if (!macn) {
            if (Math.random() > Math.random()) {
                dudo = 217;
            } else {
                dudo = 331;
            }
            int ai[] = new int[19520];
            PixelGrabber pixelgrabber = new PixelGrabber(image, dudo, 0, 122, 160, ai, 0, 122);
            try {
                pixelgrabber.grabPixels();
            } catch (InterruptedException _ex) {
                dudo = -1;
            }
            int j = 0;
            do {
                int ai1[] = new int[19520];
                PixelGrabber pixelgrabber1 = new PixelGrabber(dude[j], 0, 10, 122, 160, ai1, 0, 122);
                try {
                    pixelgrabber1.grabPixels();
                } catch (InterruptedException _ex) {
                    dudo = -1;
                }
                if (dudo != -1) {
                    int k = 0;
                    do {
                        if (ai1[k] != ai1[0]) {
                            Color color = new Color(ai1[k]);
                            Color color1 = new Color(ai[k]);
                            int l = (color.getRed() + color1.getRed() * 3) / 4;
                            if (l > 255) {
                                l = 255;
                            }
                            if (l < 0) {
                                l = 0;
                            }
                            int i1 = (color.getGreen() + color1.getGreen() * 3) / 4;
                            if (i1 > 255) {
                                i1 = 255;
                            }
                            if (i1 < 0) {
                                i1 = 0;
                            }
                            int j1 = (color.getBlue() + color1.getBlue() * 3) / 4;
                            if (j1 > 255) {
                                j1 = 255;
                            }
                            if (j1 < 0) {
                                j1 = 0;
                            }
                            Color color2 = new Color(l, i1, j1);
                            ai1[k] = color2.getRGB();
                        }
                    } while (++k < 19520);
                    dudeb[j] = createImage(new MemoryImageSource(122, 160, ai1, 0, 122));
                }
            } while (++j < 3);
        } else {
            if (Math.random() > Math.random()) {
                dudo = 176;
            } else {
                dudo = 372;
            }
            int i = 0;
            do {
                dudeb[i] = dude[i];
            } while (++i < 3);
        }
    }

    public void musicomp(int i, Control control) {
        hipnoload(i, true);
        if (control.handb || control.enter) {
            System.gc();
            fase = 0;
            control.handb = false;
            control.enter = false;
        }
    }

    public void drawSmokeCarsbg() {
        if (Math.abs(flyr - flyrdest) > 20) {
            if (flyr > flyrdest) {
                flyr -= 20;
            } else {
                flyr += 20;
            }
        } else {
            flyr = flyrdest;
            flyrdest = (int) ((flyr + m.random() * 160F) - 80F);
        }
        if (flyr > 160) {
            flyr = 160;
        }
        if (flatr > 170) {
            flatrstart++;
            flatr = flatrstart * 3;
            flyr = (int) (m.random() * 160F - 80F);
            flyrdest = (int) ((flyr + m.random() * 160F) - 80F);
            flang = 1;
            flangados = (int) (m.random() * 6F + 2.0F);
            blackn = 0.0F;
            blacknados = m.random() * 0.4F;
        }
        int i = 0;
        do {
            int j = 0;
            do {
                if (smokey[i + j * 466] != smokey[0]) {
                    float f = Utility.pys(i, 233, j, flyr);
                    int k = (int) (((i - 233) / f) * flatr);
                    int l = (int) (((j - flyr) / f) * flatr);
                    int i1 = i + k + 100 + (j + l + 110) * 900;
                    if (i + k + 100 < 900 && i + k + 100 > 0 && j + l + 110 < 500 && j + l + 110 > 0 && i1 < 0x416e0
                            && i1 >= 0) {
                        Color color = new Color(flexpix[i1]);
                        Color color1 = new Color(smokey[i + j * 466]);
                        float f1 = (255F - color1.getRed()) / 255F;
                        int j1 = (int) ((color.getRed() * (flang * f1)
                                + color1.getRed() * (1.0F - f1)) / (flang * f1 + (1.0F - f1) + blackn));
                        if (j1 > 255) {
                            j1 = 255;
                        }
                        if (j1 < 0) {
                            j1 = 0;
                        }
                        Color color2 = new Color(j1, j1, j1);
                        flexpix[i1] = color2.getRGB();
                    }
                }
            } while (++j < 202);
        } while (++i < 466);
        blackn += blacknados;
        flang += flangados;
        flatr += 10 + flatrstart * 2;
        Image image = createImage(new MemoryImageSource(900, 500, flexpix, 0, 900));
        rd.drawImage(image, 0, 0, null);
    }

    public void loaddata(int i) {
        kbload = 625;
        sunny = false;
        String s = "default/";
        String s1 = "au";
        if (i == 2) {
            kbload = 950;
            sunny = true;
            s = "JavaNew/";
            s1 = "wav";
        }
        String s2 = System.getProperty("os.name");
        if (!s2.startsWith("Win")) {
            macn = true;
        }
        runtyp = 176;
        
        runner = new Thread(this);
        runner.start();
        
        loadimages();
        //loadnetworkimages();
        
        cars = new RadicalMod("data/music/cars.radq", app);      
        dnload += 27;
        
        int j = 0;
        do {
            int k = 0;
            do {
                engs[k][j] = getSound("data/sounds/" + s + "" + k + "" + j + ".au");
                dnload += 3;
            } while (++k < 5);
            pengs[j] = false;
        } while (++j < 5);
        mainmenu = new RadicalMod("data/music/mainmenu.radq", app);
        dnload += 91;
        j = 0;
        do {
            air[j] = getSound("data/sounds/" + s + "air" + j + ".au");
            dnload += 2;
        } while (++j < 6);
        j = 0;
        do {
            crash[j] = getSound("data/sounds/" + s + "crash" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 10;
            } else {
                dnload += 7;
            }
        } while (++j < 3);
        j = 0;
        do {
            lowcrash[j] = getSound("data/sounds/" + s + "lowcrash" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 10;
            } else {
                dnload += 3;
            }
        } while (++j < 3);
        tires = getSound("data/sounds/" + s + "tires." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 4;
        }
        checkpoint = getSound("data/sounds/" + s + "checkpoint." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 6;
        }
        carfixed = getSound("data/sounds/" + s + "carfixed." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 10;
        }
        powerup = getSound("data/sounds/" + s + "powerup." + s1);
        if (i == 2) {
            dnload += 42;
        } else {
            dnload += 8;
        }
        three = getSound("data/sounds/" + s + "three." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 4;
        }
        two = getSound("data/sounds/" + s + "two." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 2;
        }
        one = getSound("data/sounds/" + s + "one." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 4;
        }
        go = getSound("data/sounds/" + s + "go." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 4;
        }
        wastd = getSound("data/sounds/" + s + "wasted." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 4;
        }
        firewasted = getSound("data/sounds/" + s + "firewasted." + s1);
        if (i == 2) {
            dnload += 24;
        } else {
            dnload += 10;
        }
        j = 0;
        do {
            skid[j] = getSound("data/sounds/" + s + "skid" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 22;
            } else {
                dnload += 6;
            }
        } while (++j < 3);
        j = 0;
        do {
            dustskid[j] = getSound("data/sounds/" + s + "dustskid" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 22;
            } else {
                dnload += 7;
            }
        } while (++j < 3);
    }

    public void clicknow() {
         rd.setFont(new Font("Adventure", 1, 32));
        if (aflk) {
            drawcs(485, "Click here to Start", 255, 255, 255, 3);
            aflk = false;
        } else {
            drawcs(485, "Click here to Start", 200, 200, 200, 3);
            aflk = true;
        }
    }

    private Image loadimage(byte abyte0[], MediaTracker mediatracker, Toolkit toolkit) {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception _ex) {
        }
        return image;
    }

    public void rad(int i, int x) { //splash
        if (i == 0) {
            firewasted.play();
            radpx = 240;
            pin = 0;
        }
        rd.drawImage(splash, 0, 0, null);
        //rd.setColor(new Color(0, 0, 0));
        //rd.fillRect(0, 110, 900, 59);
        if (pin != 0) {
            rd.drawImage(radicalplay, radpx + (int) (8D * Math.random() - 4D), 185, null);
        } else {
            rd.drawImage(radicalplay, 280, 185, null);
        }
        if (radpx != 147) {
            radpx += 40;
            if (radpx > 900) {
                radpx = -453;
            }
        } else if (pin != 0) {
            pin--;
        }
        if (i == 40) {
            radpx = 148;
            pin = 7;
        }
        rd.setFont(new Font("SansSerif", 1, 11));
        FontHandler.fMetrics = rd.getFontMetrics();
        if (aflk) {
            drawcs(270, "Where the crazy just got even crazier....", 200, 200, 155, 3);
            aflk = false;
        } else {
            drawcs(270, "Where the crazy just got even crazier....", 250, 250, 200, 3);
            aflk = true;
        }
        
        if (aflk) {
            drawcs(180, "Where the crazy just got even crazier....", 200, 200, 200, 3);
            aflk = false;
        } else {
            drawcs(180, "Where the crazy just got even crazier....", 250, 250, 250, 3);
            aflk = true;
        }
  
    }

    public void skid(int i, float f) {
        if (bfcrash == 0 && bfskid == 0 && f > 150F) {
            if (i == 0) {
                if (!mutes) {
                    skid[skflg].play();
                }
                if (skidup) {
                    skflg++;
                } else {
                    skflg--;
                }
                if (skflg == 3) {
                    skflg = 0;
                }
                if (skflg == -1) {
                    skflg = 2;
                }
            } else {
                if (!mutes) {
                    dustskid[dskflg].play();
                }
                if (skidup) {
                    dskflg++;
                } else {
                    dskflg--;
                }
                if (dskflg == 3) {
                    dskflg = 0;
                }
                if (dskflg == -1) {
                    dskflg = 2;
                }
            }
            bfskid = 35;
        }
    }
    
    public void cantreply() {
        rd.setColor(new Color(64, 143, 223));
        rd.fillRoundRect(135, 73, 500, 23, 7, 20);
        rd.setColor(new Color(0, 89, 223));
        rd.drawRoundRect(135, 73, 500, 23, 7, 20);
        drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void stopallnow() {
        int i = 0;
        do {
            if (loadedt[i]) {
               if (isMidi[i]) {
                  mtracks[i].unloadMidi();
                  } else {
                  stracks[i].unloadAll();
                  stracks[i] = null;
               }
            }
        } while (++i < 25);
        i = 0;
        do {
            engs[0][i].stop();
            engs[1][i].stop();
        } while (++i < 5);
        i = 0;
        do {
            air[i].stop();
        } while (++i < 6);
        wastd.stop();
        cars.unloadAll();
        
    }

    public void inishcarselect() {
        carsbginflex();
        flatrstart = 0;
        m.lightson = true;
        cars.loadMod(200, 8000, 125, sunny, macn);
        pnext = 0;
        pback = 0;
    }
    
    public void carsbginflex() {
        flatr = 0;
        flyr = (int) (m.random() * 160F - 80F);
        flyrdest = (int) ((flyr + m.random() * 160F) - 80F);
        flang = 1;
        flangados = (int) (m.random() * 6F + 2.0F);
        blackn = 0.0F;
        blacknados = m.random() * 0.4F;
        
        
        PixelGrabber pixelgrabber = new PixelGrabber(carstarter, 0, 0, 900, 500, flexpix, 0, 900);
             
        
               
        
        
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
    }
 
    public void carselect(Control control, ContO aconto[], Madness madness) {
        mainmenu.stop();
        cars.play();
        if (flatrstart == 6) {
            if (sc[0] <= 5 ) {
               rd.drawImage(carstarter, 0, 0, null); 
            }
            if (sc[0] <= 9 && sc[0] >= 6   ) {
               rd.drawImage(carstreetelites, 0, 0, null); 
            }
            if (sc[0] <= 13 && sc[0] >= 10) {
               rd.drawImage(carfuriousfour, 0, 0, null); 
            }
        } else if (flatrstart <= 1) {
            drawSmokeCarsbg();
        } else {
            rd.setColor(new Color(255, 255, 255));
            rd.fillRect(0, 0, 900, 500);
            carsbginflex();
            flatrstart = 6;
        }
        //rd.drawImage(selectcar, 375, 30, null);
        if(sc[0] == 9) {
          m.crs = true;
         m.x = -450;
         m.y = -550;
         m.z = 230;
         m.xz = 0;
         m.zy = 10;
         m.ground = 1500;
         aconto[sc[0]].d(rd);
         } else {
         m.crs = true;
         m.x = -450;
         m.y = -550;
         m.z = 215;
         m.xz = 0;
         m.zy = 10;
         m.ground = 1500;
         aconto[sc[0]].d(rd);
        
        }
       
        //DIM LOCKED CARS
        if ((sc[0] - 5) * 3 >= unlocked) {
             aconto[sc[0]].blackout = true;
        }
        if ((sc[0] - 5) * 3 < unlocked) {
             aconto[sc[0]].blackout = false;
        }
        aconto[sc[0]].d(rd);
        if (flipo == 0) {
            rd.setFont(new Font("SansSerif", 1, 13));
            FontHandler.fMetrics = rd.getFontMetrics();
            byte byte0 = 0;
            if (flatrstart < 6) {
                byte0 = 2;
            }
            if (aflk) {
                drawcs(140 + byte0, ">  " + names[sc[0]] + "  <", 240, 240, 240, 3);
                drawcs(445 + byte0, "Made By: " + creators[sc[0]], 240, 240, 240, 3);
                drawcs(170 + byte0, "" + specialty[sc[0]] + "", 255, 0, 0, 3);
               
         
                aflk = false;
            } else {
                drawcs(140,">  " + names[sc[0]] + "  <", 176, 176, 176, 3);
                drawcs(445, "Made By: " + creators[sc[0]], 176, 176, 176, 3); 
                drawcs(170,"" + specialty[sc[0]] + "", 200, 0, 0, 3);
                
                aflk = true;
            }
 
            aconto[sc[0]].z = 950;
            if (sc[0] == 9) {
                aconto[sc[0]].z = 1000;
            }
            if (sc[0] == 13) {
                aconto[sc[0]].z = 1000;
            }
            aconto[sc[0]].y = -34 - aconto[sc[0]].grat;
            aconto[sc[0]].x = 0;
            aconto[sc[0]].xz += 3;
            aconto[sc[0]].xy = 0;
            aconto[sc[0]].zy = 0;
            aconto[sc[0]].wzy -= 10;
            if (aconto[sc[0]].wzy < -45) {
                aconto[sc[0]].wzy += 45;
            }
            
            //comeback
          
            if (sc[0] <= 5 ) {
                if (sc[0] != 0) {
                  rd.drawImage(backstart, 30, 350, null);
               }
               rd.drawImage(nextstart, 810, 350, null);
            }
            if (sc[0] <= 9 && sc[0] >= 6   ) {
               rd.drawImage(backse, 30, 350, null);
               rd.drawImage(nextse, 810, 350, null);
            }
            if (sc[0] <= 13 && sc[0] >= 10) {
               rd.drawImage(back[pback], 30, 350, null);
                 if (sc[0] != 13) {
                 rd.drawImage(next[pnext], 810, 350, null);
               }
            }
            
            
            
            if ((sc[0] - 5) * 2 >= unlocked) {
                if (gatey == 300) {
                    int i = 0;
                    do {
                        pgas[i] = false;
                        pgady[i] = 0;
                    } while (++i < 9);
                    pgas[0] = true;
                }
                int j = 0;
                do {
                    rd.drawImage(pgate, pgatx[j], (pgaty[j] + pgady[j]) - gatey, null);
                    if (flatrstart == 6) {
                        if (pgas[j]) {
                            pgady[j] -= ((80 + 100 / (j + 1)) - Math.abs(pgady[j])) / 3;
                            if (pgady[j] < -(70 + 100 / (j + 1))) {
                                pgas[j] = false;
                                if (j != 8) {
                                    pgas[j + 1] = true;
                                }
                            }
                        } else {
                            pgady[j] += ((80 + 100 / (j + 1)) - Math.abs(pgady[j])) / 3;
                            if (pgady[j] > 0) {
                                pgady[j] = 0;
                            }
                        }
                    }
                } while (++j < 9);
                if (gatey != 0) {
                    gatey -= 100;
                }
                if (flatrstart == 6) {
                    drawcs(210, "[ Car Locked ]", 210, 210, 210, 3);
                    drawcs(235, "Complete Stage " + (sc[0] - 5) * 3 + " to unlock " + names[sc[0]], 255, 255, 255, 3);
                    rd.setColor(new Color(255,170,0));
                    rd.setFont(new Font("SansSerif", 1, 11));
                    FontHandler.fMetrics = rd.getFontMetrics();
                    
                    
                }
            } else {
                if (flatrstart == 6) {
                    rd.setColor(new Color(255,255,255));
                    rd.setFont(new Font("SansSerif", 1, 11));
                    FontHandler.fMetrics = rd.getFontMetrics();
                    rd.drawString("Top Speed:", 631, 90);
                    rd.drawString("Acceleration:", 621, 105);
                    rd.drawString("Handling:", 643, 120);
                    rd.drawString("Stunts:", 654, 135);
                    rd.drawString("Strength:", 642, 150);
                    rd.drawString("Endurance:", 632, 165);
                    if (sc[0] <= 5 ) {
                        rd.drawImage(statbstart, 695, 85, null);
                        rd.drawImage(statbstart, 695, 100, null);
                        rd.drawImage(statbstart, 695, 115, null);
                        rd.drawImage(statbstart, 695, 130, null);
                        rd.drawImage(statbstart, 695, 145, null);
                        rd.drawImage(statbstart, 695, 160, null);
                    }
                    if (sc[0] <= 9 && sc[0] >= 6   ) {
                        rd.drawImage(statbse, 695, 85, null);
                        rd.drawImage(statbse, 695, 100, null);
                        rd.drawImage(statbse, 695, 115, null);
                        rd.drawImage(statbse, 695, 130, null);
                        rd.drawImage(statbse, 695, 145, null);
                        rd.drawImage(statbse, 695, 160, null);
                    }
                    if (sc[0] <= 13 && sc[0] >= 10   ) {
                        rd.drawImage(statbff, 695, 85, null);
                        rd.drawImage(statbff, 695, 100, null);
                        rd.drawImage(statbff, 695, 115, null);
                        rd.drawImage(statbff, 695, 130, null);
                        rd.drawImage(statbff, 695, 145, null);
                        rd.drawImage(statbff, 695, 160, null);
                    }
              
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawImage(contin[pcontin], 405, 460, null);
                    float f = (float)(madness.swits[sc[0]][2] - 220) / 90F;
                    
                    if (f < 0.20000000000000001D) {
                        f = 0.2F;
                    }
                    if(statrate[0] > f)
                    {
                        statrate[0] -= 0.015F;
                    }
                    if(statrate[0] < f)
                    {
                        statrate[0] += 0.015F;
                    }
                    rd.fillRect((int) (695F + 156F * statrate[0]), 85, (int) (156F * (1.0F - statrate[0]) + 1.0F), 7);
                    
                    f = (madness.acelf[sc[0]][1] * madness.acelf[sc[0]][0] * madness.acelf[sc[0]][2] * madness.grip[sc[0]]) / 7700F;
                    if (f > 1.0F) {
                        f = 1.0F;
                    
                        }
                    if(statrate[1] > f)
                    {
                        statrate[1] -= 0.015F;
                    }
                    if(statrate[1] < f)
                    {
                        statrate[1] += 0.015F;
                    }
                    rd.fillRect((int) (695F + 156F * statrate[1]), 100, (int) (156F * (1.0F - statrate[1]) + 1.0F), 7);
                    f = dishandle[sc[0]];
                    if(statrate[2] > f)
                    {
                        statrate[2] -= 0.015F;
                    }
                    if(statrate[2] < f)
                    {
                        statrate[2] += 0.015F;
                    }
                    
                    rd.fillRect((int) (695F + 156F * statrate[2]), 115, (int) (156F * (1.0F - statrate[2]) + 1.0F), 7);
                   
                    f = ((float)madness.airc[sc[0]] * madness.airs[sc[0]] * madness.bounce[sc[0]] + 28F) / 139F;
                    if (f > 1.0F) {
                        f = 1.0F;
                    }
                    if(statrate[3] > f)
                    {
                        statrate[3] -= 0.015F;
                    }
                    if(statrate[3] < f)
                    {
                        statrate[3] += 0.015F;
                    }
                    rd.fillRect((int) (695F + 156F * statrate[3]), 130, (int) (156F * (1.0F - statrate[3]) + 1.0F), 7);
                    
                    float f1 = 0.5F;
                    if (sc[0] == 9) {
                        f1 = 0.8F;
                    }
                     f = (madness.moment[sc[0]] + f1) / 2.6F;
                    if (f > 1.0F) {
                        f = 1.0F;
                    }
                    if(statrate[4] > f)
                    {
                        statrate[4] -= 0.015F;
                    }
                    if(statrate[4] < f)
                    {
                        statrate[4] += 0.015F;
                    }
                    rd.fillRect((int) (695F + 156F * statrate[4]), 145, (int) (156F * (1.0F - statrate[4]) + 1.0F), 7);
                    
                    f = outdam[sc[0]];
                    if(statrate[5] > f)
                    {
                        statrate[5] -= 0.015F;
                    }
                    if(statrate[5] < f)
                    {
                        statrate[5] += 0.015F;
                    }
                    rd.fillRect((int) (695F + 156F * statrate[5]), 160, (int) (156F * (1.0F - statrate[5]) + 1.0F), 7);
                    
                    
                    if (sc[0] <= 5 ) {
                        rd.drawImage(statbostart, 695, 85, null);
                        rd.drawImage(statbostart, 695, 100, null);
                        rd.drawImage(statbostart, 695, 115, null);
                        rd.drawImage(statbostart, 695, 130, null);
                        rd.drawImage(statbostart, 695, 145, null);
                        rd.drawImage(statbostart, 695, 160, null);
                    }
                    if (sc[0] <= 9 && sc[0] >= 6   ) {
                        rd.drawImage(statbose, 695, 85, null);
                        rd.drawImage(statbose, 695, 100, null);
                        rd.drawImage(statbose, 695, 115, null);
                        rd.drawImage(statbose, 695, 130, null);
                        rd.drawImage(statbose, 695, 145, null);
                        rd.drawImage(statbose, 695, 160, null);
                    }
                    if (sc[0] <= 13 && sc[0] >= 10   ) {
                        rd.drawImage(statboff, 695, 85, null);
                        rd.drawImage(statboff, 695, 100, null);
                        rd.drawImage(statboff, 695, 115, null);
                        rd.drawImage(statboff, 695, 130, null);
                        rd.drawImage(statboff, 695, 145, null);
                        rd.drawImage(statboff, 695, 160, null);
                    }
                    rd.setColor(new Color(255,255,255));
                    rd.setFont(new Font("SansSerif", 1, 11));
                    //LORE TEXT
                    if (sc[0] == 0) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                
                       rd.drawString("Able to withstand the toughest elements", 39, 105);
                       rd.drawString("that nature has to offer, Storm Rider is", 39, 125);
                       rd.drawString("a car that will power through any obstacle", 39, 145);
                       rd.drawString("that it may face, including other drivers...", 39, 165);
                       
                     
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 1) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                
                       rd.drawString("This car is deadly viper on the loose ", 39, 105);
                       rd.drawString("with a taste for blood.... It operates on", 39, 125);
                       rd.drawString("the most potent venom of the worlds most", 39, 145);
                       rd.drawString("poisionus snakes.... Watch out.....", 39, 165);
                       
                       
                     
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 2) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                      
                       
                       rd.drawString("As normal as the Explorer may look to the", 39, 105);
                       rd.drawString("naked eye, but this beast is no where", 39, 125);
                       rd.drawString("near normal.... You'll definitely want to make", 39, 145);
                       rd.drawString("decisions cautiously when he is near...", 39, 165);
                       
                       
                       
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 3) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                
                       rd.drawString("You may be wondering, why the hell would ", 39, 105);
                       rd.drawString("anyone even consider racing in this tiny car?", 39, 125);
                       rd.drawString("The answer is quite simple actually, great ", 39, 145);
                       rd.drawString("mileage and a low financing rate of $0 down ", 39, 165);
                      
                       
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 4) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                
                       rd.drawString("Its all in the name... Outrunner will fly", 39, 105);
                       rd.drawString("by you on the track with its breakneck speed", 39, 125);
                       rd.drawString("and the only thing left will be a trail", 39, 145);
                       rd.drawString("of smoke.... You can't outrun the outrunner...", 39, 165);
                       
                     
                       
                       
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 5) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                
                       rd.drawString("It is said that Solar Reflex is a concept car", 39, 105);
                       rd.drawString("that hails from an unknown galaxy millions", 39, 125);
                       rd.drawString("of light years away... How did it get here?", 39, 145);
                       rd.drawString("That's the scary thing, nobody has a clue.... ", 39, 165);
                       
                       
                       
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 6) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                
                       rd.drawString("Zorgaro is a fierce competetior that will do", 39, 105);
                       rd.drawString("just about damn near anything to cross that", 39, 125);
                       rd.drawString("finish line first... Winning at all costs...", 39, 145);
                       rd.drawString("Life is always on the line when he's near...", 39, 165);
                       
                     
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 7) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                
                       
                       
                        rd.drawString("Stolen directly from FBI headquarters, this", 39, 105);
                       rd.drawString("is a bulletproof monster of a vehicle looking", 39, 125);
                       rd.drawString("to cause mayhem and destruction to all... If", 39, 145);
                       rd.drawString("you ever hear sirens in the distance, run....", 39, 165);
                       
                     
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 8) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                
                      rd.drawString("If you've ever noticed a trail of flames on a", 39, 105);
                       rd.drawString("long stretch of road, Firestarter is always", 39, 125);
                       rd.drawString("the first thought. Torch the competition at all", 39, 145);
                       rd.drawString("costs, even if all costs means arson....", 39, 165);
                       
                     
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    } 
                    if (sc[0] == 9) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                       
                       rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       rd.drawString("your final mistake that you ever make...", 39, 165);
                       
                       
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 10) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                       
                       rd.drawString("Capable of bending space and time with ", 39, 105);
                       rd.drawString("sheer speed, Amethyst is not to be taken", 39, 125);
                       rd.drawString("lightly. The chance of emerging victorious", 39, 145);
                       rd.drawString("is slim to none, but is never zero...", 39, 165);
                       
                       
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 11) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                       
                       rd.drawString("A mad farmer's science experiment horribly", 39, 105);
                       rd.drawString("wrong, Rampage is on the hunt for your soul!", 39, 125);
                       rd.drawString("The only fuel that this crazy digger feeds", 39, 145);
                       rd.drawString("off of is this little feeling called FEAR....", 39, 165);
                       
                       
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    if (sc[0] == 12) {
                       rd.setColor(new Color(255,255,255));
                       rd.setFont(new Font("SansSerif", 1, 12));
                       
                       rd.drawString("A prototype created at the gates of heaven", 39, 105);
                       rd.drawString("by the lord himself, Angelus is willing to do", 39, 125);
                       rd.drawString("just about anything, even if it results in deadly", 39, 145);
                       rd.drawString("sin.... A devils mind with angels wings...", 39, 165);
                       
                       
                       //rd.drawString("Looks like the 18 Wheeler has lost its trailer", 39, 105);
                       //rd.drawString("and hes looking for scrap metal.... ", 39, 125);
                       //rd.drawString("Crossing paths with the Diesel King will be", 39, 145);
                       //rd.drawString("your final mistake that you ever make...", 39, 165);
                    }
                    //CREATOR NAMES //make thing like names
        
                }
                }
        } else {
            pback = 0;
            pnext = 0;
            gatey = 300;
            if(flipo > 10)
            {
            aconto[sc[0]].x -= 100;
            if(nextc)
            {
             aconto[sc[0]].x += 20;
             } else
             {
              aconto[sc[0]].x -= 20;
              }
             } else
                {
               if(flipo == 10)
               {
                 if(nextc)
                {
                  sc[0]++;
                  } else
                  {
                    sc[0]--;
                }
                   aconto[sc[0]].x = 20;

                 aconto[sc[0]].y += 10000;
                 }
          }
          flipo--;
        }
        rd.setFont(new Font("SansSerif", 1, 11));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(495, "You can also use Keyboard Arrows and Enter to navigate.", 255, 255, 255, 3);
        if(control.right)
        {
            control.right = false;
            sc[0]++;
            if(sc[0] == 14)
                sc[0] = 13;
        }
        if(control.left)
        {
            control.left = false;
            sc[0]--;
            if(sc[0] == -1)
                sc[0] = 0;
        }
        if(control.handb || control.enter)
        {
            if(flipo == 0 && (sc[0] - 5) * 3 <= unlocked) //mainculprit if ((sc[0] - 5) * 2 >= unlocked)
            {
                lastload = -11;
                m.crs = false;
                fase = 58;
            }
            control.handb = false;
            control.enter = false;
        }
    }

    public void ctachm(int i, int j, int k, Control control) {
        if (fase == 1) {
            if (k == 1) {
                if (over(next[0], i, j, 560, 110)) {
                    pnext = 1;
                }
                if (over(back[0], i, j, 50, 110)) {
                    pback = 1;
                }
                if (over(contin[0], i, j, 290, 325)) {
                    pcontin = 1;
                }
            }
            if (k == 2) {
                if (pnext == 1) {
                    control.right = true;
                }
                if (pback == 1) {
                    control.left = true;
                }
                if (pcontin == 1) {
                    control.enter = true;
                }
            }
        }
        if (fase == 3) {
            if (k == 1 && over(contin[0], i, j, 290, 325)) {
                pcontin = 1;
            }
            if (k == 2 && pcontin == 1) {
                control.enter = true;
                pcontin = 0;
            }
        }
        if (fase == 4) {
            if (k == 1 && over(back[0], i, j, 305, 320)) {
                pback = 1;
            }
            if (k == 2 && pback == 1) {
                control.enter = true;
                pback = 0;
            }
        }
        if (fase == 6) {
            if (k == 1 && (over(star[0], i, j, 294, 360) || over(star[0], i, j, 294, 270))) {
                pstar = 2;
            }
            if (k == 2 && pstar == 2) {
                control.enter = true;
                pstar = 1;
            }
        }
        if (fase == 7) {
            if (k == 1) {
                if (over(next[0], i, j, 580, 250)) {
                    pnext = 1;
                }
                if (over(back[0], i, j, 30, 250)) {
                    pback = 1;
                }
                if (over(contin[0], i, j, 290, 360)) {
                    pcontin = 1;
                }
            }
            if (k == 2) {
                if (pnext == 1) {
                    control.right = true;
                }
                if (pback == 1) {
                    control.left = true;
                }
                if (pcontin == 1) {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if (fase == -5) {
            lxm = i;
            lym = j;
            if (k == 1 && over(contin[0], i, j, 290, 350 - pin)) {
                pcontin = 1;
            }
            if (k == 2 && pcontin == 1) {
                control.enter = true;
                pcontin = 0;
            }
        }
        if (fase == -7) {
            if (k == 1) {
                if (overon(264, 45, 137, 22, i, j)) {
                    opselect = 0;
                    shaded = true;
                }
                if (overon(255, 73, 155, 22, i, j)) {
                    opselect = 1;
                    shaded = true;
                }
                if (overon(238, 99, 190, 22, i, j)) {
                    opselect = 2;
                    shaded = true;
                }
                if (overon(276, 125, 109, 22, i, j)) {
                    opselect = 3;
                    shaded = true;
                }
            }
            if (k == 2 && shaded) {
                control.enter = true;
                shaded = false;
            }
            if (k == 0 && (i != lxm || j != lym)) {
                if (overon(264, 45, 137, 22, i, j)) {
                    opselect = 0;
                }
                if (overon(255, 73, 155, 22, i, j)) {
                    opselect = 1;
                }
                if (overon(238, 99, 190, 22, i, j)) {
                    opselect = 2;
                }
                if (overon(276, 125, 109, 22, i, j)) {
                    opselect = 3;
                }
                lxm = i;
                lym = j;
            }
        }
        if (fase == 10) {
            if (k == 1) {
                if (overon(278, 246, 110, 22, i, j)) {
                    opselect = 0;
                    shaded = true;
                }
                if (overon(234, 275, 196, 22, i, j)) {
                    opselect = 1;
                    shaded = true;
                }
                if (overon(290, 306, 85, 22, i, j)) {
                    opselect = 2;
                    shaded = true;
                }
            }
            if (k == 2 && shaded) {
                control.enter = true;
                shaded = false;
            }
            if (k == 0 && (i != lxm || j != lym)) {
                if (overon(278, 246, 110, 22, i, j)) {
                    opselect = 0;
                }
                if (overon(234, 275, 196, 22, i, j)) {
                    opselect = 1;
                }
                if (overon(290, 306, 85, 22, i, j)) {
                    opselect = 2;
                }
                lxm = i;
                lym = j;
            }
        }
        if (fase == 11) {
            if (flipo >= 1 && flipo <= 13) {
                if (k == 1 && over(next[0], i, j, 600, 370)) {
                    pnext = 1;
                }
                if (k == 2 && pnext == 1) {
                    control.right = true;
                    pnext = 0;
                }
            }
            if (flipo >= 3 && flipo <= 15) {
                if (k == 1 && over(back[0], i, j, 10, 370)) {
                    pback = 1;
                }
                if (k == 2 && pback == 1) {
                    control.left = true;
                    pback = 0;
                }
            }
            if (flipo == 15) {
                if (k == 1 && over(contin[0], i, j, 500, 370)) {
                    pcontin = 1;
                }
                if (k == 2 && pcontin == 1) {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if (fase == 8) {
            if (flipo != 102) {
                if (k == 1 && over(next[0], i, j, 600, 370)) {
                    pnext = 1;
                }
            } else {
                if (k == 1 && over(next[0], i, j, 600, 30)) {
                    pnext = 1;
                }
            }
            if (k == 2 && pnext == 1) {
                control.enter = true;
                pnext = 0;
            }
        }
    }

    public void stopairs() {
        int i = 0;
        do {
            air[i].stop();
        } while (++i < 6);
    }

    @Override
    public void run() {
        while (runtyp != 0) {
            if (runtyp >= 1 && runtyp <= 17) {
                hipnoload(runtyp, false);
            }
            if (runtyp == 176) {
                loading();
            }
            app.repaint();
            try {
                Thread.sleep(20L);
            } catch (InterruptedException _ex) {
            }
        }
    }

    public void loadingfailed(CheckPoints checkpoints, Control control, String error) {
        trackbg(false);
        rd.drawImage(select, 273, 45, null);    
        if (checkpoints.stage <= 12) {
            rd.drawImage(brse, 0, 0, null); 
            }
        if (checkpoints.stage >= 13 && checkpoints.stage != 25) {
            rd.drawImage(br, 0, 0, null);
            }
        if (checkpoints.stage != 1) {
            rd.drawImage(back[pback], 50, 110, null);
        }
        if (checkpoints.stage != 25) {
            rd.drawImage(next[pnext], 560, 110, null);
        }
        rd.setFont(new Font("SansSerif", 1, 13));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(140, "Error Loading Stage " + checkpoints.stage, 255, 255, 255, 3);
        drawcs(170, error, 177, 177, 177, 3);
        drawcs(220, "Check console for more info.", 177, 177, 177, 3);
        rd.drawImage(contin[pcontin], 290, 325, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(346, "You can also use Keyboard Arrows and Enter to navigate.", 255, 255, 255, 3);
        if (control.handb || control.enter) {
            fase = 58;
            control.handb = false;
            control.enter = false;
        }
        if(control.right && checkpoints.stage < 25) {
            if (checkpoints.stage != unlocked) {
                checkpoints.stage++;
                fase = 58;
                control.right = false;
            } else {
                fase = 4;
                lockcnt = 100;
                control.right = false;
            }
        }
        if(control.left && checkpoints.stage > 1) {
            checkpoints.stage--;
            fase = 58;           
            control.left = false;
        }
    }

    public void hipnoload(int i, boolean flag) {
        int j = (int) (230F - 230F * (m.snap[0] / (100F * hipno[i - 1])));
        if (j > 255) {
            j = 255;
        }
        if (j < 0) {
            j = 0;
        }
        int l = (int) (230F - 230F * (m.snap[1] / (100F * hipno[i - 1])));
        if (l > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        int j1 = (int) (230F - 230F * (m.snap[2] / (100F * hipno[i - 1])));
        if (j1 > 255) {
            j1 = 255;
        }
        if (j1 < 0) {
            j1 = 0;
        }
        if (i == 1) {
            j = 230;
            l = 230;
            j1 = 230;
        }
        rd.setColor(new Color(j, l, j1));
        rd.fillRect(0, 0, 900, 500);
        rd.setFont(new Font("SansSerif", 1, 13));
        FontHandler.fMetrics = rd.getFontMetrics();
        drawcs(25, asay, 0, 0, 0, 3);
        byte byte0 = -90;
        if (i == unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12
                || i == 13 || i == 16)) {
            byte0 = 0;
        }
        if (byte0 == 0) {
            if (dudo > 0) {
                if (aflk) {
                    if (Math.random() > Math.random()) {
                        duds = (int) (Math.random() * 3D);
                    } else {
                        duds = (int) (Math.random() * 2D);
                    }
                    aflk = false;
                } else {
                    aflk = true;
                }
                dudo--;
            } else {
                duds = 0;
            }
            rd.drawImage(dude[duds], 145, 10, null);
            rd.drawImage(flaot, 242, 42, null);
            int k = (int) (80F - 80F * (m.snap[0] / (50F * hipno[i - 1])));
            if (k > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            int i1 = (int) (80F - 80F * (m.snap[1] / (50F * hipno[i - 1])));
            if (i1 > 255) {
                i1 = 255;
            }
            if (i1 < 0) {
                i1 = 0;
            }
            int k1 = (int) (80F - 80F * (m.snap[2] / (50F * hipno[i - 1])));
            if (k1 > 255) {
                k1 = 255;
            }
            if (k1 < 0) {
                k1 = 0;
            }
            if (i == 1) {
                k = 80;
                i1 = 80;
                k1 = 80;
            }
            rd.setColor(new Color(k, i1, k1));
            rd.setFont(new Font("SansSerif", 1, 13));
            if (i == 1) {
                rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 312, 67);
                rd.drawString("all checkpoints in the track!", 312, 87);
            }
            if (i == 2) {
                rd.drawString("Remember, the more power you have the faster your car will be!", 312, 67);
            }
            if (i == 3) {
                rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 312, 67);
                rd.drawString("Don't upset him or you'll be arrested!", 312, 87);
                rd.drawString("Better run, run, run.", 312, 127);
            }
            if (i == 4) {
                rd.drawString("Don't waste your time.  Waste them instead!", 312, 67);
                rd.drawString("Try a taste of sweet revenge here (if you can)!", 312, 87);
                rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 312, 127);
                rd.drawString("the track.", 312, 147);
            }
            if (i == 7) {
                rd.drawString("Welcome to the realm of the king...", 312, 67);
                rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 312, 107);
                rd.drawString("and STRONGER you car will be!", 312, 127);
            }
            if (i == 8) {
                rd.drawString("Watch out, EL KING is out to get you now!", 312, 67);
                rd.drawString("He seems to be seeking revenge?", 312, 87);
                rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 312, 127);
                rd.drawString("before take off).", 312, 147);
            }
            if (i == 9) {
                rd.drawString("It\u2019s good to be the king!", 312, 67);
            }
            if (i == 10) {
                rd.drawString("Remember, forward loops give your car a push forwards in the air", 312, 67);
                rd.drawString("and help in racing.", 312, 87);
                rd.drawString("(You may need to do more forward loops here.  Also try keeping", 312, 127);
                rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 312, 147);
            }
            if (i == 12) {
                rd.drawString("Watch out!  Beware!  Take care!", 312, 67);
                rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 312, 87);
            }
            if (i == 13) {
                rd.drawString("Anyone for a game of Digger?!", 312, 67);
                rd.drawString("You can have fun using MASHEEN here!", 312, 87);
            }
            if (i == 16) {
                rd.drawString("This is it!  This is the toughest stage in the game!", 312, 67);
                rd.drawString("This track is actually a 4D object projected onto the 3D world.", 312, 107);
                rd.drawString("It's been broken down, separated and, in many ways, it is also a", 312, 127);
                rd.drawString("maze!  GOOD LUCK!", 312, 147);
            }
        }
        rd.drawImage(loadingmusic, 334, 180 + byte0, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        FontHandler.fMetrics = rd.getFontMetrics();
        if (!flag) {
            drawcs(415 + byte0, "" + sndsize[i - 1] + " KB", 0, 0, 0, 3);
            drawcs(450 + byte0, " Please Wait...", 0, 0, 0, 3);
        } else {
            drawcs(440 + byte0, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            rd.drawImage(star[pstar], 409, 460 + byte0, null);
            if (pstar != 2) {
                if (pstar == 0) {
                    pstar = 1;
                } else {
                    pstar = 0;
                }
            }
        }
    }

    private Image loadopsnap(Image image, int i, int j) {
        int k = image.getHeight(ob);
        int l = image.getWidth(ob);
        int ai[] = new int[l * k];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, l, k, ai, 0, l);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException _ex) {
        }
        int i1 = 0;
        if (j == 1) {
            i1 = ai[61993];
        }
        for (int j1 = 0; j1 < l * k; j1++) {
            if (ai[j1] != ai[j]) {
                Color color = new Color(ai[j1]);
                int k1 = 0;
                int l1 = 0;
                int i2 = 0;
                if (j == 1 && ai[j1] == i1) {
                    k1 = (int) (237F - 237F * (m.snap[0] / (150F * hipno[i - 1])));
                    if (k1 > 255) {
                        k1 = 255;
                    }
                    if (k1 < 0) {
                        k1 = 0;
                    }
                    l1 = (int) (237F - 237F * (m.snap[1] / (150F * hipno[i - 1])));
                    if (l1 > 255) {
                        l1 = 255;
                    }
                    if (l1 < 0) {
                        l1 = 0;
                    }
                    i2 = (int) (237F - 237F * (m.snap[2] / (150F * hipno[i - 1])));
                    if (i2 > 255) {
                        i2 = 255;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    if (i == 1) {
                        k1 = 250;
                        l1 = 250;
                        i2 = 250;
                    }
                } else {
                    k1 = (int) (color.getRed()- color.getRed() * (m.snap[0] / (50F * hipno[i - 1])));
                    if (k1 > 255) {
                        k1 = 255;
                    }
                    if (k1 < 0) {
                        k1 = 0;
                    }
                    l1 = (int) (color.getGreen()
                            - color.getGreen() * (m.snap[1] / (50F * hipno[i - 1])));
                    if (l1 > 255) {
                        l1 = 255;
                    }
                    if (l1 < 0) {
                        l1 = 0;
                    }
                    i2 = (int) (color.getBlue()
                            - color.getBlue() * (m.snap[2] / (50F * hipno[i - 1])));
                    if (i2 > 255) {
                        i2 = 255;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    if (i == 1) {
                        k1 = color.getRed();
                        l1 = color.getGreen();
                        i2 = color.getBlue();
                    }
                }
                Color color1 = new Color(k1, l1, i2);
                ai[j1] = color1.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(l, k, ai, 0, l));
        return image1;
    }

    /**
     * returns an audioclip
     * @param s name of clip
     * @return the new audio clip
     */
    private AudioClip getSound(String s) {
        return Applet.newAudioClip(getClass().getResource(s));
    }

    
    int time;
    float speed;
    DecimalFormat dc = new DecimalFormat("00");
    String getTime (long millis) {
       long cent = (millis%1000)/10;
       int secs = (int)((millis/1000)%60);
       int mins = (int)((millis/1000)/60);
       return dc.format(mins) + ":" + dc.format(secs) + "." + dc.format(cent);
    }
    //DecimalFormat dc = new DecimalFormat("");
    //String getSpeed (float speed) {
       
       //return dc.format(speed) + ":" + dc.format(secs) + "." + dc.format(cent);
    //}
        
}
