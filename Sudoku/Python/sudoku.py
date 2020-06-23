board = [
    [7, 8, 0, 4, 0, 0, 1, 2, 0],
    [6, 0, 0, 0, 7, 5, 0, 0, 9],
    [0, 0, 0, 6, 0, 1, 0, 7, 8],
    [0, 0, 7, 0, 4, 0, 2, 6, 0],
    [0, 0, 1, 0, 5, 0, 9, 3, 0],
    [9, 0, 4, 0, 6, 0, 0, 0, 5],
    [0, 7, 0, 3, 0, 0, 0, 1, 2],
    [1, 2, 0, 0, 0, 7, 4, 0, 0],
    [0, 4, 9, 2, 0, 6, 0, 0, 7]
]


def sudoku_solved(bo):
    flag = solver(bo)
    if flag:
        print('\nThe Solution is: ')
        print_board(bo)
    else:
        print("No solution")


def solver(bo):
    find = find_empty(bo)
    if not find:
        return True
    else:
        row, col = find

    for i in range(1, 10):
        if is_valid(bo,row, col, i):
            bo[row][col] = i

            if solver(bo):
                return True

            bo[row][col] = 0

    return False

def is_valid(bo, row, col, num):
    # row
    for i in range(len(bo)):
        if bo[i][col] == num:
            return False

    # column
    for j in range(len(bo)):
        if bo[row][j] == num:
            return False
    
    # Check for same number in 3x3 grid
    row_check = row - row % 3
    col_check = col - col % 3
    
    # Check for one 3x3 grid     
    for i in range(row_check, row_check + 3):
        for j in range(col_check, col_check + 3):
            if bo[i][j] == num:
                return False
    return True


def print_board(bo):
    for i in range(len(bo) + 1):
        if i % 3 == 0:
            print("-------------------------------")
        if i == 9:
            continue

        for j in range(len(bo) + 1):
            if j % 3 == 0:
                print("|", end="")
            if j == 9:
                continue
            print(" " + str(bo[i][j]), end=" ")
        print()


def find_empty(bo):
    for i in range(len(bo)):
        for j in range(len(bo[0])):
            if bo[i][j] == 0:
                return (i, j)  # row, col

    return None


if __name__ == '__main__':
    print_board(board)
    sudoku_solved(board)
