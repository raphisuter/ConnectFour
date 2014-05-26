package connectfour.ui.welcome;

/**
 * Diese Klasse handelt die Daten des Welcome-GUI's
 * @author markus.birrer.01@stud.hslu.ch
 */
public class WelcomeModel {

    private boolean playComputer;
    private boolean playHuman;
    private String playerName;
    private int numberOfRows;
    private int numberOfColumns;

    public WelcomeModel() {
    }

    public void setPlayComputer(boolean setComputer) {
        playComputer = setComputer;
    }

    public void setPlayHuman(boolean setHuman) {
        playComputer = setHuman;
    }

    public void setPlayerName(String setName) {
        playerName = setName;
    }

    public void setNumberOfRows(int setRows) {
        numberOfRows = setRows;
    }

    public void setNumberOfColumns(int setColumns) {
        numberOfColumns = setColumns;
    }

    public boolean getPlayComputer() {
        return playComputer;
    }

    public boolean getPlayHuman() {
        return playHuman;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }
}
