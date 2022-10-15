import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;

public class ArrayTests {

  /*@Test
  public void testReversed() {
    int[] input1 = {1,2,3,4};
    assertArrayEquals(new int[]{4,3,2,1}, ArrayExamples.reversed(input1));
  }

  @Test
  public void testReversed1() {
    int[] input1 = {3,3,3};
    assertArrayEquals(new int[]{3,3,3}, ArrayExamples.reversed(input1));
  }

  @Test
  public void testReversed2() {
    int[] input1 = {6,4,78,9,1};
    assertArrayEquals(new int[]{1,9,78,4,6}, ArrayExamples.reversed(input1));
  }
   
	/*@Test 
	public void testReverseInPlace() {
    int[] input1 = { 4,3,2,1,0 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 0,1,2,3,4 }, input1);
	}*/

  /*@Test
    public void testReverseInPlace1() {
    int[] input1 = { 4,3,2,1 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 1,2,3,4 }, input1);
}
@Test 
	public void averageWithoutLowest1 () {
    double[] input1 = { 4,3,2,1,0 };
    assertEquals(2.25, ArrayExamples.averageWithoutLowest(input1),0.01);
	}

  @Test 
	public void averageWithoutLowest2 () {
    double[] input1 = {6,5,7,3,5};
    assertEquals(5.75, ArrayExamples.averageWithoutLowest(input1),0.01);
	}

  @Test 
	public void averageWithoutLowest3 () {
    double[] input1 = {1,4,4,9,3};
    assertEquals(5, ArrayExamples.averageWithoutLowest(input1),0.01);
	}

  @Test 
	public void averageWithoutLowest4() {
    double[] input1 = {1,1,4,4,9,3};
    assertEquals(5, ArrayExamples.averageWithoutLowest(input1),0.01);
	}
  */

  @Test
  public void testmerge1(){
      List<String> list1=List.of("a", "c", "f");
      List<String> list2=List.of("d", "e", "g");
      List<String> result=List.of("a", "c", "d","e", "f", "g");

      assertEquals(result, ListExamples.merge(list1,list2));
  }

  @Test
  public void testmerge2(){
      List<String> list1=List.of("b", "c", "g");
      List<String> list2=List.of("d", "e", "z");
      List<String> result=List.of("b", "c", "d","e", "g", "z");

      assertEquals(result, ListExamples.merge(list1,list2));
  }
}
