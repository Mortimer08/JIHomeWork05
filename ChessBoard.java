public class ChessBoard {
    public int[][] field = new int[8][8];

    public void showBoard() {
        System.out.println("---------------------------------");
        for (int i = 0; i < field.length; i++) {
            String sign = " ";
            for (int j = 0; j < field[i].length; j++) {

                switch (field[i][j]) {
                    case 0:
                        sign = " ";
                        break;
                    case 1:
                        sign = "+";
                        break;
                    case 2:
                        sign = "M";
                        break;
                    // default:
                    // sign = "M";
                    // break;
                }
                System.out.printf("| %s ", sign);

            }
            System.out.println("|");
            System.out.println("---------------------------------");
        }

    }

    void setFigure(Integer line, Integer column) {
        field[line][column] = 2;
        setThreat(line, column);
    }

    void setThreat(Integer line, Integer column) {
        Integer add = 1;
        Integer lineNumber = line - 1;
        while (lineNumber >= 0) {
            field[lineNumber][column] = 1;
            if (column - add >= 0) {
                field[lineNumber][column - add] = 1;
            }
            if (column + add < 8) {
                field[lineNumber][column + add] = 1;
            }
            lineNumber--;
            add++;
        }
        add = 1;
        lineNumber = line + 1;
        while (lineNumber < 8) {
            field[lineNumber][column] = 1;
            if (column - add >= 0) {
                field[lineNumber][column - add] = 1;
            }
            if (column + add < 8) {
                field[lineNumber][column + add] = 1;
            }
            lineNumber++;
            add++;
        }
        for (int i = 0; i < field[column].length; i++) {
            if(i != column){
                field[line][i]=1;
            }
        }

    }
}
