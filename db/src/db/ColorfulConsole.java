package db;
public class ColorfulConsole {
    public static void main(String[] args) {
        // ANSI escape codes for colors
        String reset = "\u001B[0m";     // Resets the color
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";

        // Example output with colors
        System.out.println(red + "This text is red!" + reset+"hello");
        System.out.println(green + "This text is green!" + reset);
        System.out.println(yellow + "This text is yellow!" + reset);
        System.out.println(blue + "This text is blue!" + reset);
    }
}
