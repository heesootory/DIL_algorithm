# DIL_algorithm
언어정리(C/C++, C#, java, python, Kotlin)<br>
-> c/c++과 비교하여, 다른 특징들만 정리

---

## Kotlin
>  함수형 언어/ 객체지향언어<br>
>  세미콜론 생략가능
* if 문 c/c++와 동일
* do/while 문 동일
* 전위, 후위 연산자 존재. (a++, ++a)
* break, continue 동일

### 변수 
* var : 변경 가능
* val : 읽기만 가능. 수정불가.
* Any : 어떤 자료형에도 호환되는 최상위 클래스
> 알아서 형을 지정해주지만, 특별히 형을 지정할 수 있음
```kotlin
//<명시적 선언>
val a : Int = 1234     //val a = 1234      -> int
val b : Long = 1234L   //val b = 1234L     -> long
val c : Double = 12.34 //val c = 12.34     -> double(소수는 기본적으로 double형)
val d : Float = 12.34f //val d = 12.34f    -> float형은 f를 꼭 붙히기
//<암시적 선언>
val str = "hello"
val str = """ 안녕하세요.
반갑습니다."""            //""" 3개쓰면, 줄바꿈,띄워쓰기 알아서 가능.
val e : Char = 'g'    // 자바와 같이 Char은 문자를 의미, 작은따음표로 문자 하나
val e = 'g'            //Char 로 자동인식.
val boo = true         //Boolean으로 자동 인식.
val boo : Boolean = true   //위와 동일
val f = 0xABCD          //16진수 -> int형으로 추론
val g = 0b0110110       //2진수 -> int형으로 추론
```

### 형변환
* 코틀린은 암시적 형변환 지원X, 전부 명시적 형변환 해줘야함.
> toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar
* String을 int로 형변환시, var!!.toInt() -> !!를 붙여준다

```kotlin
var a : Int = 12345
var b :Long = a.toLong()       //int를 long으로 바꿀때도, 명시적으로 형변환 해줘야함

var c = readLine()          //입력은 String
var d = c!!.toInt()         //int로 형변환

```


### 데이터 타입 확인
> 변수.javaClass

### 입력
> 코틀린용 readLine()과 자바에서 가져온 Scanner(System.`in`)이 있다.
> readLine()은 무조건 String로 받아오므로, 형변환이 필요하다.
```kotlin
var input = readLine()                  //문자열을 다 받아옴

var s = Scanner(System.`in`)
var input: Int = s.nextInt()            //t숫자를 하나씩 받아옴
var input = s.next()                    //띄워쓰기를 기준으로 단어를 받아옴

```


### 출력

```kotlin
print(num)
print(str)
print("hello world\n")
println("it it ${num}")
println("hi ${str}")
print("%.3f".format(ans)) // float 타입 ans를 소수 3번째 자리까지 출력
```

### 반복문(for)
* 변수의 타입 지정 X.
* step을 사용하여 증가정도 표현.
* downTo 를 사용하면 감소식
* a..b/ b downTo a -> 숫자 범위 a,b가 모두 포함됨
* Char 자료형도 가능
* until 로 미만구현

```kotlin
for(i in 0..9 step 3){
    println(i)
}
```
```kotlin
for(i in 9 downTo 0 step 3){        //9부터 0까지 3씩 감소
    println(i)
}
```
```kotlin
for(i in 'a'..'f'){                 //char형 
    println(i)
}
for(i in 배열명){                   //배열
    println(i)
}
for(i in 0 until 4){               
    println(i)                      //0,1,2,3
}
```

### 레이블 @loop
* 이중 반복문에서 두번 break해야하는 수고를 덜어줌 -> 즉시 탙출
```kotlin
loop@for(i in 0..9){
        for (j in 0..9){
            if( i==1 && j == 2)break@loop
        }
    }
```

### 배열 & 문자열

* 한번 생성시, 크기 변경 불가 but 빠른 입출력
* arr.get(index),  arr.set(index, num), arr.size 가능
* Array 객체를 이용한 배열 생성/ arrayOf 라이브러리 함수를 이용한 배열 생성
* joinToString(",") : 배열 원소를 ','로 구분해서 문자열처럼 출력. 
* lastIndex :  마지막 인덱스 -> for문에서 사용하기 편리
* fill(element, fromIndex, ToIndex) : ToIndex는 포함안됨.
* 배열.indices : 배열의 index값만을 가져온다
* 두 배열 합치기 : arr1 + arr2
* 8개의 자료형 빈 배열 제공: charArrayOf(),shortArrayOf(),byteArrayOf(),intArrayOf(),longArrayOf(),doubleArrayOf(),floatArrayOf(),booleanArrayOf() -> 초기화 없이도 생성 가능.
* 문자열도 배열의 함수들 모두 동일하게 사용가능
* for((index, value) in arr.withIndex()) -> 배열의 인덱스와 값이 한쌍으로 묶여서 반복.
* builder클래스는 클래스에서 만들어진 객체배열이므로, 사이즈만 지정해도  Int 형이면 0으로 초기화됨.
* arr.filter{it > 100} : {}안에는 it을 사용한 조건절이 나와서 조건에 해당하는 값만 뽑아냄
* arr.find{it > 100} : {}람다식 안의 조건에 만족하는 첫번째 요소를 꺼냄
* 배열과 관련된 함수를 사용할시, 그배열의 원소를 it으로 칭하면, 반복문 없이 순서대로 불러온다.
* 모든 배열의 index는 Int형으로만 가능! Long도 불가능!


| **라이브러리 함수형** | **builder클래스** |
|-|-|
|특정값을 넣어서 배열을 생성하는 경우| 크기만 정해서 생성하는 경우|
|arrayof(1,2,3)| Array(10, {0})|
|charArrayOf()|CharArray|
|shortArrayOf()|ShortArray|
|byteArrayOf()|ByteArray|
|intArrayOf(1,2,3,4,5)|IntArray(5, {0})|
|longArrayOf()|LongArray|
|doubleArrayOf()|DoubleArray|
|floatArrayOf()|FloatArray|
|booleanArrayOf()|BooleanArray|
|원소들을 일일히 초기화 하여야함| 사이즈를 정하고, 람다식으로 초기화됨->간편! |
| 원소 안넣으면 초기화X | 사이즈만 정해줘도 초기화, char형은 초기화 안됨|


```kotlin
* 라이브러리 함수형
var arr = arrayOf(1,100,"하이", false, 12.34);      //타입을 지정하지 않을시, 다양한 타입이 들어가도 상관없음.
var arr = intArrayOf(1,2,3)     // *제공함수 형    
var arr = arrayOf<Int>(1,2,3);  // *제네릭 형
//------------------------------------------------------
* builder클래스형
var arr2 = Array(10, {0});
var arr2 = IntArray(10, {0})    // * 제공클래스 형
var arr2 = Array<Int>(10, {0})  // * 제네릭 형
var arr = Array<Int>(10) {i -> i}   // * 제네릭 형 - {}가 밖으로 나와도 가능
//-------------------------------------------------------

val a = Array(10, {0})                                  //10개의 원소, 0으로 초기화
val b = Array<Int>(10, {1})                             //10개 1로 초기화
val c = Array<Int?>(10, {null})                 
                        //<타입?>->nullable : null이 들어가도 가능(여기선 모두 null로 초기화됨)
val d = CharArray(4, {'A'})                             //빌더 클래스를 사용하여 빠르게 배열 생성
val e = BooleanArray(5, {true})
val f = IntArray(10, {5})
val g = IntArray(5, {i -> i})         //0,1,2,3,4로 초기화 -> 람다식 초기화!!
val h = IntArray(3, {i -> i * 1000 + 500})      //500, 1500, 2500
val i = IntArray(4)
i.fill(100, 0, 4)               //0~3까지 100으로 채움

var arr = arrayOf(1,2,3,4,5)                                // 배열 생성과 초기화
var arr1 = arrayOfNulls<Int>(5)                 
                        //null로된 5개짜리 배열 - generic 사용해서 타입을 꼭 명시
val fruit_arr = arrayOf<String>("banana", "apple", "orange")
val k_arr : Array<String> = Array(3, {"k"})
val fruit_k_arr = fruit_arr + k_arr                         //배열 합치기
println("fruit_k_arr = ${fruit_k_arr.joinToString(",")}")       
                        //배열을 문자열로 출력(쉽게 출력가능)
                        // banana, apple, orange, k , k , k 출력
for(i in 0..arr.lastIndex){ 
        println(arr[i])         //1,2,3,4,5                                     
    }
for(i in arr){                                  
    println(i)             //1,2,3,4,5
}                                          
for(i in arr.indices){          //0,1,2,3,4
    println(arr[i])             //1,2,3,4,5                                     
}
val arr = intArrayOf(1,2,3,4,5)                                  
val arr2 = intArrayOf()             //초기화 안됨
val arr3 = charArrayOf('A', 'B', 'C', 'D', 'E')
val arr4: CharArray = charArrayOf('A', 'B', 'C', 'D', 'E')         //명시적 선언
println("arr4 = ${arr4}")       //배열의 주소값이 나옴 - 해시코드
val str: String = "ABCDE"
println("str = ${str}")       //ABCDE 문자열그대로 출력
println("str = ${str.toCharArray().joinToString(",")}")         //A,B,C,D,E
// toCharArray함수는 자바의 함수를 그대로 가져온것
for((i,iv) in arr.withIndex()){
    println("($i,$iv)")                 //(0,1)(1,2)(2,3)(3,4)(4,5)
}
print("ans = ${arr.filter{it > 3}}\n")  //filter를 이용해서 새로운 함수를 생성 or 출력 가능
val arr2 = arr.filter{it > 3}           //ans = [4,5]
for((i,iv) in arr2.withIndex()){
    println(iv)                         //4,5
}
```

#### 2차원 배열
> Array(m, {oooArray(n)}) -> m x n 배열
```kotlin
val arr = Array(3, {IntArray(4)})       // 3x4 행렬 - 0으로 초기화 됨.
for((i,iv) in arr.withIndex()){     // i,j는 행과 열의 라인수를 의미하고, iv,jv는 원소의 값을 나타낸다.
    for((j, jv) in iv.withIndex()){
        print("$jv ")              // 0 0 0 0
    }                              // 0 0 0 0
    println()                      // 0 0 0 0
}

val arr2 = Array(3, {i -> IntArray(4, {j -> j + i})})        
                                    //행넘버를 활용해서, 초기화 할시.

```

### ArrayList< type>()
* 가변배열 Arraylist는 값을 추가, 수정, 제거 가능
* Collections.min(arr)/Collections.max(arr) 로 최솟값, 최댓값
* add(var), removeAt(index), clear(var)
* remove(var) - 발견한 첫번째 var을 삭제


### 함수
* fun 함수명(변수: 타입) : 리턴형{}
* call by reference를 지원하지 않고, call by value만 가능.
> 매개변수를 입력받을 변수로 조차 선언하지 못함. (아예 변경 불가)
* 배열을 함수의 매개변수로 받을 때는 builder 객체형으로 표현.
* 함수의 매개변수는  모두 Immutable로 변할수 없는 val타입이다.

```kotlin
fun pluss(a: Int, b:Int):Int{       //리턴형이 있을때
    return a+b
}
fun pluss(a: Any, b:Int){       //리턴형이 없을때
    return a+b
}
```
```kotlin
val arr = intArrayOf(12,22,39,34,51)

    fun punction(i: IntArray) {         //int타입으로 구성된 배열이므로
        println(i[3])
    }
    punction(arr)
```

#### 단일 표현식
* 반환형을 추론하므로, 생략가능
```kotlin
fun add(a: Int, b: Int) = a+b
```

### when문
* switch문가 유사
* 조건에 등호나 부등호 사용이 불가
* break를 쓰지않아도, 조건이 맞다면 거기서 멈춤.
*  else 존재
* when의 결과를 변수에 받아서도 사용가능

```kotlin
    val a = 10 

    fun doWhen (i: Any){
        when(i){
            is Int -> println("type")
            !is String -> println("not Str")
            10 -> println("num")
            "ten" ->println("str")
            else -> println("뭐야이거")
        }
    }

    doWhen(a)
```
> type만 출력됨
```kotlin
    val a = 10

    fun doWhen (i: Any){
        var result = when(i){
            is Int -> "type"
            !is String -> "not Str"
            10 ->"num"
            "ten" ->"str"
            else -> "뭐야이거"
        }
        println(result + "입니다.")
    }

    doWhen(a)
```
> 변수에 담아서 사용

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


## C#

### ArrayList

> ArrayList는 c++ 의 vector같은 가변배열이다.

* 타입을 지정 안해도되기 떄문에, 다양한 타입을 한꺼번에 담을 수 있다.
* 따라서, 어떤 지정된 변수로 받을 때는 형변환을 명시적으로 해줘야함.

* ArrayList에 타입이 지정된게, List이다.


```cs
ArrayList arr = new ArrayList();    
//이렇게 크기를 지정하지 않고, 배열기호인[]도 사용하지 않음
ArrayList[] arr = new ArrayList[100];
//따라서 이런식으로 만들었다면, 각각이 ArrayList인 일반배열 100개짜리를 만든것이다.
//따라서 이차원 배열이 됨.
arr.Add(1);
arr.Add('5');
arr.Add("hello");

int v = (int)arr[0];        //명시적 형변환

```

![c#](/Image/cs_1.PNG)






<br>

---

# 언어별 차이

## call by reference

### c
> call by reference 불가능하므로, 포인터를 이용
```c
#include <stdio.h>

void swap(int * n1, int * n2) {
    int temp = *n2;
    *n2 = *n1;
    *n1 = temp;
}

int main(void)
{
    int num1 = 100, num2 = 300;
    swap(&num1, &num2);
    
    printf("num1: %d\n", num1);
    printf("num2: %d\n", num2);
    
    return 0;
}
```

### c++
> call by reference 가능.
```cpp
using namespace std;

void swap(int & n1, int & n2) {
    int temp = n2;
    n2 = n1;
    n1 = temp;
}

int main()
{
    int num1 = 100, num2 = 300;
    swap(num1, num2);

    cout << "num1: " << num1 << endl;
    cout << "num2: " << num2 << endl;

    return 0;
}
```

### c#
> call by reference 가능.
```cs
public class Program
{
    public static void Swap(ref int n1, ref int n2) {
        int temp = n2;
        n2 = n1;
        n1 = temp;
    }
    
    public static void Main(string[] args)
    {
        int num1 = 100, num2 = 300;
        Swap(ref num1, ref num2);
        
        Console.WriteLine("num1: {0}", num1);
        Console.WriteLine("num2: {0}", num2);
        
    }
}

```

### Java
>  call by reference 지원되지 않아, 배열같은 컨테이너 객체의 원소를 이용해야함.
```java
class SwappingIntegersExample {

    public static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;        
    }

    public static void main(String args[]) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70};
        swap(numbers, 0, 1);

        System.out.printf("numbers[0]: %d\n", numbers[0]);
        System.out.printf("numbers[1]: %d\n", numbers[1]);
    }

}

```


### Kotlin

> call by reference 지원되지 않아, 배열같은 컨테이너 객체의 원소를 이용해야함.
```kotlin
fun swap(numbers : IntArray, i1 : Int, i2 : Int) {
    var temp : Int = numbers[i1]
    numbers[i1] = numbers[i2]
    numbers[i2] = temp
}

fun main(args : Array<String>) {
    var numbers : IntArray = intArrayOf(10, 20, 30, 40, 50, 60, 70)
    swap(numbers, 0, 1)

    println("numbers[0]: ${numbers[0]}")
    println("numbers[1]: ${numbers[1]}")
}
```

### Python

> Call by assignment(Call by object-reference) 모든것을 객체화 했기때문에, 변수명은 이름표에 불과.
<br>
> call by reference 지원X.


<br>
<br>
<br>

---


## range based for

### C++

```cpp
int arr[] = {1,2,3,4,5};
for(auto num: arr)
    printf("%d", num);
```


### C#
```cs
int[] arr = {1,2,3,4,5};
for(int i in arr)
    Write($"{i}");
```

### java
```java
int[] arr = {1,2,3,4,5};
for(int i: arr)
    System.out.print(i);
```

### kotlin
> 코틀린은 기본이 for-each의 형태이다.
```kt
var arr = arrayOf(1,2,3,4,5);
for(i in arr)
    print("${i}");
```

### python
```py
arr[] = {1,2,3,4,5};
for i in arr:
    print(i);
```

## 출력

### C<sup>++<sup>
```cpp
int i = 10;
cout << "정답은" << i << "입니다." << '\n';
printf("%.3lf", mid);        // 소수점 3번째까지
```

### C# 
```cs
int i = 10;
WriteLine($"정답은 {i}입니다.");
Write("{0:F3}", mid);       // 소수점 3번째까지 출력
```

### java
```java
int i = 10;
System.out.println("정답은 " + i + "입니다.");
System.out.println(String.format("%.3f", mid));  // 소수점 3번째까지 출력
```

### kotlin
```kt
val i = 10
println("정답은 ${i}입니다.")
print("%.3f".format(mid))         // 소수점 3번째까지 출력   
```

### python
```py
i = 10
print(f'정답은 {i}입니다.')
print(f'{mid:.3f}')     # 소수점 3번째까지 출력
```

<br>
<br>
<br>


---

## 배열

### C++
* 1차원 배열
```cpp
//static
int arr[10];
//local
int arr[10] = {};
```

* 2차원 배열
```cpp
//static
int arr2[10][10];
```

* vector (가변 배열)
```cpp
vector<int> v;
```

* vector배열(1차원- vector, 2차원 - 배열)
```cpp
vactor<int> arr2[10];
//각 행이 vector로 되어있는 10개 짜리 배열
```

* 2차원 vector배열(1차원- vector, 2차원 - vector)
```cpp
vector<vector<int>> arr2;
```


### C#

* 1차원 배열
```cs
int[] arr = new int[10];
길이 = arr.Length;
```

* 2차원 배열
> java와 다르게 생성시에는, reference value를 담을 공간의 갯수만 지정가능.
```cs
int[][] arr2 = new int[10][];
for(int i = 0; i< arr2.Length; i++) arr[i] = new int[10];
```
cf > 2차원 배열 입력받기
```cs
string[] s = ReadLine().Split(' ');
for(int i = 0; i< arr2.Length; i++)
        {
            s = ReadLine().Split(' ');
            for(int j = 0; j < arr2[i].Length; j++)
            {
                arr2[i][j] = int.Parse(s[j]);
            }
        }
```


* ArrayList (가변배열)
```cs
ArrayList arr = new ArrayList();
갯수 = arr.Count;
```

* ArrayList배열(1차원- ArrayList, 2차원 - 배열)
```cs
//local

ArrayList[] arr2 = new ArrayList[10];       //배열의 주소값 생성
for(int i = 0; i < 10; i++) arr2[i] = new ArrayList();     
// 배열의 index마다 reference value 생성.

//static 
//- 함수를 통해서 생성시켜주자.
ArrayList[] arr2 = new ArrayList[10];      //배열 주소 생성 

static void make_arr(ArrayList[] arr_list){
    for(int i = 0; i< 10; i++) arr_list[i] = new ArrayList();
}

make_arr(arr2)
```

* 2차원 ArrayList배열(1차원- vector, 2차원 - vector)
```cs

```


### java
* 1차원 배열
```java
int[] arr = new int[10];
//길이 : arr.length
```

* 2차원 배열
> reference value를 담을 공간의 갯수는 지정해줘야함. (c#과 동일)
```java
int[][] arr2 = new int[10][10];
```

* ArrayList (가변배열)
> c#과 달리 제너릭을 통해 타입을 지정해줘야함.

* 길이(갯수) : arr.Count

```cs
ArrayList arr = new ArrayList();                //타입 앞뒤 전부 생략시, object에 대한 배열
ArrayList<Integer> arr = new ArrayList();       //타입생략 가능
//길이 : arr.size()
ArrayList<Integer> arr = new ArrayList<>();        //타입생략 가능
ArrayList<Integer> arr = new ArrayList<Integer>(10);        
//capacity (용량) 설정 가능
```

* ArrayList 2차원 배열(1차 - ArrayLisr, 2차 - 배열)
> c#과 매우 유사
```cs
//local

ArrayList<Integer>[] arr2 = new ArrayList[10];      //배열 주소 생성
for(int i = 0; i< 10; i++) arr2[i] = new ArrayList(); 
// 배열의 index마다 reference value 생성.

//static 
//- 함수를 통해서 생성시켜주자.
ArrayList<Integer>[] arr2 = new ArrayList[10];      //배열 주소 생성

static void make_arr(ArrayList<Integer>[] arr_list){
    for(int i = 0; i< 10; i++) arr_list[i] = new ArrayList();
}

make_arr(arr2);
```


### kotlin
* 1차원 배열
```kt
var Array(10, {0})
var Array<Int>(10) {i -> i}
var arrayOf(0,0,0,0,0)
```

* 2차원 배열
```kt
var arr2 = Array(10, {Array(10, {i ->i})})
var arr2 = Array<Array<Int>>(10) {Array<Int>(10, {i->i})}
var arr2 = Array<Array<Int>>(10) {Array<Int>(10) {i->i}}
```

* ArrayList (가변배열)
> 자바처럼 타입 지정.
```kt
var arr = ArrayList<Int>();
```

* ArrayList 2차원 배열(1차 - ArrayList, 2차 - 배열)
```kt
var arr2 = Array<ArrayList<Int>>(10) {ArrayList<Int>()}
```

### python
> 파이썬은 일반 배열자체가 list이다.
>
> 타입을 지정할 필요도 없음


* 1차원 list
```py
arr = []
arr = [0,1,2,3,4,5,6,7,8,9]
arr = [0 for _ in range(10)]
arr = [False for _ in range(10)]
arr = [i for i in range(10)]       //0,1,2,3,4,5,6,7,8,9
```

*2차원 list
```py
arr2 = [[0 for _ in range(10)] for _ in range(10)]
```

cf> 2차원 배열 입력 받기
```py
for i in range(len(arr2)):
    inpu = input().split(' ')
    for j in range(len(arr2[i])):
        arr2[i][j] = int(inpu[j])

```



<br>
<br>
<br>
<br>
<br>


---

## queue 생성

### C++
```cpp
#include <queue>

queue<int> q;

q.push(var);
q.pop();
bool b = q.empty();
int var = q.front();
int var = q.back();
int var = q.size();
```

### C#
```cs
using System.Collections;

Queue q = new Queue();
q.Enqueue(var);     //데이터 추가
int var = (int)q.Dequeue();     //최상위 데이터 제거& 호출
int var = q.Count;         //갯수

```


### JAVA 
```java
import java.util.*;

Queue<Integer> q = new LinkedList();
q.add(var);
int var = q.peek();     //최상위 데이터 호출
q.poll()        //최상위 데이터 삭제
q.isEmpty()
```


### Kotlin
> 자바와 함수는 동일.
```kt
var q = LinkedList<Int>()

q.add(var)
var var = q.peek()
q.poll()
q.isEmpty()
```

### python
```py
from collections import deque   

q = deque()
q.append(var)   //가장 마지막에(right) 데이터 추가
var = q.popleft()       //가장 앞의 (left) 데이터 제거 & 호출
var = len(q)           //큐의 길이
```


## Class

### C++
> c++은 struct이 있다. 인스턴스 변수들로만 구성되어야 한다.
> 
> 메소드나 생성자가 들어갈 수없다.

```cpp
struct shark
{
    int x;
    int y;
};


shark s;

```
<br>


### C#
#### static class (정적 클래스)

* 정적클래스는 생성자를 가질 수 없다. <br>
  static class는 인스턴스 변수만 가지고 있다. 유니티 게임을 만들 때, 기존의 점수를 "싱글톤 패턴"으로 만들었을때 경우를 생각해보자.
  그 인스턴스 변수를 어디서 든지 사용할 수 있게 만들고, 그 집합이 static class이다. static빼면 어디서든 객체를 생성할 수 있는 일반적인 class이다.
* static class안의 인스턴스 변수들은 static 을 무조건 가지고 잇어야한다.
  static class의 변수들은 모두 어디서나 쓸수있는 전역변수 들이므로, 당연히 static 을 가지고 있어야함.

```cs
public static class shark{
    static int x;
    static int y;
}
public class shark{
        public int x;
        public int y;
        public shark(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }


shark shark_position = new shark(i, j);

```

### java


