package jdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

import bean.Book;

public class ArrayListTest
{
        @Test
        public void testName() throws Exception
        {
                ArrayList<Book> list = new ArrayList<Book>();
                Collections.sort(list, new Comparator<Book>()
                {
                        public int compare(Book o1, Book o2)
                        {
                                
                                return 0;
                        }
                });
        }
}
