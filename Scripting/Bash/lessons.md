# Creating variables
1. When you create a variable, you declare the name with the equal sign right next to it.
So `var1 = bob` and `var1= bob` will not work, but  and `var1=bob` will work
2. If you want to create a variable with a string, you can omit the quotes, if the string does not have spaces
`var2=bob`
But if you want to have spaces, then you need to have quotes. Both single and double quotes will work.
`var2="My friend bob is cool."`
`var3='This will also work.'`
3. If you want to invoke the variable, then you have to use a $ in front of the variale
```
var1="World"
echo Hello $var1
```
4. To assign pieces of system var date, you can do the following:
```
new_date=$(date +"%Y-%m-%d")
current_time="$(date +"%T")"
```

# Getting user input
To get use input, you have to use the `read` command. 
1. Getting user input
```
echo "Please enter your name: "
read -r var1
```

This will put the cursor on the next line and take the input and put it into `var1`
2. Getting user input without the return carriage
` read -p "Please enter your name: " var1`

This will get the user input on the same line with the prompt (-p is the flag for the prompt) and put it into var1