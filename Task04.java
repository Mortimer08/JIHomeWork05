//**На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
public class Task04 {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        Integer figuresOnboard = 0;
        Integer firstLine = 0;
        Integer firstColumn = 0;
        while (figuresOnboard < 8) { // повторять пока на доске меньше 8 фигур
            board.clearBoard(); // очищаем доску
            board.setFigure(firstLine, firstColumn); // установка первой фигуры
            figuresOnboard = 1;
            for (int j = 0; j < 8; j++) { // проходим по всем клеткам
                for (int k = 0; k < 8; k++) {
                    if (!board.isOcupated(j, k)) { // если клетка не занята - ставим фигуру
                        board.setFigure(j, k);
                        figuresOnboard++;
                    }
                }
            }
            if (firstColumn < 7) {  // если фигур меньше 8 - начинаем снова,
                firstColumn++; // но первую фигуру ставим в другое место
            } else {    // верим, что правильная расстановка найдётся - не проверяем номер линии
                firstColumn = 0;
                firstLine++;
            }
        }
        System.out.printf("\nНа доске %d фигур!\n", figuresOnboard);
        board.showBoard();
    }
}