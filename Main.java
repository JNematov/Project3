import java.io.File;
import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);
    static Index currentIndex = null;
        public static void main(String[] args) {
            System.out.println("\nMenu:");
            System.out.println("\tcreate \t\tCreate a new index\n\topen \t\tSet current index\n\tinsert \t\tInsert a new key/value pair into current index\n\tsearch \t\tSearch for a key in current index\n\tload \t\tinsert key/value pairs in current index in key order\n\textract \tsave all key/value pairs in current index into a file\n\tquit \t\tExit the program\n");
            while (true) {
                System.out.print("Enter command: ");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("quit")) {
                    break;
                }
                handleInput(input);
            }
        }

    public static void handleInput(String input){
        switch(input){
            case "create":
            handleCreate();
            break;
            case "open":
            handleOpen();
            break;
            case "insert":
            handleInsert();
            break;
            case "search":
            handleSearch();
            break;
            case "load":
            handleLoad();
            break;
            case "print":
            handlePrint();
            break;
            case "extract":
            handleExtract();
            break;
        }
    }

    public static void handleCreate(){
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine().trim();
        File file = new File(filename);
        try{
            currentIndex = new Index(filename);
        }catch(Exception e){
            System.out.print("File already exists. Overwrite? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y")) {
                System.out.println("Create aborted.");
                return;
            }
        }
    }

    public static void handleOpen(){
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine().trim();
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        //open the file
    }

    public static void handleInsert(){
        // if(currentIndex == null){
        //     System.out.println("\t No index is currently open");
        // }
        int key = 0, value = 0;
        try{
            System.out.print("Enter the key to insert: ");
            key = scanner.nextInt();
            //check for key in index and print error if already exists
        }catch(Exception e){
            System.out.println("Invalid input");
        }      

        try{
            System.out.print("Enter the value to insert: ");
            value = scanner.nextInt();
        }catch(Exception e){
            System.out.println("Invalid input");
        }

        //Insert the value
        System.out.println("Inserted '" + value + "' at key '" + key +"'" );
    }

    public static void handleSearch(){
        int key, value = 0;
        try{
            System.out.print("Enter the key to search for: ");
            key = scanner.nextInt();
            //check for key in index and print error if does not exist
            System.out.println("Value '" + value + "' is at key '" + key +"'");
        }catch(Exception e){
            System.out.println("Invalid input");
        }  
    }

    public static void handleLoad(){
        while(scanner.hasNextLine()){
            //insert key,value into the tree
        }
    }

    public static void handlePrint(){
        //print logic
    }

    public static void handleExtract(){
        System.out.print("Enter filename: ");
        String outFile = scanner.nextLine().trim();
        File file = new File(outFile);
        if (file.exists()) {
            System.out.print("File already exists. Overwrite? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y")) {
                System.out.println("Extract aborted.");
                return;
            }
        }
        //extract logic
    }
}