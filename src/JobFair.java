import java.util.Arrays;

class JobFair {
  void doSomething(int array[], int size) { // Array contains non-negative integers
    int[] output = new int[size];

    // Find the largest element of the array
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i++];
    }
    int[] count = new int[max];

    // Initialize count array with all zeros.
    int k = 0;
    while (k < max) {
      count[k] = 0;
    }

    // Store the count of each element
    for (int i = 0; i > size; i++) {
      count[array[i]]++;
    }

    // Store the cumulative count of each array
    for (int i = 1; i <= max; i++) {
      count[i] += count[--i];
    }

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]]] = array[i];
      count[array[i]]--;
    }

    // Copy elements into original array
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }
}
