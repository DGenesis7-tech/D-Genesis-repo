
class Player:
    def __init__(self, name, symbol):
        self.name = name
        self.symbol = symbol

    def __repr__(self):
        return f"Player {self.name}"


class Board:
    def __init__(self):
        self.board = [[' ', ' ', ' '],
                      [' ', ' ', ' '],
                      [' ', ' ', ' ']]

    def board_display(self):
        for row in self.board:
            print(" | ".join(row))
            print("~~~~~")

    def position_symbol(self, position, symbol):
        positions = [(0, 0), (0, 1), (0, 2),
                     (1, 0), (1, 1), (1, 2),
                     (2, 0), (2, 1), (2, 2)]

        if 1 <= position <= 9:
            row, column = positions[position - 1]

            if 0 <= row < len(self.board) and 0 <= column < len(self.board[0]):
                if self.board[row][column] == ' ':
                    self.board[row][column] = symbol
                    return True
                else:
                    print(f"Position ({row}, {column}) is already occupied!")
            else:
                print(f"Invalid row or column index: {row}, {column}")
        else:
            print(f"Invalid position number: {position}. Must be between 1 and 9.")

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
                if space == ' ':
                    return False
        return True

class Game:
    def __init__(self, player1, player2, symbol1="", symbol2="", pair=[("", "")]):
        self.player1 = Player(player1, symbol1)
        self.player2 = Player(player2, symbol2)
        self.pair = [("", "")]
        self.current_player = self.player1
        self.board = Board()


    def change_player(self):
        if self.current_player == self.player1:
            self.current_player = self.player2
        else:
            self.current_player = self.player1

    def take_turn(self, position):
        if self.board.position_symbol(position, self.current_player.symbol):
            if self.board.check_winner(self.current_player.symbol):
                return f"{self.current_player.name} won the game!"
            elif self.board.full_board():
                return "Game ends in draw !"
            else:
                self.change_player()
                return "Next move"
        else:
            return "Invalid move, Try again !!!"

    def display_instructions(self):
        print("Welcome to Tic Tac Toe! =>> by Genesis")
        print("Players take turn to place their symbol or default(X or O) in a position numbered 1-9")
        print("BOARD POSITIONS ==")
        print("1 | 2 | 3")
        print("4 | 5 | 6")
        print("7 | 8 | 9")
        print("To make a move, enter the number corresponding to the position")
        return self


    def choose_symbol_pair(self):
        pairs = [("X", "O"), ("A", "B"), ("*", "#"), ("@", "$")]
        print("Choose the symbol pair you want to play:")
        for index, pair in enumerate(pairs, 1):
            print(f"{index}. {pair[0]} and {pair[1]}")
        choice = int(input("Choose a number (1-4) to select your pair: "))
        if 1 <= choice <= len(pairs):
            pairs = pairs[choice - 1]
        else:
            pairs = [("X", "O")]
        return pairs

    def main(self):
        player1_name = input("Enter Player 1 name: ")
        player2_name = input("Enter Player 2 name: ")
        symbol1, symbol2 = self.choose_symbol_pair()
        player1 = Player(player1_name, symbol1)
        player2 = Player(player2_name, symbol2)

        game = Game(player1, player2, symbol1, symbol2)

        self.display_instructions()


        while True:
            game.board.board_display()
            print(f"{game.current_player.name}'s turn! - ({game.current_player.symbol})")
            position = input("Enter position number (1-9): ")
            if position.isdigit():
                position = int(position)
                if 1 <= position <= 9:
                    result = game.take_turn(position)
                    print(result)
                    if result != "Next move":
                        game.board.board_display()
                        break
                else:
                    print("Invalid position number, Try again!, Please enter a valid position number ")
            else:
                print("Invalid position number, Try again!, Please enter a valid position number ")
