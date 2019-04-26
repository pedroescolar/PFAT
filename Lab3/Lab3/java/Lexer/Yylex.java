package Lexer;
import Errors.LexerException;
import Parser.sym;


public class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;

private java_cup.runtime.Symbol tok(int k, Object value) {
  //System.out.println("Token: " + k);
  return new java_cup.runtime.Symbol(k, yyline, 0, value); 
}
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NOT_ACCEPT,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"48:9,47:2,48:2,47,48:18,47,48:7,35,36,34,32,37,38,44,33,19,20,18,43:5,21,43" +
",28,27,30,29,31,48:2,46:4,45,17,46:2,22,46:6,16,46,23,46:8,48:6,13,26,25,9," +
"5,2,39,4,1,46,41,7,46,6,12,11,46,14,8,3,42,24,10,46,40,15,48:5,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,128,
"0,1,2,3,1,4,1:10,5,6,7,6:3,1,6:20,8,9,10,11,12,1,13,14,15,16,17,18,19,20,21" +
",22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46" +
",47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71" +
",72,73,74,75,76,77,78,79,80,81,82,83,6,84,85,86,87,88,89,90")[0];

	private int yy_nxt[][] = unpackFromString(91,49,
"1,2,44,100,120,47,79,120,101,50,122,51,52,80,81,120,123,120,3:4,124,125,102" +
",126,103,4,5,6,7,8,9,10,11,12,13,14,15,104,127,120:2,3,45,53,120,16,48,-1:5" +
"0,120,17,120:3,54,120:20,-1:12,120:5,-1,120:2,-1:7,43,-1:12,3:4,-1:21,3,46," +
"43,-1:32,22,-1:66,16,-1:2,120:26,-1:12,120:5,-1,120:2,-1:3,120:17,18:4,120:" +
"5,-1:12,120:4,18,-1,120:2,-1:20,49:4,-1:10,43,-1:5,43,-1:4,49,-1:6,120:12,1" +
"05,120:13,-1:12,120:5,-1,120:2,-1:20,46:4,-1:21,46,-1:10,43,-1:12,46:4,-1:2" +
"1,46,-1,43,-1:4,120:5,55,84,120:10,18:4,120:5,-1:5,43,-1:5,43,120:4,18,-1,1" +
"20:2,-1:20,49:4,-1:21,49,-1:6,120:11,19,120:14,-1:12,120:5,-1,120:2,-1:3,20" +
",120:5,87,120:19,-1:12,120:5,-1,120:2,-1:3,120:13,21,120:12,-1:12,120:5,-1," +
"120:2,-1:3,120:17,18:4,120:5,-1:5,43,-1:5,43,120:4,18,-1,120:2,-1:3,120:2,2" +
"3,120:23,-1:12,120:5,-1,120:2,-1:3,120:8,24,120:17,-1:12,120:5,-1,120:2,-1:" +
"3,120:2,25,120:23,-1:12,120:5,-1,120:2,-1:3,120:8,26,120:17,-1:12,120:5,-1," +
"120:2,-1:3,120:8,27,120:3,65,120:13,-1:12,120:5,-1,120:2,-1:3,120:5,28,120:" +
"20,-1:12,120:5,-1,120:2,-1:3,120:4,29,120:21,-1:12,120:5,-1,120:2,-1:3,120:" +
"4,30,120:21,-1:12,120:5,-1,120:2,-1:3,120:4,31,120:21,-1:12,120:5,-1,120:2," +
"-1:3,120:11,32,120:14,-1:12,120:5,-1,120:2,-1:3,120:2,33,120:23,-1:12,120:5" +
",-1,120:2,-1:3,120:6,34,120:19,-1:12,120:5,-1,120:2,-1:3,120:7,35,120:18,-1" +
":12,120:5,-1,120:2,-1:3,120:4,27,120:21,-1:12,120:5,-1,120:2,-1:3,120:6,36," +
"120:19,-1:12,120:5,-1,120:2,-1:3,120:4,73,120:21,-1:12,120,27,120:3,-1,120:" +
"2,-1:3,120:4,37,120:21,-1:12,120:5,-1,120:2,-1:3,120:4,38,120:21,-1:12,120:" +
"5,-1,120:2,-1:3,120:26,-1:12,120:2,27,120:2,-1,120:2,-1:3,120:5,27,120:20,-" +
"1:12,120:5,-1,120:2,-1:3,120:20,39,120:5,-1:12,120:5,-1,120:2,-1:3,120:11,4" +
"0,120:14,-1:12,120:5,-1,120:2,-1:3,120:9,27,120:16,-1:12,120:5,-1,120:2,-1:" +
"3,120:6,41,120:19,-1:12,120:5,-1,120:2,-1:3,120:2,42,120:23,-1:12,120:5,-1," +
"120:2,-1:3,120:11,56,120:14,-1:12,120:5,-1,120:2,-1:3,120:5,57,120:20,-1:12" +
",120:5,-1,120:2,-1:3,120:4,58,120:21,-1:12,120:5,-1,120:2,-1:3,120:4,59,120" +
":21,-1:12,120:5,-1,120:2,-1:3,120:26,-1:12,120:3,60,120,-1,120:2,-1:3,120:7" +
",61,120:18,-1:12,120:5,-1,120:2,-1:3,120:14,62,120:11,-1:12,120:5,-1,120:2," +
"-1:3,120:5,63,120:20,-1:12,120:5,-1,120:2,-1:3,120:11,64,120:14,-1:12,120:5" +
",-1,120:2,-1:3,120:13,66,120:12,-1:12,120:5,-1,120:2,-1:3,120:12,94,120:13," +
"-1:12,120:3,67,120,-1,120:2,-1:3,120:11,68,120:14,-1:12,120:5,-1,120:2,-1:3" +
",120:4,69,120:21,-1:12,120:5,-1,120:2,-1:3,120:7,70,120:18,-1:12,120:5,-1,1" +
"20:2,-1:3,120:2,67,120:3,71,120:19,-1:12,120:5,-1,120:2,-1:3,120:24,72,120," +
"-1:12,120:5,-1,120:2,-1:3,120:19,74,120:6,-1:12,120:5,-1,120:2,-1:3,120:5,7" +
"5,120:20,-1:12,120:5,-1,120:2,-1:3,120:11,76,120:14,-1:12,120:5,-1,120:2,-1" +
":3,120:12,77,120:13,-1:12,120:5,-1,120:2,-1:3,120:5,78,120:20,-1:12,120:5,-" +
"1,120:2,-1:3,120:3,82,120:9,83,120:12,-1:12,120:5,-1,120:2,-1:3,85,120:3,86" +
",120:21,-1:12,120:5,-1,120:2,-1:3,120:12,88,120:13,-1:12,120:5,-1,120:2,-1:" +
"3,120:6,89,120:4,90,120:14,-1:12,120:5,-1,120:2,-1:3,120:13,91,120:12,-1:12" +
",120:5,-1,120:2,-1:3,120:6,92,120:19,-1:12,120:5,-1,120:2,-1:3,93,120:25,-1" +
":12,120:5,-1,120:2,-1:3,120:17,112,120:8,-1:12,120:5,-1,120:2,-1:3,120:2,11" +
"3,120:23,-1:12,120:5,-1,120:2,-1:3,120:12,121,120:13,-1:12,120:5,-1,120:2,-" +
"1:3,120:7,114,120:18,-1:12,120:5,-1,120:2,-1:3,120:6,115,120:19,-1:12,120:5" +
",-1,120:2,-1:3,120:18,95,120:7,-1:12,120:5,-1,120:2,-1:3,120:17,116,120:8,-" +
"1:12,120:5,-1,120:2,-1:3,120:4,96,120:21,-1:12,120:5,-1,120:2,-1:3,120:6,97" +
",120:19,-1:12,120:5,-1,120:2,-1:3,120:22,118,120:3,-1:12,120:5,-1,120:2,-1:" +
"3,120:17,119,120:8,-1:12,120:5,-1,120:2,-1:3,120:4,98,120:21,-1:12,120:5,-1" +
",120:2,-1:3,120:21,99,120:4,-1:12,120:5,-1,120:2,-1:3,120:6,117,120:19,-1:1" +
"2,120:5,-1,120:2,-1:3,120:3,106,120:22,-1:12,120:5,-1,120:2,-1:3,120:16,107" +
",120:9,-1:12,120:5,-1,120:2,-1:3,120:5,108,120:20,-1:12,120:5,-1,120:2,-1:3" +
",120:4,109,120:21,-1:12,120:5,-1,120:2,-1:3,120:11,110,120:14,-1:12,120:5,-" +
"1,120:2,-1:3,120:4,111,120:21,-1:12,120:5,-1,120:2,-1:2");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException, 
LexerException

		{
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

{return tok(sym.EOF, null); }
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{return tok(sym.IDENT, yytext()); }
					case -3:
						break;
					case 3:
						{return tok(sym.CENT, new Integer(yytext())); }
					case -4:
						break;
					case 4:
						{return tok(sym.PC, null); }
					case -5:
						break;
					case 5:
						{throw new LexerException("Caracter Ilegal en linea " + yyline); }
					case -6:
						break;
					case 6:
						{return tok(sym.IGUALQUE, null); }
					case -7:
						break;
					case 7:
						{return tok(sym.MENORQUE, null); }
					case -8:
						break;
					case 8:
						{return tok(sym.MAYORQUE, null); }
					case -9:
						break;
					case 9:
						{return tok(sym.MAS, null); }
					case -10:
						break;
					case 10:
						{return tok(sym.DIV, null); }
					case -11:
						break;
					case 11:
						{return tok(sym.POR, null); }
					case -12:
						break;
					case 12:
						{return tok(sym.PAREN, null); }
					case -13:
						break;
					case 13:
						{return tok(sym.TESIS, null); }
					case -14:
						break;
					case 14:
						{return tok(sym.COMA, null); }
					case -15:
						break;
					case 15:
						{return tok(sym.MENOS, null); }
					case -16:
						break;
					case 16:
						{ }
					case -17:
						break;
					case 17:
						{return tok(sym.IF, null); }
					case -18:
						break;
					case 18:
						{return tok(sym.CREAL, new Double(yytext())); }
					case -19:
						break;
					case 19:
						{return tok(sym.DO, null); }
					case -20:
						break;
					case 20:
						{return tok(sym.PI, null); }
					case -21:
						break;
					case 21:
						{return tok(sym.OR, null); }
					case -22:
						break;
					case 22:
						{return tok(sym.ASOP, null); }
					case -23:
						break;
					case 23:
						{return tok(sym.TIPO, new Integer(1)); }
					case -24:
						break;
					case 24:
						{return tok(sym.END, null); }
					case -25:
						break;
					case 25:
						{return tok(sym.NOT, null);	}
					case -26:
						break;
					case 26:
						{return tok(sym.AND, null); }
					case -27:
						break;
					case 27:
						{return tok(sym.COLOR, yytext()); }
					case -28:
						break;
					case 28:
						{return tok(sym.THEN, null); }
					case -29:
						break;
					case 29:
						{return tok(sym.CLOG, new Boolean(true)); }
					case -30:
						break;
					case 30:
						{return tok(sym.ELSE, null); }
					case -31:
						break;
					case 31:
						{return tok(sym.SIZE, null); }
					case -32:
						break;
					case 32:
						{return tok(sym.SENO, null); }
					case -33:
						break;
					case 33:
						{return tok(sym.PLOT, null); }
					case -34:
						break;
					case 34:
						{return tok(sym.TIPO, new Integer(3)); }
					case -35:
						break;
					case 35:
						{return tok(sym.VARS, null); }
					case -36:
						break;
					case 36:
						{return tok(sym.TIPO, new Integer(2)); }
					case -37:
						break;
					case 37:
						{return tok(sym.CLOG, new Boolean(false)); }
					case -38:
						break;
					case 38:
						{return tok(sym.WHILE, null); }
					case -39:
						break;
					case 39:
						{return tok(sym.PROG, null); }
					case -40:
						break;
					case 40:
						{return tok(sym.COSENO, null); }
					case -41:
						break;
					case 41:
						{return tok(sym.INT2REAL, null); }
					case -42:
						break;
					case 42:
						{return tok(sym.REAL2INT, null); }
					case -43:
						break;
					case 44:
						{return tok(sym.IDENT, yytext()); }
					case -44:
						break;
					case 45:
						{throw new LexerException("Caracter Ilegal en linea " + yyline); }
					case -45:
						break;
					case 46:
						{return tok(sym.CREAL, new Double(yytext())); }
					case -46:
						break;
					case 47:
						{return tok(sym.IDENT, yytext()); }
					case -47:
						break;
					case 48:
						{throw new LexerException("Caracter Ilegal en linea " + yyline); }
					case -48:
						break;
					case 49:
						{return tok(sym.CREAL, new Double(yytext())); }
					case -49:
						break;
					case 50:
						{return tok(sym.IDENT, yytext()); }
					case -50:
						break;
					case 51:
						{return tok(sym.IDENT, yytext()); }
					case -51:
						break;
					case 52:
						{return tok(sym.IDENT, yytext()); }
					case -52:
						break;
					case 53:
						{return tok(sym.IDENT, yytext()); }
					case -53:
						break;
					case 54:
						{return tok(sym.IDENT, yytext()); }
					case -54:
						break;
					case 55:
						{return tok(sym.IDENT, yytext()); }
					case -55:
						break;
					case 56:
						{return tok(sym.IDENT, yytext()); }
					case -56:
						break;
					case 57:
						{return tok(sym.IDENT, yytext()); }
					case -57:
						break;
					case 58:
						{return tok(sym.IDENT, yytext()); }
					case -58:
						break;
					case 59:
						{return tok(sym.IDENT, yytext()); }
					case -59:
						break;
					case 60:
						{return tok(sym.IDENT, yytext()); }
					case -60:
						break;
					case 61:
						{return tok(sym.IDENT, yytext()); }
					case -61:
						break;
					case 62:
						{return tok(sym.IDENT, yytext()); }
					case -62:
						break;
					case 63:
						{return tok(sym.IDENT, yytext()); }
					case -63:
						break;
					case 64:
						{return tok(sym.IDENT, yytext()); }
					case -64:
						break;
					case 65:
						{return tok(sym.IDENT, yytext()); }
					case -65:
						break;
					case 66:
						{return tok(sym.IDENT, yytext()); }
					case -66:
						break;
					case 67:
						{return tok(sym.IDENT, yytext()); }
					case -67:
						break;
					case 68:
						{return tok(sym.IDENT, yytext()); }
					case -68:
						break;
					case 69:
						{return tok(sym.IDENT, yytext()); }
					case -69:
						break;
					case 70:
						{return tok(sym.IDENT, yytext()); }
					case -70:
						break;
					case 71:
						{return tok(sym.IDENT, yytext()); }
					case -71:
						break;
					case 72:
						{return tok(sym.IDENT, yytext()); }
					case -72:
						break;
					case 73:
						{return tok(sym.IDENT, yytext()); }
					case -73:
						break;
					case 74:
						{return tok(sym.IDENT, yytext()); }
					case -74:
						break;
					case 75:
						{return tok(sym.IDENT, yytext()); }
					case -75:
						break;
					case 76:
						{return tok(sym.IDENT, yytext()); }
					case -76:
						break;
					case 77:
						{return tok(sym.IDENT, yytext()); }
					case -77:
						break;
					case 78:
						{return tok(sym.IDENT, yytext()); }
					case -78:
						break;
					case 79:
						{return tok(sym.IDENT, yytext()); }
					case -79:
						break;
					case 80:
						{return tok(sym.IDENT, yytext()); }
					case -80:
						break;
					case 81:
						{return tok(sym.IDENT, yytext()); }
					case -81:
						break;
					case 82:
						{return tok(sym.IDENT, yytext()); }
					case -82:
						break;
					case 83:
						{return tok(sym.IDENT, yytext()); }
					case -83:
						break;
					case 84:
						{return tok(sym.IDENT, yytext()); }
					case -84:
						break;
					case 85:
						{return tok(sym.IDENT, yytext()); }
					case -85:
						break;
					case 86:
						{return tok(sym.IDENT, yytext()); }
					case -86:
						break;
					case 87:
						{return tok(sym.IDENT, yytext()); }
					case -87:
						break;
					case 88:
						{return tok(sym.IDENT, yytext()); }
					case -88:
						break;
					case 89:
						{return tok(sym.IDENT, yytext()); }
					case -89:
						break;
					case 90:
						{return tok(sym.IDENT, yytext()); }
					case -90:
						break;
					case 91:
						{return tok(sym.IDENT, yytext()); }
					case -91:
						break;
					case 92:
						{return tok(sym.IDENT, yytext()); }
					case -92:
						break;
					case 93:
						{return tok(sym.IDENT, yytext()); }
					case -93:
						break;
					case 94:
						{return tok(sym.IDENT, yytext()); }
					case -94:
						break;
					case 95:
						{return tok(sym.IDENT, yytext()); }
					case -95:
						break;
					case 96:
						{return tok(sym.IDENT, yytext()); }
					case -96:
						break;
					case 97:
						{return tok(sym.IDENT, yytext()); }
					case -97:
						break;
					case 98:
						{return tok(sym.IDENT, yytext()); }
					case -98:
						break;
					case 99:
						{return tok(sym.IDENT, yytext()); }
					case -99:
						break;
					case 100:
						{return tok(sym.IDENT, yytext()); }
					case -100:
						break;
					case 101:
						{return tok(sym.IDENT, yytext()); }
					case -101:
						break;
					case 102:
						{return tok(sym.IDENT, yytext()); }
					case -102:
						break;
					case 103:
						{return tok(sym.IDENT, yytext()); }
					case -103:
						break;
					case 104:
						{return tok(sym.IDENT, yytext()); }
					case -104:
						break;
					case 105:
						{return tok(sym.IDENT, yytext()); }
					case -105:
						break;
					case 106:
						{return tok(sym.IDENT, yytext()); }
					case -106:
						break;
					case 107:
						{return tok(sym.IDENT, yytext()); }
					case -107:
						break;
					case 108:
						{return tok(sym.IDENT, yytext()); }
					case -108:
						break;
					case 109:
						{return tok(sym.IDENT, yytext()); }
					case -109:
						break;
					case 110:
						{return tok(sym.IDENT, yytext()); }
					case -110:
						break;
					case 111:
						{return tok(sym.IDENT, yytext()); }
					case -111:
						break;
					case 112:
						{return tok(sym.IDENT, yytext()); }
					case -112:
						break;
					case 113:
						{return tok(sym.IDENT, yytext()); }
					case -113:
						break;
					case 114:
						{return tok(sym.IDENT, yytext()); }
					case -114:
						break;
					case 115:
						{return tok(sym.IDENT, yytext()); }
					case -115:
						break;
					case 116:
						{return tok(sym.IDENT, yytext()); }
					case -116:
						break;
					case 117:
						{return tok(sym.IDENT, yytext()); }
					case -117:
						break;
					case 118:
						{return tok(sym.IDENT, yytext()); }
					case -118:
						break;
					case 119:
						{return tok(sym.IDENT, yytext()); }
					case -119:
						break;
					case 120:
						{return tok(sym.IDENT, yytext()); }
					case -120:
						break;
					case 121:
						{return tok(sym.IDENT, yytext()); }
					case -121:
						break;
					case 122:
						{return tok(sym.IDENT, yytext()); }
					case -122:
						break;
					case 123:
						{return tok(sym.IDENT, yytext()); }
					case -123:
						break;
					case 124:
						{return tok(sym.IDENT, yytext()); }
					case -124:
						break;
					case 125:
						{return tok(sym.IDENT, yytext()); }
					case -125:
						break;
					case 126:
						{return tok(sym.IDENT, yytext()); }
					case -126:
						break;
					case 127:
						{return tok(sym.IDENT, yytext()); }
					case -127:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
