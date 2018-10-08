# iteratorDemo
iterator and iterable


接口定义
```
public interface Iterable<T> {
  Iterator<T> iterator();
}

public interface Iterator<E> {
  boolean hasNext();
  E next();
  void remove();
}

```
摘自 https://www.zhihu.com/question/271757053/answer/363282519
