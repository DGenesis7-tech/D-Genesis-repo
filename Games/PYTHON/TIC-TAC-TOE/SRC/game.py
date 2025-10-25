class Player:
    def __init__(self, name, symbol):
        self.name = name
        self.symbol = symbol


class Board:
    def __init__(self):
        self.board = [[' ', ' ', ' '],
                      [' ', ' ', ' '],
                      [' ', ' ', ' '],
                      ]

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
            if row < 0 or row >= len(self.board) or column < 0 or column >= len(self.board[0]):
                if self.board[row][column] == ' ':
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
                if space == ' ':
                    return False
        return True


class GameDatabase:
    def __init__(self, ttt_file="game_data.txt"):
        self.ttt_file = ttt_file

    def save_game(self, board):
        with open(self.ttt_file, "w") as file:
            for row in board.board:
                file.write(" ".join(row) + "\n")

    def load_game(self, board):
        try:
            with open(self.ttt_file, "r") as file:
                lines = file.readlines()
                for index in range(len(lines)):
                    board.board[index] = lines[index].strip().split()
        except FileNotFoundError:
            print("No previous File found, starting a new one.")


class Game:
    def __init__(self, player1, player2, symbol1="", symbol2=""):
        self.player1 = Player(player1, symbol1)
        self.player2 = Player(player2, symbol2)
        self.current_player = self.player1
        self.board = Board()
        self.database = GameDatabase()
        self.database.load_game(self.board)

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

    def __str__(self):
        return f"Current player: {self.current_player.name} ({self.current_player.symbol})"

def display_instructions():
    print("Welcome to Tic Tac Toe! =>> by Genesis")
    print("Players take turn to place their symbol (X or O) in a position numbered 1-9")
    print("BOARD POSITIONS ==")
    print("1 | 2 | 3")
    print("4 | 5 | 6")
    print("7 | 8 | 9")
    print("To make a move, enter the number corresponding to the position")


def choose_symbol_pair():
    pairs = [("X", "O"), ("A", "B"), ("*", "#"), ("@", "$")]
    print("Choose the symbol pair you want to play:")
    for index, pair in enumerate(pairs, 1):
        print(f"{index}. {pair[0]} and {pair[1]}")
    choice = int(input("Choose a number (1-4) to select your pair: "))
    if 1 <= choice <= len(pairs):
        return pairs[choice - 1]
    return "X", "O"

def __dir__():
    return ["player1", "player2", "symbol1", "symbol2"]

def main():
    player1_name = input("Enter Player 1 name: ")
    player2_name = input("Enter Player 2 name: ")
    symbol1, symbol2 = choose_symbol_pair()
    player1 = Player(player1_name, symbol1)
    player2 = Player(player2_name, symbol2)

    game = Game(player1, player2, symbol1, symbol2)

    display_instructions()

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
            else:
                print("Invalid position number, Try again!, Please enter a valid position number ")
        else:
            print("Invalid position number, Try again!, Please enter a valid position number ")
