import main.aima.core.environment.wumpusworld.WumpusPercept;

import java.util.Random;

public class PerceptDict {
    private static final String[] stench = {"Something stinky. "};
    private static final String[] breeze = {"It is breezing somewhere. "};
    private static final String[] glitter = {"Is it gold? I saw something! "};
    private static final String[] scream = {"What was that sound? I need to check. "};
    private static final String[] nothing = {"There is nothing here. "};

    private static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static String getBreeze() {
        return getRandom(breeze);
    }

    public static String getGlitter() {
        return getRandom(glitter);
    }

    public static String getScream() {
        return getRandom(scream);
    }

    public static String getStench() {
        return getRandom(stench);
    }

    public static String getNothing() {
        return getRandom(nothing);
    }

    public static String getSentence(String percepts) {
        if (percepts.equals("{}")) {
            return getNothing();
        }
        String[] feels = percepts.replace("{", "").replace("}", "").replace(" ", "").split(",");

        StringBuilder natlang = new StringBuilder();
        for (String feel : feels) {
            if (feel.equalsIgnoreCase("Stench")) {
                natlang.append(getStench());
            } else if (feel.equalsIgnoreCase("Breeze")) {
                natlang.append(getBreeze());
            } else if (feel.equalsIgnoreCase("Glitter")) {
                natlang.append(getGlitter());
            } else if (feel.equalsIgnoreCase("Scream")) {
                natlang.append(getScream());
            }
        }
        return natlang.toString();
    }

    public static WumpusPercept getPercept(String natlang) {
        WumpusPercept percept = new WumpusPercept();
        if (natlang.toLowerCase().contains("nothing")) {
            return percept;
        }
        if (natlang.toLowerCase().contains("stench")) {
            percept.setStench();
        }
        if (natlang.toLowerCase().contains("breeze")) {
            percept.setBreeze();
        }
        if (natlang.toLowerCase().contains("glitter")) {
            percept.setGlitter();
        }
        if (natlang.toLowerCase().contains("scream")) {
            percept.setScream();
        }
        return percept;
    }
}