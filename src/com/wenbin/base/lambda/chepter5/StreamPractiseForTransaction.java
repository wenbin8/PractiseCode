package com.wenbin.base.lambda.chepter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Auther: wenbin
 * @Date: 2018/12/23 15:00
 * @Description:
 */
public class StreamPractiseForTransaction {


    private static List<Transaction> transactions;

    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }


    public static void main(String[] args) {
        // 找出2011年发生的所有交易,并按照交易额排序
        findTranscation();
        System.out.println("-----------------");
        // 交易员都在哪些不同的城市
        distintCity();
        System.out.println("-----------------");
        // 找出所有来自剑桥的交易员
        getForCambridgeTrader();
        System.out.println("-----------------");
        // 返回所有交易员的姓名字符串,按字母顺序排序
        getNameInfo();
        System.out.println("-----------------");
        // 有没有交易员是在米兰工作的
        isMilanJob();
        System.out.println("-----------------");
        // 打印生活在剑桥的交易员的所有交易额
        getCambridgeValue();
        System.out.println("-----------------");
        // 所有交易额中,最高的交易额是多少
        getMaxValue();
        System.out.println("-----------------");
        // 找到交易额中,最小的交易
        getMinValue();
        System.out.println("-----------------");

    }

    public static void getMinValue() {
        Optional<Integer> minValue = transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compareTo);
        System.out.println("minValue:" + minValue.get());

        // 找到交易
        Optional<Transaction> minTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(minTransaction.get());
    }

    public static void getMaxValue() {
        Optional<Transaction> optional = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));

        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);

        System.out.println("maxValue:" + maxValue.get());

        optional.ifPresent(transaction -> System.out.println(transaction));


    }

    public static void getCambridgeValue() {
        // 打印生活在剑桥的交易员的所有交易额
        int sum = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, (a, b) -> a + b);

        System.out.println("总数:" + sum);
    }

    public static void isMilanJob() {
        // 有没有交易员是在米兰工作的
        List<Trader> traders = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                .map(Transaction::getTrader)
                .collect(Collectors.toList());

        boolean isMilanJos = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));


        System.out.println(isMilanJos);

        traders.forEach(trader -> System.out.println(trader));
    }

    public static void getNameInfo() {
        // 返回所有交易员的姓名字符串,按字母顺序排序
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .reduce("", (n1, n2) -> n1 + " " + n2);
        System.out.println(names);
    }

    public static void getForCambridgeTrader() {
        // 找出所有来自剑桥的交易员
        List<Trader> traders = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        traders.forEach(trader -> System.out.println(trader));
    }

    public static void distintCity() {
        // 交易员都在哪些不同的城市
        List<String> cityList = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        cityList.forEach(s -> System.out.println(s));

        // 使用toSet
        Set<String> citySet = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        citySet.forEach(s -> System.out.println(s));

    }

    public static void findTranscation() {
        // 找出2011年发生的所有交易,并按照交易额排序
        List<Transaction> orderTransactionList = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        orderTransactionList.forEach(System.out::println);
    }

}
