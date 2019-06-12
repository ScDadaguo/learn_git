package cn.securitystack.ctuconsole.service.datamigration;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * @FileName: DataMigrationServiceTest.java
 * @Description: DataMigrationServiceTest.java类说明
 * @Author: jiwliu
 * @Date: 2019/4/16 14:13
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
public class DataMigrationServiceTest {
    @Test
    public void verify_behaviour(){
        //模拟创建一个List对象
        List mock = mock(List.class);
        //使用mock的对象
        mock.add(2);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        verify(mock).add(1);
        verify(mock).clear();
    }

    @Test
    public void when_thenReturn(){
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        //验证结果
        assertEquals("hello world world",result);
    }

    @Test
    public void with_unspecified_arguments(){
        List list = mock(List.class);
        //匹配任意参数
        when(list.get(anyInt())).thenReturn(1);
        when(list.contains(argThat(new IsValid()))).thenReturn(true);
        assertEquals(1, list.get(1));
        assertEquals(1, list.get(999));
        assertTrue(list.contains(1));
        assertTrue(!list.contains(3));
    }

    private class IsValid extends ArgumentMatcher<List> {
        @Override
        public boolean matches(Object o) {
            return o.equals(1)  || o.equals(2);
        }

    }

    @Test
    public void testStubbing() throws Exception {
        //你可以mock具体的类，而不仅仅是接口
        LinkedList mockedList = mock(LinkedList.class);

        //设置桩
        when(mockedList.get(0)).thenReturn("first");
//		when(mockedList.get(1)).thenThrow(new RuntimeException());

        //打印 "first"
        System.out.println(mockedList.get(0));

        //这里会抛runtime exception
        System.out.println(mockedList.get(1));

        //这里会打印 "null" 因为 get(999) 没有设置
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }





}
