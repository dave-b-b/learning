<h1 style="align-text:center;"> Data Types </h1>

## Decimal

### Uses
- Precise Math

## Float
Float has less precision that a decimal


<h1 style="algin-text:center;">Casting vs. Converting</h1>

## Casting
Cast has unexpected behavior (like loss of precision--it doesn't round up as expected). Sound casting will truncate data.

## Converting
Converting is better to use because it behaves as expect--such as rounding up.


## Arrays
- Normally arrays (and all other datatypes in C#) are passed as values. To pass an array as a reference, one needs to use the `ref` key word

**Explanation**: Regardless of using `ref`, changing one of the elements within the array will change the value from the copy to the original (because an array is a reference). If you `ref` the reference inside of a function, you can then reassign the entire reference to a different point in memory. But if you don't, then any changes to the array's pointer in memory will only be localized.

```C#
void ModifyArray(int[] arr)
{
    // Modify the contents
    arr[0] = 99;

    // Attempt to reassign
    arr = new int[] { 1, 2, 3, 4 }; // This only changes the local reference
}

int[] myArray = { 10, 20, 30 };
ModifyArray(myArray);

// After calling the method:
// myArray[0] is 99 (because contents were modified)
// But myArray still points to the original array
Console.WriteLine(myArray[0]); // Output: 99
Console.WriteLine(myArray.Length); // Output: 3
```

-----------

```C#
void ModifyArray(ref int[] arr)
{
    // Modify the contents of the array
    if (arr.Length > 0)
        arr[0] = 42;

    // Reassign the array to a new array
    arr = new int[] { 1, 2, 3, 4 };
}

int[] myArray = { 10, 20, 30 };
ModifyArray(ref myArray);

// After calling the method:
// myArray[0] is now 1 (because the array was reassigned)
Console.WriteLine(myArray[0]); // Output: 1
Console.WriteLine(myArray.Length); // Output: 4
```