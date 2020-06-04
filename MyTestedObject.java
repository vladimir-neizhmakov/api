public class MyTestedObject {
/*
2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки.
Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
*/
    private final static int DELIMITER = 4;

    public static int[] ExtractFromPacket(int[] packet){
        for (int i = packet.length-1; i > 0; i--) {
            if (packet[i] == DELIMITER){
                int[] message = new int[packet.length - i - 1];
                for (int j = 0; j < packet.length - i - 1; j++) {
                    message[j] = packet[j+i+1];
                }
                return message;
            }
        } throw new RuntimeException("INPUT PACKET WITHOUT DELIMITER");
    }
}
