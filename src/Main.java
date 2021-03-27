import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Integer[] inputData1 = {22, 28, 99, 43, 46, 68, 40, 22, 11, 10, 5, 1, 61, 30, 78, 5, 20, 36, 44, 26};
        Integer[] inputData2 = {22, 65, 8, 16, 82, 58, 24, 37, 62, 24, 51, 36, 52, 99, 79, 50, 68, 71, 73, 31};
        Integer[] inputData3 = {81, 30, 33, 94, 60, 63, 99, 81, 99, 96, 59, 73, 13, 68, 90, 95, 26, 66, 84, 40};
        Integer[] inputDataAll = {22, 28, 99, 43, 46, 68, 40, 22, 11, 10, 5, 1, 61, 30, 78, 5, 20, 36, 44, 26,
                22, 65, 8, 16, 82, 58, 24, 37, 62, 24, 51, 36, 52, 99, 79, 50, 68, 71, 73, 31,
                81, 30, 33, 94, 60, 63, 99, 81, 99, 96, 59, 73, 13, 68, 90, 95, 26, 66, 84, 40};


        unsorted(inputData1, inputData2, inputData3, inputDataAll);
        sortedUp(inputData1, inputData2, inputData3, inputDataAll);
        sortedDown(inputData1, inputData2, inputData3, inputDataAll);

    }

    private static void sortedDown(Integer[] inputData1, Integer[] inputData2, Integer[] inputData3, Integer[] inputDataAll) {
        System.out.println("---------------------sorted down----------------------------");
        Arrays.sort(inputData1, Collections.reverseOrder());
        Arrays.sort(inputData2, Collections.reverseOrder());
        Arrays.sort(inputData3, Collections.reverseOrder());
        Arrays.sort(inputDataAll, Collections.reverseOrder());
        start(inputData1, inputData2, inputData3, inputDataAll);
    }

    private static void sortedUp(Integer[] inputData1, Integer[] inputData2, Integer[] inputData3, Integer[] inputDataAll) {
        System.out.println("-----------------------sorted up-----------------------------");
        Arrays.sort(inputData1);
        Arrays.sort(inputData2);
        Arrays.sort(inputData3);
        Arrays.sort(inputDataAll);
        start(inputData1, inputData2, inputData3, inputDataAll);
    }

    private static void unsorted(Integer[] inputData1, Integer[] inputData2, Integer[] inputData3, Integer[] inputDataAll) {
        System.out.println("-----------------------unsorted-----------------------------");
        start(inputData1, inputData2, inputData3, inputDataAll);

    }

    private static void start(Integer[] inputData1, Integer[] inputData2, Integer[] inputData3, Integer[] inputDataAll) {
        System.out.println("NFA algorithm");
        NFAallFuncComp(inputData1, inputData2, inputData3, inputDataAll); // заповнення наступного

        System.out.println("\nFFA algorithm");
        FFAallFuncComp(inputData1, inputData2, inputData3, inputDataAll); // заповнення наступного

        System.out.println("\nWFA algorithm");
        WFAallFuncComp(inputData1, inputData2, inputData3, inputDataAll); // заповнення наступного

        System.out.println("\nBFA algorithm");
        BFAallFuncComp(inputData1, inputData2, inputData3, inputDataAll); // заповнення наступного
    }

    private static void BFAallFuncComp(Integer[] inputData1, Integer[] inputData2, Integer[] inputData3, Integer[] inputDataAll) {
        System.out.printf("\n####inputData1####");
        BFAfunc(inputData1);
        System.out.printf("\n####inputData2####");
        BFAfunc(inputData2);
        System.out.printf("\n####inputData3####");
        BFAfunc(inputData3);
        System.out.printf("\n####inputDataAll####");
        BFAfunc(inputDataAll);
    }

    private static void WFAallFuncComp(Integer[] inputData1, Integer[] inputData2, Integer[] inputData3, Integer[] inputDataAll) {
        System.out.printf("\n####ninputData1####");
        WFAfunc(inputData1);
        System.out.printf("\n####inputData2####");
        WFAfunc(inputData2);
        System.out.printf("\n####inputData3####");
        WFAfunc(inputData3);
        System.out.printf("\n####inputDataAll####");
        WFAfunc(inputDataAll);
    }

    private static void FFAallFuncComp(Integer[] inputData1, Integer[] inputData2, Integer[] inputData3, Integer[] inputDataAll) {
        System.out.printf("\n####inputData1####");
        FFAfunc(inputData1);
        System.out.printf("\n####inputData2####");
        FFAfunc(inputData2);
        System.out.printf("\n####inputData3####");
        FFAfunc(inputData3);
        System.out.printf("\n####inputDataAll####");
        FFAfunc(inputDataAll);
    }

    private static void NFAallFuncComp(Integer[] inputData1, Integer[] inputData2, Integer[] inputData3, Integer[] inputDataAll) {
        System.out.printf("\n####inputData1####");
        NFAfunc(inputData1);
        System.out.printf("\n####inputData2####");
        NFAfunc(inputData2);
        System.out.printf("\n####inputData3####");
        NFAfunc(inputData3);
        System.out.printf("\n####inputDataAll####");
        NFAfunc(inputDataAll);
    }

    private static void addItem(ArrayList<Container> containers, Integer inputDatum, int iterCont) {
        containers.get(iterCont).content.add(inputDatum);
        containers.get(iterCont).sum += inputDatum;
    }

    private static void addItem(Container temp, Integer inputDatum) {
        temp.content.add(inputDatum);
        temp.sum += inputDatum;
    }

    private static void PrintFunc(ArrayList<Container> containers, int compare) {
        int iterator = 1;
        System.out.println("\nCount containers = " + containers.size() + " \nCount compare = " + compare);
//        for (Container container : containers) {
//            System.out.print("#" + iterator+"  \t|");
//            iterator++;
//            for (Integer content : container.content) {
//                System.out.print(content + " ");
//            }
//            System.out.println("\t| sum = " + container.sum);
//        }
    }

    private static void NFAfunc(Integer[] inputData) {
        ArrayList<Container> containers = new ArrayList<>();
        int compare = 0;

        int iterCont = 0;
        containers.add(new Container());

        for (int i = 0; i < inputData.length; i++) {
            if ((containers.get(iterCont).sum + inputData[i]) <= 100) {
                addItem(containers, inputData[i], iterCont);
            } else {
                iterCont++;
                containers.add(new Container());
                addItem(containers, inputData[i], iterCont);
            }
            compare++;
        }

        PrintFunc(containers, compare);
    }

    private static void FFAfunc(Integer[] inputData) {
        ArrayList<Container> containers = new ArrayList<>();
        int compare = 0;
        int iterCont = 0;
        containers.add(new Container());

        for (int i = 0; i < inputData.length; i++) {
            if ((containers.get(iterCont).sum + inputData[i]) <= 100) {
                compare++;
                addItem(containers, inputData[i], iterCont);
            } else {
                compare++;
                // check free container
                boolean checkFree = false;
                for (Container temp : containers) {
                    if ((temp.sum + inputData[i]) <= 100) {
                        compare++;
                        addItem(temp, inputData[i]);
                        checkFree = true;
                    }
                }
                if (!checkFree) {
                    compare++;
                    iterCont++;
                    containers.add(new Container());
                    addItem(containers, inputData[i], iterCont);
                }
            }
        }

        PrintFunc(containers, compare);
    }

    private static void WFAfunc(Integer[] inputData) {
        ArrayList<Container> containers = new ArrayList<>();
        int compare = 0;
        int iterCont = 0;
        containers.add(new Container());

        for (int i = 0; i < inputData.length; i++) {
            if ((containers.get(iterCont).sum + inputData[i]) <= 100) {
                compare++;
                addItem(containers, inputData[i], iterCont);
            } else {
                compare++;
                int min = containers.get(0).sum, minIter = 0;
                for (int iterTemp = 1; iterTemp < containers.size(); iterTemp++)
                    if (containers.get(iterTemp).sum < min) {
                        compare++;
                        min = containers.get(iterTemp).sum;
                        minIter = iterTemp;
                    }

                if ((containers.get(minIter).sum + inputData[i]) <= 100) {
                    compare++;
                    addItem(containers.get(minIter), inputData[i]);
                } else {
                    compare++;
                    iterCont++;
                    containers.add(new Container());
                    addItem(containers, inputData[i], iterCont);
                }
            }
        }

        PrintFunc(containers, compare);
    }

    private static void BFAfunc(Integer[] inputData) {
        ArrayList<Container> containers = new ArrayList<>();
        int compare = 0;
        int iterCont = 0;
        containers.add(new Container());

        for (int i = 0; i < inputData.length; i++) {
            if ((containers.get(iterCont).sum + inputData[i]) <= 100) {
                compare++;
                addItem(containers, inputData[i], iterCont);
            } else {
                compare++;
                int min = 100, minIter = 0;
                for (int iterTemp = 0; iterTemp < containers.size(); iterTemp++)
                    if (((100 - containers.get(iterTemp).sum) < min) && ((containers.get(iterTemp).sum + inputData[i]) <= 100)) {
                        compare++;
                        compare++;
                        min = 100 - containers.get(iterTemp).sum;
                        minIter = iterTemp;
                    }

                if ((containers.get(minIter).sum + inputData[i]) <= 100) {
                    compare++;
                    addItem(containers.get(minIter), inputData[i]);

                } else {
                    compare++;
                    iterCont++;
                    containers.add(new Container());
                    addItem(containers, inputData[i], iterCont);
                }
            }
        }

        PrintFunc(containers, compare);
    }

}
