# Programming Paradigms

## Functional programming

Functional programming is a programming paradigm that avoids changing stating and mutable data. It emphasizes immutability, declarative code, and the use of pure functions to build applications.

1. **Pure Function**: the output depends soely on the input and has no side effects (e.g. modifying variables, writing to a file, altering the program's state, etc)

```C#
int Add(int x, int y) {
    return x + y; // Depends only on x and y; has no side effects.
}
```

2. **Immutability**: Once you create data, it cannot be modified. Instead of modifying the data, you create new versions of it.

```C#
var list = new List<int> { 1, 2, 3 };
var newList = list.Select(x => x * 2).ToList(); // Returns a new list without modifying the original.
```

3. **First-Class, Higher-Order Functions**

**First-Class**: Functions can be assigned to variables, passed as arguments, and returned from other functions.

**Higher-Order Fnctions**: Function can take other functions as arguments or return them as results.


```C#
Func<int, int, int> add = (x, y) => x + y; // Function assigned to a variable.
int ApplyOperation(Func<int, int, int> operation, int a, int b) {
    return operation(a, b); // Higher-order function.
}
Console.WriteLine(ApplyOperation(add, 3, 5)); // Output: 8

```

4. **Declarative Code**: Focuses on `what to do` and not `how to do it`. You describe the logic of the computation without explicity specifying control flow.

### Declarative
```C# 
var evenNumbers = numbers.Where(x => x % 2 == 0).ToList();
```

### Imperative
```C#
var evenNumbers = new List<int>();
foreach (var number in numbers) {
    if (number % 2 == 0) {
        evenNumbers.Add(number);
    }
}
```

