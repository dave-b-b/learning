<h1 style="align-text:center;"> Data Types </h1>

## Primitives
- byte, int, bloat, decimal, bool

## Value Types
- struct
- DataTime
- enum

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

### Why Arrays have static methods and not instance methods

Arrays are clean data structures without the overhead of additional functionality. The `Array` class servers as a helper class that provides reusable operations without adding instance-level methods to every array object.

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

## Difference between myArray.Reverse() and Array.Reverse(myArray)

### myArray.Reverse();

- Is a Linq extension

#### Use cases

- You do not want to modify the original array
- You are working with collections other than arrays
- You need a functional approach that returns a new collection

### Array.Reverse(myArray);


#### Use cases

- You want to modify the original array
- You are working *ONLY* with arrays
- You do not want to return a new value

## LINQ

Linq extension methods work on any type that implements `IEnumberable<T>`. (E.g. List<T>, IEnumerable<T>, etc)

| Collection Type | LINQ .Reverse() Available? | In-Place .Reverse() Method? |
| :-------------: | :------------------------: | :-------------------------: |
Array | ✅ Yes | ❌ No (use Array.Reverse()) |
List<T> | ✅ Yes | ✅ Yes (List<T>.Reverse()) |
Queue<T> | ✅ Yes | ❌ No |
Stack<T> | ✅ Yes | ❌ No |
Dictionary<K, V> | ✅ Yes (reverses key-value pairs as an enumerable) | ❌ No |
Custom Collections | ✅ If IEnumerable<T> | ❌ No (unless implemented) |

When an instance has both an instance method (and an extension method), then the instance method always takes precedence.

In the case of a list, when you call `myList.Reverse()`, it will always call `List<T>.Reverse`. If you want to be able to call the LINQ extension method `.Reverse()`, then you need to cast the list to `IEnumberable<T>`.

List<int> list = new List<int> { 1, 2, 3, 4, 5 };
var reversed = ((IEnumerable<int>)list).Reverse(); // Calls LINQ's Reverse().
Console.WriteLine(string.Join(", ", reversed)); // Output: 5, 4, 3, 2, 1

## List

List<T> is a dynamic collection that encapsulates both data and behavior. 