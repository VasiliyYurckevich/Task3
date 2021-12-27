package main.java.com.yurkevichVV;


import javafx.scene.control.Cell;
import org.nocrala.tools.texttablefmt.*;


public class HelpTable {
    public static void generateTable(String[] moves){
        CellStyle numberstayle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(6,BorderStyle.UNICODE_BOX_HEAVY_BORDER,ShownBorders.ALL);

        t.addCell("");
        t.addCell(moves[0]);
        t.addCell(moves[1]);
        t.addCell(moves[2]);
        t.addCell(moves[3]);
        t.addCell(moves[4]);

        t.addCell(moves[0]);
        t.addCell("Draw");
        t.addCell("Win");
        t.addCell("Win");
        t.addCell("Lose");
        t.addCell("Lose");

        t.addCell(moves[1]);
        t.addCell("Lose");
        t.addCell("Draw");
        t.addCell("Win");
        t.addCell("Win");
        t.addCell("Lose");

        t.addCell(moves[2]);
        t.addCell("Lose");
        t.addCell("Lose");
        t.addCell("Draw");
        t.addCell("Win");
        t.addCell("Win");

        t.addCell(moves[3]);
        t.addCell("Win");
        t.addCell("Lose");
        t.addCell("Lose");
        t.addCell("Draw");
        t.addCell("Win");

        t.addCell(moves[4]);
        t.addCell("Win");
        t.addCell("Win");
        t.addCell("Lose");
        t.addCell("Lose");
        t.addCell("Draw");
        System.out.println(t.render());

    }

}
