package com.wenbin.base.lambda.chepter5;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Auther: wenbin
 * @Date: 2018/12/23 10:52
 * @Description:
 */
public class StreamPractise {

    public static void main(String[] args) {
        System.out.println("----------筛选和切片-----------");
        // filter操作会接受一个谓词作为参数,并返回一个包括所有符合谓词元素的流.
        filter();
        System.out.println("------------------------");
        // distinct返回一个元素各异(根据流所生成元素的hashCode和equals方法实现)的流.
        distinct();
        System.out.println("------------------------");
        // limit方法返回一个不超过给定长度的流.所需长度作为参数传递给limit.
        // 如果流是有序的,则会返回前n个元素.
        // 会短路
        limit();
        System.out.println("------------------------");
        // skip方法,跳过元素,返回一个 扔掉前n个元素的流.如果流中元素不足n个,则返回一个空流.
        // limit和skip是互补的.
        skip();
        System.out.println("------------映射------------");
        // map方法,接受一个函数作为参数.这个函数会被应用到每个元素上,并将其映射成一个新的元素
        // 映射和转换类似,映射结果是创建一个新的版本,而不是去修改.
        map();
        System.out.println("------------------------");
        mapToValue();
        System.out.println("------------------------");
        map2();
        System.out.println("------------------------");
        map3();
        System.out.println("------------------------");
        map4();
        System.out.println("------------------------");

        System.out.println("-----------流的扁平化------------");
        // flatMap方法让你把一个流中的每个值都换成另一个流,然后把所有的流连接起来成为一个流
        flatMap();
        System.out.println("------------------------");
        flatMap1();
        System.out.println("------------------------");
        flatMap2();
        System.out.println("------------查找和匹配------------");
        // anyMatch方法可以回答"流中是否有一个元素能匹配给定的谓词"
        anyMatch();
        System.out.println("------------------------");
        // allMatch方法看流中的元素是否都能匹配给定的谓词.
        allMatch();
        System.out.println("------------------------");
        // noneMatch方法看流中没有任何元素与给定的谓词匹配.
        noneMatch();
        System.out.println("------------------------");
        // findAny方法看数据集中的某些元素是否匹配一个给定的属性
        findAny();
        System.out.println("------------------------");
        // findFirst方法找到刘中第一个符合条件的元素
        findFirst();
        System.out.println("-----------归约-------------");
        /**
         * 需要将流中所有元素反复结合起来,得到一个值.这样的查询可以被归类为归约操作
         * 用函数式编程的术语来说,这称为折叠(fold).
         */
        // reduce操作是,反复使用Lambda表达式,知道流被归约成一个值.
        // 求和
        sumReduce();
        System.out.println("------------------------");
        // 相乘
        multiplyReduce();
        System.out.println("------------------------");
        reduceOther();
        System.out.println("------------------------");
        /**
         * 归约方法的优势与并行化:
         * 相比于之前的逐步迭代求和,使用reduce的好处在于,这里的迭代被内部迭代抽象掉了,这让内部
         * 实现得以选择并行执行reduce操作.而迭代求和要并行需要更新共享变量.如果加入了同步,很可能
         * 线程竞争抵消了并行本应带来的性能提升.这种计算的并行化需要将输入分块,分块求和,最后在合并
         * 起来.但是使用fork/join方法代码结构就会复杂很多.
         */

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(calories);
        // 上面代码暗含装箱的执行成本,每个Integer都必须拆箱成一个原始类型再进行求和.

        System.out.println("----------原始类型流特化--------------");
        /**
         * Java 8 引入了三个原始类型特化流接口来解决拆箱问题: IntStream,DoubleStream,LongStream,
         * 分别将流中的元素特化未int,double,long,从而避免了暗含的装箱成本.每个接口都带来了进行常用
         * 数值归约的新方法,比如对数值流求和的sum,找到最大元素的max.
         */
        // 将流转换为特化版本的常用方法是mapToInt,mapToDouble,mapToLong,它们和map的使用方法一样
        // 但是返回的是一个特化流
        mapToInt();
        System.out.println("------------------------");
        rangeOrRangeClosed();
        System.out.println("------------------------");

        System.out.println("--------------构建流---------------");
        constructorStream();

        System.out.println("--------------收集器(待续)----------");
        System.out.println("--------------并行(待续)----------");

    }





    public static void constructorStream() {
        // 由值创建流:使用静态方法Stream.of,通过显示值创建一个流.可以接受任意数量参数.
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In ", "Action");
        stream.map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("------------------------");
        // 由数组创建流:使用静态方法Arrays.stream从数组创建一个流.
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("Arrays.stream:" + sum);
        System.out.println("------------------------");
        // 由文件生成流
        /**
         * Java中用于处理文件等I/O操作的NIO API (非阻塞 I/O)已更新.以便利用Stream API.
         * java.nio.file.Files 中很多静态方法都会返回一个流.
         */

        // 使用Files.lines获得一个流,每个元素都文件中的一行.
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("/Users/wenbin/log/awk/awk_copy.log"), Charset.defaultCharset())) {
            // 文件中有多少不重复的单词
            uniqueWords = lines
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("awk_copy.log:" + uniqueWords);

        /**
         * 由函数生成流:创建无限流
         * Stream API 提供了两个静态方法来从函数生成流: Stream.iterate和Stream.generate
         * 这两个操作可以创建无限流:
         * 无限流: 不像从固定集合创建流那样有固定大小的流.由iterate和generate产生的流会用给定
         * 的函数按需创建值,因此可以无穷无尽的计算下去.一般来说应该使用limit限制这种流.
         * 这是流和集合之间关键区别
         */

        // iterate方法接受一个初始值,还有一个依次应用在每个产生的新值上的Lambda
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("------------------------");

        // generate方法接受一个Supplier<T>类型的Lambda提供新的值
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("------------------------");
    }

    public static void rangeOrRangeClosed() {
        /**
         * Java8 引入了两个可以用于IntStream和LongStream的静态方法,帮助生成这种范围:
         * range和rangeClosed.这两个方法都是第一个参数接受起始值,第二个参数接受结束值.
         */

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);

        IntStream evenNumbers1 = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);

        //range不包含结尾数, rangeClosed包含结束数
        System.out.println(evenNumbers.count());
        System.out.println(evenNumbers1.count());
    }

    public static void mapToInt() {
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println("mapToInt:" + calories);

        // 转换回对象流
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        // 将数值流转换为对象流
        Stream<Integer> stream = intStream.boxed();
        stream.collect(Collectors.toList()).forEach(System.out::println);

        // 对于三种原始流特化,也分别有一个Optional原始类型特化版本:
        // OptionalInt,OptionalDouble,OptionalLong

        OptionalInt optionalInt = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        System.out.println(optionalInt.getAsInt());

    }

    public static void reduceOther() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        // 用map和reduce数一数流中有多少菜
        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);

        max.ifPresent(integer -> System.out.println("max:" + max.get()));
        min.ifPresent(integer -> System.out.println("min:" + min.get()));

        System.out.println("count:" + count);
    }

    public static void multiplyReduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(sum);
    }


    public static void sumReduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        // reduce还有一个重载变体,它不接收初始值,但是会返回一个Optional对象
        Optional<Integer> sum3 = numbers.stream().reduce((a, b) -> (a + b));


        System.out.println("1:" + sum);
        System.out.println("2:" + sum2);
        System.out.println("3:" + sum3.get());
        sum3.ifPresent(System.out::println);

    }

    public static void findFirst() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivis = someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();

        firstSquareDivis.ifPresent(integer -> System.out.println(integer));

    }

    public static void noneMatch() {
        if (menu.stream().noneMatch(d -> d.getCalories() >= 1000)) {
            System.out.println("所有都不满足");
        }
    }

    public static void allMatch() {
        if (menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("所有都满足");
        }
    }

    public static void anyMatch() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }

    public static void findAny() {
        // findAny方法将返回当前流中的任意元素.它可以与其他流操作结合使用
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        /**
         * Optional<T> 类是一个容器类.代表一个值存在或不存在.
         * java8的库设计人员引入了Optional<T>,着用就不用返回众所周知容易出问题的null.
         */

        // 在Optinal包含值的时候返回true,否则返回false
        if (dish.isPresent()) {
            // 会再存在值的时候执行给定的代码块.
            dish.ifPresent(dish1 -> System.out.println(dish));

            Dish dish2 = dish.get(); // 值存在时返回值.否则抛出NoSuchElement异常
            System.out.println(dish2);
            // 会在值存在时返回值,否则返回一个默认值.
            Dish dish3 = dish.orElse(new Dish("pork2", false, 800, Type.MEAT));
            System.out.println(dish3);
        }

    }

    public static void flatMap2() {
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        List<int[]> pairs = number1.stream()
                .flatMap(i ->
                        number2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                ).collect(Collectors.toList());

        pairs.forEach(s -> Arrays.stream(s).forEach(i -> System.out.println(i)));

    }

    public static void flatMap1() {
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        List<int[]> pairs = number1.stream()
                .flatMap(i -> number2.stream()
                        .map(j -> new int[]{i, j})
                ).collect(Collectors.toList());

        pairs.forEach(s -> Arrays.stream(s).forEach(i -> System.out.println(i)));
//        pairs.forEach(s -> System.out.println(s));
    }

    public static void map4() {
        // 给定数字列表返回列表数的平方构成的列表
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        squares.forEach(s -> System.out.println(s));

    }

    public static void flatMap() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> list = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        list.forEach(s -> System.out.println(s));
    }

    public static void map3() {
        List<String> words = Arrays.asList("Hello", "World");

        List<String[]> list = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        list.forEach(s -> System.out.println(s.length));
    }

    public static void map2() {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        wordLengths.forEach(integer -> System.out.println(integer));
    }

    public static void map() {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        dishNames.forEach(s -> System.out.println(s));
    }

    public static void mapToValue() {
        List<Value> dishValueList = menu.stream()
                .map(dish -> new Value(dish.getName(), dish.getCalories()))
                .collect(Collectors.toList());

        dishValueList.forEach(value -> System.out.println(value));
    }

    public static void skip() {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        dishes.forEach(dish -> System.out.println(dish));
    }

    public static void filter() {
        // filter 方法筛选出符合条件的元素,collect方法转换为新的集合
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        vegetarianMenu.forEach(dish -> System.out.println(dish.getName()));
    }

    public static void distinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        numbers.stream()
                .filter(i -> i % 2 == 0)  // 获取偶数
                .distinct()// 去除重复
                .forEach(System.out::println);
    }

    public static void limit() {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());

        dishes.forEach(dish -> System.out.println(dish));

    }
    public enum Type {MEAT, FISH , OHTER}

    private static class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;



        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Dish{" +
                    "name='" + name + '\'' +
                    ", vegetarian=" + vegetarian +
                    ", calories=" + calories +
                    ", type=" + type +
                    '}';
        }
    }
    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OHTER),
            new Dish("rice", true, 350, Type.OHTER),
            new Dish("season fruit", true, 120, Type.OHTER),
            new Dish("pizza", true, 550, Type.OHTER),
            new Dish("prawna", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH)
    );

}
