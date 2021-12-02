import java.util.Scanner;

enum StringCommand {ADD, REMOVE, CLEAN, QUIT, INVALID}
public class StringSetManager {
    static int index = 0;
    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);
        String[] stringSet = new String[100];
        while ( true ){
            final StringCommand command = getCommand(scanner);
            if (command == StringCommand.QUIT){
                System.out.println("BYE!"); break;
            }
            switch (command) {
                case ADD: {
                    final String str = getString(scanner);
                    add(stringSet, str);
                    break;
                }
                case REMOVE: {
                    final String str = getString(scanner);
                    remove(stringSet, str);
                    break;
                }
                case CLEAN:{
                    clear(stringSet);
                    break;
                }
                default:
                    System.out.println("Unknown Command!");
                    break;
            }
            print(stringSet);
        }
    }
    private static StringCommand getCommand(Scanner scanner){
        String commandName = scanner.next();
        StringCommand stringCommand;
        String[] commands = {"ADD", "REMOVE", "CLEAN", "QUIT"};
        for (String s : commands){
            if (s.equalsIgnoreCase(commandName)){
                stringCommand = StringCommand.valueOf(commandName.toUpperCase());
                return stringCommand;
            }
        }
        stringCommand = StringCommand.INVALID;
        return stringCommand;
    }
    private static String getString(Scanner scanner){
        return scanner.nextLine();
    }
    private static void add(String[] stringSet, String str){
        int i;
        str = str.trim();
        for (i=0; i<index; i++){
            if (stringSet[i].equals(str)) break;
        }
        if (i==index) {
            stringSet[index] = str;
            index++;
        }
    }
    private static void remove(String[] stringSet, String str){
        int i;
        str = str.trim();
        for (i=0; i<index; i++){
            if (stringSet[i].equals(str)){
                System.arraycopy(stringSet, i+1, stringSet, i, index-1-i);
                break;
            }
        }
        if (i!=index) index--;
    }
    private static void clear(String[] stringSet){
        index = 0;
    }
    private static void print(String[] stringSet){
        System.out.print("Element Size: " + index + ", Values = [");
        for (int i=0; i<index; i++){
            System.out.print(stringSet[i]);
            if (i!=index-1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
