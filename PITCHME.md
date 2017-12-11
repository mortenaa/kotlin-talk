# Kotlin
## En introduksjon
#### Morten Nygaard Åsnes

---
## Tema

- Introduksjon
- Historie
- Syntax
- Java
- Scala
- Pros/Cons
- Multiplatform Java/JavaScript/Native
- Interop

---
## Funksjoner
```kotlin
fun main(args: Array<String>) {
    println("Hello, World!")
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun sum(a: Int, b: Int) = a + b
```
@[1-3]
@[5-7]
@[9]
Note:
Et minimalt Kotlin program. En funksjon i Kotlin trenger ikke 
tilhøre en klasse. Retur type kan unnlates om den er Unit (void). 
Type kommer etter parameter/argument i typesignaturen.
Legg merke til at 'if' er en expression.
Om funksjonen består av en enkelt expression kan den skrives med = uten klammer.
Returtypen kan også unnlates om den kan utledes. Semicolons are optional.

---
## Variabler
### Immutable
```kotlin
val a: Int = 1 
val b = 2
val c: Int  
c = 3
```
@[1]
@[2]
@[3-4]
### Mutable
```kotlin
var sum: Int = 0 
sum = a + b

var s = "$sum = ${a + b}"
```
Note:
'val' definerer en immutable variabel. Om typen kan utledes kan den utelates.
Variabler kan også forekomme på top level (i en fil), ikke bare i klasser og funksjoner.
Et eget nøkkelord 'var' definerer in mutable variabel.
Streng interpolation. Varaiabler eller expressions.

---
## Nullable
```kotlin

```

