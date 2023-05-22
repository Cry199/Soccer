package App;

import CopaDoMundo.CopaDoMundo;

public class UI
{
    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen() 
    {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

    public static void init()
    {
        /* 
        CopaDoMundo copaDoMundo = new CopaDoMundo();
        copaDoMundo.CopaDoMundoInit();
        */

        printLogoDoMenu();
        printMenu();
    }

    public static void printLogoDoMenu()
    {
        System.out.println(ANSI_BLUE + " _______  __   _______    ___      " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|   ____||  | |   ____|  /   \\     " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|  |__   |  | |  |__    /  ^  \\    " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|   __|  |  | |   __|  /  /_\\  \\   " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|  |     |  | |  |    /  _____  \\  " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|__|     |__| |__|   /__/     \\__\\ " + ANSI_RESET);
    }

    public static void printMenu() 
    {
        System.out.println("Opções:");
        System.out.println("1. Opção 1");
        System.out.println("2. Opção 2");
        System.out.println("3. Opção 3");
        System.out.println("4. Opção 4");
        System.out.println("5. Opção 5");
        System.out.println("0. Sair");
    }
}
