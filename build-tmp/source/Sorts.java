import java.util.*;

public class Sorts
{
  public void bubbleSort(int[] list)
  {
    for(int outer = 0; outer < list.length-1; outer++) {
      for(int inner = 0; inner < list.length-outer-1; inner++) {
        if(list[inner] > list[inner+1]) {
          int temp = list[inner];
          list[inner] = list[inner+1];
          list[inner+1] = temp;
        }
      }
    }
  }

  public void selectionSort(int[] list)
  {
    int min, temp;
    for(int outer = 0; outer < list.length-1; outer++) {
      min = outer;
      for(int inner = outer+1; inner < list.length; inner++) {
        if(list[inner] < list[min])
          min = inner;
      }
    temp = list[outer];
    list[outer] = list[min];
    list[min] = temp;
    }
  }
  
  public void insertionSort(int[] list)
  {
    for(int outer = 1; outer < list.length; outer++) {
      int pos = outer;
      int key = list[pos];

      while(pos > 0 && list[pos-1] > key) {
        list[pos] = list[pos-1];
        pos--;
      }
      list[pos] = key;
    }
  }

  private void merge(int[] a, int first, int mid, int last)
  {
    int [] temp = new int[last-first+1];
    int aa = first;
    int bb = mid+1;

    for(int i = first; i <= last; i++) {
      temp[i-first] = a[i];
    }

    for(int i = 0; i <= last-first; i++) {
      if(aa <= mid && (bb > last || a[aa] <= a[bb])) {
        temp[i] = a[aa];
        aa++;
      }
      else {
        temp[i] = a[bb];
        bb++;
      }
    }

    for(int i = first; i <= last; i++) {
      a[i] = temp[i-first];
    }
  }

  public void mergeSort(int[] a, int first, int last)
  {
    if(first != last) {    
      int mid = (first + last)/2;
      mergeSort(a, first, mid);
      mergeSort(a, mid+1, last);
      merge(a, first, mid, last);
    }
  }
}
