import java.util.Scanner;

enum Command {ADD, LIST, SUM, MAX, MIN, QUIT, NO_COMMAND}
public class ArrayEnum {
    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);
        int[] values = new int[100];
        int index = 0;
        while (true) {
            final Command command = getCommand(scanner);
            if (command == Command.QUIT) {
                System.out.println("Bye!");
                break;
            }
            switch (command){
                case ADD:
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case LIST:
                    printList(values, index);
                    break;
                case SUM:
                    System.out.println(getSum(values, index));
                    break;
                case MAX:
                    System.out.println(getMax(values, index));
                    break;
                case MIN:
                    System.out.println(getMin(values, index));
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }
    private static Command getCommand(Scanner scanner){
        String commandName = scanner.next();
        Command command;
        String[] commands = {"ADD", "LIST", "SUM", "MAX", "MIN", "QUIT"};
        for (String s : commands){
            if (s.equalsIgnoreCase(commandName)) {
                command = Command.valueOf(commandName.toUpperCase());
                return command;
            }
        }
        command = Command.NO_COMMAND;
        return command;
    }
    private static int getValue(Scanner scanner){
        return scanner.nextInt();
    }
    private static void printList(int[] values, int index){
        for(int i=0; i<index; i++){
            System.out.print(values[i]+" ");
        }
        System.out.println();
    }
    private static int getSum(int[] values, int index){
        int sum = 0;
        for (int i=0; i<index; i++) sum += values[i];
        return sum;
    }
    private static int getMax(int[] values, int index){
        int max = values[0];
        for (int i=1; i<index; i++){
            if (values[i]>max) max = values[i];
        }
        return max;
    }
    public static int getMin(int[] values, int index){
        int min = values[0];
        for (int i=1; i<index; i++){
            if (values[i]<min) min = values[i];
        }
        return min;
    }
}
