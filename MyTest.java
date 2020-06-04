public class MyTest {

    private static MyTestedObject testedObject= new MyTestedObject();

    @BeforeSuite
    public static void init() {
        System.out.println("-------------The Start------------");
    }

    @AfterSuite
    public static void fin() {
        System.out.println("-------------The End--------------");
    }

    @Test
    public static void Test_1_Values_ExtractFromPacket() {
        int[] input = {3,4,5,7,8,9,5,4,2,3,7,6,8,9};
        int[] output = {2,3,7,6,8,9};
        MyTester.assertArrayEquals(output, testedObject.ExtractFromPacket(input));
    }

    @Test(priority = 1)
    public static void Test_2_Values_ExtractFromPacket() {
        int[] input = {3,4,5,6,8,9,1};
        int[] output = {5,6,8,9,1};
        MyTester.assertArrayEquals(output, testedObject.ExtractFromPacket(input));
    }


}
