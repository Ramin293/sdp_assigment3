public final class Main {
    private static int passed;
    private static int total;

    private Main() {
    }

    public static void main(String[] args) {
        if (args.length != 1 || !"--demo".equals(args[0])) {
            System.err.println("Usage: java -cp out Main --demo");
            return;
        }

        check("T1", "Circle + VectorRenderer",
                new Circle("C-01", 2, new VectorRenderer()).execute(),
                "VECTOR circle radius=2");
        check("T2", "Circle + RasterRenderer",
                new Circle("C-01", 2, new RasterRenderer()).execute(),
                "RASTER circle radius=2 (pixels)");
        check("T3", "Square + VectorRenderer",
                new Square("S-01", 3, new VectorRenderer()).execute(),
                "VECTOR square side=3");
        check("T4", "Square + RasterRenderer",
                new Square("S-01", 3, new RasterRenderer()).execute(),
                "RASTER square side=3 (pixels)");

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void check(String id, String classes, String actual, String expected) {
        boolean success = expected.equals(actual);
        total++;
        if (success) {
            passed++;
        }
        System.out.println(id + " " + status(success) + " | " + classes + " | result=" + actual);
        if (!success) {
            System.out.println("   expected: " + expected);
        }
    }

    private static String status(boolean success) {
        return success ? "PASS" : "FAIL";
    }
}
