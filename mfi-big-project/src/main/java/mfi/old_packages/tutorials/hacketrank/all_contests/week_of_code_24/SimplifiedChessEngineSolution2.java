package mfi.old_packages.tutorials.hacketrank.all_contests.week_of_code_24;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimplifiedChessEngineSolution2 {

    public static int[] queen = { 1, 0, -1, 0, 0, 1, 0, -1, 2, 0, -2, 0, 0, 2, 0, -2, 3, 0, -3, 0, 0, 3, 0, -3, 1, 1,
			-1, -1, 1, -1, -1, 1, 2, 2, -2, -2, 2, -2, -2, 2, 3, 3, -3, -3, 3, -3, -3, 3 };
	public static int[] rook = { 1, 0, -1, 0, 0, 1, 0, -1, 2, 0, -2, 0, 0, 2, 0, -2, 3, 0, -3, 0, 0, 3, 0, -3 };
	public static int[] bishop = { 1, 1, -1, -1, 1, -1, -1, 1, 2, 2, -2, -2, 2, -2, -2, 2, 3, 3, -3, -3, 3, -3, -3, 3 };
	public static int[] knight = { 1, 2, -1, -2, 2, 1, -2, -1, 1, -2, -1, 2, 2, -1, -2, 1 };

	public abstract static class Piece
	{
		final boolean white;
		final int[] moves;
		final boolean canJump;
		int x, y;
		boolean taken;

		public Piece(int x, int y, boolean white, int[] moves, boolean canJump)
		{
			this.white = white;
			this.x = x;
			this.y = y;
			this.moves = moves;
			this.canJump = canJump;
		}

		int count()
		{
			return moves.length / 2;
		}

		boolean canMove(int number, Piece[][] board)
		{
			int dx = moves[2 * number];
			int dy = moves[2 * number + 1];
			int x = this.x + dx;
			int y = this.y + dy;
			if (!(0 <= x && x <= 3 && 0 <= y && y <= 3))
			{
				return false;
			}
			Piece taking = board[x][y];
			if (taking != null && taking.white == white)
			{
				return false;
			}
			if (canJump)
			{
				return true;
			}
			int steps = Math.max(Math.abs(dx), Math.abs(dy)) - 1;
			int sx = dx == 0 ? 0 : dx > 0 ? 1 : -1;
			int sy = dy == 0 ? 0 : dy > 0 ? 1 : -1;
			for (int i = 1; i <= steps; i++)
			{
				if (board[this.x + sx * i][this.y + sy * i] != null)
				{
					return false;
				}
			}
			return true;
		}

		void move(int number, boolean reverse)
		{
			number += !reverse ? 0 : number % 2 == 0 ? 1 : -1;
			this.x += moves[2 * number];
			this.y += moves[2 * number + 1];
		}

		@Override
		public String toString()
		{
			return (white ? "white " : "black ") + getClass().getSimpleName();
		}
	}

	public static class Queen extends Piece
	{
		public Queen(int x, int y, boolean white)
		{
			super(x, y, white, queen, false);
		}
	}

	public static class Rook extends Piece
	{
		public Rook(int x, int y, boolean white)
		{
			super(x, y, white, rook, false);
		}
	}

	public static class Bishop extends Piece
	{
		public Bishop(int x, int y, boolean white)
		{
			super(x, y, white, bishop, false);
		}
	}

	public static class Knight extends Piece
	{
		public Knight(int x, int y, boolean white)
		{
			super(x, y, white, knight, true);
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int games = sc.nextInt();
		while (games-- > 0)
		{
			int w = sc.nextInt();
			int b = sc.nextInt();
			int m = sc.nextInt();
			Piece board[][] = new Piece[4][4];
			List<Piece> white = new ArrayList<>();
			List<Piece> black = new ArrayList<>();
			for (int j = 0; j < 2; j++)
			{
				for (int i = 0; i < (j == 0 ? w : b); i++)
				{
					char p = sc.next()
							.charAt(0);
					int x = sc.next()
							.charAt(0) - 'A';
					int y = sc.nextInt() - 1;
					Piece piece = p == 'Q' ? new Queen(x, y, j == 0)
							: p == 'R' ? new Rook(x, y, j == 0)
									: p == 'B' ? new Bishop(x, y, j == 0) : new Knight(x, y, j == 0);
					board[x][y] = piece;
					(j == 0 ? white : black).add(piece);
				}
			}

			boolean win = move(true, white, black, board, m);
			System.out.println(win ? "YES" : "NO");
		}
	}

	public static boolean move(boolean whiteTurn, List<Piece> white, List<Piece> black, Piece[][] board, int m)
	{
		if (m <= 0)
		{
			return false;
		}
		boolean all = !whiteTurn;
		List<Piece> pieces = whiteTurn ? white : black;
		for (Piece piece : pieces)
		{
			if (piece.taken)
			{
				continue;
			}
			for (int i = 0; i < piece.count(); i++)
			{
				if (piece.canMove(i, board))
				{
					board[piece.x][piece.y] = null;
					piece.move(i, false);
					Piece taken = board[piece.x][piece.y];
					board[piece.x][piece.y] = piece;

					if (taken != null)
					{
						taken.taken = true;
					}

					try
					{
						if (taken instanceof Queen)
						{
							return whiteTurn;
						}

						boolean result = move(!whiteTurn, white, black, board, m - 1);

						if (result && whiteTurn)
						{
							return true;
						}
						all &= result;
					}
					finally
					{
						if (taken != null)
						{
							taken.taken = false;
						}

						board[piece.x][piece.y] = taken;
						piece.move(i, true);
						board[piece.x][piece.y] = piece;
					}
				}
			}
		}
		return all;
	}
}