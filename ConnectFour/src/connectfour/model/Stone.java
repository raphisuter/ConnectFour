
package connectfour.model;

/**
 *
 * @author Alex
 */
public class Stone {
    
    private int column;
    
    private int row;
    
    private Player player;

    public Stone(int column, int row, Player player) {
        this.column = column;
        this.row = row;
        this.player = player;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
