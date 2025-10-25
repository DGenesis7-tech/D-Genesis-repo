class Player:
    def __init__(self, name, symbol):
        self.name = name
        self.symbol = symbol

class Board:
    def __init__(self):
        self.board = [['-', '-', '-'],
                      ['-', '-', '-'],
                      ['-', '-', '-'],
                      ]

    def board_display(self):
        for row in self.board:
            print(" | ".join(row))
            print("~~~~~~~~~")

    def position_symbol(self, position, symbol):
        positions = [(0, 0), (0, 1), (1, 0),
                     (1, 1), (1, 2), (0, 2),
                     (2, 0), (2, 2), (2, 1)
                     ]

        if 1 <= position <= 9:
            row, column = positions[position - 1]
            if self.board[row][column] == '-':
                self.board[row][column] = symbol
                return True
        return False

    def check_winner(self, symbol):
        for row in self.board:
            if row[0] == symbol and row[1] == symbol and row[2] == symbol:
                return True
        for column in range(3):
            if self.board[0][column] == symbol and self.board[1][column] == symbol and self.board[2][column] == symbol:
                return True
        if self.board[0][0] == symbol and self.board[1][1] == symbol and self.board[2][2] == symbol:
            return True
        if self.board[0][2] == symbol and self.board[1][1] == symbol and self.board[2][0] == symbol:
            return True
        return False

    def full_board(self):
        for row in self.board:
            for space in row:
                if space == '-':
                    return False
        return True







