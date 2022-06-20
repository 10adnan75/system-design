public class HelperClass {
    public static void clearScreen() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (Exception e) {
            System.out.println("\n\n\n\n");
        }
    }
}
