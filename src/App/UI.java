package App;

import java.util.Scanner;

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

    private static final Scanner sc = new Scanner(System.in);
    private static final CopaDoMundo copaDoMundo = new CopaDoMundo();

    public static void init()
    {
        printLogoDoMenu();
        printMenu();
        int opcaoUser = sc.nextInt();
        initDoMenu(opcaoUser);

    }

    private static void printLogoDoMenu()
    {
        System.out.println(ANSI_BLUE + " _______  __   _______    ___      " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|   ____||  | |   ____|  /   \\     " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|  |__   |  | |  |__    /  ^  \\    " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|   __|  |  | |   __|  /  /_\\  \\   " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|  |     |  | |  |    /  _____  \\  " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "|__|     |__| |__|   /__/     \\__\\ " + ANSI_RESET);
    }

    private static void printMenu() 
    {
        System.out.println(ANSI_GREEN + "Opções:"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "1. Inicio" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "2. Ver Todos Paises"+ ANSI_RESET);
        System.out.println(ANSI_BLUE + "3. Ver Todos Jogadores"+ ANSI_RESET);
        System.out.println(ANSI_RED + "0. Sair"+ ANSI_RESET);
    }

    private static void initDoMenu(int opcaoUser)
    {
        do
        {
            switch(opcaoUser)
            {
                case 1:

                    copaDoMundo.CopaDoMundoInit();

                break;

                case 2:

                    copaDoMundo.CopaDoMundoInit();

                break;

                case 3:

                    copaDoMundo.CopaDoMundoInit();

                break;

                case 0:

                    System.out.println(ANSI_RED + "Saindo..." + ANSI_RESET);

                break;
            }
        }
        while(opcaoUser != 0);
    }

    private static void initDaCopaDoMundo()
    {
        
    }
}
