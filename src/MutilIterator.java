import java.util.*;

/**
 * MutilIterator实现了三种迭代器，分别是默认的前向迭代器，反向迭代器和随机迭代器。主函数中分别调用了三种迭代器进行遍历。
 */
public class MutilIterator implements Iterable<String>
{
    private String[] words = "Nice to meet you.".split(" ");


    //默认的迭代器,前向遍历
    //匿名内部类
    @Override
    public Iterator<String> iterator() {
        return new Iterator <String>() {
            private  int index=0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    //反向迭代器
    public Iterable<String> reverseIterator(){
        return new Iterable <String>() {

            private int index = words.length - 1;

            @Override
            public Iterator <String> iterator() {
                return new Iterator <String>() {
                    @Override
                    public boolean hasNext() {
                        return  index > -1;
                    }

                    @Override
                    public String next() {
                        return  words[index--];
                    }
                };
            }
        };


    }


    //随机迭代器，注意这里不是创建一个新的Iterator，而是返回了一个打乱的List中的迭代器
    public Iterable<String> randomized() {
        return new Iterable <String>() {
            @Override
            public Iterator <String> iterator() {
                List<String> shuffled=new ArrayList <>(Arrays.asList(words));
                Collections.shuffle(shuffled,new Random(47));
                return shuffled.iterator();
            }
        };
    }


    public static void main (String args[]){
        MutilIterator mi = new MutilIterator();

        //默认的迭代器
        for (String word : mi) {
        System.out.print(word + " ");
        }
        System.out.println();

        //反向迭代器
        for (String word: mi.reverseIterator()) {
            System.out.print(word + " ");
        }
        System.out.println();
        //随机迭代器
        for (String word : mi.randomized()) {
        System.out.print(word + " ");
        }


    }

}
